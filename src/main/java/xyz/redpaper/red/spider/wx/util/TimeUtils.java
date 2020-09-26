package xyz.redpaper.red.spider.wx.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    private static final String DATE_FORMATTER = "yyyyMMdd";

    private static final String TIME_FORMATTER = "HHmmss";


    public static String getDate(){
        LocalDateTime now = LocalDateTime.now();
        return DateTimeFormatter.ofPattern(DATE_FORMATTER).format(now);
    }

    public static String getTime(){
        LocalDateTime now = LocalDateTime.now();
        return DateTimeFormatter.ofPattern(TIME_FORMATTER).format(now);
    }

    public static String getGitDatePath(){
        LocalDateTime now = LocalDateTime.now();
        return "/"+now.getYear()+"/"+fillZero(now.getMonthValue())+"/";
    }

    public static String fillZero(int i){
        if(i<10){
            return "0"+i;
        }else{
            return String.valueOf(i);
        }
    }
}
