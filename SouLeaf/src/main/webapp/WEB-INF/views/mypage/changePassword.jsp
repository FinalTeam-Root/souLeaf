<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<label for="captcha" style="display: block">자동 로그인 방지</label>
	<div style="overflow: hidden">
		<div style="float: left">
			<img title="캡차이미지" src="/captchaImg.do" alt="캡차이미지" />
			<div id="ccaudio" style="display: none"></div>
		</div>
	</div>
	<div style="padding: 3px">
		<input id="reload" type="button" onclick="javaScript:getImage()"
			value="새로고침" /> <input id="soundOn" type="button"
			onclick="javaScript:audio()" value="음성듣기" />
	</div>
	<div style="padding: 3px">
		<input id="answer" type="text" value=""> <input id="check"
			type="button" value="확인" />
	</div>

</body>
</html>