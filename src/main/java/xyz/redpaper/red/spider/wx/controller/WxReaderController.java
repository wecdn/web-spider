package xyz.redpaper.red.spider.wx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.redpaper.red.msg.ReturnData;
import xyz.redpaper.red.spider.wx.service.WxReaderService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WxReaderController {
    private static final Logger logger = LoggerFactory.getLogger(WxReaderController.class);

    @Autowired
    private WxReaderService wxReaderService;

    /**
     * 页面跳转
     * @return
     */
    @GetMapping("/wx")
    public String toIndex(){
        return "wx/index";
    }

    /**
     * 测试
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/wx/analysis/test")
    @ResponseBody
    public ReturnData test() throws InterruptedException {
        ReturnData rd = new ReturnData();
        Thread.sleep(2000);
        System.out.println("===测试===");
        return rd;
    }

    /**
     * 解析微信文章
     * @param request
     * @return
     */
    @GetMapping("/wx/analysis")
    @ResponseBody
    public ReturnData analysisWx(HttpServletRequest request){
        ReturnData rd = new ReturnData();
        try {
            String articleUrl = request.getParameter("articleUrl");
            String articleOrder = request.getParameter("articleOrder");
            String articleType = request.getParameter("articleType");
            rd = wxReaderService.analysisWx(articleUrl, articleOrder, articleType);
        }catch(Exception e){
            logger.error("解析微信文章发生异常: {}", e.getMessage(), e);
            rd.setState(ReturnData.STATE_NO);
            rd.setData("解析微信文章发生异常");
        }
        return rd;
    }
}
