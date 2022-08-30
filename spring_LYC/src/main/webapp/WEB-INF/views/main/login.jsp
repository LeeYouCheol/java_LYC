<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<form action="/spring/login" class="mt-3" method="post">
		<h1>로그인</h1>
		<div class="form-group">
  			<input type="text" class="form-control" name="me_id" placeholder="아이디를입력하세요">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" name="me_pw" placeholder="비밀번호를입력하세요">
		</div>
		<div class="form-group">
			<label class="form-check-label">
				<input type="checkbox" class="form-check-input" name="autoLogin" value="true">자동로그인
			</label>
		</div>
		<button class="btn btn-outline-success col-12 mb-3">로그인</button>
	</form>
	<a href="<c:url value="/find?type=id"></c:url>">아이디 찾기</a>/
	<a href="<c:url value="/find?type=pw"></c:url>">비밀번호 찾기</a>
</div>
<script>
	$(function(){
		$('form').submit(function(){
			let id = $('[name=id]').val()
			if(id.length == 0){
				alert('아이디를 입력하세요.')
				$('[name=id]').focus();
				return false;
			}
			let pw = $('[name=pw]').val()
			let pwRegex = /^[a-z,0-9]+$/
			if(!pwRegex.test(pw)){
				alert('문자와 정수만 입력가능합니다.')
				$('[name=pw]').focus();
				return false;
			}
		})
	})
</script>
</body>
</html>