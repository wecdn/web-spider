package xyz.redpaper.red;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.redpaper.red.spider.wx.dao.PostMapper;
import xyz.redpaper.red.spider.wx.entity.Post;

@RunWith(SpringRunner.class)
@SpringBootTest
class RedApplicationTests {

    @Autowired
    public PostMapper mapper;

    @Test
    public void testFindMaxId() {
        Long maxId = mapper.findMaxId();
        System.out.println(maxId);
    }

}
