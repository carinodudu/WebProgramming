<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib tagdir="/WEB-INF/tags" prefix="layouttag"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두두장터</title>
</head>
<body>

<table style="width: 100%;">

<layouttag:top page="top.jsp"/>

<tr>
  <td>
     <jsp:include page="center.jsp" flush="false"/>
  </td>
</tr>
 
<layouttag:bottom/>
</table>

</body>
</html>