package com.bawei.cms.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 广告幻灯片图片表
 * </p>
 *
 * @author bawei
 * @since 2019-07-21
 */
@TableName("cms_slide")
public class Slide implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 广告标识
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 广告标题
     */
    @TableField("title")
    private String title;

    /**
     * 广告图片路径
     */
    @TableField("picture")
    private String picture;

    /**
     * 广告跳转地址
     */
    @TableField("url")
    private String url;

    /**
     * 创建时间
     */
    @TableField("created")
    private Date created;

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
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Slide{" +
            "id=" + id +
            ", title=" + title +
            ", picture=" + picture +
            ", url=" + url +
            ", created=" + created +
        "}";
    }
}
