package com.huangwei.cms.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 文章栏目表
 * </p>
 *
 * @author bawei
 * @since 2019-07-21
 */
@TableName("cms_channel")
public class Channel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 栏目标识
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 栏目名称
     */
    @TableField("name")
    private String name;

    /**
     * 栏目简介
     */
    @TableField("description")
    private String description;

    /**
     * 栏目图标，使用fontawesome字体图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 栏目序号
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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public Integer getSorted() {
        return sorted;
    }

    public void setSorted(Integer sorted) {
        this.sorted = sorted;
    }

    @Override
    public String toString() {
        return "Channel{" +
            "id=" + id +
            ", name=" + name +
            ", description=" + description +
            ", icon=" + icon +
            ", sorted=" + sorted +
        "}";
    }
}
