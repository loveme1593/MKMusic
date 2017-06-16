<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>판매 등록하기</title>
<script>
	function check() {
		var artist = document.getElementById('artist');
		var title = document.getElementById('title');
		var price = document.getElementById('price');
		if (artist.value == ' ' || title.value == ' ' || price.value == ' ') {
			alert('빈 칸 없이 작성해주세요.');
			return false;
		}
		if (isNaN(price.value)) {
			alert('가격은 숫자만 기입이 가능합니다.');
			price.focus();
			return false;
		}
		if (price.value <= 0) {
			alert('가격은 0원 초과부터 기입 가능합니다.');
			return false;
		}
		return true;
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
						Register Music:<br>MK Music
					</h2>
					<p class="lead">판매 등록하기</p>
					<form action="insert" method="post" onsubmit="return check();">
						<input type="hidden" id="sell_id" name="sell_id"
							value="${loginUser.user_id }">
						<table>
							<tr>
								<th>아티스트</th>
								<td><input type="text" id="artist" name="artist" required></td>
							</tr>
							<tr>
								<th>앨범 타이틀</th>
								<td><input type="text" id="title" name="title" required></td>
							</tr>
							<tr>
								<th>가격</th>
								<td><input type="text" id="price" name="price" required></td>
							</tr>
						</table>
						<br> <input type="submit" value="등록하기"
							class="btn btn-default">
					</form>
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