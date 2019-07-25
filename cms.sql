-- 创建数据库cms
CREATE DATABASE IF NOT EXISTS cms
CHARACTER SET utf8;

-- 使用数据库cms
USE cms;

-- 创建用户表
DROP TABLE IF EXISTS cms_user;

CREATE TABLE cms_user (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '用户标识',
	username VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名',
	password VARCHAR(32) NOT NULL COMMENT '用户密码',
	nickname VARCHAR(50) NOT NULL COMMENT '用户昵称',
	birthday DATE NULL COMMENT '用户生日',
	gender INT NULL COMMENT '性别:1-男,0-女',
	locked TINYINT(1) NOT NULL DEFAULT '1' COMMENT '是否禁止:0-未禁止，1-禁止',
	created DATETIME NOT NULL COMMENT '创建时间',
	updated DATETIME NOT NULL COMMENT '修改时间'
)
CHARACTER SET utf8
ENGINE InnoDB
COMMENT '系统用户表';

INSERT INTO `cms_user` (`username`, `password`, `nickname`, `birthday`, `gender`, `locked`, `created`, `updated`) 
VALUES ('zhangsan', MD5('111'), '张三', '1993-7-08', '1', '0', '2019-07-13 20:09:11', '2019-07-13 20:09:16');
INSERT INTO `cms_user` (`username`, `password`, `nickname`, `birthday`, `gender`, `locked`, `created`, `updated`) 
VALUES ('lisi', MD5('111'), '李四', '1993-7-08', '1', '0', '2019-07-13 20:09:11', '2019-07-13 20:09:16');
INSERT INTO `cms_user` (`username`, `password`, `nickname`, `birthday`, `gender`, `locked`, `created`, `updated`) 
VALUES ('wangwu', MD5('111'), '王五', '1993-7-08', '1', '0', '2019-07-13 20:09:11', '2019-07-13 20:09:16');

DROP TABLE IF EXISTS cms_channel;
CREATE TABLE cms_channel(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '栏目标识',
	name VARCHAR(64) NOT NULL COMMENT '栏目名称',
	description VARCHAR(500) NULL COMMENT '栏目简介',
	icon VARCHAR(30) NULL DEFAULT 'navicon' COMMENT '栏目图标，使用fontawesome字体图标',
	sorted INT NULL COMMENT '栏目序号'
)
CHARACTER SET utf8
ENGINE InnoDB
COMMENT '文章栏目表';

INSERT INTO cms_channel (name, sorted) VALUES ('Java核心技术',1);
INSERT INTO cms_channel (name, sorted) VALUES ('企业级开发技术',2);
INSERT INTO cms_channel (name, sorted) VALUES ('微服务架构技术',3);
INSERT INTO cms_channel (name, sorted) VALUES ('大数据分析技术',4);

DROP TABLE IF EXISTS cms_category;
CREATE TABLE cms_category(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '文章分类标识',
	name VARCHAR(50) NOT NULL COMMENT '文章分类名称',
	channel_id INT NOT NULL COMMENT '所属栏目标识',
	sorted INT NULL COMMENT '分类序号'
)
CHARACTER SET utf8
ENGINE InnoDB
COMMENT '文章分类表';

INSERT INTO cms_category (name, channel_id, sorted) VALUES ('Java基础',1,1);
INSERT INTO cms_category (name, channel_id, sorted) VALUES ('集合框架',1,2);
INSERT INTO cms_category (name, channel_id, sorted) VALUES ('多线程并发',1,3);
INSERT INTO cms_category (name, channel_id, sorted) VALUES ('IO技术',1,4);
INSERT INTO cms_category (name, channel_id, sorted) VALUES ('Spring框架',2,5);
INSERT INTO cms_category (name, channel_id, sorted) VALUES ('MyBatis技术研究 ',2,6);
INSERT INTO cms_category (name, channel_id, sorted) VALUES ('SpringMVC',2,7);
INSERT INTO cms_category (name, channel_id, sorted) VALUES ('Dubbo',3,8);
INSERT INTO cms_category (name, channel_id, sorted) VALUES ('Spring Cloud',3,9);
INSERT INTO cms_category (name, channel_id, sorted) VALUES ('Spring Boot',3,10);
INSERT INTO cms_category (name, channel_id, sorted) VALUES ('Hadoop',4,11);
INSERT INTO cms_category (name, channel_id, sorted) VALUES ('Hive',4,12);
INSERT INTO cms_category (name, channel_id, sorted) VALUES ('Flume',4,13);
INSERT INTO cms_category (name, channel_id, sorted) VALUES ('Spark',4,14);


