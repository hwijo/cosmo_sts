<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<html>
<head>
	<title>Home</title>
	
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

</head>


<body>

<div class="work-area">
    <div class="container" style="padding : 100px;"align="center">
	    <h2>Admin</h2>
	</div>	

    <div class="container">

    <div class="card mb-4 shadow-sm">
    <div class="card-body" style="text-align:center;">
		<div class="form-group">
			<button	onclick = "location.href='/admin/insertRoom' "class="btn btn-primary" >部屋登録</button>
		</div>		
		<div class="form-group">
			<button	onclick = "location.href='/admin/insertNotice' "class="btn btn-primary" >お知らせ登録</button>
		</div>
		<div class="form-group">
			<button	onclick = "location.href='/admin/insertSliderimages' "class="btn btn-primary" >スライドイメージ登録</button>
		</div>
		<div class="form-group">
			<button	onclick = "location.href='/admin/consultationList' "class="btn btn-primary">相談</button>
		</div>
		<div class="form-group">
			<button	onclick = "location.href='/admin/reserveList' "class="btn btn-primary">予約確認</button>
		</div>
		
	</div>	
	
	</div>			
	</div>		
</div>



              



</body>



</html>


