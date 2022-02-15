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
	        <h2>予約確認</h2>
	    </div>
		<table class="table table-striped table-hover table-bordered">
			<tr class="table-info text-center">
				<td class="col-sm-3">予約された部屋</td>
				<td class="col-sm-3">予約日</td>
				<td class="col-sm-1">登録日</td>
				<td class="col-sm-1"></td>
			</tr>
		

	    <c:forEach var="listRe" items="${list}">	
	        <tr>
	            <td class="text-left">
	            ${listRe.no}
	            </td>
	            <td class="text-left">
	            ${listRe.startDate} ~ ${listRe.endDate}
	            </td>
			        <fmt:formatDate value="${listRe.updatedAt}" pattern="yy-MM-dd"
				var="rewritedAt"></fmt:formatDate>
			    <td class="text-center">${rewritedAt}</td>	
			    
			    
            <c:if test="${empty listRe.paymentFlg}">
				<td class="text-right"><button onclick = "location.href='/admin/checkReserve?no=${listRe.no}' "class="btn btn-primary" style="float:right">入金確認</button></td>	
			</c:if>
			<c:if test="${not empty listRe.paymentFlg}">
				<td class="text-right">予約確認完了</td>	
			</c:if>
			</tr>	
			
    	</c:forEach>
	    </table>

    </div>

</div>

</div>

<script>



</script>
</body>

</html>