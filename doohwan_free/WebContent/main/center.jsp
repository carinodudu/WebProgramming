<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="https://bootswatch.com/4/flatly/bootstrap.css">

</head>
<body>

<div class="jumbotron">
  
  <c:choose>
   		<c:when test="${userid ne NULL }">
   			<h1 class="display-3">반갑습니다! ${userid}님</h1>
   		</c:when>
		<c:when test="${userid eq NULL }">
   			<h1 class="display-3">안녕하세요! 두두장터입니다.</h1>
   		</c:when>
	</c:choose>
  <p class="lead">※ 두두장터 이용방법</p>
  <hr class="my-4">
  <p class="lead">1. 회원가입 한다.</p>
  <p class="lead">2. 판매하기를 원하면 판매하고 싶은 물품을 등록한다.</p>
  <p class="lead">3. 구매하기를 원하면 구매하고 싶은 물품을 구매한다.</p>
  <p class="lead">4. 단, 물품을 구매하기 위해서는 포인트를 충전해야 한다.</p>
  <c:if test="${userid ne NULL }">
	<p class="lead">
		<a class="btn btn-primary btn-lg" href="<%=request.getContextPath() %>/Member?key=point" role="button" style="margin-right: 3em">포인트 충전</a>
		<%= session.getAttribute("point") %> <span class="badge badge-warning">POINT</span>
	</p>
  </c:if>
	
</div>

</body>
</html>