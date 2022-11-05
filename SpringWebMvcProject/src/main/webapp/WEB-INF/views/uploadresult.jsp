<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{margin:0;}
</style>
</head>
<body>
	<!--  
	파일이 업로드 됨.
	파일명 : ${savedName}
	<br> -->
	
	<img src="${uploadpath}" width="100%">   <!-- 크기 자동조절 등은 뒤에서 해결~ -->  <!-- 4:3으로 하쟈 -->
	 
	
	<!--  이거 무슨 의미지
	<script>
	    let uploadpath = "${uploadpath}";
	    parent.addFilePath(uploadpath); //파일명을 부모페이지로 전달
	</script>--> 
	
</body>

</html>