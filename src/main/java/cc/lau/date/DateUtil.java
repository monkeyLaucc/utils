package cc.lau.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cc on 18/3/16
 */
public class DateUtil {

    /**
     * date 转字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * date 转字符串, pattern = yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
    }


    /**
     * string to date
     *
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date parse(String dateStr, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            Date date = sdf.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * string to date, pattern = yyyy-MM-dd HH:mm:ss
     *
     * @param dateStr
     * @return
     */
    public static Date parse(String dateStr) {
        return DateUtil.parse(dateStr, "yyyy-MM-dd HH:mm:ss");
    }


}
