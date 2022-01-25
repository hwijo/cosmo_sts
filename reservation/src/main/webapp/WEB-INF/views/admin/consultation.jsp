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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
<div>
		<!-- 상담 -->
		<div style="padding : 100px;">
	   　　<div class="container" style="padding : 50px;" align="center">
	        <h2>相談</h2>
	    </div>
		<table class="table table-striped table-hover table-bordered">
			<tr class="table-info text-center">
				<td class="col-sm-5">title</td>
				<td class="col-sm-1">date</td>
			</tr>
		

	    <c:forEach var="list" items="${list}">		
			<tr>
				<td class="text-center">${list.title}</td>
				<fmt:formatDate value="${list.updatedAt}" pattern="yy-MM-dd"
					var="rewritedAt"></fmt:formatDate>
				<td class="text-center">${rewritedAt}</td>
				<td class="text-right"><button onclick = "location.href='/admin/consulReply?no=${list.no}' "class="btn btn-primary" style="float:right">답글 등록</button></td>
			</tr>		
    	</c:forEach>
	    </table>

	    </div>

</div>

</div>

</body>
</html>