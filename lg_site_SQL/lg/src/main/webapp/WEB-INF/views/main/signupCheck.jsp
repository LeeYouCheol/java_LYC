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
	<h4>�̸��� ����</h4>
	<c:if test="${res}">
		<h5>������ Ȱ��ȭ �ƽ��ϴ�.</h5>
	</c:if>
	<c:if test="${!res}">
		<h5>�̸��� ������ �����߽��ϴ�. ���� ������ �ٽ� Ȯ�����ּ���.</h5>
	</c:if>
</div>
</body>
</html>