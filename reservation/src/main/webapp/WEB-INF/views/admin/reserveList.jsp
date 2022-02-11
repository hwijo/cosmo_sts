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
	        <h2>예약확인</h2>
	    </div>
		<table class="table table-striped table-hover table-bordered">
			<tr class="table-info text-center">
				<td class="col-sm-3">예약된 방</td>
				<td class="col-sm-3">예약된 날짜</td>
				<td class="col-sm-1">예약한 날짜</td>
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
			    
			    
			<!-- <form id="replyForm" role="form" name="reply" action="/admin/consulReply" method="post">    
			    <input type="hidden" value="1" id="paymentFlg" name="paymentFlg">	
			</form> -->
			    			
				<td class="text-right"><button onclick = "check(${listRe.paymentFlg})" class="btn btn-primary" style="float:right">입금확인</button></td>	
			</tr>	
			
    	</c:forEach>
	    </table>

    </div>

</div>

</div>

<script>

function check(no) {
	console.log(no);
	alert("예약확인 되었습니다.");
		
}

$(function() {
		$.ajax({
			url : '/fullcalendar',
			type: 'GET',
			data: 'JSON',
			success: function(datas) {
				console.log(datas)
				var result = [];
				$.each(datas, function(index, data){
					result.push({                                 
		   		        start: data[0],
		   		        end: data[1],
		   		        title: data[2],
		   		        backgroundColor : data[3]
		   		        		   		        
	   		        });					
				});
				console.log(result);
				return result;
			
			},
			error : function(request, status, error) {
				console.log("ajax error");
			}			

		});	
			


});
</script>
</body>

</html>