package xyz.redpaper.red.spider.wx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "wp_posts")
public class Post {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column
    private Long postAuthor;
    @Column
    private Date postDate;
    @Column
    private Date postDateGmt;
    @Column
    private String postContent;
    @Column
    private String postTitle;
    @Column
    private String postExcerpt;
    @Column
    private String postStatus;
    @Column
    private String commentStatus;
    @Column
    private String pingStatus;
    @Column
    private String postPassword;
    @Column
    private String postName;
    @Column
    private String toPing;
    @Column
    private String pinged;
    @Column
    private Date postModified;
    @Column
    private Date postModifiedGmt;
    @Column
    private String postContentFiltered;
    @Column
    private Long postParent;
    @Column
    private String guid;
    @Column
    private Integer menuOrder;
    @Column
    private String postType;
    @Column
    private String postMimeType;
    @Column
    private Long commentCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(Long postAuthor) {
        this.postAuthor = postAuthor;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Date getPostDateGmt() {
        return postDateGmt;
    }

    public void setPostDateGmt(Date postDateGmt) {
        this.postDateGmt = postDateGmt;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostExcerpt() {
        return postExcerpt;
    }

    public void setPostExcerpt(String postExcerpt) {
        this.postExcerpt = postExcerpt;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getPingStatus() {
        return pingStatus;
    }

    public void setPingStatus(String pingStatus) {
        this.pingStatus = pingStatus;
    }

    public String getPostPassword() {
        return postPassword;
    }

    public void setPostPassword(String postPassword) {
        this.postPassword = postPassword;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getToPing() {
        return toPing;
    }

    public void setToPing(String toPing) {
        this.toPing = toPing;
    }

    public String getPinged() {
        return pinged;
    }

    public void setPinged(String pinged) {
        this.pinged = pinged;
    }

    public Date getPostModified() {
        return postModified;
    }

    public void setPostModified(Date postModified) {
        this.postModified = postModified;
    }

    public Date getPostModifiedGmt() {
        return postModifiedGmt;
    }

    public void setPostModifiedGmt(Date postModifiedGmt) {
        this.postModifiedGmt = postModifiedGmt;
    }

    public String getPostContentFiltered() {
        return postContentFiltered;
    }

    public void setPostContentFiltered(String postContentFiltered) {
        this.postContentFiltered = postContentFiltered;
    }

    public Long getPostParent() {
        return postParent;
    }

    public void setPostParent(Long postParent) {
        this.postParent = postParent;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getPostMimeType() {
        return postMimeType;
    }

    public void setPostMimeType(String postMimeType) {
        this.postMimeType = postMimeType;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postAuthor=" + postAuthor +
                ", postDate=" + postDate +
                ", postDateGmt=" + postDateGmt +
                ", postContent='" + postContent + '\'' +
                ", postTitle='" + postTitle + '\'' +
                ", postExcerpt='" + postExcerpt + '\'' +
                ", postStatus='" + postStatus + '\'' +
                ", commentStatus='" + commentStatus + '\'' +
                ", pingStatus='" + pingStatus + '\'' +
                ", postPassword='" + postPassword + '\'' +
                ", postName='" + postName + '\'' +
                ", toPing='" + toPing + '\'' +
                ", pinged='" + pinged + '\'' +
                ", postModified=" + postModified +
                ", postModifiedGmt=" + postModifiedGmt +
                ", postContentFiltered='" + postContentFiltered + '\'' +
                ", postParent=" + postParent +
                ", guid='" + guid + '\'' +
                ", menuOrder=" + menuOrder +
                ", postType='" + postType + '\'' +
                ", postMimeType='" + postMimeType + '\'' +
                ", commentCount=" + commentCount +
                '}';
    }
}
