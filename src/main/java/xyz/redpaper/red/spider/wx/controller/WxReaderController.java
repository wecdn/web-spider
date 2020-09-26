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

    @GetMapping("/wx")
    public String toIndex(){
        return "wx/index";
    }

    @GetMapping("/wx/get")
    @ResponseBody
    public ReturnData getWordPressArticleFormWx(HttpServletRequest request){
        ReturnData rd = new ReturnData();
        try {
            String articleUrl = request.getParameter("articleUrl");
            String articleOrder = request.getParameter("articleOrder");
            String articleType = request.getParameter("articleType");
            rd = wxReaderService.getWordPressArticleFormWx(articleUrl, articleOrder, articleType);
        }catch(Exception e){
            logger.error("发生异常: {}", e.getMessage(), e);
            rd.setState(ReturnData.STATE_NO);
            rd.setData("发生异常");
        }
        return rd;
    }
}
