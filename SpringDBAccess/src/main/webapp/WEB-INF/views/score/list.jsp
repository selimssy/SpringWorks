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
	
	
	
	<h2>학생들의 전체 성적 조회</h2>

	<c:forEach var="stu" items="${sList}" >
		
		<p>
			- 학번 : ${stu.stuId}, 이름 : ${stu.stuName}, 국어 : ${stu.kor}, 영어 : ${stu.eng}, 
			  수학 : ${stu.math}, 총점 : ${stu.total}, 평균 : ${stu.average}
			  &nbsp; 
			  <a href="/db/score/delete?stuId=${stu.stuId}">[삭제]</a>
		</p>
	</c:forEach>


	<a href="/db/score/register">다른 점수 등록하기</a>
	<a href="/db/score/list">점수 전체 조회</a>
	<a href="/db/score/search">점수 개별 조회</a>
	
	
	<script type="text/javascript">
		let msg = "${message}"  // 자바스크립트도 el 쓸 수 있고  // 문자는 "" 안에 el태그 넣어야ㅠ  
		
		if(msg === "delSuccess"){
			alert("점수 삭제 완료!")
		}
	</script>
	
</body>
</html>