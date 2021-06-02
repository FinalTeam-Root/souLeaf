$kind = 0, $property = 0;
$( document ).ready(function() {
open_chatroom();
	$( window ).resize(function() {
   		open_chatroom();
	});		

$("#plantSearch").on("change keyup",function(){
	var content = $("#plantSearch").val();
	   	$("#plantSearch").css('width',5.4*content.length+'vw');
		   if(content.length <= 0){
			$("#plantSearch").css('width','15.63vw');
		   }

	});

	///
	var typingBool = false; 
var typingIdx=0; 
var liIndex = 0;
var liLength = $(".typing-txt>ul>li").length;
var del = -1;
var repeatInt= null;
var tyInt = null;


// 타이핑될 텍스트를 가져온다 
var typingTxt = $(".typing-txt>ul>li").eq(liIndex).text(); 

typingTxt=typingTxt.split(""); // 한글자씩 자른다. 

if(typingBool==false){ 
  // 타이핑이 진행되지 않았다면 
    typingBool=true; 
    tyInt = setInterval(typing,200); // 첫번재 반복동작 
} 
     
function typing(){ 
  if(typingIdx<typingTxt.length){ 
    // 타이핑될 텍스트 길이만큼 반복 
   $(".typing").append(typingTxt[typingIdx]); 
    // 한글자씩 이어준다. 
     typingIdx++; 
    if(typingIdx == typingTxt.length){
      //첫번째 단어가 써지면 1분쉰다.
        clearInterval(tyInt);
         setTimeout(function(){
           tyInt = setInterval(typing,200);
         },1000);
       }
   } else{ 
     
     //한문장이끝나면
       if(-typingTxt.length-1 < del ){
         //한글자씩 지운다.
          $(".typing").html(typingTxt.slice(0, del))
          del--;
       }else{
         if(liIndex >= liLength-1){
              liIndex=0;
         }else{
           liIndex++;
         }
         
         //변수초기화 
         typingIdx=0;
         del= -1;
         typingTxt = $(".typing-txt>ul>li").eq(liIndex).text(); 
         
         //후 다음분장 타이핑 
         clearInterval(tyInt);
         setTimeout(function(){
           tyInt = setInterval(typing,200);
         },500);
       }
     

    } 
}  

$(".plant-search").hide();
	///
	$(".search-form").on("click" , function(){
		$(".typing").hide();
    $(".plant-search").show();
    $("#plantSearch").focus()
	});
  $(".typing").on("click", function(){
    $(".typing").hide();
    $(".plant-search").show();
    $("#plantSearch").focus();
  });
});



function open_chatroom(){
	var windowWidth = $( window ).width();
	
	if(windowWidth < 992) {
		$("#head-chat").text('');
		$("#head-leaf").text('');
		$("#head-mypage").text('');
		$("#head-logout").text('');
	} else {
		$("#head-chat").text(' 채팅');
		$("#head-leaf").text(' 성장일기');
		$("#head-mypage").text(' 마이페이지');
	$("#head-logout").text(' 로그아웃');
}
}

function kindSelect(value){
  $kind = value;
  console.log($.trim($("label[for='plant-kind"+value+"']").text()));
  var kindText = $.trim($("label[for='plant-kind"+value+"']").text());
  $("#plant-text").text(kindText);
  $("#plant-text").css('color','#00b564');
  $("#kind-form").hide();
  $("#property-form").show();
}

function propertySelect(value){  
  $property = value;
  $("#select-btn").show();  
}

function resetSelect(){
  $kind = 0;
  $property = 0;
  $("#plant-text").text('어떤 식물을');
  $("#plant-text").css('color','#000');
  $('.form-group').children('div').children().removeClass('active');
  $("#property-form").hide();
  $("#kind-form").show();
}

function plantSelect(){
  location.href = 'plantListView.kh?kind='+$kind+'&property='+$property;
}