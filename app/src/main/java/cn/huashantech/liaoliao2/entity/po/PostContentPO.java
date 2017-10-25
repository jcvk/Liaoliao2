package cn.huashantech.liaoliao2.entity.po;

import java.util.Date;
import java.util.Map;

import cn.huashantech.liaoliao2.entity.Base.BaseEntity;


public class PostContentPO extends BaseEntity<PostContentPO> {
    private Long id;

    private Long postId;

    private Integer contentType;

    private String contentPath;

    private Map extMap;

    private Integer sequence;

    private Date gmtCreate;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getContentPath() {
        return contentPath;
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath == null ? null : contentPath.trim();
    }

    public Map getExtMap() {
        return extMap;
    }

    public void setExtMap(Map extMap) {
        this.extMap = extMap;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "PostContentPO{" +
                "id=" + id +
                ", postId=" + postId +
                ", contentType=" + contentType +
                ", contentPath='" + contentPath + '\'' +
                ", extMap=" + extMap +
                ", sequence=" + sequence +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}