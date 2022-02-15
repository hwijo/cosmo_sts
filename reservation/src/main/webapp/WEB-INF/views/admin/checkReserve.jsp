<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form id="updateForm" role="form" name="reply" action="/admin/checkReserve" method="post">    
	<input type="hidden" value="${dto.paymentFlg}" id="paymentFlg" name="paymentFlg">	
</form>

<script>

$(function() {
	alert("予約確認しました。");
	document.getElementById("updateForm").submit();	
});

</script>

</body>
</html>