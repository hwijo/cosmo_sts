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

<script src="http://rosinante6000.co.kr/thema/Basic/assets/bs3/js/bootstrap.min.js"></script>
<script src="http://rosinante6000.co.kr/thema/Basic/assets/js/sly.min.js"></script>
<script src="http://rosinante6000.co.kr/thema/Basic/assets/js/custom.js"></script>
<script src="http://rosinante6000.co.kr/thema/Basic/widget/basic-sidebar/sidebar.js"></script>

</head>

<!-- 예약 -->

<style>






</style>



<body>
    
<!-- top 레이아웃 include -->


<div class="work-area">	

	<div class="container" style="padding : 50px;"align="center">
	    <h2>予約</h2>
	</div>

  			<div class="container">
				<form method="post" action="/reserve">
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
	        						<c:forEach var="room" items="${room}">
	        						<li>
	          							<button><img src="/resources/roomimages/${room.images}" width="200px" height="200px"/></button>
	          						</li>
	          						<div>
	          						    <p>${room.roomTitle}</p>
	          						</div>
	          						<li style="float:left;">
	          						    <p>${room.explnation}</p>
	          						</li>  
	          						<li>
	          						<select name="month" class="form-control mb-2" style="text-align-last: center;">
	        						<option value="">大人</option>									
										<option value="${room}">${room.maxpeople}</option>								   	
								    </select>
								    <select name="day" class="form-control mb-2" style="text-align-last: center;">
									<option value="">子供</option>
									
										<c:if test="${Integer.toString(day).length() lt 2}">
											<option value="0${day}">${day}일</option>
										</c:if>
										<c:if test="${Integer.toString(day).length() gt 1}">
											<option value="${day}">${day}일</option>
										</c:if>
									
								    </select>
                                    </li>
	          						</c:forEach>
<!-- 	          						<li class="mb-2">
	          							<button onclick="handleStartChange2()" type="button" class="btn btn-block btn-outline-secondary">roo2</button>
	          						</li>
	          						<li class="mb-2">
	          							<button onclick="handleStartChange3()" type="button" class="btn btn-block btn-outline-secondary">room3</button>
	          						</li> -->
	        					</ul>
	      					</div>
	    				</div>
	    				
	    				<div class="card mb-4 shadow-sm">
	      					

	      					<div class="card-header">
	        					<h4 class="my-0 font-weight-normal">入退室日</h4>
	      					</div>
	      					<div class="card-body">
	        					<select name="month" class="form-control mb-2" style="text-align-last: center;">
	        						<option value="">-- 월 --</option>
									<c:forEach var="month" items="${map.months}">
										<c:if test="${Integer.toString(month).length() lt 2}">
											<option value="0${month}">${month}월</option>
										</c:if>
										<c:if test="${Integer.toString(month).length() gt 1}">
											<option value="${month}">${month}월</option>
										</c:if>
									</c:forEach>
								</select>
								<select name="day" class="form-control mb-2" style="text-align-last: center;">
									<option value="">-- 일 --</option>
									<c:forEach var="day" items="${map.days}">
										<c:if test="${Integer.toString(day).length() lt 2}">
											<option value="0${day}">${day}일</option>
										</c:if>
										<c:if test="${Integer.toString(day).length() gt 1}">
											<option value="${day}">${day}일</option>
										</c:if>
									</c:forEach>
								</select>

	        					<button type="submit" class="btn btn-lg btn-block btn-outline-primary">予約</button>
	      					</div>
	    				</div>		
					</div>
				</form>
				
				<div class="modal fade" id="roomReserveListModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
			</div>
			<div class="modal-body">
			<input type="hidden" id="roomReserveNo" value="">
			<input type="hidden" id="ddayYear" value="0">
			<input type="hidden" id="ddayMonth" value="0">
			                  <div class="panel-body">
                        <div class="calendar fc fc-ltr">
                    
                            <table class="fc-header" style="width:100%">
                                <tbody>
                                    <tr>
                                        <td class="fc-header-left">
                                            <div class="btn-group">
                                                <button type="button" class="fc-button-prev fc-corner-left btn btn-default btn-sm calendarMoveBtn" ddayOption="prev"> <i class="fa fa-chevron-left"></i>

                                                </button>
                                                <button type="button" class="btn btn-default btn-sm calendarMoveBtn" ddayOption="next"> <i class="fa fa-chevron-right"></i>

                                                </button>
                                            </div> 
                                        </td>
                                        <td class="fc-header-center"> <span class="fc-header-title">          <h2 id="calendarTitle">January 2014</h2>          </span>

                                        </td>
                                        <td class="fc-header-right">

                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="fc-content" style="position: relative; min-height: 1px;">
                                <div class="fc-view fc-view-month fc-grid" style="position: relative; min-height: 1px;" unselectable="on">
                                    <table class="fc-border-separate" cellspacing="0">
                                        <thead>
                                            <tr class="fc-first fc-last">
                                                <th class="fc-day-header fc-sun fc-widget-header fc-first" style="width: 158px;">Sun</th>
                                                <th class="fc-day-header fc-mon fc-widget-header" style="width: 158px;">Mon</th>
                                                <th class="fc-day-header fc-tue fc-widget-header" style="width: 158px;">Tue</th>
                                                <th class="fc-day-header fc-wed fc-widget-header" style="width: 158px;">Wed</th>
                                                <th class="fc-day-header fc-thu fc-widget-header" style="width: 158px;">Thu</th>
                                                <th class="fc-day-header fc-fri fc-widget-header" style="width: 158px;">Fri</th>
                                                <th class="fc-day-header fc-sat fc-widget-header fc-last" style="width: 158px;">Sat</th>
                                            </tr>
                                        </thead>
                                        <tbody id="calendarListTbody">

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>


				
				
