package com.huangwei.cms.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author bawei
 * @since 2019-07-21
 */
@TableName("cms_article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章标识
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文章标题
     */
    @TableField("title")
    private String title;

    /**
     * 文章内容摘要
     */
    @TableField("summary")
    private String summary;

    /**
     * 文章内容
     */
    @TableField("content")
    private String content;

    /**
     * 文章配图路径
     */
    @TableField("picture")
    private String picture;

    /**
     * 所属栏目标识 
     */
    @TableField("channel_id")
    private Integer channelId;

    /**
     * 所属分类标识
     */
    @TableField("category_id")
    private Integer categoryId;

    /**
     * 发布文章的用户标识
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 文章点击量
     */
    @TableField("hits")
    private Integer hits;

    /**
     * 文章是否上热门：1-上，0-不上
     */
    @TableField("hot")
    private Boolean hot;

    /**
     * 文章是否审核通过：1-通过，0-不通过
     */
    @TableField("status")
    private Boolean status;

    /**
     * 文章是否有效，即逻辑删除标志：1-有效，0-无效
     */
    @TableField("deleted")
    private Boolean deleted;

    /**
     * 文章创建时间
     */
    @TableField("created")
    private Date created;

    /**
     * 文章最近更新时间
     */
    @TableField("updated")
    private Date updated;
    
    @TableField("type")
    private Integer type;

    public Integer getType() {
    	return type;
    }
    
    public void setType(Integer type) {
    	this.type = type;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }
    public Boolean getHot() {
        return hot;
    }

    public void setHot(Boolean hot) {
        this.hot = hot;
    }
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Article{" +
            "id=" + id +
            ", title=" + title +
            ", summary=" + summary +
            ", content=" + content +
            ", picture=" + picture +
            ", channelId=" + channelId +
            ", categoryId=" + categoryId +
            ", userId=" + userId +
            ", hits=" + hits +
            ", hot=" + hot +
            ", status=" + status +
            ", deleted=" + deleted +
            ", created=" + created +
            ", updated=" + updated +
            ", type=" + type +
        "}";
    }
}
