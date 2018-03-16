package cc.lau.json;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Map;

/**
 * Created by cc on 18/3/16
 */
public class JsonUtil {

    /**
     * object to json
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * json to object
     *
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T fromObject(String jsonStr, Class<T> clazz) {
        return JSON.parseObject(jsonStr, clazz);
    }


    /**
     * json to map
     *
     * @param jsonStr
     * @return
     */
    public static Map toMap(String jsonStr) {
        return JSON.parseObject(jsonStr, Map.class);
    }

    /**
     * json to list
     *
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(String jsonStr, Class<T> clazz) {
        return JSON.parseArray(jsonStr, clazz);
    }
}
