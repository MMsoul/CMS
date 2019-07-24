package com.bawei.cms.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 文章分类表
 * </p>
 *
 * @author bawei
 * @since 2019-07-21
 */
@TableName("cms_category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章分类标识
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文章分类名称
     */
    @TableField("name")
    private String name;

    /**
     * 所属栏目标识
     */
    @TableField("channel_id")
    private Integer channelId;

    /**
     * 分类序号
     */
    @TableField("sorted")
    private Integer sorted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }
    public Integer getSorted() {
        return sorted;
    }

    public void setSorted(Integer sorted) {
        this.sorted = sorted;
    }

    @Override
    public String toString() {
        return "Category{" +
            "id=" + id +
            ", name=" + name +
            ", channelId=" + channelId +
            ", sorted=" + sorted +
        "}";
    }
}
