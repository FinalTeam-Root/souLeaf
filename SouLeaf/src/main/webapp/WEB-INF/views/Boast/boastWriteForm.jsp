<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <title>souLeaf - 자랑하기 </title>
  <meta charset="utf-8">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
  <!-- 서머노트를 위해 추가해야할 부분 -->
  <script src="${pageContext.request.contextPath}/resources/summernote/summernote-lite.js"></script>
  <script src="${pageContext.request.contextPath}/resources/summernote/lang/summernote-ko-KR.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/summernote/summernote-lite.css">
  <!--  -->
  
</head>
<body>
  
<section class="ftco-section ftco-no-pt ftco-no-pb">
    	<div class="container">
    		<div class="row col-md-12 d-flex no-gutters">
    		
    			</div>
    			<div class="col-md-6 pl-md-5 py-md-5">
    				
    				<div class="heading-section pt-md-5">
	            <h2 class="mb-4">내 반려식물 자랑하기</h2>
    				</div>
	    				  <div class="container">
	    				  
    				<div class="row">

                  <div class="row col-md-12">
                     <div class="col-md-3">
                     <h5 style="text-align:right;">제목</h5>
                     </div>
                     <div class="col-md-9">
                     <input type="text" id="" class="form-control" name="" placeholder="제목을 입력하세요">
                     </div>
                     <div class="col-md-3"></div>
                  </div>
                  <hr>
	    				  
                       
                  <div class="row col-md-12">
                     <div class="col-md-3">
                     <h5 style="text-align:right;">식물이름 </h5>
                     </div>
                     
                     
                     <div class="col-md-9">
                     <input type="text" id="" class="form-control" name="" placeholder="식물이름 입력하세요">
                     </div>
                     <div class="col-md-3"></div>
                  </div>
                  <hr>
	    				
	    				<div class="col-md-6 services-2 w-100 d-flex">
	    					<div class="icon d-flex align-items-center justify-content-center"><span class="flaticon-emergency-call"></span></div>
	    					
	    				</div>
	    			
	    			</div>
  <!-- Content here -->
</div>

	    				
	        </div>
        </div>
    	</div>
    	
    </section>
<div class="container">
  <textarea id="summernote" name="content">
<section class="ftco-section ftco-no-pt ftco-no-pb">
    	<div class="container">
    	
  </textarea>    
  
  
       
        <!--  게시물 등록 버튼!!!!!!!! -->
        <div align = "center">
        <button class="btn btn-outline-success" onclick="location.href='boastListView.kh'">등록</button>
          <button class="btn btn-outline-success" onclick="location.href='boastListView.kh'">취소</button>
        </div>
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
['insert', ['link', 'picture', 'video']],
['view', ['fullscreen', 'codeview', 'help']],
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
                ['insert', ['link', 'picture']]
              ]
            }
  });
$('.dropdown-toggle').dropdown()
</script>

 
</body>
 

</html>