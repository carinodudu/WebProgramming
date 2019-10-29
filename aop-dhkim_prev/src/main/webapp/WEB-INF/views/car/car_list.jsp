<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>DH-Car-목록</title>
	<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
</head>
<body>
	<div align=center>
		<header>예약 가능 차량 목록</header><br>
		<table>
		  <tr>
		    <th>차량이미지</th><th>모델명</th><th>분류</th><th>운행가능지역</th><th>차량예약</th>
		  </tr>
		  <c:forEach var="car" items="${carList}" >
		  <c:if test="${car.booker eq null}">
			  <tr>
			    <td><img src="../resources/${car.image}.png" width="300" height="200"></td>
			    <td><c:out value="${car.carname}"/></td>
			    <td><c:out value="${car.category}"/></td>
			    <td><c:out value="${car.area}"/></td>
			    <td>
			      <c:url value="/car/book?num=${car.num}" var="url"/><a href="${url}">예약하기</a>
			    </td>
			  </tr>
		  </c:if>
		  </c:forEach>
		</table>
	</div>
</body>
</html>