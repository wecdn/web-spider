package xyz.redpaper.red.spider.wx.util;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import xyz.redpaper.red.msg.S2tApi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class YesApiUtils {

    /**
     * 单元测试
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
        S2tApi api = tryS2t("这个国家的兴亡，匹夫有责，今天天气挺好的", 3);
    }

    /**
     * 简体中文转繁体中文
     * 1. yesapi接口每个月最多调用10万次
     * 2. yesapi接口有效期至2020-12-24
     * @param s 中文简体内容
     * @return
     * @throws UnsupportedEncodingException
     */
    public static S2tApi s2t(String s) throws UnsupportedEncodingException {
        S2tApi api = new S2tApi();
        Map<String, String> map = new HashMap<String, String>();
//        String url = "http://hb9.api.yesapi.cn/?s=App.Opencc.Convert";
//        map.put("return_data", "0");
//        map.put("text", s);
//        map.put("type", "s2t");
//        map.put("app_key", "649DB87D2A8CA150DDB97A2B784D297C");
//        map.put("sign", "7809F5F458C80DF9FE48B9BCF76A8C79");
        String url = "https://api.jisuapi.com/fontconvert/convert?appkey=0822ebf15030c07c";
        map.put("content", s);
        map.put("type", "2t");
        try {
            String result = HttpClientUtils.post(url.toString(), map);
            System.out.println(result);
            api = new Gson().fromJson(result, S2tApi.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return api;
    }

    /**
     * 尝试s2t
     * @param simplified 简体内容
     * @param num 尝试次数
     * @return
     * @throws UnsupportedEncodingException
     * @throws InterruptedException
     */
    public static S2tApi tryS2t(String simplified, int num) throws UnsupportedEncodingException, InterruptedException {
        S2tApi api = new S2tApi();
        int first = num;
        //api接口可能会失败，所以第二次以及后面的请求最好休眠2秒
        do{
            api = s2t(simplified);
            num--;
            if(first!=num){
                Thread.sleep(2000);
            }
        }while((!"0".equals(api.getStatus()) || StringUtils.isBlank(api.getResult().getRcontent())) &&  num>0);
        return api;
    }
}
