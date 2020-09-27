package xyz.redpaper.red.spider.wx.util;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import xyz.redpaper.red.msg.YesApi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

public class YesApiUtils {

    /**
     * 单元测试
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        YesApi yesApi = s2t("<div class=\"rich\">哈打发斯蒂芬，让他问题</div>");
        System.out.println(null==yesApi);
        System.out.println(!"200".equals(yesApi.getRet()));
        System.out.println(null==yesApi.getData());
        System.out.println(null==yesApi.getData().getText());
        if(null==yesApi || !"200".equals(yesApi.getRet()) || null==yesApi.getData() || null==yesApi.getData().getText()){
            System.out.println("GG");
        }
    }

    /**
     * 简体中文转繁体中文
     * 1. yesapi接口每个月最多调用10万次
     * 2. yesapi接口有效期至2020-12-24
     * @param s 中文简体内容
     * @return
     * @throws UnsupportedEncodingException
     */
    public static YesApi s2t(String s) throws UnsupportedEncodingException {
        YesApi api = new YesApi();
        StringBuilder url = new StringBuilder("http://hb9.api.yesapi.cn/?s=App.Opencc.Convert");
        url.append("&return_data=0");
        url.append("&text=");
        url.append(URLEncoder.encode(s, "UTF-8"));
        url.append("&type=s2t");
        url.append("&app_key=649DB87D2A8CA150DDB97A2B784D297C&sign=7809F5F458C80DF9FE48B9BCF76A8C79");
        try {
            String result = HttpClientUtils.get(url.toString());
            System.out.println(result);
            api = new Gson().fromJson(result, YesApi.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return api;
    }
}
