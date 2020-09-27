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
        YesApi yesApi = s2t("<section style=\"display: none;\" data-tools=\"新媒体管家\" data-label=\"powered by xmt.cn\">\n" +
                " <br>\n" +
                "</section>\n" +
                "<p style=\"white-space: normal;text-align: center;\" data-mpa-powered-by=\"yiban.io\"><img class=\"rich_pages\" data-ratio=\"0.75\" data-s=\"300,640\" data-src=\"https://cdn.jsdelivr.net/gh/wecdn/red01@master/2020/09/20200927_001_235053_dev.jpg\" data-type=\"jpeg\" data-w=\"1024\"></p>\n" +
                "<p style=\"margin: 25px 8px;white-space: normal;-webkit-tap-highlight-color: transparent;border-width: 0px;border-style: initial;border-color: initial;color: rgb(34, 34, 34);font-family: &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, &quot;Helvetica Neue&quot;, Arial, sans-serif;font-size: 16px;background-color: rgb(255, 255, 255);line-height: 1.75em;\"><span style=\"font-size: 15px;\"><span style=\"color: rgb(18, 18, 18);font-family: -apple-system, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Microsoft YaHei', 'Source Han Sans SC', 'Noto Sans CJK SC', 'WenQuanYi Micro Hei', sans-serif;text-align: start;\">见过真正头铁的程序员吗？如题所示，真人真事，这位二本的兄弟在这短短几个月内海<strong>投了538份简历</strong>，全挑的大厂岗位投的，<strong>仅字节跳动就前前后后面试了九次</strong>，他说：没有撤退可言。</span></span><br></p>\n" +
                "<p style=\"margin: 25px 8px;white-space: normal;-webkit-tap-highlight-color: transparent;border-width: 0px;border-style: initial;border-color: initial;color: rgb(34, 34, 34);font-family: &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, &quot;Helvetica Neue&quot;, Arial, sans-serif;font-size: 16px;background-color: rgb(255, 255, 255);line-height: 1.75em;\"><span style=\"font-size: 15px;\"><span style=\"color: rgb(18, 18, 18);font-family: -apple-system, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Microsoft YaHei', 'Source Han Sans SC', 'Noto Sans CJK SC', 'WenQuanYi Micro Hei', sans-serif;text-align: start;\">九次面试经历也是奇了——</span></span></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><img class=\"rich_pages\" data-ratio=\"1.387962962962963\" data-s=\"300,640\" data-src=\"https://cdn.jsdelivr.net/gh/wecdn/red01@master/2020/09/20200927_001_235056_dev.jpg\" data-type=\"jpeg\" data-w=\"1080\"></p>\n" +
                "<p style=\"margin: 25px 8px;white-space: normal;-webkit-tap-highlight-color: transparent;border-width: 0px;border-style: initial;border-color: initial;color: rgb(34, 34, 34);font-family: &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, &quot;Helvetica Neue&quot;, Arial, sans-serif;font-size: 16px;background-color: rgb(255, 255, 255);line-height: 1.75em;\"><span style=\"color: rgb(18, 18, 18);font-family: -apple-system, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Microsoft YaHei', 'Source Han Sans SC', 'Noto Sans CJK SC', 'WenQuanYi Micro Hei', sans-serif;font-size: 15px;text-align: start;\">网友们的评论真相了：</span><span style=\"color: rgb(51, 51, 51);font-family: mp-quote, -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;font-size: 17px;\"></span></p>\n" +
                "<section style=\"white-space: normal;font-size: 16px;\">\n" +
                " <section powered-by=\"xiumi.us\" style=\"margin-top: 10px;margin-bottom: 8px;\">\n" +
                "  <section style=\"padding-left: 8px;display: inline-block;width: 578px;vertical-align: top;border-left: 3px solid rgb(219, 219, 219);border-bottom-left-radius: 0px;\">\n" +
                "   <section powered-by=\"xiumi.us\" style=\"color: rgba(0, 0, 0, 0.5);\">\n" +
                "    <p>“字节这么缺人？大家可以去投了”</p>\n" +
                "    <p><br></p>\n" +
                "    <p>“看来字节跳动就是要定你了！”</p>\n" +
                "    <p><br></p>\n" +
                "    <p>“哥们你这得累积多少大厂面试经验啊！快点传授一波！”</p>\n" +
                "    <p><br></p>\n" +
                "    <p>“我的天哪，638份简历，9次字节面试，吾辈楷模。”<span style=\"color: rgb(51, 51, 51);font-family: mp-quote, -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;font-size: 17px;\"></span></p>\n" +
                "   </section>\n" +
                "  </section>\n" +
                " </section>\n" +
                "</section>\n" +
                "<p style=\"margin: 25px 8px;white-space: normal;-webkit-tap-highlight-color: transparent;border-width: 0px;border-style: initial;border-color: initial;color: rgb(34, 34, 34);font-family: &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, &quot;Helvetica Neue&quot;, Arial, sans-serif;font-size: 16px;background-color: rgb(255, 255, 255);line-height: 1.75em;\"><strong><span style=\"font-size: 15px;\">真正的海量面经！</span></strong><span style=\"font-size: 15px;\">问及面试考题，</span><span style=\"font-size: 15px;\">这位兄弟言辞中有些许惭愧：面试官已经给了一些提示，但无奈自己准备得不充分，回答很不理想。</span><span style=\"font-size: 15px;\">他没想到，像</span><span style=\"font-size: 15px;-webkit-tap-highlight-color: transparent;border-width: 0px;border-style: initial;border-color: initial;font-weight: 700;\">Seata、Nacos，Sentinel，Eureka</span><span style=\"font-size: 15px;\">等这些在工作中都有涉及过的技术，面试官会问的这么深入——</span><span style=\"color: rgb(51, 51, 51);font-family: mp-quote, -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;font-size: 17px;\"></span></p>\n" +
                "<section style=\"white-space: normal;font-size: 16px;\">\n" +
                " <section style=\"margin-top: 20px;margin-bottom: 20px;line-height: 1.5em;\">\n" +
                "  <section style=\"padding-bottom: 10px;display: inline-block;width: 578px;vertical-align: top;border-left: 1px dashed rgb(0, 0, 0);border-bottom-left-radius: 0px;border-bottom: 1px dashed rgb(0, 0, 0);border-bottom-right-radius: 0px;\">\n" +
                "   <section powered-by=\"xiumi.us\" style=\"text-align: right;justify-content: flex-end;\">\n" +
                "    <section style=\"padding-top: 10px;padding-right: 6px;display: inline-block;width: 565.453px;vertical-align: top;border-top: 1px dashed rgb(0, 0, 0);border-top-left-radius: 0px;border-bottom: 0px none rgb(62, 62, 62);border-bottom-right-radius: 0px;border-right: 1px dashed rgb(0, 0, 0);border-top-right-radius: 0px;height: auto;\">\n" +
                "     <section powered-by=\"xiumi.us\">\n" +
                "      <section style=\"text-align: center;color: rgb(62, 62, 62);letter-spacing: 2px;\">\n" +
                "       <p style=\"text-align: left;\"><span style=\"font-size: 15px;\">1、<span style=\"text-align: center;\">微服务注册中心的注册表如何更好的防止读写并发冲突？</span></span></p>\n" +
                "       <p style=\"text-align: left;\"><span style=\"text-align: center;font-size: 15px;\">2、Eureka注册表多级缓存架构有了解过吗？</span></p>\n" +
                "       <p style=\"text-align: left;\"><span style=\"text-align: center;font-size: 15px;\">3、Nacos如何支撑阿里巴巴内部上百万服务实例的访问？</span></p>\n" +
                "       <p style=\"text-align: left;\"><span style=\"text-align: center;font-size: 15px;\">4、Nacos高并发异步注册架构知道如何设计的吗？</span></p>\n" +
                "       <p style=\"text-align: left;\"><span style=\"text-align: center;font-size: 15px;\">5、Sentinel底层滑动时间窗限流算法怎么实现的？</span></p>\n" +
                "       <p style=\"text-align: left;\"><span style=\"text-align: center;font-size: 15px;\">6、Sentinel底层是如何计算线上系统实时QPS的？</span></p>\n" +
                "       <p style=\"text-align: left;\"><span style=\"text-align: center;font-size: 15px;\">7、Seata分布式事务协调管理器是如何实现的？</span></p>\n" +
                "       <p style=\"text-align: left;\"><span style=\"text-align: center;font-size: 15px;\">8、Seata分布式事务一致性锁机制如何设计的？</span></p>\n" +
                "       <p style=\"text-align: left;\"><span style=\"text-align: center;font-size: 15px;\">9、Seata分布式事务回滚机制如何实现的？</span></p>\n" +
                "       <p style=\"text-align: left;\"><span style=\"text-align: center;font-size: 15px;\">10、Nacos集群CP架构底层类Raft协议怎么实现的？</span></p>\n" +
                "       <p style=\"text-align: left;\"><span style=\"font-size: 15px;text-align: center;\">11、Nacos&amp;Eureka&amp;Zookeeper集群架构都有脑裂问题吗？</span></p>\n" +
                "       <p style=\"text-align: left;\"><span style=\"text-align: center;font-size: 15px;\">12、如何设计能支撑全世界公司使用的微服务云架构？</span></p>\n" +
                "      </section>\n" +
                "     </section>\n" +
                "    </section>\n" +
                "   </section>\n" +
                "  </section>\n" +
                " </section>\n" +
                "</section>\n" +
                "<section style=\"margin-right: 8px;margin-left: 8px;white-space: normal;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">看完你能回答上几道？</span>\n" +
                "</section>\n" +
                "<section style=\"margin-right: 8px;margin-left: 8px;white-space: normal;\">\n" +
                " <br>\n" +
                "</section>\n" +
                "<section style=\"margin-right: 8px;margin-left: 8px;white-space: normal;text-align: center;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\"><img class=\"rich_pages js_insertlocalimg\" data-ratio=\"0.6578947368421053\" data-s=\"300,640\" data-src=\"https://cdn.jsdelivr.net/gh/wecdn/red01@master/2020/09/20200927_001_235059_dev.jpg\" data-type=\"gif\" data-w=\"456\" style=\"width: 260.094px;\"></span>\n" +
                "</section>\n" +
                "<section style=\"margin-right: 8px;margin-left: 8px;white-space: normal;\">\n" +
                " <br>\n" +
                "</section>\n" +
                "<section style=\"margin-right: 8px;margin-left: 8px;white-space: normal;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">据我所知，如果能回答的出其中的一半，就算是勉强及格了。</span>\n" +
                "</section>\n" +
                "<section style=\"margin-right: 8px;margin-left: 8px;white-space: normal;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">如果十二条你都能全部回答出来，那你应该是妥妥的技术大牛了！可以放心去投大厂简历了！</span>\n" +
                "</section>\n" +
                "<section style=\"margin-right: 8px;margin-left: 8px;white-space: normal;\">\n" +
                " <br>\n" +
                "</section>\n" +
                "<section style=\"margin-right: 8px;margin-left: 8px;white-space: normal;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">但如果你没办法完全答出这些问题，我建议你听听这四天的课，来提升一下自己的核心竞争力，这四节课就是</span><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;color: rgb(255, 76, 0);font-weight: bold;\"><strong style=\"color: rgb(6, 137, 229);font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;\">《3天阿里微服务架构专题特训营》，从阿里微服务架构实战到源码级别深度讲解</strong></span><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">！</span>\n" +
                "</section>\n" +
                "<section style=\"margin-right: 8px;margin-left: 8px;white-space: normal;\">\n" +
                " <span style=\"font-family: mp-quote, -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;\"></span>\n" +
                " <br>\n" +
                "</section>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);\">拿到150个专属福利名额</span></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);color: rgb(255, 169, 0);font-weight: bold;\">扫码立即0元报名</span></p>\n" +
                "<p style=\"text-align: center;\"><img data-ratio=\"1\" data-src=\"https://cdn.jsdelivr.net/gh/wecdn/red01@master/2020/09/20200927_001_235102_dev.png\" data-type=\"png\" data-w=\"260\" style=\"width: 228px;height: 228px;\"></p>\n" +
                "<p style=\"margin: 25px 8px;white-space: normal;font-size: medium;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: 1.75em;\"><span style=\"color: rgb(63, 63, 63);font-family: 'Microsoft YaHei';font-size: 15px;letter-spacing: 1px;\">这期课程是<strong>技术大牛诸葛老师</strong>根据一线大厂面试内容专门出的，并且<span style=\"color: rgb(255, 76, 0);font-weight: 700;text-align: center;background-color: rgb(255, 255, 255);\"><strong style=\"color: rgb(6, 137, 229);font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;\">免费</strong></span>！针对技术人的<span style=\"color: rgb(255, 76, 0);font-family: 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei', 'WenQuanYi Micro Hei', 'Helvetica Neue', Arial, sans-serif;font-weight: 700;background-color: rgb(255, 255, 255);\"><strong style=\"color: rgb(6, 137, 229);font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;\">面试考点</strong></span>与<span style=\"color: rgb(255, 76, 0);font-family: 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei', 'WenQuanYi Micro Hei', 'Helvetica Neue', Arial, sans-serif;font-weight: 700;background-color: rgb(255, 255, 255);\"><strong style=\"color: rgb(6, 137, 229);font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;\">成长路径</strong></span>，给程序员传授实用的技能跟面试技巧，</span><span style=\"font-family: 'Microsoft YaHei';font-size: 15px;letter-spacing: 1px;\"><span style=\"color: rgb(63, 63, 63);\">培养真正符合一线互联网公司用人需求的人才，</span></span><span style=\"color: rgb(63, 63, 63);font-size: 15px;letter-spacing: 1px;\">针对具体技能进行深度剖析讲解，结合一线互联网大厂热门面试题详析，搞定大厂面试，拿下心仪offer。</span><span style=\"background-color: rgb(255, 255, 255);text-align: center;font-family: mp-quote, -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;\"></span></p>\n" +
                "<p style=\"margin: 25px 8px;white-space: normal;color: rgb(0, 0, 0);font-size: medium;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: 1.75em;\"><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;color: rgb(63, 63, 63);font-family: 'Microsoft YaHei';letter-spacing: 1px;\">在这四天的训练营中，由三位具有十多年经验的一线互联网大厂的讲师讲解，每天一节课，直播时可以一起聊聊，大家工作中遇到的问题和程序员职业发展方向、瓶颈等，都能为大家解答！</span></p>\n" +
                "<p style=\"margin: 25px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: 1.75em;\"><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;color: rgb(63, 63, 63);letter-spacing: 1px;\">所以这次金九银十跳槽季，想进大厂的同学，希望大家抓住机会，四天时间，抓紧提升！</span></p>\n" +
                "<p style=\"margin: 10px 8px 15px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: 1.75em;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">3天7个半小时干货，看海报▼</span></p>\n" +
                "<p style=\"text-align: center;\"><img class=\"rich_pages js_insertlocalimg\" data-cropselx1=\"0\" data-cropselx2=\"578\" data-cropsely1=\"0\" data-cropsely2=\"1474\" data-ratio=\"2.55\" data-s=\"300,640\" data-src=\"https://cdn.jsdelivr.net/gh/wecdn/red01@master/2020/09/20200927_001_235105_dev.jpg\" data-type=\"jpeg\" data-w=\"800\" style=\"width: 578px;height: 1474px;\"><span style=\"font-family: mp-quote, -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;text-align: justify;\"></span></p>\n" +
                "<section style=\"margin: 10px 8px 15px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: 1.75em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;font-weight: bold;\">训练营时间：</span><span style=\"font-family: mp-quote, -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;\"></span>\n" +
                "</section>\n" +
                "<p style=\"margin: 10px 8px 5px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: 1.75em;\"><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;color: rgb(255, 0, 0);font-weight: bold;\">9月28日</span><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;font-weight: bold;\"></span><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;color: rgb(255, 0, 0);font-weight: bold;\">-9月30日，20:00-22:30</span><span style=\"font-family: mp-quote, -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;\"></span></p>\n" +
                "<section style=\"margin: 10px 8px 15px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: 1.75em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;font-weight: bold;\">课程技能点目录：</span><span style=\"font-family: mp-quote, -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;\"></span>\n" +
                "</section>\n" +
                "<p style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;\"><span style=\"color: rgb(6, 137, 229);\"><span style=\"font-size: 15px;\"><span style=\"background-color: rgb(255, 255, 255);font-weight: bold;\">第一天</span><strong><span style=\"background-color: rgb(255, 255, 255);\">：</span></strong></span><strong style=\"font-size: 15px;\">阿里微服务架构Spring?Cloud?Alibaba实战</strong></span></p>\n" +
                "<p><br></p>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"font-size: 15px;\">1、亿级流量电商网站微服务架构详解</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"font-size: 15px;\">2、Nacos注册中心实现电商微服务拆分实战</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"font-size: 15px;\">3、Ribbon多实例服务负载均衡调用实战</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"font-size: 15px;\">4、Sentinel服务高可用限流熔断降级实战</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"font-size: 15px;\">5、微服务架构下的分布式事务Seata实战</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"font-size: 15px;\">6、路由&amp;限流&amp;安全认证网关Gateway实战</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"font-size: 15px;\">7、Nacos分布式配置中心详解</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"font-size: 15px;\">8、微服务调用链路追踪Pinpoint详解</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"font-size: 15px;\">9、微服务自动化监控Prometheus&amp;Grafana详解</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"font-size: 15px;\">10、阿里京东后端微服务中台架构实战</span>\n" +
                "</section>\n" +
                "<p style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;\"><br></p>\n" +
                "<p style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;\"><span style=\"background-color: rgb(255, 255, 255);font-weight: bold;font-size: 15px;\"></span><strong style=\"color: rgb(6, 137, 229);font-size: 15px;\"><span style=\"background-color: rgb(255, 255, 255);\">第二天：</span><span style=\"background-color: rgb(255, 255, 255);\">阿里微服务架构Spring Cloud Alibaba源码深度剖析</span></strong><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;font-weight: 700;\"></span></p>\n" +
                "<p><br></p>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">1、Nacos服务注册与发现源码深度剖析</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">2、Nacos心跳机制与服务健康检查源码剖析</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">3、Nacos注册表如何防止多节点读写并发冲突</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">4、Nacos高并发支撑异步任务与内存队列剖析</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">5、Nacos集群CP架构底层Raft协议实现源码剖析</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">6、从脑裂问题剖析Nacos&amp;Eureka&amp;Zookeeper架构异同</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">7、阿里云超大规模注册中心SaaS架构剖析</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">8、Sentinel底层滑动时间窗限流算法深度剖析</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">9、利用Sentinel的Metric机制计算线上系统实时QPS</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">10、Seata分布式事务回滚机制剖析</span><span style=\"font-family: mp-quote, -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;\"></span>\n" +
                "</section>\n" +
                "<p style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;\"><br></p>\n" +
                "<p style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;\"><span style=\"background-color: rgb(255, 255, 255);font-weight: bold;font-size: 15px;\"><strong style=\"color: rgb(6, 137, 229);\"><strong>第三天：</strong>阿里微服务分布式事务Seata源码深度剖析</strong></span><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\"></span></p>\n" +
                "<p><br></p>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">1、微服务架构分布式事务详解</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">2、十分钟快速实战阿里分布式事务框架Seata</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">3、Seata中AT模式模型架构与数据模型设计</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">4、Seata事务管理器实现原理详解</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">5、Seata全局事务与分支事务源码剖析</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">6、Seata数据源代理扩展源码剖析</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">7、Seata事务隔离级别底层源码剖析</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">8、Seata事务超时、二阶段失败解决方案源码剖析</span>\n" +
                "</section>\n" +
                "<section style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;text-indent: 2em;\">\n" +
                " <span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">9、生产环境AT模式与TCC模式性能差异分析</span><span style=\"font-family: mp-quote, -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;\"></span>\n" +
                "</section>\n" +
                "<p style=\"margin: 5px 8px;white-space: normal;font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;line-height: normal;\"><br></p>\n" +
                "<p style=\"white-space: normal;\"><span style=\"font-size: 15px;color: rgb(172, 57, 255);font-weight: 700;\"><strong style=\"font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;color: rgb(6, 137, 229);\"><span style=\"background-color: rgb(255, 255, 255);\">训练营中将会提供哪些学习服务？</span></strong></span></p>\n" +
                "<p style=\"white-space: normal;\"><span style=\"font-size: 15px;\"><span style=\"color: rgb(255, 76, 0);font-weight: 700;background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(255, 169, 0);text-align: center;\">直播授课：</span><span style=\"color: rgb(255, 169, 0);text-align: center;\"></span></span>全程直播授课，可与讲师技术互动，实时解答你的技术疑问。<br></span></p>\n" +
                "<p style=\"white-space: normal;\"><span style=\"font-size: 15px;\"><span style=\"color: rgb(255, 76, 0);font-weight: 700;background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(255, 169, 0);text-align: center;\">作业实战：</span><span style=\"color: rgb(255, 169, 0);text-align: center;\"></span></span>课后通过实战作业，进一步提升对技术的理解，巩固学到的技能。<br></span></p>\n" +
                "<p style=\"white-space: normal;\"><span style=\"font-size: 15px;\"><span style=\"color: rgb(255, 76, 0);font-weight: 700;\"><span style=\"color: rgb(255, 169, 0);text-align: center;background-color: rgb(255, 255, 255);\">助教督学：</span></span>资料发放、提醒到课及其他学习相关疑问都可以反映给助教。</span></p>\n" +
                "<p style=\"white-space: normal;\"><span style=\"font-size: 15px;\"><span style=\"color: rgb(255, 76, 0);font-weight: 700;background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(255, 169, 0);text-align: center;\">学习资料：</span></span>领取独家微服务架构项目源码以及课上笔记资料。</span></p>\n" +
                "<p style=\"white-space: normal;\"><br></p>\n" +
                "<p style=\"white-space: normal;\"><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;\">参与本次直播课程还可以有机会获得<span style=\"color: rgb(255, 169, 0);font-weight: 700;text-align: center;\">超级多重</span><span style=\"color: rgb(255, 169, 0);font-weight: 700;text-align: center;\">福利</span><span style=\"color: rgb(255, 169, 0);font-weight: 700;text-align: center;\"></span>哦~</span><span style=\"color: rgb(255, 76, 0);font-size: 15px;font-weight: 700;background-color: rgb(255, 255, 255);\"></span></p>\n" +
                "<p style=\"white-space: normal;\"><br></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;color: rgb(172, 57, 255);font-weight: bold;\"><strong style=\"font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;color: rgb(6, 137, 229);\">超级福利一：送书</strong></span></p>\n" +
                "<p style=\"white-space: normal;\"><span style=\"font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;font-size: 15px;letter-spacing: 0.544px;background-color: rgb(255, 255, 255);\">上课抽奖还可以获得《</span><span style=\"font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;letter-spacing: 0.544px;font-size: 15px;background-color: rgb(199, 224, 244);\">一线互联网公司Java面试核心知识点</span><span style=\"font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;font-size: 15px;letter-spacing: 0.544px;background-color: rgb(255, 255, 255);\">》教材：</span></p>\n" +
                "<p style=\"white-space: normal;\"><br></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;font-size: 15px;letter-spacing: 0.544px;background-color: rgb(255, 255, 255);\">①2020最新版BATJ大厂面试题合集<br></span></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;font-size: 15px;letter-spacing: 0.544px;background-color: rgb(255, 255, 255);\">②独家内部教材分享含</span><span style=\"background-color: rgb(255, 255, 255);font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;font-size: 15px;letter-spacing: 0.544px;\">13个架构模块</span></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;font-size: 15px;letter-spacing: 0.544px;background-color: rgb(255, 255, 255);\">③涵盖九成以上应用场景典型真题分析</span></p>\n" +
                "<p style=\"white-space: normal;\"><br></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><img class=\"rich_pages\" data-ratio=\"0.75078125\" data-s=\"300,640\" data-src=\"https://cdn.jsdelivr.net/gh/wecdn/red01@master/2020/09/20200927_001_235108_dev.jpg\" data-type=\"jpeg\" data-w=\"1280\" style=\"width: 433.5px;\"></p>\n" +
                "<p style=\"white-space: normal;\"><br></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"color: rgb(172, 57, 255);font-size: 15px;font-weight: 700;background-color: rgb(255, 255, 255);\"><strong style=\"font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;color: rgb(6, 137, 229);\">超级福利二：面试资料</strong></span></p>\n" +
                "<p style=\"white-space: normal;\"><span style=\"font-size: 15px;\">免费领取2020年最新最全的一线互联网大厂面试题及详析，帮助你更快更稳地拿下心仪offer！</span></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><img class=\"rich_pages\" data-ratio=\"1.1060419235511714\" data-s=\"300,640\" data-src=\"https://cdn.jsdelivr.net/gh/wecdn/red01@master/2020/09/20200927_001_235111_dev.png\" data-type=\"png\" data-w=\"811\"></p>\n" +
                "<p style=\"white-space: normal;\"><br></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;color: rgb(172, 57, 255);font-weight: bold;\"><strong style=\"font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;color: rgb(6, 137, 229);\">超级福利三：抽奖</strong></span></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;font-style: italic;\">一等奖：小米背包&nbsp;*&nbsp; 5</span></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;font-style: italic;\">二等奖：小米蓝牙耳机&nbsp;* &nbsp;10</span></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;font-style: italic;\">三等奖：罗技无线鼠标&nbsp;*&nbsp; 20</span></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><br></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><img class=\"rich_pages\" data-ratio=\"0.3333333333333333\" data-s=\"300,640\" data-src=\"https://cdn.jsdelivr.net/gh/wecdn/red01@master/2020/09/20200927_001_235115_dev.jpg\" data-type=\"jpeg\" data-w=\"450\"></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><br></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;color: rgb(172, 57, 255);font-weight: bold;\"><strong style=\"font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;color: rgb(6, 137, 229);\">再强调一遍，扫码后：</strong></span></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;font-style: italic;\">1.先领取预习资料</span></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;font-style: italic;\">2.参与直播课程，免费抽大奖</span></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;font-style: italic;\">3.上课打卡，送实体书籍</span></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);font-size: 15px;font-style: italic;\">4.联系助教，领取面试资料</span></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><br></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);\">本号粉丝专属福利</span></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);color: rgb(255, 169, 0);font-weight: bold;\">扫码立即免费报名</span></p>\n" +
                "<p style=\"text-align: center;\"><img data-ratio=\"1\" data-src=\"https://cdn.jsdelivr.net/gh/wecdn/red01@master/2020/09/20200927_001_235118_dev.png\" data-type=\"png\" data-w=\"260\" style=\"width: 240px;height: 240px;\"></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);\">长按扫码，</span><span style=\"background-color: rgb(255, 255, 255);color: rgb(255, 76, 0);font-weight: bold;\">抢最后150个名额</span></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;font-size: 15px;\"><span style=\"color: rgb(255, 169, 0);font-weight: 700;\"></span></span></p>\n" +
                "<p style=\"white-space: normal;text-align: center;\"><span style=\"background-color: rgb(255, 255, 255);font-family: 'Helvetica Neue', Helvetica, 'Hiragino Sans GB', 'Microsoft YaHei', Arial, sans-serif;font-size: 15px;\"><span style=\"color: rgb(255, 169, 0);font-weight: 700;\">给自己进击大厂增加砝码</span></span></p>\n");
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
