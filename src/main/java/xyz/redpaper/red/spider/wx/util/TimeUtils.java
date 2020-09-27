package xyz.redpaper.red.spider.wx.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 时间工具类
 */
public class TimeUtils {

    private static final String DATE_FORMATTER = "yyyyMMdd";

    private static final String TIME_FORMATTER = "HHmmss";


    /**
     * 获取当前日期，例如:20200919
     * @return
     */
    public static String getDate(){
        LocalDateTime now = LocalDateTime.now();
        return DateTimeFormatter.ofPattern(DATE_FORMATTER).format(now);
    }

    /**
     * 获取当前日期，例如:125938
     * @return
     */
    public static String getTime(){
        LocalDateTime now = LocalDateTime.now();
        return DateTimeFormatter.ofPattern(TIME_FORMATTER).format(now);
    }

    /**
     * 获取github图片路径，例如:/2020/09/
     * @return
     */
    public static String getGitDatePath(){
        LocalDateTime now = LocalDateTime.now();
        return "/"+now.getYear()+"/"+fillZero(now.getMonthValue())+"/";
    }

    /**
     * 数字补零
     * @param i
     * @return
     */
    public static String fillZero(int i){
        if(i<10){
            return "0"+i;
        }else{
            return String.valueOf(i);
        }
    }
}
