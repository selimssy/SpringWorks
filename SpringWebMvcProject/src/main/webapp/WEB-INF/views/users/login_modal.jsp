<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 로그인 Modal-->
<div class="modal fade" id="log-in">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">
					<span style="color: #ff52a0;">IZONE</span> 로그인
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">

				<form action="#" name="izone-sign-in" method="post" id="signInForm"
					style="margin-bottom: 0;">
					<table style="cellpadding: 0; cellspacing: 0; margin: 0 auto; width: 100%">
						<tr>
							<td style="text-align: left">
								<p><strong>아이디를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="idCheck"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="text" name="userId" id="signInId"
								class="form-control tooltipstered" maxlength="10"
								required="required" aria-required="true"
								style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
								placeholder="최대 10자"></td>
						</tr>
						<tr>
							<td style="text-align: left">
								<p><strong>비밀번호를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="pwCheck"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="password" size="17" maxlength="20" id="signInPw"
								name="userPw" class="form-control tooltipstered" 
								maxlength="20" required="required" aria-required="true"
								style="ime-mode: inactive; margin-bottom: 25px; height: 40px; border: 1px solid #d9d9de"
								placeholder="최소 8자"></td>
						</tr>
						<tr>
							<td style="padding-top: 10px; text-align: center">
								<p><strong>로그인하셔서 WIZONE이 되어보세요~~!</strong></p>
							</td>
						</tr>
						<tr>
							<td style="width: 100%; text-align: center; colspan: 2;"><input
								type="button" value="로그인" class="btn form-control tooltipstered" id="signIn-btn"
								style="background-color: #ff52a0; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">
							</td>
						</tr>
						<tr>
							<td
								style="width: 100%; text-align: center; colspan: 2; margin-top: 24px; padding-top: 12px; border-top: 1px solid #ececec">

								<a class="btn form-control tooltipstered" data-toggle="modal"
								href="#sign-up"
								style="cursor: pointer; margin-top: 0; height: 40px; color: white; background-color: orange; border: 0px solid #388E3C; opacity: 0.8">
									회원가입</a>
							</td>
						</tr>
						<tr>
							<td	style="width: 100%; text-align: center; colspan: 2; margin-top: 24px; padding-top: 12px; border-top: 1px solid #ececec">

								<a id="custom-login-btn" href="https://kauth.kakao.com/oauth/authorize?client_id=1b99bdb2b2d8b2b7b7f7c7ee8f97842b&redirect_uri=http://localhost:8181/ggbro/kakaoLogin&response_type=code">
									<img src="//mud-kage.kakao.com/14/dn/btqbjxsO6vP/KPiGpdnsubSq3a0PHEGUK1/o.jpg" width="300"/>
								</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>

