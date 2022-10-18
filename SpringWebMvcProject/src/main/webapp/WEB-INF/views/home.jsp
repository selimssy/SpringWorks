<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="include/header.jsp" />


<!--  인터셉터 처리 후 컨트롤러에서 자바스크립트로 처리!
<script type="text/javascript">
	
	const msg = "${msg}"
		if(msg === "notLogin"){
			alert("로그인이 필요한 서비스입니다.")
		}
</script>
-->


<jsp:include page="include/footer.jsp" />