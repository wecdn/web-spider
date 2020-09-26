package xyz.redpaper.red.spider.wx.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.redpaper.red.spider.wx.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
