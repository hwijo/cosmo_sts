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
<div class="container">
		<!-- 상담 -->
    <div style="padding : 100px;">
	   　　<div class="container" style="padding : 50px;" align="center">
	        <h2>相談(Admin)</h2>
	    </div>
		<table class="table table-striped table-hover table-bordered">
			<tr class="table-info text-center">
				<td class="col-sm-5">title</td>
				<td class="col-sm-1">date</td>
				<td class="col-sm-1"></td>
			</tr>
		

	    <c:forEach var="list" items="${list}">	
	        <tr>
	        <td class="text-left">
	        <c:forEach var="i" begin="0" end="${list.depth}">	
	            &nbsp;&nbsp;&nbsp;
	        </c:forEach>

	    <c:if test="${list.grgrod > 0}">	
	        <img src="https://previews.123rf.com/images/siamimages/siamimages1701/siamimages170102537/70663670-%EC%9E%90%EB%AC%BC%EC%87%A0-%EC%95%84%EC%9D%B4%EC%BD%98.jpg" style="width:20px; height:20px;">
	    </c:if>
	        <a href="/consultation?no=${list.no}">${list.title}</a>
	        </td>
				<fmt:formatDate value="${list.updatedAt}" pattern="yy-MM-dd"
					var="rewritedAt"></fmt:formatDate>
				<td class="text-center">${rewritedAt}</td>		
				
				<td class="text-right"><button onclick = "location.href='/admin/consulReply?no=${list.no}' "class="btn btn-primary" style="float:right">返信登録</button></td>		
			</tr>	
			
    	</c:forEach>
	    </table>

    </div>

</div>

</div>

</body>
</html>