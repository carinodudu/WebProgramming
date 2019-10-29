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
  <td >
  	<jsp:include page="../main/top.jsp"/>
  </td>
</tr>
 
<tr class="table-light" height="500px">
  <td align="center">	
	<div class="card text-white bg-primary mb-3" style="max-width: 30rem; height: 20rem;">
	  <div class="card-header"><img alt="두두장터" src="<%= request.getContextPath() %>/images/dove.png" width="50" height="50">두두장터의 가족이 되신 걸 환영합니다!</div>
	  <div class="card-body">
	    <h4 class="card-title">${username} 님 회원 가입을 <br> 축하드립니다!</h4>
	    <p class="card-text"><a class="alert-link" href="<%= request.getContextPath() %>/Member?key=login">로그인 하고싶으면 눌러봐~.~</a><br>하기 싫음 말고</p>
  	</div>
</div>
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