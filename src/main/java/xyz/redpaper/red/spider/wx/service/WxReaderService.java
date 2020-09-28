package xyz.redpaper.red.spider.wx.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xyz.redpaper.red.msg.ReturnData;
import xyz.redpaper.red.msg.S2tApi;
import xyz.redpaper.red.spider.wx.dao.PostMapper;
import xyz.redpaper.red.spider.wx.dao.PostRepository;
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

    //文件缓存
    public static Map<String, List<String>> FILE_CACHE = new HashMap<String, List<String>>();
    //模拟用户id
    public static String USER_ID = "redpaper";

    public static final Integer Try_Time = 3;

    /**
     * 图片本地缓存
     */
    @Value("${article.wx.img.local.cache.path}")
    private String localImgCachePath;
    @Value("${article.wx.img.local.git.path}")
    private String localImgGitPath;

    /**
     * 解析微信文章
     * @param articleUrl
     * @param articleOrder
     * @param articleType
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public ReturnData analysisWx(String articleUrl, String articleOrder, String articleType) throws IOException, InterruptedException {
        ReturnData rd = new ReturnData();
        //缓存文件夹
        FileUtils.newFolder(localImgCachePath);
        //git仓库路径
        if(StringUtils.isBlank(localImgGitPath)){
            rd.setState(ReturnData.STATE_NO);
            rd.setData("请先配置本地Git路径，再重启程序");
            return rd;
        }
        ArticleCategoryEnum articleTypeEnum = ArticleCategoryEnum.getByType(articleType);
        StringBuilder simplifiedArticleContent = new StringBuilder();
        //爬取文章
        String articleTitle = ReadWeiXinHtml.wxArticleSpider(articleUrl, articleTypeEnum, articleOrder, localImgCachePath, localImgGitPath, simplifiedArticleContent, FILE_CACHE);
        //简转繁
        S2tApi content = YesApiUtils.tryS2t(simplifiedArticleContent.toString(), Try_Time);
        S2tApi title = YesApiUtils.tryS2t(articleTitle, Try_Time);
        if(null!=content.getResult() && null!=content.getResult().getRcontent() && null!=title.getResult() && null!=title.getResult().getRcontent()){
            Long maxPostId = postMapper.findMaxId();
            Date postDate = TimeUtils.getTodayDate();
            Date postDateGmt = TimeUtils.getTodayBeforeHourDate(8L);
            Long postId = maxPostId + 1;
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
            post.setPostName(articleTitle);
            post.setToPing("");
            post.setPinged("");
            post.setPostModified(postDate);
            post.setPostModifiedGmt(postDateGmt);
            post.setPostContentFiltered("");
            post.setPostParent(0L);
            post.setGuid("https://www.redpaper.xyz/?p="+postId);
            post.setMenuOrder(0);
            post.setPostType("post");
            post.setPostMimeType("");
            post.setCommentCount(0L);
            postRepository.save(post);
        }else{
            rd.setState(ReturnData.STATE_NO);
            rd.setData("yesApi接口返回的数据无效，本次解析失败");
        }
        return rd;
    }

    /**
     * 清空文件
     */
    public void clearFile() {
        List<String> list = FILE_CACHE.get(USER_ID);
        List<String> localImgCachePathFileList = new ArrayList<>();
        for(String file : list){
            localImgCachePathFileList.add(localImgCachePath + File.separator + file);
        }
        FileUtils.batchDelFile(localImgCachePathFileList);
    }
}
