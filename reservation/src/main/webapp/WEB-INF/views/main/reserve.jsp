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

	<div class="container" style="padding : 100px;" align="center">
	    <h2>予約</h2>	    
	</div>  
	
<%-- 	<c:forEach var="date" items="${date}">
	    <p id="date">${date.startDate}</p>
	    <p id="date">${date.endDate}</p>		
	</c:forEach> --%>
	

  			<div class="container"> 
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
	          						
	          						<select id="adult" name="adult" style="text-align-last: center;">
	        						<option value="0">大人</option>	
	        							<c:forEach var="i" begin="1" end="${room.max}">	
	        							    <option><c:out value="${i}"/></option>		
										</c:forEach>				   	
								    </select>
								    <select id="child" name="child" style="text-align-last: center;">
									<option value="0">子供</option>
									    <c:forEach var="i" begin="1" end="${room.max}">	
	        							    <option><c:out value="${i}"/></option>		
										</c:forEach>								
								    </select>
                                    </li>
                                    
                                    <li>
                                                                                
                                        <span id="adultCost" name="adultCost"></span>円     
                                        <span id="childCost" name="childCost"></span>円                                     
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
						    <p><input type="text" id="name" name="name" style="width:100px" placeholder="名前"></p>
						    <p>銀行
						    <select id="bankName" name="bankName" style="text-align-last: center;">
								<option value="">銀行</option>
								<option value="韓国">韓国</option>
								<option value="日銀">日銀</option>
								<option value="三菱">三菱</option>					
						    </select>
						    </p>
						    <p><input type="text" id="phone" name="phone" style="width:100px" placeholder="連絡先"></p>						
						</div>
						
						<div>
						    <p><input type="text" id="totalCost" name="totalCost" style="width:100px" placeholder="総金額">円</p>						
						</div>				
						
	

						<div class="d-grid gap-2 col-6 mx-auto">
					        <button type="button" class="btn btn-primary float-right" onclick="checkNull(${room.no})">予約</button>
				        </div>		
	      					

	    				</div>		
					</div>
				</form>    				

				



<script type="text/javascript">

// null 체크
function checkNull(no) {
	if($("#datepicker1").val().trim() == ""){		
        alert("入室日を入力してください。");
        $("#datepicker1").focus();
        return false;
    }
	
	else if($("#datepicker2").val().trim() == ""){		
        alert("退室日を入力してください。");
        $("#datepicker2").focus();
        return false;
    }

	else if($("#name").val().trim() == ""){		
        alert("名前を入力してください。");
        $("#name").focus();
        return false;
    }

	else if($("#bankName").val().trim() == ""){		
        alert("銀行を入力してください。");
        $("#bankName").focus();
        return false;
    }

	else if($("#phone").val().trim() == ""){		
        alert("連絡先を入力してください。");
        $("#phone").focus();
        return false;
    }

	else if($("#totalCost").val().trim() == ""){		
        alert("総金額を入力してください。");
        $("#totalCost").focus();
        return false;
    }
	
	else {
		document.getElementById("insertForm").submit();
	}
	
}


// 금액 계산
var adult = 0; // 대인 가격
var child = 0; // 소인 가격
var sum = 0;

$("#adult").change(function() {
	$("#adultCost").empty();
	$("#adultCost").append("${room.adultCost}"*$(this).val());

	adult = "${room.adultCost}"*$(this).val();

	$("#totalCost").empty();
	$("#totalCost").val(adult + child); 
	
});
 
$("#child").change(function() {
	$("#childCost").empty();
	$("#childCost").append("${room.childCost}"*$(this).val());

    child = "${room.childCost}"*$(this).val();

	$("#totalCost").empty();
	$("#totalCost").val(adult + child);

});

$(function() {
	
    $("#datepicker1").datepicker({
        dateFormat: 'yy-mm-dd',
        minDate: 0,
        showOn:"both",
        buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif", 
        beforeShowDay: my_check // 캘린더가 실행 되기 전에 실행
    });

    $("#datepicker2").datepicker({
        dateFormat: 'yy-mm-dd',
        minDate: 0,
        showOn:"both",
        buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif"  
        
    });

/*     var startDate;
    var endDate;

    <c:forEach items="${date}" var="date" varStatus="status">
        //console.log(${status.count}) // 1번만 돔                
        startDate = "${date.startDate}"; // 위에 list나 변수를 선언하고 차례대로 값을 받는다.
        endDate = "${date.endDate}";
        var re = [];
        re.push(startDate);
        re.push(endDate);
        console.log(startDate)
        console.log(endDate)
        console.log(re)        
    </c:forEach> */ 
    
        
    function my_check(in_date) {
        var startDate;
        var endDate;
        var re = [];
        var re1 = [];
        var re2 = [];

        <c:forEach items="${date}" var="date" varStatus="status"> 
       
            //console.log(${status.count})             
            startDate = "${date.startDate}"; // 위에 list나 변수를 선언하고 차례대로 값을 받는다.
            endDate = "${date.endDate}";                       
            re.push(startDate);
            re.push(endDate);
            re1.push(startDate); 
            re2.push(endDate); 
                 
        </c:forEach> 


                
    	in_date = in_date.getFullYear() + '-'
        + (in_date.getMonth() + 1).toString().padStart(2,'0') + '-' + in_date.getDate().toString().padStart(2,'0'); // padStart : 자리 수를 설정하고 남는 공간에 다른 문자열을 채울수 있게 하는 메서드 
        //console.log(in_date)          
        
        //console.log(re1.length)
        
        var result = [];
        
        for(var i=0; i<re1.length; i++) {
        	//console.log(re1)
            //console.log(re2)
	        var regex = RegExp(/^\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/);
	        //console.log(regex.test(re1[i]))
	        if(!(regex.test(re1[i]) && regex.test(re2[i]))) // regex가 false일경우
	            return "Not Date Format";
	        
	        var curDate = new Date(re1[i]);
	        while(curDate <= new Date(re2[i])) {
	        	result.push(curDate.toISOString().split("T")[0]); // startDate, endDate 사이의 날짜를 result 배열에 담음
	        	curDate.setDate(curDate.getDate() + 1);
	        }
	       
        }   
        
        console.log(result)
        
	        //var my_array = new Array('2022-02-15', '2022-02-16', '2022-02-20'); // 막을 날짜 담기
	        //$('#d1').append(in_date+'<br>')
	        //console.log(my_array)
	        if (result.indexOf(in_date) >= 0) { // 찾는 문자열이 없으면 -1 리턴
	            return [false, "notav", 'Not Available'];
	        } else {
	            return [true, "av", "available"];
	        }
        
        


    }
    
   
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
// function end
 









	
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
			