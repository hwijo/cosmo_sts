<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<meta charset="UTF-8">



<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>



<!-- 공지사항 등록/수정 -->

<div class="work-area">	
<div class="container">
　　　　   <div align="center">
          <h2>お知らせ登録</h2>
      </div>
      <c:if test="${empty notice.no}">
 	  <form id="insertForm" role="form" name="insert" action="/admin/insertNotice" method="post">
          <br style="clear: both">
		  <div class="form-group">
		  <input type="text" class="form-control" id="title" name="title" placeholder="タイトル" required>
		  </div>
		  <div class="form-group">
		  <input type="text" class="form-control" id="passwd" name="passwd" placeholder="パスワード" required>
		  </div>
		  <div class="form-group">
			  <textarea class="form-control" id="summernote" name="contents" placeholder="contents" maxlength="140" rows="7"></textarea>
		  </div>
		  <button type="button" class="btn btn-primary pull-right" onclick="checkNull(${notice.no})">登録</button>
	  </form>	
	  </c:if> 
	  <c:if test="${not empty notice.no}">
 	  <form id="insertForm" role="form" name="insert" action="/admin/insertNotice" method="post">
          <br style="clear: both">
		  <div class="form-group">
		  <input type="text" class="form-control" id="title" name="title" value="${notice.title}" placeholder="タイトル" required>
		  </div>
		  <div class="form-group">
		  <input type="text" class="form-control" id="passwd" name="passwd" value="${notice.passwd}" placeholder="パスワード" required>
		  </div>
		  <div class="form-group">
			  <textarea class="form-control" id="summernote" name="contents" placeholder="contents" maxlength="140" rows="7">${notice.contents}</textarea>
		  </div>
		  <button type="button" class="btn btn-primary pull-right" onclick="checkNull(${notice.no})">登録</button>
	  </form>	
	  </c:if>
</div> 

</div>


<script type="text/javascript">

//null 체크
function checkNull(no) {
	if($("#title").val().trim() == ""){		
        alert("タイトルを入力してください。");
        $("#title").focus();
        return false;
    }
	
	else if($("#passwd").val().trim() == ""){		
        alert("パスワードを入力してください。");
        $("#passwd").focus();
        return false;
    }

	else if($("textarea[name=contents]").val().trim() == ""){		
        alert("内容を入力してください。");
        $("#contents").focus();
        return false;
    }	
	
	else {
		document.getElementById("insertForm").submit();
	}
	
}

// summernote
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