<%-- 

  				<footer class="pt-4 border-top">
  					<div class="pricing-header px-3 py-3 pb-md-4 mx-auto text-center">
						<p class="lead">좌석 검색</p>
					</div>
  				
    				<div class="row text-center d-flex justify-content-center">
      					<form class="form-inline" name="search_form" method="post" action="${path}/timetable/list.do">
							<select name="month" class="form-control mr-2 mb-2" style="text-align-last: center;">
								<option value="">-- 월 --</option>
								<c:forEach var="month" items="${map.months}">
									<c:if test="${Integer.toString(month).length() lt 2}">
										<option value="0${month}">${month}월</option>
									</c:if>
									<c:if test="${Integer.toString(month).length() gt 1}">
										<option value="${month}">${month}월</option>
									</c:if>
								</c:forEach>
							</select>
							<select name="day" class="form-control mr-2 mb-2" style="text-align-last: center;">
								<option value="">-- 일 --</option>
								<c:forEach var="day" items="${map.days}">
									<c:if test="${Integer.toString(day).length() lt 2}">
										<option value="0${day}">${day}일</option>
									</c:if>
									<c:if test="${Integer.toString(day).length() gt 1}">
										<option value="${day}">${day}일</option>
									</c:if>
								</c:forEach>
							</select>
							<select name="time" class="form-control mr-2 mb-2" style="text-align-last: center;">
								<option value="">-- 출발 시간 --</option>
								<c:forEach var="time" items="${map.times}">
									<c:if test="${Integer.toString(time).length() lt 2}">
										<option value="0${time}">${time}시</option>
									</c:if>
									<c:if test="${Integer.toString(time).length() gt 1}">
										<option value="${time}">${time}시</option>
									</c:if>
								</c:forEach>
							</select>
							<button type="submit" class="btn btn-outline-secondary mb-2">검색</button>
						</form>
						
						<c:if test="${map.count eq 0}">
							<span style="color: blue;">이 시간대의 버스는 없습니다</span>
						</c:if>
					</div>
						
					<div class="row text-center d-flex justify-content-center">
						<table class="table table-hover" border="1" style="width: 600px">
							<tr>
								<th>#</th>
								<th>출발 시간</th>
								<th>도착 시간</th>
								<th>버스 번호</th>
							</tr>
							<c:forEach var="row" items="${map.timetable}">
							
								<tr>
									<td>${row.getSeqNo()}</td>
									<td>
										<a href="${path}/timetable/detail.do?id=${row.getSeqNo()}">
											${row.getStartTime().substring(0, 4)}년
											${row.getStartTime().substring(4, 6)}월
											${row.getStartTime().substring(6, 8)}일
											${row.getStartTime().substring(8, 10)}시
											${row.getStartTime().substring(10, 12)}분
										</a>
									</td>
									<td>
										<a href="${path}/timetable/detail.do?id=${row.getSeqNo()}">
											${row.getEndTime().substring(0, 4)}년
											${row.getEndTime().substring(4, 6)}월
											${row.getEndTime().substring(6, 8)}일
											${row.getEndTime().substring(8, 10)}시
											${row.getEndTime().substring(10, 12)}분
										</a>
									</td>
									<td>${row.getBusNo()}</td>
								</tr>
							
							</c:forEach>
							
						</table>
					</div>
						
					<div class="row d-flex justify-content-center">
						<nav aria-label="Page navigation example">
						  <ul class="pagination">
						  	<c:if test="${map.pagination.getCurPage() > 1}">
						  		<li class="page-item">
						  			<a class="page-link" href="javascript:list('1')">[처음]</a>
						  		</li>
							</c:if>
							
							<c:if test="${map.pagination.getCurBlock() > 1}">
								<li class="page-item">
									<a class="page-link" aria-label="Previous" href="javascript:list('${map.pagination.getPrevPage()}')">
										<span aria-hidden="true">&laquo;</span>
									</a>
								</li>
							</c:if>
							
							<c:forEach var="num" begin="${map.pagination.getBlockBegin()}" end="${map.pagination.getBlockEnd()}">						
								<c:choose>
									<c:when test="${num == map.pagination.getCurPage()}">
										<li class="page-item disabled">
									    	<span class="page-link">${num}</span>
									    </li>
									</c:when>
									<c:otherwise>
										<li class="page-item">
											<a class="page-link" href="javascript:list('${num}')">${num}</a>
										</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						    
						    <c:if test="${map.pagination.getCurBlock() <= map.pagination.getTotBlock()}">
						    	<li class="page-item">
									<a class="page-link" href="javascript:list('${map.pagination.getNextPage()}')">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</c:if>
							<c:if test="${map.pagination.getCurPage() < map.pagination.getTotPage()}">
								<li class="page-item">
									<a class="page-link" href="javascript:list('${map.pagination.getTotPage()}')">[끝]</a>
								</li>
							</c:if>
						    
						  </ul>
						</nav>
					</div>
  				</footer>
			</div> --%>

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
			
			


</div>


</div>
    
<!--     <div class="container">
    <form method="post" action="/reserve">
        <table>
			<ul class="jss26 itemList">
				<li><a class="jss28">이미지</a>
					<div class="jss30 itemInfo">방정보</div>
					<div class="jss32 jss43">인원수</div>
					<div class="jss34">가격</div>
				</li>
			</ul>
		</table>     
    </form> -->
    
    


</body>

<script>


</script>

</html>
