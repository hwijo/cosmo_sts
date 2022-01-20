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
	<title>Home</title>
	
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

</head>


<body>

<!-- top 레이아웃 include -->
<jsp:include page = "../views/topLayout.jsp" flush = "false"/>

<div class="work-area">
	<div class="container" style="padding : 50px;"align="center">
	    <h2>ようこそ!</h2>
	</div>

        <!-- 슬라이드 -->
		<div id="bxslider" class="designer_area">
			<c:forEach var="rlt" items="${images}">
				<ul>
                    <li style="float: center;"><img src="/resources/${rlt.filename}" width="100%" height="400px"/></li>
				</ul>
			</c:forEach>
		</div>
			
</div>

<div>
		<!-- 공지사항 -->
		<div style="padding : 100px;">
	    <p>お知らせ</p>
		<table class="table table-striped table-hover table-bordered">
			<tr class="table-info text-center">
				<td class="col-sm-5">title</td>
				<td class="col-sm-1">date</td>
			</tr>
		

	    <c:forEach var="notice" items="${notice}">
		
			<tr>
				<td class="text-center"><a href="notice?no=${notice.no}">${notice.title}</a></td>
				<fmt:formatDate value="${notice.updatedAt}" pattern="yy-MM-dd"
					var="rewriteDate"></fmt:formatDate>
				<td class="text-center">${rewriteDate}</td>
			</tr>
		
    	</c:forEach>
	    </table>
	    	<div class="form-group">
				<button	onclick = "location.href='/insertNotice' "class="btn btn-primary" style="float:right">등록(관리자전용)</button>
			</div>
	    </div>

</div>


              

<script type="text/javascript">

	$(document).ready(function() {
        $('#bxslider').bxSlider({
			auto : true, // 자동 슬라이드
			speed : 500,
			pause : 4000,
			mode : 'fade',
			//autoControls : true, // 시작, 정지버튼 노출
			pager : true, // 블릿 버튼
			//slideWidth: 800, // 가로 크기
		});
	});
</script>


</body>



</html>


