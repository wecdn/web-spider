package xyz.redpaper.red.spider.wx.util;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import xyz.redpaper.red.msg.YesApi;

import java.io.IOException;
import java.net.URL;

public class YesApiUtils {

    public static void main(String[] args) {
        YesApi yesApi = s2t("本站对作者上传的内容将尽可能审核来源及出处，但对内容不作任何保证或承诺。其真实性及合法性请读者自行核实。如您发现图文内容有误或侵犯了您的权益请告知，本站将及时予以修改或删除。");
        System.out.println(null==yesApi);
        System.out.println(!"200".equals(yesApi.getRet()));
        System.out.println(null==yesApi.getData());
        System.out.println(null==yesApi.getData().getText());
        if(null==yesApi || !"200".equals(yesApi.getRet()) || null==yesApi.getData() || null==yesApi.getData().getText()){
            System.out.println("GG");
        }
    }

    public static YesApi s2t(String s) {
        YesApi api = new YesApi();
        StringBuilder url = new StringBuilder("http://hb9.api.yesapi.cn/?s=App.Opencc.Convert");
        url.append("&return_data=0");
        url.append("&text=");
        url.append(s);
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
