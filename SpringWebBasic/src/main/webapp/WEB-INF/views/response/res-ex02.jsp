<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="<c:url value='/response/join' />" method="post">
		<fieldset>
			<legend>회원가입 양식</legend>
			<p>
				- ID: <input type="text" name="userId" size="10"><br>
				- PW: <input type="password" name="userPw" size="10"><br>
				- NAME: <input type="text" name="userName" size="10"><br>
				- HOBBY:
				<input type="checkbox" name="hobby" value="soccer">축구&nbsp;
				<input type="checkbox" name="hobby" value="book">독서&nbsp;
				<input type="checkbox" name="hobby" value="music">음악&nbsp;
				<br>
				<input type="submit" value="회원가입">
			</p>
		</fieldset>
	</form>

</body>
</html>