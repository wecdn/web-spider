package xyz.redpaper.red.spider.wx.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xyz.redpaper.red.msg.ReturnData;
import xyz.redpaper.red.msg.S2tApi;
import xyz.redpaper.red.spider.util.FileUtils;
import xyz.redpaper.red.spider.util.SequenceUtils;
import xyz.redpaper.red.spider.util.TimeUtils;
import xyz.redpaper.red.spider.util.WordConvertUtils;
import xyz.redpaper.red.spider.wx.dao.ArticleOrderRepository;
import xyz.redpaper.red.spider.wx.dao.PostMapper;
import xyz.redpaper.red.spider.wx.dao.PostRepository;
import xyz.redpaper.red.spider.wx.entity.ArticleOrder;
import xyz.redpaper.red.spider.wx.entity.Post;
import xyz.redpaper.red.spider.wx.util.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class WxReaderService {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ArticleOrderRepository articleOrderRepository;

    public static final Integer TRY_TIME = 3;

    /**
     * 图片本地缓存
     */
    @Value("${article.wx.img.local.cache.path}")
    private String localImgCachePath;

    /**
     * 解析微信文章
     * @param articleUrl
     * @param articleType
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public ReturnData analysisWx(String articleUrl, String articleType) throws IOException, InterruptedException {
        ReturnData rd = new ReturnData();
        //缓存文件夹
        FileUtils.newFolder(localImgCachePath);
        ArticleCategoryEnum articleTypeEnum = ArticleCategoryEnum.getByType(articleType);
        StringBuilder simplifiedArticleContent = new StringBuilder();
        //计算文章序号
        String articleOrder = "001";
        String today = TimeUtils.getTodayStr(TimeUtils.DATE_FORMATTER_YYYYMMDD);
        Optional<ArticleOrder> order = articleOrderRepository.findById(Integer.valueOf(today));
        if(order.isPresent()){
            articleOrder = SequenceUtils.getThousandSeq(order.get().getArticleOrder() + 1);
        }
        //爬取文章
        String articleTitle = ReadWeiXinHtml.wxArticleSpider(articleUrl, articleTypeEnum, articleOrder, localImgCachePath, simplifiedArticleContent);
        //简转繁
        S2tApi content = WordConvertUtils.tryS2t(simplifiedArticleContent.toString(), TRY_TIME);
        S2tApi title = WordConvertUtils.tryS2t(articleTitle, TRY_TIME);
        if(null!=content.getResult() && null!=content.getResult().getRcontent() && null!=title.getResult() && null!=title.getResult().getRcontent()){
            savePost(title, content);
            saveOrder(order);
        }else{
            rd.setState(ReturnData.STATE_NO);
            rd.setData("采集失败 - s2t接口返回的数据无效");
        }
        return rd;
    }

    /**
     * 保存文章
     * @param title
     * @param content
     */
    private void savePost(S2tApi title, S2tApi content){
        //保存post
        Long postId = postMapper.findMaxId() + 1;
        Date postDate = TimeUtils.getTodayDate();
        Date postDateGmt = TimeUtils.getTodayBeforeHourDate(8L);
        Post post = new Post();
        post.setId(postId);
        post.setPostAuthor(1L);
        post.setPostDate(postDate);
        post.setPostDateGmt(postDateGmt);
        post.setPostContent(content.getResult().getRcontent());
        post.setPostTitle(title.getResult().getRcontent());
        post.setPostExcerpt("");
        post.setPostStatus("publish");
        post.setCommentStatus("open");
        post.setPingStatus("open");
        post.setPostPassword("");
        post.setPostName(title.getResult().getRcontent());
        post.setToPing("");
        post.setPinged("");
        post.setPostModified(postDate);
        post.setPostModifiedGmt(postDateGmt);
        post.setPostContentFiltered("");
        post.setPostParent(0L);
        post.setGuid("https://www.redpaper.xyz/?p=" + postId);
        post.setMenuOrder(0);
        post.setPostType("post");
        post.setPostMimeType("");
        post.setCommentCount(0L);
        postRepository.save(post);
    }

    /**
     * 保存文章序号
     * @param orderOpt
     */
    private void saveOrder(Optional<ArticleOrder> orderOpt){
        if(orderOpt.isPresent()){
            ArticleOrder order = orderOpt.get();
            order.setArticleOrder(order.getArticleOrder() + 1);
            articleOrderRepository.save(order);
        }else{
            ArticleOrder order = new ArticleOrder();
            order.setDayId(Integer.valueOf(TimeUtils.getTodayStr(TimeUtils.DATE_FORMATTER_YYYYMMDD)));
            order.setArticleOrder(1);
            articleOrderRepository.save(order);
        }
    }
}
