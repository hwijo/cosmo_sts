<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<html>
<head>

<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>



</head>


<body>
<div class="work-area">	
<div class="container">
      <div align="center">
          <h2>返信登録</h2>
      </div>
      
 	  <form id="replyForm" role="form" name="reply" action="/admin/consulReply" method="post">
          <br style="clear: both">
          
          <div>
          <input type="hidden" value="${e.grno}" id="grno" name="grno">
          <input type="hidden" value="${e.grgrod}" id="grno" name="grgrod">
          <input type="hidden" value="${e.depth}" id="grno" name="depth">
		  </div>	 
	      
	      
	      <div class="form-group">
		      <input type="text" class="form-control" id="name" name="name" placeholder="名前" style="width:300px" required >
		  </div>
		  <div class="form-group">
		      <input type="text" class="form-control" id="passwd" name="passwd" placeholder="暗証番号" style="width:300px" required>
		  </div>
		  <div class="form-group">
		      <input type="text" class="form-control" value="RE:${e.title}" id="title" name="title" placeholder="タイトル" style="width:500px" required>
		  </div>
		  <div class="form-group">
			  <textarea class="form-control" id="summernote" name="contents" placeholder="contents" maxlength="140" rows="7"></textarea>
		  </div>

		  <button type="submit" id="submit" name="submit" class="btn btn-primary pull-right">登録</button>
	      
	  
	  </form>	
</div>
</div> 



 
 

</body>

<script type="text/javascript">
$(document).ready(function() {
	//여기 아래 부분
    $('#summernote').summernote({
    	  height: 300,                 // 에디터 높이
		  minHeight: null,             // 최소 높이
		  maxHeight: null,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '最大500字まで書けます。'	//placeholder 설정

			  
          
	}); 

});
</script>

</html>
