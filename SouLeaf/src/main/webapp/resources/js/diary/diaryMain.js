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
      defaultDate : Date, // 달력 초기화면에서 날짜 값 (오늘날짜 불러오기)
      navLinks: false, // can click day/week names to navigate views
      businessHours: true, // display business hours
      editable: true,
      selectable: true,
      locale: 'ko',
      fixedWeekCount : false,
      contentHeight: 600,
      // eventContent: {
      //   html : '<div><img src="https://img.icons8.com/ultraviolet/40/000000/water.png" class="event-icon"/>물주는 날</div>'
      // },
      eventRender:function(title,start,end,color,img){
        img.find("span.fc.title").prepend("<img src='https://img.icons8.com/ultraviolet/40/000000/water.png' class='event-icon'/>");
      },
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
          color : '#f06595'
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
        }
      ]
    });
    calendar.render();

    // 일기 등록 버튼 클릭 시 일기 등록
    $("#save-event").on("click", function() {
      var companionNick = $("#selectCompanion option:selected").val(); 
      var diaryTitle = $("#edit-title").val();
      var diaryStartDate = $("#edit-date").val();
      var diaryColor = $("input[name='color']:checked").val();
      var diaryPicname = $("#customFile").val();
      var diaryContent = $("#edit-desc").val();
      var diaryStartWater = $("#edit-startWater").val();
      // diaryStartWater.add(Calendar.DATE,+7);
      // diaryStartWater +7일 해주는 것은 어떻게 할까? 
      console.log(diaryStartWater);
      $.ajax({
        url :"addDiary.kh",
        type:"post",
        data: {"companionNick":companionNick,"diaryTitle" :diaryTitle,
      "diaryStartDate":diaryStartDate,"diaryColor":diaryColor,"diaryPicname":diaryPicname,"diaryContent":diaryContent,"diaryStartWater":diaryStartWater},
      success : function(data) {
        if(data == "success"){
          alert("다이어리 등록 성공");
        } else {
          alert("다이어리 등록 실패!");
        }
      }, error : function() {
        
      }
      })

    })

    //input을 datepicker로 선언
    $("#edit-date,#edit-startWater").datepicker({
      format: "yyyy-mm-dd",
      language : "kr"
    }).datepicker("setDate",new Date());
    // datepicker 오늘 날짜 초기값 설정
    // 하지만 달력 클릭시 오늘 날짜에 박스가 왜 안쳐질까?
  
    // 글자 수 세주는 카운팅 적용
    $('#comment-content').on('keyup',function() {
        getwordCount($(this), $('#wordCount1'));
    });

    $('#edit-desc').on('keyup',function() {
        getwordCount($(this), $("#wordCount3"));
    });
    // 카운팅 끝~!!!

    // 사진 첨부 시 이름이 안보여서 추가해주는 코드
    $("input[type='file']").on('change',function(event){
      $(this).next('.custom-file-label').html(event.target.files[0].name);
    });

    getGuestbookList();
    //방명록 등록 버튼클릭 시 DB에 데이터 저장
    $("#btnGuestbook").on("click",function() {
      var guestbookContent = $("#comment-content").val();
      var memberDiary = $("#memberDiary").val();
      $.ajax({
      url:"regiseterGuestbook.kh",
      type:"post",
      data:{"guestbookContent":guestbookContent,"memberDiary":memberDiary},
      success : function(data) {
        if(data == "success"){
          alert("방명록 등록 성공");
          $("#comment-content").val("");
          $("#wordCount1").text("(0/최대 200자 작성가능)");
          getGuestbookList();
        } else {
          alert("방명록 등록 실패!");
        }
      },
      error : function() {
      
      }
    
      });
	  });

});

// 글자수 카운팅 함수
function getwordCount(textarea, alertText){
  var content = textarea.val();
  alertText.html("("+content.length+"/최대 200자 작성가능)");

  if(content.length > 200) {
    alert("최대 200자까지 입력 가능합니다.");
    textarea.val(textarea.val().substring(0,200));
    alertText.html("(200/최대 200자 작성가능)");
  }
}
// this로 obj로 받아와서 제이쿼리 객체로 만든 다음에 객체탐색메소드를 이용해서 키업 적용
// 수정을 누를수있는 버튼이 많이 존재하기 때문에 특정 객체만 불러와준다.
function commentModify(obj) {
  $(obj).on("keyup", function() {
     var wordCount2 = $(obj).parent().next().find('#wordCount2');
     getwordCount($(obj),wordCount2);
  })
}
// 방명록 리스트를 불러오는 함수
function getGuestbookList() {
  var memberDiary = $('#memberDiary').val();
  $.ajax({
    url:"guestbookList.kh",
    type:"get",
    data:{"memberDiary" : memberDiary},
    dataType : "json",
    success : function(data) {
     console.log(data);
     var $cacommentList = $(".comment-list");
     $cacommentList.html("");
     if(data.length > 0) {
       for(var i in data){
         var $cardBody = $("<div class='card-body'>");
         var $row = $("<div class='row'>").append("<div class='col-md-2'><img src='https://img.icons8.com/pastel-glyph/64/000000/person-male--v3.png' class='img rounded-circle img-fluid user-img' style='width: 50px';'/></a><p class='text-secondary text-center'>"+data[i].memberNick+"</p></div>")
         .append("<div class='col-md-10'><div class='clearfix'><p>"+data[i].guestbookContent+"</p><span class='datetime'>"+data[i].guestbookDate+" </span><a href='#' onclick='modifyGuestbook(this,"+data[i].guestbookNo+",\""+data[i].guestbookContent+"\")'> 수정 </a> <a href='#' onclick='removeGuestbook("+data[i].guestbookNo+");return false'> 삭제</a></div></div>");
         $cardBody.append($row);
         $cacommentList.append($cardBody);
       }
       }
     }, error :function(){
       console.log("fail");
     }
  })	
};
// 방명록 수정 버튼 클릭시 수정창이 띄워주는 함수
function modifyGuestbook(obj,guestbookNo, modifyContent) {
  var $modifySection = $("<div class='modify-section'>");
  var $modifyForm = $("<div class='modifyform'>").append("<div class='comment-retext'><textarea id='comment-modify' onclick='commentModify(this);' rows='3'>"+ modifyContent +"</textarea></div>").append("<div class='comment-reEnroll'><span id='wordCount2'>(0/최대 200자 작성가능)</span><button type='button' class='btn btn-default btn-secondary' onclick='modifyGuestbookCommit("+guestbookNo+",\""+modifyContent+"\")'>수정</button></div>");
  $modifySection.append($modifyForm);
  $(obj).parent().parent().parent().parent().after($modifySection);
}

// 방명록 수정 commit 함수
function modifyGuestbookCommit(guestbookNo,modifyedContent) {
  var modifyedContent = $("#comment-modify").val();
  $.ajax({
    url :"modifyGuestbook.kh",
    type :"post",
    data : {"guestbookNo":guestbookNo,"guestbookContent":modifyedContent},
    success : function(data){
      if(data == "success"){
        alert("방명록이 수정되었습니다.");
        getGuestbookList();
      } else {
        alert("방명록 수정 실패");
      }
    }
  });
}

// 방명록 삭제함수
function removeGuestbook(guestbookNo) {
  $.ajax({
    url : "deleteGuestbook.kh",
    type : "get",
    data: {"guestbookNo" :guestbookNo},
    success : function(data){
      if(data == "success") {
        alert("방명록이 삭제되었습니다.");
        getGuestbookList();
      } else {
        alert("방명록 삭제 실패");
      }
    },
    error : function() {

    }
  });
}
  