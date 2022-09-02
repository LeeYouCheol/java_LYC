<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
<script src="https://kit.fontawesome.com/ae0416ee4f.js" crossorigin="anonymous"></script>
<style>
.home{
	background-image: url(<%=request.getContextPath()%>/resources/img/logo.svg);
	width: 100px; height: 29px; display: block; background-size: 100% 100%;
}
.member .dropdown-toggle::after{
	display:none;
}
.fa-regular{
	line-height: 1.5
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<div class="container">
	  	<a class="navbar-brand home" href="<c:url value="/"></c:url>"></a>
	  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
	    	<span class="navbar-toggler-icon"></span>
	  	</button>
	  	<div class="collapse navbar-collapse" id="collapsibleNavbar">
	    	<ul class="navbar-nav">
		      	<li class="nav-item dropdown member">
				    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"><i class="fa-regular fa-user"></i></a>
				    <div class="dropdown-menu">
				    	<c:if test="${user ==null }">
							<a class="dropdown-item" href="<c:url value="/signup"></c:url>">회원가입</a>
							<a class="dropdown-item" href="<c:url value="/login"></c:url>">로그인</a>
						</c:if>
						<c:if test="${user != null }">
							<a class="dropdown-item" href="<c:url value="/mypage"></c:url>">마이페이지</a>
							<a class="dropdown-item" href="<c:url value="/logout"></c:url>">로그아웃</a>
						</c:if>
					</div>
				</li>
		      	<li class="nav-item">
		        	<a class="nav-link" href="#">Link</a>
		      	</li>
		      	<li class="nav-item">
		        	<a class="nav-link" href="#">Link</a>
		      	</li>    
	    	</ul>
		</div> 
	</div> 
</nav>
</body>