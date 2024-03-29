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
<title>发布博客</title>

<!-- Bootstrap -->
<script type="text/javascript" src="/libs/Scripts/esm/popper.js"></script>
<script type="text/javascript" src="/libs/Scripts/umd/popper.js"></script>
<script type="text/javascript" src="/libs/Scripts/popper.js"></script>
<link rel="stylesheet" type="text/css"
	href="/libs/bootstrap/css/bootstrap.min.css" />
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css"
	rel="stylesheet">
<!--  <link href="libs/summernote/summernote.css" rel="stylesheet"> -->
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
						value="blog" name="module" /></jsp:include>
			</div>
			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-body">
						<h1>发布图片</h1>
						<hr />
						<div class="card">
							<div class="card-body">
								<form:form modelAttribute="blog" action="/article/editPictures"
									enctype="multipart/form-data" method="post">
									<p align="center" class="red">
										<form:errors path="id" />
									</p>
									<p>
										<form:textarea path="summary" rows="3" class="form-control"
											placeholder="摘要"></form:textarea>
										<span class="red"><form:errors path="summary" /></span>
									</p>
									<p>
										上传封面：<input type="file" name="file" />
										<c:if test="${not empty blog.cover}">
											<img alt="图片预览" src="${blog.cover}" height="50">
											<form:hidden path="cover" />
											<a href="#">删除图片</a>
										</c:if>
									</p>

									<p>
										<button type="submit" class="btn btn-info btn-block">保存</button>
									</p>

								</form:form>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/inc/footer.jsp" />

	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
	<!-- <script type="text/javascript" src="libs/summernote/summernote.js"></script> -->
	<script type="text/javascript">
	</script>
</body>
</html>