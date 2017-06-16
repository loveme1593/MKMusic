<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>

<script>
	//로그인 폼 검사
	function formCheck() {
		var user_id = document.getElementById('user_id');
		var user_password = document.getElementById('user_password');

		if (user_id.value == '' || user_password.value == '') {
			alert('ID와 비밀번호를 입력하세요.');
			user_id.focus();
			return false;
		}
		return true;
	}
	function toList() {
		location.href = "${pageContext.request.contextPath}/";
	}
	function focus() {
		//로그인 창 켰을 때 id 칸에 포커싱
		var user_id = document.getElementById('user_id');
		user_id.focus();
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
<body onload="focus()">
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

	<!-- Page Content -->
	<a name="services"></a>
	<div class="content-section-a">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Sign in:<br>MK Music
					</h2>
					<p class="lead">로그인 후 여러 서비스를 즐겨보세요.</p>
					<div class="centerdiv">
						<input type="button" value="처음으로" onclick="toList()"
							class="btn btn-default">
						<form id="loginForm" action="login" method="post"
							onSubmit="return formCheck();">
							<div class="errorMsg">${errorMsg}</div>
							<table>
								<tr>
									<th class="center">ID</th>
									<td><input type="text" name="user_id" id="user_id" /></td>
								</tr>
								<tr>
									<th class="center">Password</th>
									<td><input type="password" name="user_password"
										id="user_password" /></td>
								</tr>
								<tr>
								</tr>
							</table>
							<br> <br> <input type="submit" value="Login"
								class="btn btn-default" />
						</form>
					</div>
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