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
		 getReplyList($("#boastNo").val());
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
			url: 'summer_image.kh',
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

function replyRegister(boastNo){	
	var content = $("#replyContent").val();
	$.ajax({
		url : "boastReplyRegister.kh",
		type:"post",
		data : {"boastNo":boastNo,"bocommentContent":content},		
		success : function(data){
						 
		if(data == 1){
			getReplyList(boastNo);
			$("#replyContent").val("");
		}
		  
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
}

function replyModifyView(obj,boastNo,memberNo,replyNo,content){	
    $textarea = '<div class="row" style="position: relative;"><input type="text" style="width: 80%; margin-left:10%; height: 32px !important;" class="form-control" id="replyReContent" value="'+content+'"><button class="mt-4 p-2 btn btn-secondary reply-btn" style="right:6%;" onclick="replyUpdate('+boastNo+','+memberNo+','+replyNo+')">수정</button></div>';
	$(".boast-btn").hide();
  $(obj).hide();  
  $(obj).parent().parent().parent().after($textarea);
}

function replyUpdate(boastNo,memberNo,replyNo){	
	var content = $("#replyReContent").val();
	$.ajax({
		url : "boastReplyModify.kh",
		type:"post",
		data : {"boastNo":boastNo,"memberNo":memberNo,"bocommentNo":replyNo,"bocommentContent":content},		
		success : function(data){
						 
		if(data == 1){
			getReplyList(boastNo);
			$("#replyContent").val("");
		}
		  
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
	
}

function getReplyList(boastNo){	
	var loginNo = $("#loginNo").val();
	$.ajax({
		url : "boastReplyList.kh",
		type:"get",
		data : {"boastNo":boastNo},	
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
			str+='<strong>'+data[i].memberName+'</strong><br>';
			str+='<span>'+data[i].bocommentContent+'</span><br>';
            if(loginNo == data[i].memberNo){
				str+='<small>'+data[i].bocommentDate+' <span onclick="replyModifyView(this,'+data[i].boastNo+','+data[i].memberNo+','+data[i].bocommentNo+',\''+data[i].bocommentContent+'\')" class="text-success curiosity-btn">수정</span> <span class="text-danger boast-btn">삭제</span></small><br>';

			}else{
				str+='<small>'+data[i].bocommentDate+'</small><br>';
			}

			str+='</div>';
			str+='</div>';
		 }
		
		  $("#boast-comment").html(str);
		}
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
}