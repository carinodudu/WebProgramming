<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>DH-Car-회원정보수정</title>
	<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
</head>
<body>
	<div align=center>
		<header>DH-Car-회원정보수정</header>
		<form name=form1 action="http://localhost:8080/dhcar/member/modify/" method="post">
		<table>
			<tr><th>ID</th><td><input type="text" name="id" readonly value="${member.id}"></td></tr>
			<tr><th>PASSWORD</th><td><input type="text" name="passwd" value="${member.passwd}"></td></tr>
			<tr><th>NAME</th><td><input type="text" name="membername" value="${member.membername}"></td></tr>
			<tr><th>AGE</th><td><input type="text" name="age" value="${member.age}"></td></tr>
			<tr><th>LICENSE</th><td><input type="text" name="license" value="${member.license}"></td></tr>
			<tr><th>MOBILE</th><td><input type="text" name="mobile" value="${member.mobile}"></td></tr>
			<tr><th>EMAIL</th><td><input type="text" name="email" value="${member.email}"></td></tr>
		</table><br>
			<input type="submit" name="submit" value="최종 수정">
			<input type="reset" name="reset" value="다시작성">
		</form>
	</div>
</body>
</html>