$(function(){
//여기 아래 부분
	$('#summernote').summernote({
		placeholder: '최대 500자 작성 가능합니다.',
		        height: 300,
		        lang: 'ko-KR',
		        callbacks: {
		        	onImageUpload: function(files, editor, welEditable) {
		        		for(var i = files.length -1; i>=0; i--) {
		        			sendFile(files[i], this);
		        		}
		        	}
		        }
		 });
		 getReplyList($("#clinicNo").val());
});

/**
	* 이미지 파일 업로드
	*/
	function sendFile(file, el) {
		var form_data = new FormData();
		form_data.append('file', file);
		$.ajax({
			data: form_data,
			type : "post",
			url: 'clinic_image.kh',
			cache :false,
			contentType : false,
			enctype : 'multipart/form-data',
			processData : false,
			success : function(img_name) {
				$(el).summernote('editor.insertImage', img_name);
			}
		});
	}

function readURL(input) {
  if (input.files && input.files[0]) {

    var reader = new FileReader();

    reader.onload = function(e) {
      $('.image-upload-wrap').hide();

      $('.file-upload-image').attr('src', e.target.result);
      $('.file-upload-content').show();

      $('.image-title').html(input.files[0].name);
    };

    reader.readAsDataURL(input.files[0]);

  } else {
    removeUpload();
  }
}

function removeUpload() {
  $('.file-upload-input').replaceWith($('.file-upload-input').clone());
  $('.file-upload-content').hide();
  $('.image-upload-wrap').show();
}
$('.image-upload-wrap').bind('dragover', function () {
        $('.image-upload-wrap').addClass('image-dropping');
    });
    $('.image-upload-wrap').bind('dragleave', function () {
        $('.image-upload-wrap').removeClass('image-dropping');
});

function replyRegister(clinicNo){	
	var content = $("#replyContent").val();
	$.ajax({
		url : "clinicReplyRegister.kh",
		type:"post",
		data : {"clinicNo":clinicNo,"cliniccommentContent":content},		
		success : function(data){
						 
		if(data == 1){
			getReplyList(clinicNo);
			$("#replyContent").val("");
		}
		  
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
}

function replyModifyView(obj,clinicNo,memberNo,replyNo,content){	
    $textarea = '<div class="row" style="position: relative;"><input type="text" style="width: 80%; margin-left:10%; height: 32px !important;" class="form-control" id="replyReContent" value="'+content+'"><button class="mt-4 p-2 btn btn-secondary reply-btn" style="right:6%;" onclick="replyUpdate('+clinicNo+','+memberNo+','+replyNo+')">수정</button><button class="mt-4 p-2 btn btn-secondary reply-btn" style="right:1%;">취소</button></div>';
	$(".clinic-btn").hide();
  $(obj).hide();  
  $(obj).parent().parent().parent().after($textarea);
}

function replyUpdate(clinicNo,memberNo,replyNo){	
	var content = $("#replyReContent").val();
	$.ajax({
		url : "clinicReplyModify.kh",
		type:"post",
		data : {"clinicNo":clinicNo,"memberNo":memberNo,"cliniccommentNo":replyNo,"cliniccommentContent":content},		
		success : function(data){
						 
		if(data == 1){
			getReplyList(clinicNo);
			$("#replyContent").val("");
		}
		  
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
	
}

function getReplyList(clinicNo){	
	var loginNo = $("#loginNo").val();
	$.ajax({
		url : "clinicReplyList.kh",
		type:"get",
		data : {"clinicNo":clinicNo},	
		dataType:"json",	
		success : function(data){
				
			var str = "";
			if(data.length > 0){
				$("#comment-count").text(data.length);
				$("#replyCount").text(data.length);
		
		 for(var i in data){
			str+='<div class="media p-3">';
			str+='<img src="resources/images/gallery-3.jpg" alt="John Doe" class="mr-3 mt-2 rounded-circle" style="width:60px; height: 60px">';
			str+='<div class="media-body">';
			str+='<strong>'+data[i].memberNick+'</strong><br>';
			str+='<span>'+data[i].cliniccommentContent+'</span><br>';
            if(loginNo == data[i].memberNo){
				str+='<small>'+data[i].cliniccommentDate+' <span onclick="replyModifyView(this,'+data[i].clinicNo+','+data[i].memberNo+','+data[i].cliniccommentNo+',\''+data[i].cliniccommentContent+'\')" class="text-success clinic-btn">수정</span> <span class="text-danger clinic-btn">삭제</span></small><br>';

			}else{
				str+='<small>'+data[i].cliniccommentDate+'</small><br>';
			}

			str+='</div>';
			str+='</div>';
		 }
		
		  $("#clinic-comment").html(str);
		}
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
}


 
var btn_like = document.getElementById("btn_like");
 btn_like.onclick = function(){ changeHeart(); }
 
/* 좋아요 버튼 눌렀을떄 */
 function changeHeart(){
 	var memberNo = $("#loginNo").val();
	var clinicNo = $("#clinicNo").val();
	const resultElement = document.getElementById('likepoint');
	let number = resultElement.innerText;
	console.log(number);
     $.ajax({
            type : "POST",  
            url : "clickLike.kh",       
            dataType : "json",   
            data : {"clinicNo":clinicNo,"memberNo":memberNo},
            success : function(jdata) {
                if(jdata == -1){
                    Rnd.alert("좋아요 오류","error","확인",function(){});
                }
                else{
                    if(jdata == 1){
						$("#btn_like").removeClass("far fa-heart");
                        $("#btn_like").addClass("fa fa-heart");
                        number = parseInt(number) + 1;
                        $("#likecnt").empty();
                    }
                    else if (jdata == 0){
						$("#btn_like").removeClass("fa fa-heart");
                        $("#btn_like").addClass("far fa-heart");
                        number = parseInt(number) - 1;
                        $("#likecnt").empty();
                    }
                    resultElement.innerText = number;
                }
            }
        });
 }