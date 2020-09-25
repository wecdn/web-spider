package xyz.redpaper.red.spider.wx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.redpaper.red.spider.wx.entity.Post;

@Mapper
@Repository
public interface PostMapper {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Post findById(Long id);

    /**
     * 获取最大主键
     * @return
     */
    public Long findMaxId();

}
