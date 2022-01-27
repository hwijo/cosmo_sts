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
	
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css" />
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.css" />


<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>



</head>

<!-- 예약 -->



<body>


    

<div class="work-area">	

	<div class="container" style="padding : 80px;" align="center">
	    <h2>予約</h2>
	</div>  
	

  			<div class="container"> 
<%--             <c:if test="${not empty reserveinfo.startDate}"> --%>
				<form method="post" action="/reserve" id="insertForm" name="reserve">
	  				<div class="card-deck mb-3 text-center">
	    				<div class="card mb-4 shadow-sm">
	      					<div class="card-header">
	        					<h4 class="my-0 font-weight-normal">部屋</h4>
	      					</div>
	      					<div class="card-body">
	        					<ul class="list-unstyled mt-3 mb-4">
	        						<li class="mb-2">
	        							<strong id="start"></strong>
	        						</li>
	        						
	        						<li>
	          							<img src="/resources/roomimages/${room.images}" width="200px" height="200px"/>
	          						<div>
	          						    <p>${room.roomTitle}</p>
	          						</div>
	          						<li style="float:left;">
	          						    <p>${room.explnation}</p>
	          						</li>	          						
	          						<li>
	          						<input type="hidden" value="${room.no}" name="no">
	          						<select name="adult" style="text-align-last: center;">
	        						<option value="">大人</option>	
	        							<c:forEach var="i" begin="1" end="${room.max}">	
	        							    <option><c:out value="${i}"/></option>		
										</c:forEach>				   	
								    </select>
								    <select name="child" style="text-align-last: center;">
									<option value="">子供</option>
									    <c:forEach var="i" begin="1" end="${room.max}">	
	        							    <option><c:out value="${i}"/></option>		
										</c:forEach>								
								    </select>
                                    </li>
	          						
	          						

	        					</ul>
	      					</div>
	    				</div>
	    				
	    				<div class="card mb-4 shadow-sm">   					

	      					<div class="card-header">
	        					<h4 class="my-0 font-weight-normal">入退室日</h4>
	      					</div>

                        <!-- 예약 날짜 -->
						<div style="padding:50px">
							<input type="text" id="datepicker1" name="startDate"> ~ 
							<input type="text" id="datepicker2" name="endDate">
						</div>
						
						<div>
						    <p>은행<input type="text" name="bankName"></p>
						    <p>전화번호<input type="text" name="phone"></p>
						    <p>금액<input type="text" name="totalcost"></p>						
						</div>
						
						
						
	

						<div class="d-grid gap-2 col-6 mx-auto">
					        <button type="submit" class="btn btn-primary float-right">予約</button>
				        </div>		
	      					

	    				</div>		
					</div>
				</form>    				
<%-- 				</c:if> --%>
				



<script type="text/javascript">
$(function() {
    $("#datepicker1").datepicker({
        dateFormat: 'yy-mm-dd',
        minDate: 0,
        showOn: "both" 
    });        
    $("#datepicker2").datepicker({
        dateFormat: 'yy-mm-dd',
        minDate: 0,
        showOn: "both"                       
    });
    
    $('#datepicker1').datepicker();
    $('#datepicker1').datepicker("option", "maxDate", $("#datepicker2").val());
    $('#datepicker1').datepicker("option", "onClose", function ( selectedDate ) {
        $("#datepicker2").datepicker( "option", "minDate", selectedDate );
    });

    $('#datepicker2').datepicker();
    $('#datepicker2').datepicker("option", "minDate", $("#sdate").val());
    $('#datepicker2').datepicker("option", "onClose", function ( selectedDate ) {
        $("#datepicker1").datepicker( "option", "maxDate", selectedDate );
    });
    
});

	
</script>
        
	    </div>



</div>


</body>


</html>



<!-- input text 
	 <form id="insertForm" name="reserve" action="/reserve" method="post" >
			<table class="table table-bordered">
				<tr>
					<td class="text-center"><strong>예약자 이름</strong></td>		
					<td colspan="3"><input type="text" required="required" id="name" name="name" class="col-sm-9 col-form-label"></td>		
				</tr>			
				<tr>
					<td class="text-center"><strong>방</strong></td>		
					<td colspan="3"><input type="text" required="required" id="roomNum" name="roomNum" class="col-sm-9 col-form-label"></td>		
				</tr>	
			    <tr>
					<td class="text-center"><strong>전화번호</strong></td>		
					<td colspan="3"><input type="text" required="required" id="phone" name="phone" class="col-sm-9 col-form-label"></td>		
				</tr>
				<tr>
					<td class="text-center"><strong>성인</strong></td>		
					<td colspan="3"><input type="text" required="required" id="adult" name="adult" class="col-sm-9 col-form-label"></td>		
				</tr>
				<tr>
					<td class="text-center"><strong>소인</strong></td>		
					<td colspan="3"><input type="text" required="required" id="child" name="child" class="col-sm-9 col-form-label"></td>		
				</tr>
				<tr>
					<td class="text-center"><strong>입실일</strong></td>		
					<td colspan="3"><input type="text" required="required" id="startDate" name="startDate" class="col-sm-9 col-form-label"></td>		
				</tr>
				<tr>
					<td class="text-center"><strong>퇴실일</strong></td>		
					<td colspan="3"><input type="text" required="required" id="endDate" name="endDate" class="col-sm-9 col-form-label"></td>		
				</tr>
				<tr>
					<td class="text-center"><strong>입금은행</strong></td>		
					<td colspan="3"><input type="text" required="required" id="bankName" name="bankName" class="col-sm-9 col-form-label"></td>		
				</tr>

				
				</table>
				<div class="d-grid gap-2 col-6 mx-auto">
					<button type="submit" class="btn btn-primary float-right">예약</button>
				</div>		
		</form> 
			 -->
<!-- 	<form id="insertForm" role="form" action="/insertRoom" method="post">
		<br style="clear: both">
		<h3 style="margin-bottom: 25px;">Article Form</h3>
		<div class="form-group">
			<input type="text" class="form-control" id="title" name="title"
				placeholder="title" required>
		</div>
		<div class="form-group">
			<textarea class="form-control" id="summernote" name="content"
				placeholder="content" maxlength="140" rows="7"></textarea>
		</div>
		<button type="submit" id="submit" name="submit"
			class="btn btn-primary pull-right">Submit Form</button>
	</form> -->
			