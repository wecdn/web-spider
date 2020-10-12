package xyz.redpaper.red.spider.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 时间工具类
 */
public class TimeUtils {

    public static final String DATE_FORMATTER_YYYYMMDD = "yyyyMMdd";

    public static final String TIME_FORMATTER_HHMMSS = "HHmmss";

    public static final String DATE_FORMATTER_YYYY_MM_DD = "yyyy-MM-dd";

    public static final String TIME_FORMATTER_HH_MM_SS = "HH-mm-ss";

    public static final String DATE_ADN_TIME_FORMATTER_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH-mm-ss";

    public static void main(String[] args) {
        Date todayDate = getTodayDate();
        System.out.println(todayDate);
    }

    /**
     * 获取当前日期
     * 默认格式: yyyy-MM-dd
     * @return
     */
    public static String getTodayStr(){
        return getTodayStr(DATE_FORMATTER_YYYY_MM_DD);
    }

    /**
     * 获取当前日期
     * @param formatter 日期格式
     * @return
     */
    public static String getTodayStr(String formatter){
        LocalDateTime now = LocalDateTime.now();
        return DateTimeFormatter.ofPattern(formatter).format(now);
    }

    /**
     * 获取当前日期，默认中国上海时区
     * @return
     */
    public static Date getTodayDate(){
        LocalDateTime now = LocalDateTime.now();
        return Date.from(now.atZone(ZoneId.of(ZoneId.SHORT_IDS.get("CTT"))).toInstant());
    }

    /**
     * 获取几个小时之前的日期，默认中国上海时区
     * @param hour
     * @return
     */
    public static Date getTodayBeforeHourDate(Long hour){
        LocalDateTime now = LocalDateTime.now().minusHours(hour);
        return Date.from(now.atZone(ZoneId.of(ZoneId.SHORT_IDS.get("CTT"))).toInstant());
    }

    /**
     * 获取当前时间
     * 默认格式: HH-mm-ss
     * @return
     */
    public static String getTimeStr(){
        return getTimeStr(TIME_FORMATTER_HH_MM_SS);
    }

    /**
     * 获取当前时间
     * @param formatter 时间格式
     * @return
     */
    public static String getTimeStr(String formatter){
        LocalDateTime now = LocalDateTime.now();
        return DateTimeFormatter.ofPattern(formatter).format(now);
    }

    /**
     * 获取日期和时间
     * 默认格式: yyyy-MM-dd HH-mm-ss
     * @return
     */
    public static String getDateAndTimeStr(){
        return getDateAndTimeStr(DATE_ADN_TIME_FORMATTER_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 获取日期和时间
     * @param formatter 格式
     * @return
     */
    public static String getDateAndTimeStr(String formatter){
        LocalDateTime now = LocalDateTime.now();
        return DateTimeFormatter.ofPattern(formatter).format(now);
    }

    /**
     * 获取几个小时之前的日期和时间
     * 默认格式: yyyy-MM-dd HH-mm-ss
     * @param hour
     * @return
     */
    public static String getDateAndTimeStrBeforeHour(Long hour){
        LocalDateTime before = LocalDateTime.now().minusHours(hour);
        return DateTimeFormatter.ofPattern(DATE_ADN_TIME_FORMATTER_YYYY_MM_DD_HH_MM_SS).format(before);
    }

    /**
     * 获取几个小时之前的日期和时间
     * @param hour
     * @param formatter
     * @return
     */
    public static String getDateAndTimeStrBeforeHour(Long hour, String formatter){
        LocalDateTime before = LocalDateTime.now().minusHours(hour);
        return DateTimeFormatter.ofPattern(formatter).format(before);
    }

    /**
     * 获取github图片路径，例如:/2020/09/
     * @return
     */
    public static String getGitDatePath(){
        LocalDateTime now = LocalDateTime.now();
        return "/"+now.getYear()+"/"+SequenceUtils.getHundredSeq(now.getMonthValue())+"/";
    }

}
