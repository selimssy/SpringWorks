<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<jsp:include page="../include/header.jsp" />
<style>
header.masthead {
	
	display: none;
}	
</style>
<br/><br/>
<div class="container">

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header text-white" style="background-color: #ff52a0;">${article.boardNo}</div>
      <div class="card-body">

        
        
          <div class="form-group">
            <label>작성자</label>
            <input type="text" class="form-control" name='writer' value="${article.writer}" readonly>
          </div>
          
          <div class="form-group">
            <label>제목</label>
            <input type="text" class="form-control" name='title' value="${article.title}" readonly>
          </div>

          <div class="form-group">
            <label>내용</label>
            <!-- 
            <textarea class="form-control" rows="5" name='content' readonly>${article.content}</textarea>  -->
            <div style="background-color: #ddd">${article.content}</div>
          </div>




		 <!-- POST 방식으로 삭제하는법 잘 알아두자!!★ -->	
         <form id="formObj"  role="form" action="<c:url value='/board/delete'/>" method="post">  
          
	          <input type="hidden" name="boardNo" value="${article.boardNo}">
	          <input type="hidden" name="page" value="${p.page}">
			  <input type="hidden" name="countPerPage" value="${p.countPerPage}">
	          
	          <input type="button" value="목록" class="btn"  id="list-btn"
			style="background-color: #ff52a0; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">&nbsp;&nbsp;
	          <!-- 이런식으로 location.href 경로를 통해 가는거는 get방식이다! -->
	          <!-- 그래서 목록, 수정은 get방식이 되고 boardNo hidden이랑 삭제는 post 방식이 된다 -->
	          
	          
	          <c:if test="${login.name == article.writer}">
	                      <!-- 원래는 테이블 조인해서 id를 비교해야!!★★ -->
		          <input id="modBtn" type="button" value="수정" class="btn btn-warning"  style="color:white;">&nbsp;&nbsp;
		          
		          <input type="submit" value="삭제" class="btn btn-danger" onclick="return confirm('정말로 삭제하시겠습니까?')">&nbsp;&nbsp;
	        	  <!-- return confirm은 예 아니오 버튼이 뜨는데 예를 누르면 true가 리턴되면서 submit이 전송된다!! (아니요 누르면 false리턴되고 submit 전송되지 않음)  -->	
        	  </c:if>
        </form>

		
		
		<!-- 댓글영역 -->
		<div class="comment">
			<h4>댓글</h4>
			<ol class="replyList">
				<c:forEach items="${replyList}" var="list">
					<li>
						<p> 작성자: ${list.replyer} &nbsp; &nbsp;
						    (작성일: <fmt:formatDate value="${list.replyDate}" pattern="yyyy년 MM월 dd일 a hh:mm:ss" />)						
						</p>
						<p>${list.content}</p>
					</li>
				</c:forEach>
			</ol>
		</div>
		
		
		<!-- 댓글 등록 폼 -->
		<form action="<c:url value='/board/reply'/>" method="post" id="replyForm">
			<input type="hidden" name="boardNo" value="${article.boardNo}">
			
			<ul>
				<li>
					<label>작성자</label>
					<input type="text" name="replyer" id="replyer" value="${login.name}" readonly>
				</li>
				<li>
					<textarea rows="5" cols="60" name="content" ></textarea>
					<button type="button" id="replyBtn">댓글 등록</button>
				</li>
			</ul>
		</form>
		
		

      </div>
    </div>
  </div>
</div>
</div>



<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<!-- 근데 지금 header에 들어가있어서 안해도 되긴 하다 -->

<script type="text/javascript">

	
	//수정 완료 알림창 처리(이건 제이쿼리가 아니라 바닐라 자바스크립트라서 제이쿼리 밖으로 빼야!)
	const msg = "${msg}"
	if(msg === "modSuccess"){
		alert("게시물 수정 완료!")
	}
	
	
	// 제이쿼리의 시작
	$(function(){
		
		// 목록버튼 클릭이벤트 처리
		$("#list-btn").click(function(){
			console.log("목록버튼이 클릭됨!");
			location.href='/board/list?page=${p.page}&countPerPage=${p.countPerPage}&keyword=${p.keyword}&condition=${p.condition}';
		})
		
		
		// 수정버튼 클릭이벤트 처리
		// 왜 let이 안먹지...
		//var modifyBtn = document.getElementById("modBtn");  //vanila 자바스크립트(원형)
		const forElement = $("#formObj");
		var modifyBtn = $("#modBtn"); // jQuery
		
		modifyBtn.click(function(){
			console.log("수정버튼이 클릭됨!");
			forElement.attr("action", "/board/modify");
			forElement.attr("method", "get");
			forElement.submit();
		})
		
		
		
		
		// 댓글 등록
		$("#replyBtn").click(function(){
			//e.preventDefault();
			console.log("댓글등록 클릭");
			
			$("#replyForm").submit();
		})
				
		
	});

</script>

<jsp:include page="../include/footer.jsp" />