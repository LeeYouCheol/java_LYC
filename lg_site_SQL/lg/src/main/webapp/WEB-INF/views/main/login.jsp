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
	<form action="/lg/login" class="mt-3" method="post">
		<h1>로그인</h1>
		<div class="form-group">
			<label for="me_email">이메일:</label>
  			<input type="text" class="form-control" name="me_email" placeholder="이메일을입력하세요">
		</div>
		<div class="form-group">
			<label for="me_pw">비밀번호</label>
			<input type="password" class="form-control" name="me_pw" placeholder="비밀번호를입력하세요">
		</div>
		<div class="form-check">
  			<label class="form-check-label">
    		<input type="checkbox" class="form-check-input" value="true" name="autoLogin">자동로그인
  		</label>
		<button class="btn btn-outline-success col-12 mb-3">로그인</button>
		<a href="<c:url value="/find?type=id"></c:url>">아이디찾기</a>/
		<a href="<c:url value="/find?type=pw"></c:url>">비밀번호찾기</a>
	</form>
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