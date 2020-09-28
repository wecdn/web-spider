package xyz.redpaper.red.spider.wx.util;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class HttpClientUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * 封装POST请求（Map入参）
     *
     * @param url 请求的路径
     * @param map 请求的参数
     * @return
     * @throws IOException
     */
    public static String post(String url, Map map) throws IOException {
//        1、创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
//        2、创建请求方式的实例
        HttpPost httpPost = new HttpPost();
        try {
            httpPost.setURI(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
//        3、添加请求参数(设置请求和传输超时时间)
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000).build();
        httpPost.setConfig(requestConfig);

        ArrayList<NameValuePair> list = new ArrayList<>();
        Set<Map.Entry> entrySet = map.entrySet();
        for (Map.Entry entry : entrySet) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            list.add(new BasicNameValuePair(key, value));
        }
        httpPost.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));
//        4、发送Http请求
        HttpResponse response = httpClient.execute(httpPost);
//        5、获取返回的内容
        String result = null;
        int statusCode = response.getStatusLine().getStatusCode();
        if (200 == statusCode) {
            result = EntityUtils.toString(response.getEntity());
        } else {
            logger.info("请求第三方接口出现错误，状态码为:{}", statusCode);
            return null;
        }
//        6、释放资源
        httpPost.abort();
        httpClient.getConnectionManager().shutdown();
        return result;
    }

}
