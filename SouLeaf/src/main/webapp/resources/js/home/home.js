
$( document ).ready(function() {
	$( window ).resize(function() {
   		open_chatroom();
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

