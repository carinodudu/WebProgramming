<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>DH-Car</title>
	<link rel="stylesheet" href="resources/member.css" type="text/css"></link>
</head>
<body>
	<div align="center">
		<header>DH-Car 로그인</header>
   		<form name=form1 action="http://localhost:8080/dhcar/member/login" method="post">
     	<table>
     		<tr><th>LOGIN ID</th><td><input type="text" name="id" autofocus="autofocus" placeholder="ID를 입력하세요."></td></tr>
     		<tr><th>PASSWORD</th><td><input type="password" name="passwd" placeholder="PASSWORD를 입력하세요."></td></tr>
     	</table>
     	<dl>
     		<dd style="display: inline;"><input type="submit" name="login" value="로그인"></dd>
     		<dd style="display: inline;"><c:url value="/member/register" var="url"/><input type="button" onclick="location.href='${url}'" name="join" value="회원가입"></dd>
     	</dl>
   		</form>
	</div>
</body>
</html>
