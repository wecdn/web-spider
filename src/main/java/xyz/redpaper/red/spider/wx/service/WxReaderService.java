package xyz.redpaper.red.spider.wx.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xyz.redpaper.red.msg.ReturnData;
import xyz.redpaper.red.msg.YesApi;
import xyz.redpaper.red.spider.wx.util.ArticleCategoryEnum;
import xyz.redpaper.red.spider.wx.util.ReadWeiXinHtml;
import xyz.redpaper.red.spider.wx.util.YesApiUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Service
public class WxReaderService {

    /**
     * 图片本地缓存
     */
    @Value("${article.wx.img.local.cache.path}")
    private String localImgCachePath;

    public ReturnData getWordPressArticleFormWx(String articleUrl, String articleOrder, String articleType) throws IOException, InterruptedException {
        ReturnData rd = new ReturnData();
        Map<String, String> map = new HashMap<String, String>();
        ArticleCategoryEnum articleTypeEnum = ArticleCategoryEnum.getByType(articleType);
        StringBuilder simplifiedArticleContent = new StringBuilder();
        //简体内容
        String articleTitle = ReadWeiXinHtml.wxArticleSpider(articleUrl, articleTypeEnum, articleOrder, localImgCachePath, simplifiedArticleContent);
        //繁体内容
        YesApi yesApi = new YesApi();
        int tryTime = 4;
        do{
            yesApi = YesApiUtils.s2t(simplifiedArticleContent.toString());
            tryTime--;
            Thread.sleep(1000);
        }while(
            (!"200".equals(yesApi.getRet()) || null==yesApi.getData() ||  null==yesApi.getData().getText()) && tryTime>0
        );
        map.put("articleTitle", articleTitle);
        map.put("simplifiedArticleContent", simplifiedArticleContent.toString());
        map.put("traditionalArticleContent", yesApi.getData().getText());
        rd.setData(map);
        return rd;
    }


}
