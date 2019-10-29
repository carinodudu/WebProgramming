<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>DH-Car-회원정보</title>
	<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
</head>
<body>
	<div align=center>
		<header>DH-Car-회원정보</header><br>
		<table>
		    <tr><th> ID </th><td><c:out value="${member.id}"/></td></tr>
			<tr><th> PASSWORD </th><td><c:out value="${member.passwd}"/></td></tr>
			<tr><th> NAME </th><td><c:out value="${member.membername}"/></td></tr>
			<tr><th> AGE </th><td><c:out value="${member.age}"/></td></tr>
			<tr><th> LICENSE </th><td><c:out value="${member.license}"/></td></tr>
			<tr><th> MOBILE </th><td><c:out value="${member.mobile}"/></td></tr>
			<tr><th> EMAIL </th><td><c:out value="${member.email}"/></td></tr>
		</table>
		<c:url value="/member/list" var="url"/><a href="${url}">학생 목록 보기</a>
	</div>
</body>
</html>