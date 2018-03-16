package cc.lau.http;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 18/3/16
 */
public class HttpUtil {

    /**
     * get请求
     *
     * @param uri
     * @return
     */
    public static String get(String uri) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(uri);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(get);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                String result = EntityUtils.toString(response.getEntity());
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
                if (null != client) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * post请求(用于key-value格式的参数)
     *
     * @param uri
     * @param params
     * @return
     */
    public static String post(String uri, Map<String, Object> params) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(uri);
        List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            nameValuePairList.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
        }
        CloseableHttpResponse response = null;
        try {
            post.setEntity(new UrlEncodedFormEntity(nameValuePairList, "UTF-8"));
            response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity());
                return result;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
                if (null != client) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;

    }

    /**
     * post请求(用于JSON参数)
     *
     * @param uri
     * @param params
     * @return
     */
    public static String post(String uri, String params) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(uri);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-Type", "application/json");
        post.setEntity(new StringEntity(params, "UTF-8"));
        CloseableHttpResponse response = null;
        try {
            response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity());
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != response) {
                    response.close();
                }
                if (null != client) {
                    client.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

}
