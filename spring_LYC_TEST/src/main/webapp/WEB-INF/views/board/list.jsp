<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
  <h2>게시판</h2>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
        <th>추천</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${list}" var="board">
      	<tr>
        	<td>${board.bd_num}</td>
        	<td>
        		<a href="<%=request.getContextPath()%>/board/select/${board.bd_num}">
        		${board.bd_title}
        		</a>
        	</td>
        	<td>${board.bd_me_id}</td>
        	<td>${board.bd_reg_date_str}</td>
        	<td>${board.bd_views}</td>
        	<td>${board.bd_up}/${board.bd_down}</td>
      	</tr>
    	</c:forEach>
    </tbody>
  </table>
  <ul class="pagination justify-content-center">
  	<c:if test="${pm.prev}">
    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}">이전</a></li>
    </c:if>
    <c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="i">
    	<li class="page-item <c:if test="${pm.cri.page == i}">active</c:if>">
    		<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${i}">${i}</a>
    	</li>
    </c:forEach>
    <c:if test="${pm.next}">
    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}">다음</a></li>
    </c:if>
  </ul>
  <a href="<%=request.getContextPath()%>/board/insert" class="btn btn-outline-warning mb-3">글쓰기</a>
</div>
</body>
</html>