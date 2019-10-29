<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두두장터_회원가입</title>

<link rel="stylesheet" type="text/css" href="https://bootswatch.com/4/flatly/bootstrap.css">

</head>
<body>

<table style="width: 100%;">
<tr>
  <td>
  	<jsp:include page="../main/top.jsp"/>
  </td>
</tr>
 
<tr class="table-light" >
  <td align="center">
  
  	<form name="joinform" action="<%= request.getContextPath() %>/Member?key=joinaction" method="post" style="max-width: 50%">
	  	<fieldset>
		  	<div class="form-group" style="max-width: 50%;" align="left">
		      <label>아이디</label>
		      <input type="text" name="userid" class="form-control" id="exampleInputEmail1" placeholder="아이디를 입력하시오.">
		    </div>
		    <div class="form-group" style="max-width: 50%;" align="left">
		      <label>비밀번호</label>
		      <input type="password" name="passwd" class="form-control" id="exampleInputPassword1" placeholder="비밀번호를 입력하시오.">
		    </div>
		    <div class="form-group" style="max-width: 50%;" align="left">
		      <label>이름</label>
		      <input type="text" name="username" class="form-control" id="exampleInputPassword1" placeholder="예) 홍길동">
		    </div>
		    <div class="form-group" style="max-width: 50%;" align="left">
		      <label>전화번호</label>
		      <input type="text" name="tel" class="form-control" id="exampleInputPassword1" placeholder="예) 010-1234-5678">
		    </div>
		    <div class="form-group" style="max-width: 50%;" align="left">
		      <label>이메일</label>
		      <input type="email" name="email" class="form-control" id="exampleInputPassword1" placeholder="예) abc@naver.com">
		    </div>
		    <div class="form-group" style="max-width: 50%;" align="left">
		      <label>성별</label>
		      <select name="sex" class="form-control" id="exampleSelect1">
		        <option selected="selected">남</option>
		        <option>여</option>
		      </select>
    		</div>
	  	</fieldset>
	  	<fieldset>
    		<button type="submit" class="btn btn-primary">회원가입</button>
    		<button type="reset" class="btn btn-primary">다시입력</button>
 		</fieldset>
  		
  	</form>
  </td>
</tr>
 
<tr>
  <td>
    <jsp:include page="../main/bottom.jsp" flush="false"/>
  </td>
</tr>
</table>



</body>
</html>