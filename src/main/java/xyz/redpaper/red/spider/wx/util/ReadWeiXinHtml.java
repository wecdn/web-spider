package xyz.redpaper.red.spider.wx.util;

import net.coobird.thumbnailator.Thumbnails;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * 读取微信订阅号内容
 * 最终目的：爬取与原文章一样的html
 */
public class ReadWeiXinHtml {

    /**
     * 单元测试
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        StringBuilder sb = new StringBuilder();
        String title = wxArticleSpider("https://mp.weixin.qq.com/s/ChwpBU12l_lh6MsVHHzDdA", ArticleCategoryEnum.HOUSE, "001", "D://today", "D://today/git", sb);
        System.out.println("文章标题: "+ title);
        System.out.println("简体中文文章内容: " + sb);
    }

    /**
     * 微信公众号爬虫
     * @param urlStr 爬取目标url
     * @param cat 文章分类
     * @param articleOrder 文章序号
     * @param localImgCachePath 图片本地缓存路径
     * @param simplifiedArticleContent 简体中文文章内容
     * @return 文章标题
     * @throws IOException
     * @throws InterruptedException
     */
    public static String wxArticleSpider(String urlStr, ArticleCategoryEnum cat, String articleOrder, String localImgCachePath, String localImgGitPath, StringBuilder simplifiedArticleContent) throws IOException, InterruptedException {
        URL url = new URL(urlStr);
        Document doc = Jsoup.parse(url, 10000);
        //文章板块
        Element js_article = doc.getElementById("js_article");
        //标题
        String title = js_article.getElementById("activity-name").text();
        //文章内容元素
        Element js_content = js_article.getElementById("js_content");
        Elements elements = js_content.getAllElements();
        //改变img的来源
        for (Element e : elements) {
            if("img".equals(e.tagName())){
                StringBuilder gitImgPath = imgHandler(e, title, cat, articleOrder, localImgCachePath, localImgGitPath);
                e.attr("data-src", gitImgPath.toString());
            }
        }
        simplifiedArticleContent.append(js_content.html());
        return title;
    }

    /**
     * 1. 下载公众号里面的图片
     * 2. 获取github图片地址
     * 返回数据格式举例: https://cdn.jsdelivr.net/gh/wecdn/red01@master/2020/09/20200919_001_201009_web.png
     * @param e
     * @param title
     * @return github图片地址
     * @throws IOException
     */
    private static StringBuilder imgHandler(Element e, String title, ArticleCategoryEnum cat, String articleOrder, String localImgCachePath, String localImgGitPath) throws IOException, InterruptedException {
        String imgSrc = e.attr("data-src");
        String imgFormat = e.attr("data-type");
        //图片格式处理
        if("jpeg".equalsIgnoreCase(imgFormat)){
            imgFormat = "jpg";
        }else if(!"png".equalsIgnoreCase(imgFormat)){
            imgFormat = "jpg";
        }
        URL imgUrl = new URL(imgSrc);
        URLConnection conn = imgUrl.openConnection();
        String imgName = getImgName(imgFormat, cat, articleOrder).toString();
        try(InputStream is = conn.getInputStream();
            OutputStream os = new FileOutputStream(new File(localImgCachePath, imgName))){
            byte[] buf = new byte[1024];
            int p = 0;
            while ((p = is.read(buf)) != -1) {
                os.write(buf, 0, p);
            }
        }
        //图片压缩
        String picIn = localImgCachePath + File.separator + imgName;
        String picOut = localImgGitPath + File.separator + imgName;
        thumbPic(imgFormat, picIn, picOut);
        StringBuilder str = new StringBuilder();
        str.append("https://cdn.jsdelivr.net/gh/wecdn/red01@master");
        //git目录
        str.append(TimeUtils.getGitDatePath());
        //图片名称
        str.append(imgName);
        return str;
    }

    /**
     * 获取图片名称(包括后缀名)
     * 图片名称格式举例：20200922_001_230215_web.png
     * 注意: 当前方法每次执行后会休眠几秒，防止获取的时间戳一致
     * @param imgFormat 图片格式
     * @param cat 文章类型
     * @return
     */
    private static StringBuilder getImgName(String imgFormat, ArticleCategoryEnum cat, String articleOrder) throws InterruptedException {
        StringBuilder str = new StringBuilder();
        //日期
        str.append(TimeUtils.getDate());
        str.append("_");
        //序号
        str.append(articleOrder);
        str.append("_");
        //时间
        str.append(TimeUtils.getTime());
        str.append("_");
        //文章类型
        str.append(cat.getType());
        //图片格式
        str.append(".");
        str.append(imgFormat);
        Thread.sleep(3000);
        return str;
    }

    /**
     * 图片压缩
     * @param picIn
     * @param picOut
     * @throws IOException
     */
    public static void thumbPic(String imgFormat, String picIn, String picOut) throws IOException {
        if("jpeg".equalsIgnoreCase(imgFormat) || "png".equalsIgnoreCase(imgFormat)){
            Thumbnails.of(picIn)
                    .imageType(BufferedImage.TYPE_INT_ARGB)
                    .scale(1.00f)
                    .outputQuality(0.5f)
                    .toFile(picOut);
        }
    }
}