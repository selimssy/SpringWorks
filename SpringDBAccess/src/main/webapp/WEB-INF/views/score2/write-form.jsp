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

	<h2>시험 점수 등록</h2>

	<form action="/db/mybatis/score/register" method="post">
		<p>
			이름 : <input name="stuName"><br>
			국어 : <input name="kor"><br>
			영어 : <input name="eng"><br>
			수학 : <input name="math"><br>
			<input type="submit" value="확인">
		</p>
	</form>
	
</body>
</html>