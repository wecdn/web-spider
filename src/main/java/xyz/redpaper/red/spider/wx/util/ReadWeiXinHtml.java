package xyz.redpaper.red.spider.wx.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * 读取微信订阅号内容
 * 最终目的：生成与原文章一样的html字符串，并且符合wordpress格式
 */
public class ReadWeiXinHtml {

    /**
     * 微信公众号爬虫
     */
    public static String wxArticleSpider(String urlStr, ArticleCategoryEnum cat, String articleOrder, String localImgCachePath, StringBuilder simplifiedArticleContent) throws IOException, InterruptedException {
        URL url = new URL(urlStr);
        Document doc = Jsoup.parse(url, 10000);
        //文章板块
        Element js_article = doc.getElementById("js_article");
        //标题
        String title = js_article.getElementById("activity-name").text();
        System.out.println("===文章标题："+title);
        //文章内容
        Element js_content = js_article.getElementById("js_content");
        Elements elements = js_content.getAllElements();
        for (Element e : elements) {
            if ("p".equals(e.tagName())) {
                simplifiedArticleContent.append("<!-- wp:paragraph -->");
                simplifiedArticleContent.append("<p>");
                simplifiedArticleContent.append(e.text());
                simplifiedArticleContent.append("</p>");
                simplifiedArticleContent.append("<!-- /wp:paragraph -->");
            } else if("span".equals(e.tagName())){
                simplifiedArticleContent.append(e.text());
            }else if ("img".equals(e.tagName())) {
                simplifiedArticleContent.append("<!-- wp:image {\"sizeSlug\":\"large\"} -->");
                simplifiedArticleContent.append(imgHandler(e, title, cat, articleOrder, localImgCachePath));
                simplifiedArticleContent.append("<!-- /wp:image -->");
            } else if ("h1".equals(e.tagName())) {
                simplifiedArticleContent.append("<!-- wp:heading -->");
                simplifiedArticleContent.append("<h1>");
                simplifiedArticleContent.append(e.text());
                simplifiedArticleContent.append("</h1>");
                simplifiedArticleContent.append("<!-- /wp:heading -->");
            }else if ("h2".equals(e.tagName())) {
                simplifiedArticleContent.append("<!-- wp:heading -->");
                simplifiedArticleContent.append("<h2>");
                simplifiedArticleContent.append(e.text());
                simplifiedArticleContent.append("</h2>");
                simplifiedArticleContent.append("<!-- /wp:heading -->");
            }else if ("h3".equals(e.tagName())) {
                simplifiedArticleContent.append("<!-- wp:heading -->");
                simplifiedArticleContent.append("<h3>");
                simplifiedArticleContent.append(e.text());
                simplifiedArticleContent.append("</h3>");
                simplifiedArticleContent.append("<!-- /wp:heading -->");
            }else if ("h4".equals(e.tagName())) {
                simplifiedArticleContent.append("<!-- wp:heading -->");
                simplifiedArticleContent.append("<h4>");
                simplifiedArticleContent.append(e.text());
                simplifiedArticleContent.append("</h4>");
                simplifiedArticleContent.append("<!-- /wp:heading -->");
            }else if ("h5".equals(e.tagName())) {
                simplifiedArticleContent.append("<!-- wp:heading -->");
                simplifiedArticleContent.append("<h5>");
                simplifiedArticleContent.append(e.text());
                simplifiedArticleContent.append("</h5>");
                simplifiedArticleContent.append("<!-- /wp:heading -->");
            }else if ("h6".equals(e.tagName())) {
                simplifiedArticleContent.append("<!-- wp:heading -->");
                simplifiedArticleContent.append("<h6>");
                simplifiedArticleContent.append(e.text());
                simplifiedArticleContent.append("</h6>");
                simplifiedArticleContent.append("<!-- /wp:heading -->");
            }
        }
        return title;
    }

    /**
     * 处理公众号里面的图片
     * 返回数据格式举例: <figure class="wp-block-image size-large">
     *                    <img src="https://cdn.jsdelivr.net/gh/wecdn/red01@master/2020/09/20200919_001_201009_web.png"
     *                         alt="哼哼哈嘿" />
     *                </figure>
     * @param e
     * @param title
     * @return
     * @throws IOException
     */
    private static StringBuilder imgHandler(Element e, String title, ArticleCategoryEnum cat, String articleOrder, String localImgCachePath) throws IOException, InterruptedException {
        String imgSrc = e.attr("data-src");
        String imgFormat = e.attr("data-type");
        URL imgUrl = new URL(imgSrc);
        URLConnection conn = imgUrl.openConnection();
        InputStream is = conn.getInputStream();
        String imgName = getImgName(imgFormat, cat, articleOrder).toString();
        OutputStream os = new FileOutputStream(new File(localImgCachePath, imgName));
        byte[] buf = new byte[1024];
        int p = 0;
        while ((p = is.read(buf)) != -1) {
            os.write(buf, 0, p);
        }
        StringBuilder str = new StringBuilder();
        str.append("<figure class=\"wp-block-image size-large\">");
        str.append("<img src=\"https://cdn.jsdelivr.net/gh/wecdn/red01@master");
        //git目录
        str.append(TimeUtils.getGitDatePath());
        //图片名称
        str.append(imgName);
        str.append("\"");
        str.append("alt=\"");
        str.append(title);
        str.append("\"");
        str.append("/>");
        str.append("</figure>");
        return str;
    }

    /**
     * 获取图片名称
     * 图片名称格式举例：20200922_001_230215_web.png
     * @param imgFormat
     * @param cat
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
        Thread.sleep(2000);
        return str;
    }
}