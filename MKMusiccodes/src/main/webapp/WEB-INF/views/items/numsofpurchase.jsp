<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 판매 순위 ]</title>
<script>
	function toList() {
		location.href = "${pageContext.request.contextPath}/";
	}
</script>
<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/landing-page.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top topnav"
		role="navigation">
		<div class="container topnav">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand topnav"
					href="${pageContext.request.contextPath}/">MK Music</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${!empty loginUser }">
						<li><a href="${pageContext.request.contextPath}/users/logout">로그아웃</a></li>
					</c:if>
					<c:if test="${empty loginUser }">
						<li><a href="${pageContext.request.contextPath}/users/join">회원가입</a></li>
						<li><a href="${pageContext.request.contextPath}/users/login">로그인</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>
	<!-- /.navbar-collapse -->
	<a name="services"></a>
	<div class="content-section-a">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Music Ranking:<br>MK Music
					</h2>
					<p class="lead">음악 판매 순위 살펴보기</p>
					<input type="button" value="처음으로" onclick="toList()"
						class="btn btn-default">
					<table>
						<tr>
							<th>순위</th>
							<th>아티스트</th>
							<th>제목</th>
							<th>판매수량</th>
						</tr>
						<c:set var="index" value="0" />
						<c:forEach var="items" items="${numsofpurchase }">
							<tr>
								<td>${index=index+1 }</td>
								<td>${items.artist }</td>
								<td>${items.title }</td>
								<td>${items.cnt }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="list-inline">
						<li><a href="${pageContext.request.contextPath}/">Home</a></li>
					</ul>
					<p class="copyright text-muted small">Copyright &copy;
						MoonKyung PARK, All Rights Reserved</p>
				</div>
			</div>
		</div>
	</footer>
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>