<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<html>
<head>
<title>Home</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


</head>


<body>



	<div class="work-area">

		<div class="container" style="padding: 50px;" align="center"></div>

		<!-- 슬라이드 -->
		<div id="bxslider" class="designer_area">
			<c:forEach var="rlt" items="${images}">
				<ul>
					<li style="float: center;"><img
						src="/resources/${rlt.filename}" width="100%" height="400px" /></li>
				</ul>
			</c:forEach>
		</div>

	</div>

	<!-- 날짜, 방 중복 검색 -->
	<div style="margin: 0 auto;" align="center">
		<input type="text" id="datepicker1" name="startDate"> ~ 
		<input type="text" id="datepicker2" name="endDate"> 
<%-- 		<select	name="adult" style="text-align-last: center;">
			<option value="">部屋</option>
			<c:forEach var="roomInfo" items="${roomInfo}">
				<option><c:out value="${roomInfo.roomTitle}" /></option>
			</c:forEach>
		</select> --%>
		<button type="button" class="btn btn-primary" 
			onclick="location.href='/reserve?startDate=${startDate}&endDate=${endDate}'">検索</button>

	    <a href="/reserve" id="search">	       
	    <button class="btn btn-sm btn-primary" name="search" id="search">検索</button></a>

	</div>


	<div>
		<!-- 공지사항 -->
		<div style="padding: 100px;">
			<div class="container" style="padding: 30px;" align="center">
				<h2>お知らせ</h2>
			</div>
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

		</div>

	</div>




	<script type="text/javascript">
		$(document).ready( // div안에 있어야 새로고침됨
				function() {
					$('#bxslider').bxSlider({
						auto : true, // 자동 슬라이드
						speed : 500,
						pause : 4000,
						mode : 'fade',
						//autoControls : true, // 시작, 정지버튼 노출
						pager : true, // 블릿 버튼
					//slideWidth: 800, // 가로 크기
					});

					$("#datepicker1").datepicker({
						dateFormat : 'yy-mm-dd',
						minDate : 0,
						showOn : "both" // 버튼
					});
					$("#datepicker2").datepicker({
						dateFormat : 'yy-mm-dd',
						minDate : 0,
						showOn : "both" // 버튼                     
					});

					$('#datepicker1').datepicker();
					$('#datepicker1').datepicker("option", "maxDate",
							$("#datepicker2").val());
					$('#datepicker1').datepicker(
							"option",
							"onClose",
							function(selectedDate) {
								$("#datepicker2").datepicker("option",
										"minDate", selectedDate);
							});

					$('#datepicker2').datepicker();
					$('#datepicker2').datepicker("option", "minDate",
							$("#sdate").val());
					$('#datepicker2').datepicker(
							"option",
							"onClose",
							function(selectedDate) {
								$("#datepicker1").datepicker("option",
										"maxDate", selectedDate);
							});

					$("#search").on("click", function(event) {
						$(this).attr("href", function(i,val){ // i 속성을 추가하고 값은 val
							return val+"?startDate="+$("#datepicker1").val() + "&endDate="+$("#datepicker2").val();
						});
					});

				});


	</script>
	
	


</body>



</html>


