<%@page import="com.huangwei.cms.enums.Gender"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>我的个人空间</title>

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="/libs/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/cms.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>

	<!-- 横幅 -->
	<div class="container">
		<div class="row">
			<div class="col-md-12 my_banner"></div>
		</div>
	</div>
	<br />
	<!-- 主体内容区 -->
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="/WEB-INF/inc/my_left.jsp"><jsp:param
						value="profile" name="module" /></jsp:include>
			</div>
			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-body">
						<h1>信息设置</h1>
						<hr/>
						<p>
						<form:form modelAttribute="userForm" action="/user/profile"
							class="form-inline" method="post">
							<form:hidden path="id"></form:hidden>
							<p align="center" class="red">${message}</p>
							<p>
								用户名：
								<form:input path="username" placeholder="请填写用户名"
									class="form-control" />
							</p>
							<p class="w-100">
								昵&nbsp;&nbsp;&nbsp;&nbsp;称：
								<form:input path="nickname" placeholder="请填写昵称"
									class="form-control" />
							</p>
							<!-- <p class="w-100">
								密 码：
								<form:password path="password" placeholder="请填写密码"
									class="form-control" />
							</p>
							<p class="w-100">
								确认密码：
								<form:password path="rePassword" placeholder="重复密码"
									class="form-control" />
							</p> -->
							<p class="w-100">
								出生年月：
								<form:input path="birthday" type="date" class="form-control" />
							</p>
							<p class="w-100">
								性 别：
								<div class="form-check form-check-inline">
								  <form:radiobutton class="form-check-input" path="gender" value="<%=Gender.MALE%>"/>
								  <label class="form-check-label" for="inlineRadio1">先生</label>
								</div>
								<div class="form-check form-check-inline">
								  <form:radiobutton class="form-check-input" path="gender" value="<%=Gender.FAMALE%>"/>
								  <label class="form-check-label" for="inlineRadio1">先生</label>
								</div>
							<p class="w-100">
								<button type="submit" class="btn btn-info">修改</button>
							</p>
						</form:form>
					</div>
				</div>

			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/inc/footer.jsp" />

	<script type="text/javascript">
		
	</script>
</body>
</html>