<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='http://code.jquery.com/jquery-latest.js'></script> 
<link href='/fullcalendar/main.css' rel='stylesheet' />
<script src='/fullcalendar/main.js'></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
</head>
<body style="padding: 30px;">
	<!-- calendar 태그 -->
	<div id='calendar-container'>
		<div id='calendar'></div>
	</div>
<script>
/* $(document).ready(function(){
	$.ajax({
		url: '/calendar',
		type: 'GET',
		dataType: 'json',
		success: function(map){
			var list = map;
			console.log(list);	
			alert(list);
			
 			var calendarEl = document.getElementById('calendar');
			
			var events = list.map(function(item) {
				return {
					title : item.roonInfo_No,
					start : item.startDate,
					end : item.endDate,
				}
			});
			
			var calendar = new FullCalendar.Calendar(calendarEl, {
				events : '/calendar'
				eventTimeFormat: { // like '14:30:00'
				    hour: '2-digit',
				    minute: '2-digit',
				    hour12: false
				  }
			});
			calendar.render();
		},
	})
});  */

/* $(document).ready(function() {
    var calendarEl = document.getElementById('calendar');   
    var calendar = new FullCalendar.Calendar(calendarEl, {
        height: 600,
        plugins: [ 'dayGrid' ],
        defaultView: 'dayGridMonth',
        defaultDate: new Date(),
        header: {
            left: '',
            center: 'title',
            right: 'prev,next today'
          },
        eventLimit: true,
        eventLimitText: "more",
        eventLimitClick: "popover",
        editable: false,
        droppable: false,
        dayPopoverFormat: { year: 'numeric', month: 'long', day: 'numeric' },
        events:function(info, successCallback, failureCallback){
            $.ajax({
                   url: 'calendar',
                   type: 'GET',
                   dataType: 'json',
                   success: 
                       function(result) {
 
                           var events = [];
                          
                           if(result!=null){
                               
                                   $.each(result, function(index, element) {
                                   var endDate=element.endDate;
                                    if(endDate==null){
                                        endDate=element.startDate;
                                    }
                                    
                                    var startDate=moment(element.startDate).format('YYYY-MM-DD');
                                    var endDate=moment(endDate).format('YYYY-MM-DD');
                                    //var roomInfo_No = element.roomInfo_No;
                                    
                                    // realmname (분야) 분야별로 color 설정
                                    events.push({
                                               //title: element.,
                                               start: startDate,
                                               end: endDate,
                                                  //url: "${pageContext.request.contextPath }/detail.do?seq="+element.seq,
                                                  //color:"#6937a1"                                                   
                                        }); //.push()                              
                                                                                                            

                                    
                               }); //.each()
                               
                               console.log(events);
                               
                           }//if end                           
                           successCallback(events);                               
                       }//success: function end                          
            }); //ajax end
        }, //events:function end
   });//new FullCalendar end
 
   calendar.render();
   
}); */

$(document).ready(function(){
$.ajax({
	url: '/calendar',
	type: 'GET',
	dataType: 'json',
	contentType: 'charset=UTF-8',
	cache: false,
	success: function(data){
		alert("성공");
		console.log(res);
	},
	error:function(e){
        if(e.status==300){
             alert("실패");
        }
	}
	
})
});  



</script>
</body>
</html>

