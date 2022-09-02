<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h4>이메일 인증</h4>
	<c:if test="${res}">
		<h5>계정이 활성화 됐습니다.</h5>
	</c:if>
	<c:if test="${!res}">
		<h5>이메일 인증에 실패했습니다. 받은 메일을 다시 확인해주세요.</h5>
	</c:if>
</div>
</body>
</html>