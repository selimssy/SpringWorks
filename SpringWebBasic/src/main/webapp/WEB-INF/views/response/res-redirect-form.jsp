<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- ResponseController 사용 -->
	<form method="post">  <!-- Spring에서는 @GetMapping과 @PostMapping이 같은 uri라면 action 생략해도 찾아간다!! -->
		<p>
			아이디 : <input type="text" name="userId" size="10"><br>
			비밀번호 : <input type="password" name="userPw" size="10"><br>
			비밀번호 확인 : <input type="password" name="userPwChk" size="10"><br>
			<input type="submit" value="로그인">
		</p>
	</form>
	
	
	<p style="color:red">${msg}</p>
	
</body>
</html>