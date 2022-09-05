<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h2>ī�װ� ���</h2>
	<form method="post">
		<div class="input-group mb-3">
			<input type="text" class="form-control" placeholder="ī�װ���" name="ca_name">
			<input type="text" class="form-control" placeholder="ī�װ��ڵ�" name="ca_code">
			<div class="input-group-append">
				<button class="btn btn-outline-success">���</button>
			</div>
		</div>
	</form>
	<table class="table">
		<thead>
			<tr>
				<th>ī�װ���</th>
				<th>ī�װ��ڵ�</th>
			</tr>
		</thead>
	<tbody>
	<c:forEach items="${list }" var="ca">
		<tr>
			<td>${ca.ca_name }</td>
			<td>${ca.ca_code }</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</div>
</body>
</html>