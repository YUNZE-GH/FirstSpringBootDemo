package com.gh.firstdemo.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/8/6 20:53
 */
public class PublicUtils {
    public static String TimestampToString(Timestamp timestamp){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
    }

    public static Timestamp StringToTimestamp(String time){
        return Timestamp.valueOf(time);
    }
}