DROP TABLE IF EXISTS cms_article;
CREATE TABLE cms_article(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '文章标识',
	title VARCHAR(128) NOT NULL COMMENT '文章标题',
	summary VARCHAR(144) NULL COMMENT '文章内容摘要',
	content LONGTEXT NOT NULL COMMENT '文章内容',
	picture VARCHAR(50) NULL COMMENT '文章配图路径',
	channel_id INT NOT NULL COMMENT '所属栏目标识 ',
	category_id INT NOT NULL COMMENT '所属分类标识',
	user_id INT NOT NULL COMMENT '发布文章的用户标识',
	hits INT(20) NOT NULL DEFAULT '0' COMMENT '文章点击量',
	hot TINYINT(1) NOT NULL DEFAULT '0' COMMENT '文章是否上热门：1-上，0-不上',
	status TINYINT(1) NOT NULL DEFAULT '0' COMMENT '文章是否审核通过：1-通过，0-不通过',
	deleted TINYINT(1) NOT NULL DEFAULT '1' COMMENT '文章是否有效，即逻辑删除标志：1-有效，0-无效',
	created DATETIME NOT NULL COMMENT '文章创建时间',
	updated DATETIME NOT NULL COMMENT '文章最近更新时间'
)
CHARACTER SET utf8
ENGINE InnoDB
COMMENT '文章表';

DROP TABLE IF EXISTS cms_slide;
CREATE TABLE cms_slide(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '广告标识',
	title VARCHAR(128) NULL COMMENT '广告标题',
	picture VARCHAR(50) NULL COMMENT '广告图片路径',
	url VARCHAR(100) NOT NULL COMMENT '广告跳转地址',
	created DATETIME NOT NULL COMMENT '创建时间'
)
CHARACTER SET utf8
ENGINE InnoDB
COMMENT '广告幻灯片图片表';

DROP TABLE IF EXISTS cms_settings;
CREATE TABLE cms_settings(
	id INT(1) PRIMARY KEY NOT NULL DEFAULT '1' COMMENT '配置信息标识 ',
	site_domain VARCHAR(50) NOT NULL DEFAULT 'localhost' COMMENT '网站域名',
	site_name VARCHAR(50) NOT NULL COMMENT '网站名称',
	article_list_size INT(20) NOT NULL DEFAULT '20' COMMENT '文章列表页显示数量',
	slide_size INT(10) NULL DEFAULT '5' COMMENT '首页幻灯片数量',
	admin_username VARCHAR(32) NOT NULL DEFAULT 'admin' COMMENT '管理员账号',
	admin_password VARCHAR(32) NOT NULL DEFAULT '21218cca77804d2ba1922c33e0151105' COMMENT '管理员密码，默认值是MD5(888888)'
)
CHARACTER SET utf8
ENGINE InnoDB
COMMENT '系统配置表';

DROP TABLE IF EXISTS cms_comments;
CREATE TABLE cms_comments(
	id INT PRIMARY KEY NOT NULL DEFAULT '1' COMMENT '文章评论ID',
	articleid INT NOT NULL COMMENT '文章标识',
	userid INT NULL COMMENT '评论用户ID',
	content VARCHAR(200) NOT NULL COMMENT '评论内容摘要',
	created DATETIME NOT NULL COMMENT '评论时间'
)
CHARACTER SET utf8
ENGINE InnoDB
COMMENT '文章评论表';