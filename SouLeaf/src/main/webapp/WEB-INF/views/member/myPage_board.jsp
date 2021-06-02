<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="resources/css/qna/qnalist.css">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>souLeaf - 내 게시글 관리</title>
	<link rel="icon" type="image/png" sizes="16x16" href="resources/images/favicon-16x16.png">
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src='resources/js/jquery-3.2.1.min.js'></script>
	<meta name="msapplication-TileColor" content="#ffffff">
	<meta name="theme-color" content="#ffffff">
</head>
<body>

	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col"> </th>
				<th scope="col">번호</th>
				<th scope="col">제목</th>
				<th scope="col">작성일</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
			</tr>
			<tr>
				<th scope="row">2</th>
				<td>Jacob</td>
				<td>Thornton</td>
				<td>@fat</td>
			</tr>
			<tr>
				<th scope="row">3</th>
				<td colspan="2">Larry the Bird</td>
				<td>@twitter</td>
			</tr>
		</tbody>
	</table>


	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>