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
	
	<h2>회원가입 정보 출력하기</h2>
	<p>
		- 아이디 : ${user.userId} <br>
		- 비밀번호 : ${user.userPw} <br>
		- 이름 : ${user.userName} <br>
		<!--- 취미 : ${user.hobby} <br>  -->
		
		- 취미 : 
		<c:if test="${user.hobby.size() != 0}">
	 		<c:forEach var="h" items="${user.hobby}">
				${h} &nbsp;
			</c:forEach>
		</c:if>
		<c:if test="${empty user.hobby}">   <!-- user.hobby == null 랑 똑같은데 empty를 더 권장한다, null 아닐 때는 not empty -->
			취미 없음~!
		</c:if>
	</p>

</body>
</html>