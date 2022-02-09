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
</head>
<body>

<div class="work-area">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel-body"
					style="display: flex; flex-direction: column;">
					<div class="form-group">
						<label>등록번호</label> <input readonly class="form-control"
							value="${roomInfo.no}">
					</div>
					<div class="form-group">
						<label>제목</label> <input readonly class="form-control"
							value="${roomInfo.roomTitle}">
					</div>
					<div class="form-group">
						<label>예약가(성인)</label> <input readonly class="form-control"
							value="${roomInfo.adultCost}">
					</div>
					<div class="form-group">
						<label>예약가(어린이)</label> <input readonly class="form-control"
							value="${roomInfo.childCost}">

					<div class="form-group">
						<label>내용</label>
						<textarea readonly class="form-control" rows="5">${roomInfo.explnation}</textarea>
					</div>
					<div class="form-group">
						<p><img src="<c:out value="/images/${roomInfo.images}"/>"></p>
					</div>
<%-- 
					<fmt:formatDate value="${community.community_writeDate}"
						pattern="yy-MM-dd" var="writeDate"></fmt:formatDate>
					<div class="form-group">
						<label>등록시간</label> <input readonly class="form-control"
							value="${writeDate}">
 --%>
 					</div>
					<div class="form-group">
						<button	onclick = "location.href = 'reserve?no=${roomInfo.no}' "class="btn btn-primary" style="float:right">예약</button>
<%-- 						<button
							onclick="location.href='update?id=${community.community_registerNo}'"
							onclick="update(${community.community_registerNo})"
							class="btn btn-primary" style="float:right">수정</button> --%>
					</div>

				</div>
			</div>

		</div>

</div>

<%-- <P>  The time on the server is ${serverTime}. </P> --%>
</body>
</html>
