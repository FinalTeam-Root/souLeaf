<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<link rel="stylesheet"
	href="resources/css/summernote/summernote-lite.css">

<head>
<meta charset="utf-8">

<title>souLeaf - 자랑하기</title>
<jsp:include page="../common/header.jsp"></jsp:include>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>

<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/summernote/summernote-lite.css">
<!--  -->

</head>
<body>
	<section class="hero-wrap hero-wrap-2"
		style="background-image: url('resources/images/main_bg_1.jpg');"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text align-items-end">
				<div class="col-md-9 ftco-animate pb-5">

					<h1 class="mb-0 bread">자랑하기</h1>
				</div>
			</div>
		</div>
	</section>


	<section class="ftco-section ftco-no-pt ftco-no-pb">

		<div class="container">
			<div class="row col-md-12 d-flex no-gutters"></div>
			<div class="col-md-12 pl-md-5 py-md-5">

				<div class="heading-section pt-md-5">
					<h2 class="mb-4" style="text-align: center;">내 반려식물 자랑하기 - 글
						수정</h2>
				</div>
				<form action="boastUpdate.kh" method="POST" enctype="multipart/form-data">
					<div class="container">

						<div class="row">

							<div class="row col-md-12" style="margin-bottom: 30px;">


								<h5 style="text-align: left;">제목</h5>


								<input type="text" id="" class="form-control" name="boastTitle"
									id="boastTitle" value="${boast.boastTitle }"
									}placeholder="제목을 입력하세요">


							</div>
							<hr>


							<div class="row col-md-12">


								<h5 style="text-align: left;">식물</h5>




								<input type="text" id="" class="form-control" name="plantNo"
									id="plantNo" value="${boast.plantNo }"
									placeholder="식물이름 입력하세요 (1~3)">

							</div>
							<hr>

							<div class="col-md-6 services-2 w-100 d-flex"></div>

						</div>
						<!-- Content here -->
					</div>
			</div>
		</div>
		

	
	<div class="container">
		<textarea id="summernote" name="boastContent">

    	${boast.boastContent }
  </textarea>
		<input type="file" class="form-control" size="50" name="uploadFile">


		<!--  게시물 등록 버튼!!!!!!!! -->
		<div align="center">
		<input type="hidden" name="page" value="${page }"> 
														<input type="hidden" name="count" value="${count }"> 
		<input type="hidden" name="boastNo" value="${boast.boastNo }">
			<input type="submit" class="btn btn-outline-success" value="등록">
			<!--  <input type="button" class="btn btn-outline-success" value="취소" onclick="location.href='boastListView.kh'"></button> -->
		</div>



		</form>
	</div>

</section>





	<jsp:include page="../common/footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
	<!-- 서머노트를 위해 추가해야할 부분 -->
	<script
		src="${pageContext.request.contextPath}/resources/summernote/summernote-lite.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/summernote/lang/summernote-ko-KR.js"></script>
	<script>
		$(function() {

			$('#summernote')
					.summernote(
							{
								placeholder : '여기에 내용 입력하세요~ 그림파일 용량은 2MB까지입니다~',
								tabsize : 2,
								height : 500, // 에디터 높이
								defaultFontName : '바탕체',
								toolbar : [
										[ 'style', [ 'style' ] ],
										[ 'fontname', [ 'fontname' ] ],
										[ 'fontsize', [ 'fontsize' ] ],
										[
												'font style',
												[ 'bold', 'italic',
														'underline',
														'strikethrough',
														'clear' ] ],
										[ 'color', [ 'forecolor', 'color' ] ],
										[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
										[ 'table', [ 'table' ] ],
										[ 'insert',
												[ 'link', 'picture', 'video' ] ],
										[
												'view',
												[ 'fullscreen', 'codeview',
														'help' ] ], ],
								defaultFontName : '바탕',
								fontNames : [ 'Arial', 'Comic Sans MS',
										'맑은 고딕', '궁서', '굴림', '돋음체', '바탕' ],
								fontSizes : [ '8', '9', '10', '11', '12', '14',
										'16', '18', '20', '22', '24', '28',
										'30', '36', '50', '72' ],
								maximumImageFileSize : 2097152,

								popover : {
									image : [
											[
													'image',
													[ 'resizeFull',
															'resizeHalf',
															'resizeQuarter',
															'resizeNone' ] ],
											[
													'float',
													[ 'floatLeft',
															'floatRight',
															'floatNone' ] ],
											[ 'remove', [ 'removeMedia' ] ] ],
									link : [ [ 'link',
											[ 'linkDialogShow', 'unlink' ] ] ],
									table : [
											[
													'add',
													[ 'addRowDown', 'addRowUp',
															'addColLeft',
															'addColRight' ] ],
											[
													'delete',
													[ 'deleteRow', 'deleteCol',
															'deleteTable' ] ], ],
									air : [
											[ 'color', [ 'color' ] ],
											[
													'font',
													[ 'bold', 'underline',
															'clear' ] ],
											[ 'para', [ 'ul', 'paragraph' ] ],
											[ 'table', [ 'table' ] ],
											[ 'insert', [ 'link', 'picture' ] ] ]
								}
							});
			$('.dropdown-toggle').dropdown()
		});
	</script>
</body>


</html>