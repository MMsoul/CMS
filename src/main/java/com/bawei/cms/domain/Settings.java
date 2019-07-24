package com.bawei.cms.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 系统配置表
 * </p>
 *
 * @author bawei
 * @since 2019-07-21
 */
@TableName("cms_settings")
public class Settings implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 配置信息标识 
     */
    @TableId("id")
    private Integer id;

    /**
     * 网站域名
     */
    @TableField("site_domain")
    private String siteDomain;

    /**
     * 网站名称
     */
    @TableField("site_name")
    private String siteName;

    /**
     * 文章列表页显示数量
     */
    @TableField("article_list_size")
    private Integer articleListSize;

    /**
     * 首页幻灯片数量
     */
    @TableField("slide_size")
    private Integer slideSize;

    /**
     * 管理员账号
     */
    @TableField("admin_username")
    private String adminUsername;

    /**
     * 管理员密码，默认值是MD5(888888)
     */
    @TableField("admin_password")
    private String adminPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getSiteDomain() {
        return siteDomain;
    }

    public void setSiteDomain(String siteDomain) {
        this.siteDomain = siteDomain;
    }
    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
    public Integer getArticleListSize() {
        return articleListSize;
    }

    public void setArticleListSize(Integer articleListSize) {
        this.articleListSize = articleListSize;
    }
    public Integer getSlideSize() {
        return slideSize;
    }

    public void setSlideSize(Integer slideSize) {
        this.slideSize = slideSize;
    }
    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }
    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "Settings{" +
            "id=" + id +
            ", siteDomain=" + siteDomain +
            ", siteName=" + siteName +
            ", articleListSize=" + articleListSize +
            ", slideSize=" + slideSize +
            ", adminUsername=" + adminUsername +
            ", adminPassword=" + adminPassword +
        "}";
    }
}
