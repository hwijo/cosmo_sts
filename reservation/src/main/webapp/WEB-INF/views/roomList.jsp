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
	<div class="container" style="padding : 50px;"align="center">
	    <h2>room list</h2>
	</div>	
	
	<div>
	    
	
	</div>

	<div style="padding : 100px;">
		<table class="table table-striped table-hover table-bordered">
			<tr class="table-info text-center">
				<td class="col-sm-5">title</td>
				<td class="col-sm-1">date</td>
			</tr>
		

	    <c:forEach var="roomList" items="${roomList}">
		
			<tr>
				<td class="text-center"><a href="roomInfo?no=${roomList.no}">${roomList.roomTitle}</a></td>
				<fmt:formatDate value="${roomList.updatedAt}" pattern="yy-MM-dd"
					var="rewriteDate"></fmt:formatDate>
				<td class="text-center">${rewriteDate}</td>
			</tr>
		
    	</c:forEach>
	    </table>
	</div>

</div>

<%-- <P>  The time on the server is ${serverTime}. </P> --%>
</body>
</html>
