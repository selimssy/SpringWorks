<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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
            <textarea class="form-control" rows="5" name='content' readonly>${article.content}</textarea>
          </div>




		 <!-- POST 방식으로 삭제하는법 잘 알아두자!!★ -->	
         <form role="form" action="<c:url value='/board/delete'/>" method="post">  
          
	          <input type="hidden" name="boardNo" value="${article.boardNo}">
	          
	          <input type="button" value="목록" class="btn" onclick="location.href='/board/list'"
			style="background-color: #ff52a0; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">&nbsp;&nbsp;
	          <!-- 이런식으로 location.href 경로를 통해 가는거는 get방식이다! -->
	          <!-- 그래서 목록, 수정은 get방식이 되고 boardNo hidden이랑 삭제는 post 방식이 된다 -->
	          
	          <input type="button" value="수정" class="btn btn-warning" onclick="" style="color:white;">&nbsp;&nbsp;
	          
	          <input type="submit" value="삭제" class="btn btn-danger" onclick="return confirm('정말로 삭제하시겠습니까?')">&nbsp;&nbsp;
        	  <!-- return confirm은 예 아니오 버튼이 뜨는데 예를 누르면 true가 리턴되면서 submit이 전송된다!! (아니요 누르면 false리턴되고 submit 전송되지 않음)  -->	
        
        </form>



      </div>
    </div>
  </div>
</div>
</div>
<jsp:include page="../include/footer.jsp" />