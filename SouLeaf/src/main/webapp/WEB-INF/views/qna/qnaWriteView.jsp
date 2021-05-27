<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Pet Sitting - Free Bootstrap 4 Template by Colorlib</title>
 	<jsp:include page="../common/header.jsp"></jsp:include> 
    <link rel="stylesheet" href="resources/css/member/member-style.css">
    <link rel="stylesheet" href="resources/css/summernote/summernote-lite.css">
  </head>
  <body>
 

<section class="ftco-section ftco-no-pt ftco-no-pb">
    	<div class="container">
    		<div class="row col-md-12 d-flex no-gutters">
    		
    			</div>
    			<div class="col-md-6 pl-md-5 py-md-5">
    				
    				<div class="heading-section pt-md-5">
	            <h2 class="mb-4">Q&A</h2>
	            <form action="qnaRegister.kh" method="POST" id="contactForm" name="contactForm" class="contactForm">
    				</div>
	    				  <div class="container">
	    				  
    				<div class="row">

                  <div class="row col-md-12">
                     <div class="col-md-3">
                     <h5 style="text-align:right;">제목</h5>
                     </div>
                     <div class="col-md-9">
                     <input type="text" id="qnaTitle" class="form-control" name="qnaTitle" placeholder="제목을 입력하세요">
                     </div>
                     <div class="col-md-3"></div>
                  </div>
                  <hr>
	    				  
                       
                  <hr>
	    			
	    			</div>
  <!-- Content here -->
</div>

	    				
	        </div>
        </div>
    	</div>
    	
    </section>
<div class="container">
  <textarea id="summernote" name="qnaContent">
<section class="ftco-section ftco-no-pt ftco-no-pb">
    	<div class="container">
    	
  </textarea>    
  
  
       
        <!--  게시물 등록 버튼!!!!!!!! -->
        <div align = "center">
        <input type="submit" class="btn btn-outline-success" value="등록">
          <input type="button"  class="btn btn-outline-success" onclick="location.href='qnaListView.kh'" value="취소">
        </div>
        </form>
</div>
 
 
 <!-- 모달!!!!!!!!!!! -->
 <div class="modal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
  

    
      <div class="modal-header">
        <h5 class="modal-title">자랑하기</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        
      </div>
      
      <div class="modal-body">
        <p>게시물을 등록하시겠습니까?</p>
      </div>
      <div class="modal-footer">
     
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-success">OK</button>
      </div>
    </div>
  </div>
</div>


 
 



    <jsp:include page="../common/footer.jsp"></jsp:include> 
    <script src="resources/js/member/main.js"></script>
    <script src="resources/js/summernote/summernote-lite.js"></script>
    
<script>
	
$('#summernote').summernote({
    placeholder: '여기에 내용 입력하세요~ 그림파일 용량은 2MB까지입니다~',
    tabsize: 2,
    height: 500, // 에디터 높이
    defaultFontName: '바탕체',
    toolbar: [
['style', ['style']],
['fontname', ['fontname']],
['fontsize', ['fontsize']],
['font style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
['color', ['forecolor','color']],
['para', ['ul', 'ol', 'paragraph']],
['table', ['table']],

['view', ['codeview', 'help']],
],
defaultFontName:'바탕',
fontNames: ['Arial', 'Comic Sans MS','맑은 고딕','궁서','굴림','돋음체','바탕'],
fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
maximumImageFileSize:2097152,

popover: {
              image: [
                ['image', ['resizeFull', 'resizeHalf', 'resizeQuarter', 'resizeNone']],
                ['float', ['floatLeft', 'floatRight', 'floatNone']],
                ['remove', ['removeMedia']]
              ],
              link: [
                ['link', ['linkDialogShow', 'unlink']]
              ],
              table: [
                ['add', ['addRowDown', 'addRowUp', 'addColLeft', 'addColRight']],
                ['delete', ['deleteRow', 'deleteCol', 'deleteTable']],
              ],
              air: [
                ['color', ['color']],
                ['font', ['bold', 'underline', 'clear']],
                ['para', ['ul', 'paragraph']],
                ['table', ['table']],
               
              ]
            }
  });
$('.dropdown-toggle').dropdown()
</script>
  </body>
</html>