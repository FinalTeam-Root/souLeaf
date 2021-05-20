$(function(){

$('#step1').css('background','#00bd56');
$('#ptext1').css('color','#00bd56');
$('#ptext1').css('font-weight','bold');
$('#pform2').hide();
$('#pform3').hide();
$('.file-upload').file_upload();
});

function fnMove(seq){
    var offset = $(".divup").offset();
    $('html, body').animate({scrollTop : offset.top}, 400);
    switch(seq){
    	case 1 : $('#step1').css('background','#00bd56');
			$('#ptext1').css('color','#00bd56');
			$('#ptext1').css('font-weight','bold');
	        $('#step2, #step3').css('background','#ddd');
			$('#ptext2, #ptext3').css('color','#b5b5b5');
			$('#ptext2, #ptext3').css('font-weight','500');
        	$('#pform2, #pform3').hide();
        	$('#pform1').show();
    	break;
        case 2 : $('#step1, #step3').css('background','#ddd');
			$('#ptext1, #ptext3').css('color','#b5b5b5');
			$('#ptext1, #ptext3').css('font-weight','500');
	        $('#step2').css('background','#00bd56');
			$('#ptext2').css('color','#00bd56');
			$('#ptext2').css('font-weight','bold');
        	$('#pform1, #pform3').hide();
        	$('#pform2').show();
    	break;
    	case 3 : $('#step2, #step1').css('background','#ddd');
			$('#ptext2, #ptext1').css('color','#b5b5b5');
			$('#ptext2, #ptext1').css('font-weight','500');
	        $('#step3').css('background','#00bd56');
			$('#ptext3').css('color','#00bd56');
			$('#ptext3').css('font-weight','bold');
        	$('#pform2, #pform1').hide();
        	$('#pform3').show();
    	break;
    }
}


