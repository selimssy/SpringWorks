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
	
	<!-- t는 choose 대신 if aList.size() <=0 인 경우, if aList.size() > 0 두 가지로 나눠서 했다 -->
	
	<c:choose>
		<c:when test="${empty aList}">
			<h2>게시물이 존재하지 않습니다.</h2>
		</c:when>
		<c:otherwise>
			<h2>게시글 목록</h2>
	
			<table border="1">
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>비고</th>
				</tr>
				
				<!-- 컨트롤러가 가져온 게시글 데이터를 반복하여 출력 -->
				<!-- 게시물 개수가 0개일 경우 목록 대신 "게시물이 존재하지 않습니다" 출력 -->
				
				<c:forEach var="article" items="${aList}" >
					<tr>
						<td>${article.boardNo}</td>
						<td>${article.writer}</td>
						<td><a href="/db/board/content?boardNo=${article.boardNo}">${article.title}</a></td>
						<td><a href="/db/board/delete?boardNo=${article.boardNo}">[삭제]</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	
	
	
	
	<!-- 게시물 작성 링크 -->
	<p>
		<a href="/db/board/write">게시글 작성하기</a>
	</p>
	
	
</body>
</html>