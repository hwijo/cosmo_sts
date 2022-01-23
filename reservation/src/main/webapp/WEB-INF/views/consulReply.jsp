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

</head>
<body>
<div class="work-area">	
 	  <form id="replyForm" role="form" name="reply" action="/consulReply" method="post">
          <br style="clear: both">
          <div>
          <input type="hidden" value="${e.grno}" id="grno" name="grno">
          <input type="hidden" value="${e.grgrod}" id="grno" name="grgrod">
          <input type="hidden" value="${e.depth}" id="grno" name="depth">
		  </div>
		  
		  <div class="form-group">
		      <input type="text" class="form-control" value="RE:${e.title}" id="title" name="title" placeholder="제목" required>
		  </div>
		  <div class="form-group">
			  <textarea class="form-control" id="contents" name="contents" placeholder="contents" maxlength="140" rows="7"></textarea>
		  </div>
		  <div class="form-group">
		      <input type="text" class="form-control" id="name" name="name" placeholder="이름" required>
		  </div>
		  <div class="form-group">
		      <input type="text" class="form-control" id="passwd" name="passwd" placeholder="비밀번호" required>
		  </div>
		  <button type="submit" id="submit" name="submit" class="btn btn-primary pull-right">등록</button>
	  </form>	
</div> 
 
 

</body>
</html>
