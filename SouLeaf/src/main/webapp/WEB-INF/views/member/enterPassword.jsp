<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>>souLeaf - 비밀번호 확인</title>
<jsp:include page="../common/header.jsp"></jsp:include>
<style>
.top_line {
position: relative;
    top: -18px;
    background-color: #00bd56;
    width: 21%;
    height: 3px;
    }

.wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}

.account{
  color:#00bd56;
  font-size: 25px;
}
</style>
</head>
<body>
	<div class="container bootstrap snippet">
		<br>
		<br>
		<br>
		<br>
		<div class="row">
			<div class="col-sm-12">
				<h4>ENTER PASSWORD <span class="badge badge-secondary" style="background-color: #00bd56;">비밀번호 확인</span></h4>
				<hr>
				<div class="top_line">
				</div>
				<br>
				<br>
				<br>
				<br>
				<div class="account">
					<center><div class="main">계정 확인</div></center>
				</div>
				<br>
				<br>
				<div class="container">
					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-6">
							<form action="" method="">
								<div class="form-floating">
									<input type="password" class="form-control"
										id="floatingPassword" placeholder="Password">
									<div class="container">
										<div class="row">
											<div class="col-sm-8" style="color: red">비밀번호가 일치하지
												않습니다.</div>
											<div class="col-sm-4" style="text-align: right">
												<a href="#" class="alert-link">비밀번호 찾기</a>
											</div>
										</div>
									</div>
								</div>
								<button type="sumbit" class="btn btn-primary btn-block btn-success">확인</button>
							</form>
						</div>
						<div class="col-sm-3"></div>
					</div>
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
				<hr>
				<br>
				<br>
				<br>
				<br>
				<br>
		</div>
	</div>

<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>