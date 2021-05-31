<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<meta charset="UTF-8">
<!------ Include the above in your HEAD tag ---------->
<title>Insert title here</title>
</head>
<body>
	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">회원 정보 수정</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-12">
					<div class="wrapper">
						<div class="row no-gutters">
							<div class="col-md-12">
								<div class="contact-wrap w-100 p-md-5 p-4">
									<form action="memberModify.kh" method="post" id="contactForm"
										name="contactForm" class="contactForm">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label class="label" for="memberId">아이디</label> <input
														type="text" class="form-control" name="memberId"
														id="=memberId" placeholder="MemberId"
														value="${mOne.memberId }" readonly>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="label" for="memberName">이름</label> <input
														type="text" class="form-control" name="memberName"
														id="memberName" placeholder="memberName"
														value="${mOne.memberName }" readonly>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="label" for="memberNick">닉네임</label> <input
														type="text" class="form-control" name="memberNick"
														id="memberNick" placeholder="memberNick"
														value="${mOne.memberNick }">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="label" for="memberMail">이메일</label> <input
														type="text" class="form-control" name="memberMail"
														id="memberMail" placeholder="memberMail"
														value="${mOne.memberMail }">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="label" for="password">비밀번호</label> <input
														type="password" class="form-control passwordCheck" name="memberPw"
														id=password placeholder="새 비밀번호">
														<span id="pwMsg"></span>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="label" for="re-password">비밀번호 확인</label> <input
														type="password" class="form-control passwordCheck" name="password1"
														id="password1" placeholder="비밀번호 확인">
												</div>
											</div>
												<div class="form-group">
													<p id="passwordCheck">
												</div>
											<div class="col-md-12">
												<div class="form-group">
													<input type="submit" value="수정 완료" class="btn btn-primary">
													<div class="submitting"></div>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script src="resources/js/login/memberModifyView.js"></script>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>