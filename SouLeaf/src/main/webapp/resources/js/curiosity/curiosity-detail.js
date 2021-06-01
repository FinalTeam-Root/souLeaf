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
		 getReplyList($("#curiosityNo").val());
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

function replyRegister(curiosityNo){	
	var content = $("#replyContent").val();
	$.ajax({
		url : "curiosityReplyRegister.kh",
		type:"post",
		data : {"curiosityNo":curiosityNo,"curicommentContent":content},		
		success : function(data){
						 
		if(data == 1){
			getReplyList(curiosityNo);
			$("#replyContent").val("");
		}
		  
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
}

function replyModifyView(obj,curiosityNo,memberNo,replyNo,content){	
    $textarea = '<div class="row" style="position: relative;"><input type="text" style="width: 80%; margin-left:11%; height: 32px !important;" class="form-control" id="replyReContent" value="'+content+'"><button class="mt-4 p-2 btn btn-secondary reply-btn" style="right:5%;" onclick="replyUpdate('+curiosityNo+','+memberNo+','+replyNo+')">수정</button></div>';
	$(".curiosity-btn").hide();
  $(obj).hide();  
  $(obj).parent().parent().parent().after($textarea);
}

function replyUpdate(curiosityNo,memberNo,replyNo){	
	var content = $("#replyReContent").val();
	$.ajax({
		url : "curiosityReplyModify.kh",
		type:"post",
		data : {"curiosityNo":curiosityNo,"memberNo":memberNo,"curicommentNo":replyNo,"curicommentContent":content},		
		success : function(data){
						 
		if(data == 1){
			getReplyList(curiosityNo);
			$("#replyContent").val("");
		}
		  
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
	
}

function getReplyList(curiosityNo){	
	var loginNo = $("#loginNo").val();
	$.ajax({
		url : "curiosityReplyList.kh",
		type:"get",
		data : {"curiosityNo":curiosityNo},	
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
			str+='<span>'+data[i].curicommentContent+'</span><br>';
            if(loginNo == data[i].memberNo){
				str+='<small>'+data[i].curicommentDate+' <span onclick="replyModifyView(this,'+data[i].curiosityNo+','+data[i].memberNo+','+data[i].curicommentNo+',\''+data[i].curicommentContent+'\')" class="text-success curiosity-btn">수정</span> <span class="text-danger curiosity-btn">삭제</span></small><br>';

			}else{
				str+='<small>'+data[i].curicommentDate+'</small><br>';
			}

			str+='</div>';
			str+='</div>';
		 }
		
		  $("#curiosity-comment").html(str);
		}
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
}