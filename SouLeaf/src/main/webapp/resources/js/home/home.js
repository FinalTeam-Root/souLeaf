
$( document ).ready(function() {
open_chatroom();
	$( window ).resize(function() {
   		open_chatroom();
	});		

$("#plantSearch").on("change keyup",function(){
	var content = $("#plantSearch").val();
	   	$("#plantSearch").css('width',100*content.length+'px');
		   if(content.length <= 0){
			$("#plantSearch").css('width','300px');
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
         
         //1분후 다음분장 타이핑 
         clearInterval(tyInt);
         setTimeout(function(){
           tyInt = setInterval(typing,200);
         },1000);
       }
     

    } 
}  


	///
	$("#plantSearch").on("focus" , function(){
		$(".typing").hide();
	});
  $(".typing").on("click", function(){
    $(".typing").hide();
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