<!-- 회원가입 Modal -->
<div class="modal fade" id="sign-up" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">
					<span style="color: #ff52a0;">IZONE</span> 회원 가입
				</h4>
				<button type="button" class="close" data-dismiss="modal">×</button>

			</div>

			<div class="modal-body">

				<form action="#" name="signup" id="signUpForm" method="post"
					style="margin-bottom: 0;">
					<table
						style="cellpadding: 0; cellspacing: 0; margin: 0 auto; width: 100%">
						<tr>
							<td style="text-align: left">
								<p><strong>아이디를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="idChk"></span></p>
							</td>
								
							
						</tr>
						<tr>
							<td><input type="text" name="userId" id="user_id"
								class="form-control tooltipstered" maxlength="14"
								required="required" aria-required="true"
								style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
								placeholder="숫자와 영어로 4-10자">
								</td>
							
						</tr>

						<tr>
							<td style="text-align: left">
								<p><strong>비밀번호를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="pwChk"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="password" size="17" maxlength="20" id="password"
								name="userPw" class="form-control tooltipstered" 
								maxlength="20" required="required" aria-required="true"
								style="ime-mode: inactive; margin-bottom: 25px; height: 40px; border: 1px solid #d9d9de"
								placeholder="영문과 특수문자를 포함한 최소 8자"></td>
						</tr>
						<tr>
							<td style="text-align: left">
								<p><strong>비밀번호를 재확인해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="pwChk2"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="password" size="17" maxlength="20" id="password_check"
								name="pw_check" class="form-control tooltipstered" 
								maxlength="20" required="required" aria-required="true"
								style="ime-mode: inactive; margin-bottom: 25px; height: 40px; border: 1px solid #d9d9de"
								placeholder="비밀번호가 일치해야합니다."></td>
						</tr>

						<tr>
							<td style="text-align: left">
								<p><strong>이름을 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="nameChk"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="text" name="userName" id="user_name"
								class="form-control tooltipstered" maxlength="6"
								required="required" aria-required="true"
								style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
								placeholder="한글로 최대 6자"></td>
						</tr>
						
						<!--   이메일은 일단 주석처리~
						<tr>
							<td style="text-align: left">
								<p><strong>이메일을 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="emailChk"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="email" name="userEmail" id="user_email"
								class="form-control tooltipstered" 
								required="required" aria-required="true"
								style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
								placeholder="ex) izone@produce.com"></td>
						</tr> 
						-->

						<tr>
							<td style="padding-top: 10px; text-align: center">
								<p><strong>회원가입하셔서 WIZONE이 되어보세요~~!</strong></p>
							</td>
						</tr>
						<tr>
							<td style="width: 100%; text-align: center; colspan: 2;">
							<input
								type="button" value="회원가입" 
								class="btn form-control tooltipstered" id="signup-btn"
								style="background-color: #ff52a0; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">
							</td>
						</tr>

					</table>
				</form>
			</div>
		</div>
	</div>
</div>


<!--  
<script src="<c:url value='/js/izone-user-validation.js'/>"></script>
-->



<script type="text/javascript">
	
	// 제이쿼리 시작
	$(function(){
		
		// 아이디 중복확인 keyup 이벤트(키 누를때마다 이벤트 발생)
		$("#user_id").keyup(function(){
			
			// 아이디가 공백일 경우 상태표시
			if($(this).val() === ""){
				$(this).css("background-color", "pink");
				$("#idChk").html("<b style='font-size:14px; color:green;'>[아이디를 입력해주세요]</b>")
			}else{
				$(this).css("background-color", "aqua");
				$("#idChk").html("<p></p>")
			}
			
		})
		
		
		
		
		// 회원가입 버튼 클릭 이벤트
		$("#signup-btn").click(function(){
			
			// 아이디 정보
			const id = $("#user_id").val();
			console.log(id)
			// 패스워드 정보
			const pw = $("#password").val();
			console.log(pw)
			// 이름 정보
			const name = $("#user_name").val();
			console.log(name)
			
			
			
			// 데이터 변수(자바스크립트 객체) 만들기 
			const user = {
				// key를 VO의 필드명과 똑같이 해줘야!
				account: id,
				password: pw,
				name: name
			}
			
		
			// 클라이언트에서 서버와 통신하는 ajax함수(비동기 통신)  // key: value 형태
			$.ajax({
				type: "POST",  // 서버에 전송하는 HTTP요청 방식(POST, GET, PUT, FETCH, DELETE)
				url: "/user/",  // http부터 풀로 적어도 되고 URI만 적어도 된다
				headers: {
					"Content-Type": "application/json"  // 서버로 json데이터 전송
				}, // 요청 헤더 정보
				dataType: "text",   // 응답받을 데이터의 형태(text, xml, html, json)
				data: JSON.stringify(user), // 서버로 전송할 데이터  // JSON.stringify() : 자바스크립트 객체를 json 문자열로 변환
				success: function(result){  // 통신 성공시 서버가 갖다준 데이터를 매개변수(result)에 저장 
					                        // ex. 회원가입 통신 성공시 : 서버가 보낸 joinSuccess 문자열을 매개변수 result에 저장!  
					console.log("통신 성공!" + result)
					if(result === "joinSuccess"){
						alert("회원가입에 성공했습니다!");
						location.href="/";
					}else{
						alert("회원가입 실패");
					}
				},   // 통신 성공시 처리할 내용들을 함수 내부에 작성		
				error: function(){
					console.log("통신 실패!")
				}  // 통신 실패시 처리할 내용들을 함수 내부에 작성
			})
			
		})
		
	})
	
	
</script>




