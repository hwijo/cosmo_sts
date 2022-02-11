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
<div class="container">
		<div class="row" style="padding : 70px;">
			<div class="col-lg-12">
				<div class="panel-body"
					style="display: flex; flex-direction: column;">
					<div class="form-group">
						<!-- <label>タイトル</label>  -->
						<input readonly class="form-control"
							value="${consul.name}">
					</div>
					<div class="form-group">
						<!-- <label>タイトル</label>  -->
						<input readonly class="form-control"
							value="${consul.title}">
					</div>					
					<div class="form-group">
						<!-- <label>내용</label> -->
						<span>${consul.contents}</span>
					</div>
					

				</div>
			</div>

		</div>
</div>
</div>

<%-- <P>  The time on the server is ${serverTime}. </P> --%>
</body>
</html>
