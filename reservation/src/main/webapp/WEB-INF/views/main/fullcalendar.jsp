<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<!-- íë©´ í´ìëì ë°ë¼ ê¸ì í¬ê¸° ëì(ëª¨ë°ì¼ ëì) -->
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
<!-- fullcalendar ì¸ì´ CDN -->
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>
<style>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>

/* body ì¤íì¼ */
html, body {
	overflow: hidden;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}
/* ìºë¦°ë ìì í´ë ì¤íì¼(ë ì§ê° ìë ë¶ë¶) */
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
	<!-- calendar íê·¸ -->
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

			    var title = prompt('ìë ¥í  ì¼ì  : ');

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

			eventClick : function(arg) { // ìë ì¼ì  í´ë¦­ ì
				console.log("예약된 날짜 클릭");
				console.log(arg.event);

				if(confirm("예약된 날짜를 취소하시겠습니까?")) {
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
		calendar.render(); // íìºë¦°ë í¨ì ë§ì§ë§ì	
		
		
	})
	// function end
	

</script>
</body>
</html>

