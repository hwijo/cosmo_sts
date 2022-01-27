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
	<title>home</title>
</head>
<body>

<div class="work-area">
	<div class="container" style="padding : 50px;"align="center">
	    <h2>部屋</h2>
	</div>	
	
<div class="container" > 	
    <div class="card mb-4 shadow-sm">
	    <div class="card-header" style="text-align:center;">
	        <h4 class="my-0 font-weight-normal">部屋</h4>
	    </div>
	      			<div class="card-body" style="text-align:center;">
	        			<ul class="list-unstyled mt-3 mb-4">
	        				<li class="mb-2">
	        					<strong id="start"></strong>
	        				</li>
	        					<c:forEach var="room" items="${room}">
	        						<li>
	        						    <p>${room.no}</p>
	        						    <a href="/reserve?no=${room.no}">
	          							<img src="/resources/roomimages/${room.images}" width="200px" height="200px"/>
	          						    </a>
	          						<li>	          						    
	          						    <p>${room.roomTitle}</p>
	          						</li>           						
	          						<li>
	          						    <p>${room.explnation}</p>
	          						</li>   						

	          					</c:forEach>
	          						

	        			</ul>
	      			</div>
	      					
    </div>
</div>


</div>

<%-- <P>  The time on the server is ${serverTime}. </P> --%>
</body>
</html>
