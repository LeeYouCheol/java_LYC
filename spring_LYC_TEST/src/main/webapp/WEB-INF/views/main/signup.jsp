<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>
</head>
<body>
<div class="container">
	<form action="<%=request.getContextPath()%>/signup" method="post">
	<h1 class="text-center">회원가입</h1>
		<div class="form-group">
			<label for="me_id">아이디:</label>
  			<input type="text" class="form-control" id="me_id" name="me_id">
		</div>
		<button type="button" class="btn btn-outline-secondary col-12" id="idCheck">아이디 중복확인</button>
		<div class="form-group">
			<label for="me_pw">비밀번호:</label>
  			<input type="password" class="form-control" id="me_pw" name="me_pw">
		</div>
		<div class="form-group">
			<label for="me_pw2">비밀번호확인:</label>
  			<input type="password" class="form-control" id="me_pw2" name="me_pw2">
		</div>
		<div class="form-group">
				<label>성별:</label>
		</div>
		<div class="form-check-inline">
  			<label class="form-check-label">
    		<input type="checkbox" class="form-check-input" value="M" name="me_gender">남성
  			</label>
		</div>
		<div class="form-check-inline">
  			<label class="form-check-label">
    		<input type="checkbox" class="form-check-input" value="F" name="me_gender">여성
  			</label>
		</div>
		<div class="form-group">
  				<label for="me_email">이메일:</label>
  				<input type="text" class="form-control" id="me_email" name="me_email">
		</div>
		<div class="form-group">
  			<label for="me_birth">생년월일:</label>
  			<input type="text" class="form-control" id="me_birth" name="me_birth">
		</div>
		<button class="btn btn-outline-success col-12 mb-5">회원가입</button>
	</form>
</div>
<script type="text/javascript">
	$(function(){
		$( "#me_birth" ).datepicker({
		      changeMonth: true,
		      changeYear: true,
		      dateFormat: 'yy-mm-dd',
		      yearRange: "1900:2022"
		});
	})
	let idCheck = false;
	$(function(){
		$('#idCheck').click(function(){
			let me_id = $('[name=me_id]').val();
			if(me_id.trim().length == 0){
				alert('아이디를 입력하세요.')
				return;
			}
			let obj = {
				me_id : me_id
			}
			$.ajax({
			     async:false,
			     type:'POST',
			     data:JSON.stringify(obj),
			     url: '<%=request.getContextPath()%>/id/check',
			     dataType:"json",
			     contentType:"application/json; charset=UTF-8",
			     success : function(data){
			    	 if(data.check){
			    		 alert('가입 가능한 아이디입니다.');
			    		 idCheck = true;
			    	 }else{
			    		 alert('이미 사용중인 아이디입니다.');
			    	 }
			     }
			});
		});
		$('[name=me_id]').change(function(){
			idcheck = false;
		})
		$('form').submit(function(){
			if(idCheck)
				return true;
				
			alert('아이디 중복검사를 확인하세요.')
			return false;
		})
	})
</script>
</body>
</html>