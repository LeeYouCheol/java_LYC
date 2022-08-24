<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form method="post" class="mt-5" enctype="multipart/form-data">
			<h1>게시글등록</h1>
			<div class="form-group">
  				<input type="text" class="form-control mt-3" name="bd_title" placeholder="제목">
			</div>
			<div class="form-group">
  				<textarea rows="30" class="form-control" name="bd_content" placeholder="내용"></textarea>
			</div>
    		<div class="form-group">
        		<label>첨부파일(최대 3개):</label>
       			<input type="file" class="form-control" name="file"/>
       			<input type="file" class="form-control" name="file"/>
       			<input type="file" class="form-control" name="file"/>
    		</div>
			<button class="btn btn-outline-primary col-12 mb-3">게시글 등록</button>
		</form>
	</div>
</body>
</html>