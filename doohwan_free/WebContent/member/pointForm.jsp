<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두두장터_포인트충전</title>

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
  
  	<form name="loginform" action="<%= request.getContextPath() %>/Member?key=pointaction" method="post" style="max-width: 50%">
	  	<fieldset>
		  	<div class="form-group" style="max-width: 50%" align="left">
		      <label for="exampleInputEmail1">충전하실 포인트</label>
		      <input type="number" name="point" class="form-control" id="exampleInputEmail1" placeholder="충전하실 금액을 입력해주세요.">
		    </div>
		    <div class="form-group" style="max-width: 50%;" align="left">
		      <label>결제 방식</label>
		      <select name="sex" class="form-control" id="exampleSelect1">
		        <option selected="selected">카드 결제</option>
		        <option>무통장 입금</option>
		        <option>계좌 이체</option>
		        <option>모바일 소액 결제</option>
		        <option>상품권</option>
		      </select>
    		</div>
	  	</fieldset>
	  	<fieldset>
    		<button type="submit" class="btn btn-primary">결제하기</button>
    		<button type="submit" class="btn btn-primary" formaction="<%= request.getContextPath() %>">취소하기</button>
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