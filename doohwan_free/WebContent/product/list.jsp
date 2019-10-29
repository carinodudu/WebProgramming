<%@page import="kpu.dudu.domain.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kpu.dudu.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<%
	@SuppressWarnings("unchecked")
	ArrayList<ProductVO> productList = (ArrayList<ProductVO>) application.getAttribute("productList");
%>
<html>
<head>
<meta charset="UTF-8">
<title>두두장터_판매 물품 목록</title>

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
		<table style="width: 50%;">	
			<%
				for(ProductVO pv : productList) {
			%>
			<tr style="margin-bottom: 2em">
				<td>
					<div class="card mb-3" align="center">
					  <h3 class="card-header"><%= pv.getPname() %></h3>
					  <img style="height: 300px; width: 300px; align-self: center;" src="<%= request.getContextPath() %>/images/hood.jpg">
					  <div class="card-body">
					    <p class="card-text">판매자: <%= pv.getUserid() %></p>
					    <p class="card-text">가격: <%= pv.getPrice() %><span class="badge badge-warning">POINT</span></p>
					    <a class="btn btn-primary btn-lg" href="<%= request.getContextPath() %>/Product?key=infoaction&pno=<%= pv.getPno() %>" role="button">상세정보</a>
					  </div>
  					</div>
				</td>
			</tr>
			<%
				}
			%>
		</table>
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