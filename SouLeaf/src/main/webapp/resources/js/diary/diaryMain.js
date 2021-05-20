document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
	
    var calendar = new FullCalendar.Calendar(calendarEl, {
      // 이미 등록된 일정 클릭 시 모달창
      eventClick: function(e) {
        $('#eventModal').modal({
              // 옵션값넣기
        });
    },
      // toolbar에 일기쓰기 버튼
      customButtons: {
        myCustomButton: {
          text: '일기쓰기',
          click: function(e) {
            e.preventDefault();
            $('#eventModal').modal({
              // 옵션값넣기
            });
          }
        }
    
      },
      headerToolbar: {
        left: 'today',
        center: 'prev,title,next',
        right: 'myCustomButton'
      },
      initialDate: '2020-09-12', // 달력 초기화면에서 날짜 값
      navLinks: false, // can click day/week names to navigate views
      businessHours: true, // display business hours
      editable: true,
      selectable: true,
      locale: 'ko',
      fixedWeekCount : false,
      contentHeight: 600,
      
      events: [
        
        {
          title: 'Business Lunch',
          start: '2020-09-03T13:00:00',
          constraint: 'businessHours',
          color: '#257e4a'
        },
        {
          title: 'Meeting',
          start: '2020-09-13T11:00:00',
          constraint: 'availableForMeeting', // defined below
          color: '#257e4a'
        },
        {
          title: 'Conference',
          start: '2020-09-18',
          end: '2020-09-20'
        },
        {
          title: 'Party',
          start: '2020-09-29T20:00:00'
        },
        {
          title: 'testmessage',
          start: '2020-09-22',
          end: '2020-09-22',
          color : 'red'
        },

        // areas where "Meeting" must be dropped
        {
          groupId: 'availableForMeeting',
          start: '2020-09-11T10:00:00',
          end: '2020-09-11T16:00:00',
          display: 'background'
        },
        {
          groupId: 'availableForMeeting',
          start: '2020-09-13T10:00:00',
          end: '2020-09-13T16:00:00',
          display: 'background'
        },

        // red areas where no events can be dropped
        {
          start: '2020-09-24',
          end: '2020-09-28',
          overlap: false,
          display: 'background',
          color: '#ff9f89'
        },
        {
          start: '2020-09-06',
          end: '2020-09-08',
          overlap: false,
          display: 'background',
          color: '#ff9f89'
        }
      ]
    });
    calendar.render();
	
	//getGuestbookList();
	//방명록 등록 버튼클릭 시 DB에 데이터 저장
	$("#btnGuestbook").on("click",function() {
		var guestbookContent = $("#comment-content").val()
		$.ajax({
		url:"regiseterGuestbook.kh",
		type:"post",
		data:{"guestbookContent":guestbookContent},
		success : function(data) {
			if(data == "success"){
				alert("방명록 등록 성공");
				getGuestbookList();
			} else {
				alert("방명록 등록 실패!");
			}
		},
		error : function() {
		
		}
	
		});
	});
	
	// function getGuestbookList() {
	// 	var memberDiary = '${guestbook.memberDiary}'
	// 	$.ajax({
	// 		url:"guestbookList.kh",
	// 		type:"get",
	// 		data:{"memberDiary" : memberDiary},
	// 		dataType : "json",
	// 		success : function(data) {
	// 			var $commentList = $("#comment-list");
	// 			$commentList.html("");
	// 			var $cardBody = $("<div class="card-body">");
	// 			var $row = $("<div class="row">");
	// 			var $col = $("<div class="col-md-2">");
	// 			var $userImg = $("<img src="#" class="img rounded-circle img-fluid user-img" style="width: 70px;"/>
  //       <a href="otherDiaryMain.kh?memberNo=${member.memberNo }"><p class="text-secondary text-center">김윤정</p></a>");


	// 		}
	// 	})	
	// };
});
  