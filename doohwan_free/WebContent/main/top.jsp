<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="https://bootswatch.com/4/flatly/bootstrap.css">

</head>
<body style="width: 100%;">

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="<%= request.getContextPath() %>">
  	<img alt="두두장터" src="<%= request.getContextPath() %>/images/dove.png" width="50" height="50">두두장터</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor01" >
    <ul class="navbar-nav mr-auto" >
    	<li class="nav-item">
    	<c:choose>
    		<c:when test="${userid ne NULL }">
    		<a class="nav-link" href="<%= request.getContextPath() %>/Member?key=login">로그아웃</a>
    		</c:when>
			<c:when test="${userid eq NULL }">
    		<a class="nav-link" href="<%= request.getContextPath() %>/Member?key=login">로그인 / 회원가입</a>
    		</c:when>
		</c:choose>
      </li>
      <li class="nav-item" >
        <a class="nav-link" href="<%= request.getContextPath() %>/Product?key=listaction">구매하기</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%= request.getContextPath() %>/Product?key=sell">판매하기   </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">고객게시판   </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%= request.getContextPath() %>/Member?key=listaction">회원정보   </a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" name="searchform" action="<%= request.getContextPath() %>/Member?key=infoaction" method="post">
      <input class="form-control mr-sm-2" name="userid" type="text" placeholder="회원아이디" >
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">검색</button>
    </form>
  </div>
</nav>

</body>
</html>