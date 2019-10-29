<%@page import="kpu.dudu.domain.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kpu.dudu.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<%
	ProductVO product = (ProductVO) request.getAttribute("product");
%>
<html>
<head>
<meta charset="UTF-8">
<title>두두장터_물품 상세정보</title>

<link rel="stylesheet" type="text/css" href="https://bootswatch.com/4/flatly/bootstrap.css">

</head>
<body>

<table style="width: 100%;">
<tr>
  <td >
  	<jsp:include page="../main/top.jsp"/>
  </td>
</tr>

<tr>
	<td align="center">
	
		<div class="card mb-3" style="width: 70%;">
		  <h3 class="card-header"><%= product.getPname() %></h3>
		  <div class="card-body">
		    <h5 class="card-title">판매자: <%= product.getUserid() %></h5>
		  </div>
		  <img style="height: 300px; width: 300px; align-self: center;" src="<%= request.getContextPath() %>/images/<%= product.getImage()%>">
		  <div class="card-body">
		    <p class="card-text"><%= product.getInfo() %></p>
		  </div>
		  <ul class="list-group list-group-flush">
		    <li class="list-group-item">분류: <%= product.getCategory() %></li>
		    <li class="list-group-item"><%= product.getPrice() %><span class="badge badge-warning">POINT</span></li>
		    <li class="list-group-item">
		    
		    <form name="buyForm" method="post" action="<%= request.getContextPath() %>/Product?key=buyaction&price=<%= product.getPrice() %>">
		    	<button type="submit"
		    	 class="btn btn-primary" >
		    	 	구매하기
		    	</button>
		    </form>	
    		
 				
		    </li>
		  </ul>
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