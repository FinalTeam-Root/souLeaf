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
				
		 console.log(data);
		  
		  
		},
		error : function(){
		  console.log('fail');
		}
	
	  });
}