<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두두장터_판매 물품 등록</title>

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
  
  	<form name="sellform" action="<%= request.getContextPath() %>/Product?key=sellaction" method="post" style="max-width: 80%">
	  	<fieldset>
		  	<div class="form-group" style="max-width: 50%;" align="left">
		      <label>물건이름</label>
		      <input type="text" name="pname" class="form-control" id="exampleInputEmail1" placeholder="물건이름을 입력하시오.">
		    </div>
		    <div class="form-group" style="max-width: 50%;" align="left">
		      <label>분류</label>
		      <input type="text" name="category" class="form-control" id="exampleInputPassword1" placeholder="물품의 종류를 입력하시오.">
		    </div>
		    <div class="form-group" style="max-width: 50%;" align="left">
		      <label>가격</label>
		      <input type="number" name="price" class="form-control" id="exampleInputPassword1" placeholder="예) 30000">
		    </div>
		    <div class="form-group" style="max-width: 50%; height: 100px; margin-bottom: 12em;" align="left">
		      <label>설명</label>
		      <textarea rows="10" cols="30" name="info" class="form-control" placeholder="예) 이 물건 정말 좋습니다." maxlength="499"></textarea>
		    </div>
		    <div class="form-group" style="max-width: 50%;" align="left">
		      <label>이미지</label>
		      <input type="file" name="image" class="form-control" id="exampleInputPassword1">
		    </div>
	  	</fieldset>
	  	<fieldset>
    		<button type="submit" class="btn btn-primary">판매등록</button>
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