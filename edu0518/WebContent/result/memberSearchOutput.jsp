<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.dev.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 검색</title>
</head>
<body>
	<%
		String result = (String)request.getAttribute("result");
		if(result != null) {
			out.print(result);
		} else {
	%>
			ID : ${member.id } <br>
			PWD : ${member.pwd } <br>
			NAME : ${member.name } <br>
	<% } %>
	
	<%@ include file="home.jsp" %>
</body>
</html>