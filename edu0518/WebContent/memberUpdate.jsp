<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.dev.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Update Search</h3>
	<form action="memberSearch.do" method="post">
		ID : <input type="text" name="id"><br>
		<input type="hidden" name="job" value="update">
		<input type="submit" value="Search">
	</form>
	
	<%
		MemberVO member = (MemberVO)request.getAttribute("member");
		if(member != null) {
	%>
	<h3>Update Information</h3>
	<form action="memberUpdate.do" method="post">
		ID : <input type="text" name="id" readonly value="${member.id }"><br>
		PASSWORD : <input type="password" name="pwd" value="${member.pwd }"><br>
		NAME : <input type="text" name="name" value="${member.name }"><br>
		<input type="submit" value="Update">
	</form>
	<% } else { %>
		${result}
	<% } %>
	
	

</body>
</html>