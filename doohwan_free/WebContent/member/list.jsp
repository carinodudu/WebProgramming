<%@page import="java.util.ArrayList"%>
<%@page import="kpu.dudu.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<%
	@SuppressWarnings("unchecked")
	ArrayList<MemberVO> memberList = (ArrayList<MemberVO>) request.getAttribute("memberList");
%>
<html>
<head>
<meta charset="UTF-8">
<title>두두장터_회원정보</title>

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
		<table style="width: 80%;">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
			</tr>
				
				<%
					for(MemberVO mv : memberList) {
				%>
				<tr style="margin-bottom: 2em">
					<td><%= mv.getUserid() %></td>
					<td><%= mv.getUsername() %></td>
					<td><%= mv.getTel() %></td>
					<td><%= mv.getEmail() %></td>
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