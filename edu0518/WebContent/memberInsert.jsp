<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 생성</title>
</head>
<body>

	<form action="memberInsert.do" method="post">
		ID : <input type="text" name="id"><br>
		PASSWORD : <input type="password" name="pwd"><br>
		Name : <input type="text" name="name"><br>
		<input type="submit" value="send">
	</form>

</body>
</html>