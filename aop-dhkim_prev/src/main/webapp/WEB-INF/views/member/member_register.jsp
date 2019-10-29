<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>DH-Car-회원가입</title>
	<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
</head>
<body>
	<div align=center>
		<header>DH-Car-회원가입</header>
		<form name=form1 action="http://localhost:8080/dhcar/member/register/" method="post">
		<table>	
			<tr><th>ID</th><td><input type="text" name="id" autofocus placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>PASSWORD</th><td><input type="password" name="passwd" placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>NAME</th><td><input type="text" name="membername"  placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>AGE</th><td><input type="text" name="age" placeholder="예)20"></td></tr>
			<tr><th>LICENSE</th><td><input type="text" name="license" placeholder="예)1종보통"></td></tr>
			<tr><th>MOBILE</th><td><input type="text" name="mobile" placeholder="***-****-****"></td></tr>
			<tr><th>EMAIL</th><td><input type="text" name="email" placeholder="****@****.***"></td></tr>
		</table>
		<dl>
			<dd style="display: inline;"><input type="submit" name="submit" value="보내기"></dd>
			<dd style="display: inline;"><input type="reset" name="reset" value="다시 작성"></dd>
		</dl>
		</form>
	</div>
</body>
</html>