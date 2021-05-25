document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
	
    var calendar = new FullCalendar.Calendar(calendarEl, {
      // 이미 등록된 일정 클릭 시 모달창
      // {
      //   title: 'testmessage',
      //   start: '2020-09-22',
      //   end: '2020-09-22',
      //   color : '#f06595'
      //   constraint: 'availableForMeeting', // defined below
      // },

      eventClick: function(info) {

        $('#eventModal-modify').modal("show");

        // diaryNo 받아와서 담아주기
        var diaryNo = info.event.extendedProps.diaryNo;
        $('#diaryUniqNo').val(diaryNo);
        // LastWaterday 받아와서 담아주기
        var companionLastwater = info.event.extendedProps.companionLastwater;
        console.log(companionLastwater);
        // 반려식물 애칭 받아와서 담아주기
        var companionNick = info.event.extendedProps.companionNick;

        -$('#eventModalmodify .modal-body #selectCompanion').append("<option value='1'>"+companionNick+"</option>");
        $('#eventModal-modify .modal-body #selectCompanion').html("");
        $('#eventModal-modify .modal-body #modify-edit-title').val(info.event.title);
        var todayDate = getFormatDate(info.event.start);
        $('#eventModal-modify .modal-body #modify-edit-date').val(todayDate);
        $('#eventModal-modify .modal-body #edit-desc2').val(info.event.constraint);
        $("#eventModal-modify .modal-body input:radio[name='color']:input[value='"+info.event.backgroundColor+"']").attr('checked',true);
        $('#eventModal-modify .modal-body #modify-edit-lastWater').val(companionLastwater);

      },  
      // toolbar에 일기쓰기 버튼
      customButtons: {
        myCustomButton: {
          text: '일기쓰기',
          click: function(e) {
            e.preventDefault();
            $('#eventModal-insert').modal({

            });
          }
        }
    
      },
      headerToolbar: {
        left: 'today',
        center: 'prev,title,next',
        right: 'myCustomButton'
      },
      //defaultDate : Date, // 달력 초기화면에서 날짜 값 (오늘날짜 불러오기)
      navLinks: false, // can click day/week names to navigate views
      businessHours: true, // display business hours
      editable: true,
      selectable: true,
      locale: 'ko',
      fixedWeekCount : false,
      contentHeight: 750,
      dayMaxEventRows: true, // for all non-TimeGrid views
      // eventContent: {
      //   html : '<div><img src="https://img.icons8.com/ultraviolet/40/000000/water.png" class="event-icon"/>물주는 날</div>'
      // },
      // eventRender:function(title,start,end,color,img){
      //   img.find("span.fc.title").prepend("<img src='https://img.icons8.com/ultraviolet/40/000000/water.png' class='event-icon'/>");
      // },

      // 일정 받아오는 함수 
      events: function(info, successCallback, failureCallback){
        var memberNo = $("#memberNo").val();
        $.ajax({
          url : "diaryList.kh",
          type : "get",
          dataType : "json",
          data : {
            "memberNo" : memberNo
          },
          success : function(response) {
            successCallback(response);
          }
        });
      }
    });
    calendar.render();

    //input을 datepicker로 선언
    $("#edit-date,#edit-lastWater,#modify-edit-date,#modify-edit-lasttWater").datepicker({
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

  // 일기 삭제 버튼 클릭
  $("#deleteEvent").on("click",function() {
    var diaryNo = $('#diaryUniqNo').val();
    $.ajax({
      url : "diaryDelete.kh",
      type : "get",
      data : {"diaryNo": diaryNo, "diaryRepicname":diaryRepicname},
      success : function(data) {
        if(data == "success") {
          alert("일기가 삭제되었습니다.");
          // 삭제 후 달력리스트 불러오기
          $('#eventModal-modify').modal("hide");
        } else {
          alert("일기 삭제 실패!!");
        }
      },
      error : function() {

      }
    })
  });
  // 일기 수정하기 코드
  $("#updateEvent").on("click",function() {
    // var companionNick = $("#selectCompanion option:selected").val(); 
    var diaryTitle = $("#modify-edit-title").val();
    var diaryStartDate = $("#modify-edit-date").val();
    var diaryColor = $("input[name='color']:checked").val();
    var diaryPicname = $("#modify-customFile").val();
    var diaryContent = $("#edit-desc2").val();
    var diaryStartWater = $("#modify-edit-startWater").val();
    console.log(diaryTitle,diaryStartDate,diaryColor,diaryPicname,diaryContent,diaryStartWater);
    $.ajax({
      url : "diaryUpdate.kh",
      type : "post",
      enctype: 'multipart/form-data',
      processData: false,    
      contentType: false,
      data : {"diaryTitle":diaryTitle,"diaryStartDate":diaryStartDate,"diaryColor":diaryColor,"diaryPicname":diaryPicname,"diaryContent":diaryContent,"diaryStartWater":diaryStartWater},
      success :function(data) {
        if(data == "success") {
            alert("일기 수정 완료");
            // 일기 수정 후 모달창 닫아주기
            $('#eventModal-modify').modal("hide");
            // 수정 후 내용 초기화
            diaryStartDate = data; // 날짜는 오늘날짜로 돌아오게 해주자!
            $("input[name='color']:radio[value='#D25565']").attr('checked',true);
            diaryTitle = "";
            diaryContent = "";
          } else {
            alert("일기 수정 실패");
          }
        },
        error : function() {

        }
    });
  });
  // 사진첩 리스트 부분
  $(".fancybox").fancybox({
    openEffect: "none",
    closeEffect: "none",
  });

  $(".zoom").hover(function(){

    $(this).addClass('transition');
    }, function(){
        
    $(this).removeClass('transition');
  });
  // document 끝
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

function diaryModify(obj) {
  $(obj).on("keyup", function() {
    var editdesc2 = $(obj).parent().find('#wordCount4');
    getwordCount($(obj),editdesc2);
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
  });
  
};
// 방명록 수정 버튼 클릭시 수정창을 띄워주는 함수
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
  
// 사진첩 리스트 띄우기
function getDiaryPicList(){
  var memberNo = '${diary.memberNo}'
  $.ajax({
    url : "diaryPicList.kh",
    type : "get",
    data : {"memberNo": memberNo},
    dataType : "json",
    success : function(data){
      var $carouselInner = $('.carousel-inner');
      $carouselInner.html("");
      var $carouselItem;
      var $row;
      var $thumb;
      if(data.length > 0){
        for(var i in data){
          $carouselItemActive = $("<div class='carousel-item active'>");
          $carouselItem = $("<div class='carousel-item'>");
          $row = $("<div class='row'>");
          $thumb = $("<div class='col-lg-3 col-md-4 col-xs-6 thumb'>").append("<a href='resources/uploadFiles/diary/"+data[i].diaryRepicname+"' class='fancybox' rel='ligthbox'><img  src='resources/uploadFiles/diary/"+data[i].diaryRepicname+"' class='zoom img-fluid '  alt=''></a>");
        }
      }
 
    }
  })
}

/**
 *  yyyyMMdd 포맷으로 반환
 */
 function getFormatDate(date){
  var year = date.getFullYear();              //yyyy
  var month = (1 + date.getMonth());          //M
  month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
  var day = date.getDate();                   //d
  day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
  return  year + '-' + month + '-' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
}