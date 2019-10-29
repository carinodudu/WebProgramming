<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두두장터_로그인</title>

<link rel="stylesheet" type="text/css" href="https://bootswatch.com/4/flatly/bootstrap.css">

</head>
<body>

<table style="width: 100%;">
<tr>
  <td >
  	<jsp:include page="../main/top.jsp"/>
  </td>
</tr>
 
<tr class="table-light">
  <td align="center">
  
  	<form name="loginform" action="<%= request.getContextPath() %>/Member?key=loginaction" method="post" style="max-width: 50%">
	  	<fieldset>
		  	<div class="form-group" style="max-width: 50%" align="left">
		      <label for="exampleInputEmail1">아이디</label>
		      <input type="text" name="userid" class="form-control" id="exampleInputEmail1" placeholder="아이디를 입력하시오.">
		    </div>
		    <div class="form-group" style="max-width: 50%" align="left">
		      <label for="exampleInputPassword1">비밀번호</label>
		      <input type="password" name="passwd" class="form-control" id="exampleInputPassword1" placeholder="비밀번호를 입력하시오.">
		    </div>
	  	</fieldset>
	  	<fieldset>
    		<button type="submit" class="btn btn-primary">로그인</button>
    		<button type="submit" class="btn btn-primary" formaction="<%= request.getContextPath() %>/Member?key=join">회원가입</button>
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