<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>DH-Car-예약</title>
	<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
</head>
<body>
	<div align=center>
		<header>차량 예약 확인</header><br>
		<table>
		    <tr><th> 차량이미지 </th><td><img src="../resources/${car.image}.png" width="300" height="200"></td></tr>
			<tr><th> 차량번호 </th><td><c:out value="${car.num}"/></td></tr>
			<tr><th> 모델명 </th><td><c:out value="${car.carname}"/></td></tr>
			<tr><th> 분류 </th><td><c:out value="${car.category}"/></td></tr>
			<tr><th> 운행가능지역 </th><td><c:out value="${car.area}"/></td></tr>
			<tr><th> 예약자 </th><td><c:out value="${car.booker}"/></td></tr>
		</table>
		<c:url value="/car/list" var="url"/><a href="${url}">차량 목록 보기</a>
	</div>
</body>
</html>