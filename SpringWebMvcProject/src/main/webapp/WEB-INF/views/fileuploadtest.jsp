<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    /*ifram{
        width: 1000px;
        height: 100px;
        border: 1px;
        border-style: solid;
    }*/
    
    #fra{width:1000px; height:1000px}
</style>
</head>
<body>
 
 
     <!-- target을 지정한곳으로 form data가 이동 target 속성은 폼데이터를 서버로 제출후 응답이 열릴 위치명시-->
    <form id = "form1" target="iframePhoto" action="/uploadForm" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit" value="업로드">
    </form>
    
    <iframe name="iframePhoto" id="fra"></iframe>
 
 
 
<script type="text/javascript">
 
    function addFilePath(msg){
        console.log(msg); //파일명 콘솔 출력
        //document.getElementById("form1").reset(); //ifream에 업로드 결과 출력후 form에 저장된 데이터 리셋
    }
</script>
 
</body>

</html>

