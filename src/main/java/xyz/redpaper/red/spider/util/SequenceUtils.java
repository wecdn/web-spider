package xyz.redpaper.red.spider.util;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * 序列号工具包
 */
public class SequenceUtils {

    /**
     * 获取文章序号-暂时作废
     * @return
     * @throws IOException
     */
    public static String getArticleOrder() throws IOException {
        String order = "001";
        Map<String, String> jsonMap = JsonUtils.readJson(JsonUtils.PROPERTITES_ORDER_JSON);
        String today = TimeUtils.getTodayStr(TimeUtils.DATE_FORMATTER_YYYYMMDD);
        String day = jsonMap.get("day");
        if(StringUtils.isNotBlank(day) && today.equals(day)){
            order = SequenceUtils.getThousandSeq(Integer.valueOf(jsonMap.get("order")) + 1);
        }
        return order;
    }

    /**
     * 获取百以内形式数字，例如00，09,56
     * @param i
     * @return
     */
    public static String getHundredSeq(int  i){
        if(i<10){
            return "0" + i;
        }else{
            return String.valueOf(i);
        }
    }

    /**
     * 获取千以内形式数字，例如000，009,056，125
     * @param i
     * @return
     */
    public static String getThousandSeq(int  i){
        if(i<10){
            return "00" + i;
        }else if(i>=10 && i<100){
            return "0" + i;
        }else{
            return String.valueOf(i);
        }
    }
}
