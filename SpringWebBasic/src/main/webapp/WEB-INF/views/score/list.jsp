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

	<c:forEach var="stu" items="${sList}" varStatus="stuNum">
		<!-- varStatus : el에서 제공하는 시퀀스 기능. 달러(에러방지) { 열고(에러방지)  변수.index  }  하면 0부터 시작해서 1씩 증가한다 -->
		<p>
			- 학번 : ${stuNum.index + 1}, 이름 : ${stu.stuName}, 국어 : ${stu.kor}, 영어 : ${stu.eng}, 
			  수학 : ${stu.math}, 총점 : ${stu.total}, 평균 : ${stu.average}
			  &nbsp; 
			  <a href="/web/score/delete?stuNum=${stuNum.index + 1}">[삭제]</a>
		</p>
	</c:forEach>


	<a href="/web/score/register">다른 점수 등록하기</a>
	
	
	<script type="text/javascript">
		let msg = "${message}"  // 자바스크립트도 el 쓸 수 있고  // 문자는 "" 안에 el태그 넣어야ㅠ  
		
		if(msg === "delSuccess"){
			alert("점수 삭제 완료!")
		}
	</script>
	
</body>
</html>