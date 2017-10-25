package cn.huashantech.liaoliao2.entity.po;

import java.util.Date;
import java.util.Map;

import cn.huashantech.liaoliao2.entity.Base.BaseEntity;


public class MultimediaResourcePO extends BaseEntity<MultimediaResourcePO> {
    private Long id;

    private String content;

    private String contentPath;

    private Integer contentType;

    private Map extMap;

    private Date gmtCreate;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getContentPath() {
        return contentPath;
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath == null ? null : contentPath.trim();
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public Map getExtMap() {
        return extMap;
    }

    public void setExtMap(Map extMap) {
        this.extMap = extMap;
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
        return "MultimediaResourcePO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", contentPath='" + contentPath + '\'' +
                ", contentType=" + contentType +
                ", extMap=" + extMap +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}