<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>souLeaf - 내 게시글 관리</title>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
	media="screen">
<link href='resources/css/diary/diaryMain.css' rel='stylesheet' />
</head>
<body>
	<div class="myPageBoard-content">
		<div class="tab-content tab-space">
			<div class="nav-tab-content">
				<ul class="nav nav-pills" role="tablist">
					<!--
						color-classes: "nav-pills-primary", "nav-pills-info", "nav-pills-success", "nav-pills-warning","nav-pills-danger"
					-->
					<li class="nav-item"><a class="nav-link active"
						href="#myPage-boast" role="tab" data-toggle="tab"> 식물자랑 </a></li>
					<li class="nav-item"><a class="nav-link "
						href="#myPage-clinic" role="tab" data-toggle="tab"> 식물클리닉 </a></li>
					<li class="nav-item"><a class="nav-link"
						href="#myPage-curiosity" role="tab" data-toggle="tab"> 궁금해요 </a></li>
				</ul>
			</div>

			<div class="col-md-12 tab-pane active" id="myPage-boast">
				<div>
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col"><input type="checkbox" name="del-select"
									value="selectAll"></th>
								<th scope="col">번호</th>
								<th scope="col">제목</th>
								<th scope="col">작성일</th>
								<th scope="col">조회수</th>
								<th scope="col"></th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td scope="col"><input type="checkbox" name="del-select"
									value="selectOne"></td>
								<td scope="row">1</td>
								<td>오늘의 자랑하기 : 민달래</td>
								<td>2021/05-21</td>
								<td>25</td>
								<td><button>수정</button></td>
								<td><button>삭제</button></td>
							</tr>
							<tr>
								<td scope="col"><input type="checkbox" name="del-select"
									value="selectOne"></td>
								<td scope="row">1</td>
								<td>오늘의 자랑하기 : 민달래</td>
								<td>2021/05-21</td>
								<td>25</td>
								<td><button>수정</button></td>
								<td><button>삭제</button></td>
							</tr>
							<tr>
								<td scope="col"><input type="checkbox" name="del-select"
									value="selectOne"></td>
								<td scope="row">1</td>
								<td>오늘의 자랑하기 : 민달래</td>
								<td>2021/05-21</td>
								<td>25</td>
								<td><button>수정</button></td>
								<td><button>삭제</button></td>
							</tr>
							<tr>
								<td><button>선택삭제</button></td>
								<td colspan="6"></td>
							</tr>
						</tbody>
					</table>

					<div class="row mt-5">
						<div class="col text-center">
							<div class="block-27">
								<ul id="curiosity-page">
									<li><a href="#">&lt;</a></li>
									<li class="active"><span>1</span></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#">&gt;</a></li>
								</ul>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6">
							<div id="selectSearch">
								<select name="searchKeyward" id="searchKeyward">
									<option value="searchAll">전체</option>
									<option value="searchTitle">제목</option>
									<option value="searchContent">내용</option>
								</select>
							</div>
							<div id="custom-search-input">
								<div class="input-group col-md-12">
									<input type="text" class="form-control input-lg"
										placeholder="검색어를 입력해주세요." /> <span class="input-group-btn">
										<button class="btn btn-info btn-lg" type="button">
											<i class="glyphicon glyphicon-search"></i>
										</button>
									</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="tab-pane" id="myPage-clinic">
				식물클리닉
			</div>

			<div class="tab-pane" id="myPage-curiosity">
				궁금해요
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	<script src="https://unpkg.com/@popperjs/core@2/dist/umd/popper.js"></script>
	<script src="https://unpkg.com/tippy.js@6"></script>
	<script src="resources/js/diary/diaryMain.js"></script>

</body>
</html>

