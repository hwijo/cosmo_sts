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

<div class="work-area">	
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
	    
	    <!-- 답변글이 아닌 원글일 경우 -->
	    <c:if test="${list.grgrod == 0}">
	    <c:if test="${list.depth == 0}">
			<tr>
				<td class="text-left"><a href="consultation?no=${list.no}">${list.title}</a></td>
				<fmt:formatDate value="${list.updatedAt}" pattern="yy-MM-dd"
					var="rewritedAt"></fmt:formatDate>
				<td class="text-center">${rewritedAt}</td>				
			</tr>
		</c:if>	
		</c:if>
		<!-- 답글인 경우 -->
	    <c:if test="${list.grgrod > 0}">
	    <c:if test="${list.depth > 0}">
			<tr>
				<td class="text-left"><span style="color:red; font-style:italic;">&nbsp;RE:</span><a href="consultation?no=${list.no}">${list.title}</a></td>
				<fmt:formatDate value="${list.updatedAt}" pattern="yy-MM-dd"
					var="rewritedAt"></fmt:formatDate>
				<td class="text-center">${rewritedAt}</td>				
			</tr>
		</c:if>	
		</c:if>		
		
    	</c:forEach>
	    </table>
	    
	    <div class="form-group" style="text-align:right;" >
			<button	onclick = "location.href='/insertConsultation' "class="btn btn-primary pull-right" >相談登録</button>
		</div>	

	    </div>

</div>

</div>

</body>
</html>