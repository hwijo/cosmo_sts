<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8' />
<!-- 화면 해상도에 따라 글자 크기 대응(모바일 대응) -->
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<!-- jquery CDN -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- fullcalendar CDN -->
<link
	href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css'
	rel='stylesheet' />
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
<!-- fullcalendar 언어 CDN -->
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>
<style>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>

/* body 스타일 */
html, body {
	overflow: hidden;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}
/* 캘린더 위의 해더 스타일(날짜가 있는 부분) */
.fc-header-toolbar {
	padding-top: 1em;
	padding-left: 1em;
	padding-right: 1em;
}

#calendar {
    margin:0 auto;

}

</style>
</head>
<body>
	<!-- calendar 태그 -->
	<div id='calendar-container'>
		<div id='calendar' style="width:1000px; padding:50px"></div>
	</div>
<script>
$(function() {
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
		headerToolbar : {
		//plugins: [ 'dayGrid', 'timeGrid', 'list', 'interaction' ],
		//header: 
			left: 'prev,next today',
			center: 'title',
			right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
		    },
		    navLinks : true,
		    selectable : true,
		    selectMirror : true,
		    select : function(arg) {
			    console.log(arg);

			    var title = prompt('입력할 일정 : ');

			if(title) {
				calendar.addEvent({
					title : title,
					start : arg.start,
					end : arg.end,
					allday : arg.allDay,
					backgroundColor : "yellow",
					textColor : "blue"
					})
				}
			calendar.unselect()

			},

			eventClick : function(arg) { // 있는 일정 클릭 시
				console.log("등록된 일정 클릭");
				console.log(arg.event);

				if(confirm("선택한 이벤트를 삭제하시겠습니까?")) {
					arg.event.remove()

					}
			},

			editable : true,

			
			events: 
			function(info, successCallback, failureCallback) {
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
						successCallback(result);
					
					},
					error : function(request, status, error) {
						console.log("ajax error");
					}			

				});	
			}						
				
			
		});
    
	    //getDate()
		calendar.render(); // 풀캘린더 함수 마지막에	
		
		
	})
	// function end
	
	function getDate() {
	        //var result = [];
			$.ajax({
				url : '/fullcalendar/'+60,
				type: 'GET',
				data: 'JSON',
				success: function(datas) {
					console.log(datas)
					var result = [];
					$.each(datas, function(index, data){
						result.push({
			   		        start : data.startDate,
			   		        end : data.endDate,			   		        
		   		        });					
					})
					console.log(result);
					return result;
				
				},
				error : function(request, status, error) {
					console.log("ajax error");
				}			

			});
			//return result;
			
	}
</script>
</body>
</html>

