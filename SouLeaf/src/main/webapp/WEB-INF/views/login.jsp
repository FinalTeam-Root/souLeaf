<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 로그인</title>
<style type="text/css">

body {
  font-family: 'Raleway', sans-serif;
  font-weight: 300;
  color:#fff;
  line-height:1.2;
  margin:0;
  background:linear-gradient(to bottom, rgba(0, 0, 0,0.6) 0%, rgba(0, 0, 0, 0.6) 100%), url(https://mariongrandvincent.github.io/HTML-Personal-website/img-codePen/tropical-login-form.jpg);
  background-repeat:repeat;
  background-size:cover;
  font-size: 18px;
}
.info {
  margin-bottom:50px;
}
.info p {
  text-align:center;
  color: #fff;
  text-transform:none;
  font-weight:500;
  font-size:17px;
  margin-top:2px
}

.info i {
  color:#F31131;
}
.clearfix {clear:both;}

textarea:focus, input:focus{
    outline: none;
}

h1 {
  text-align:center; 
  color: #fff;
  text-shadow: 1px 1px 0px #222;
  margin:50px 0px 0px 0px;
  font-size:32px;
  font-weight:500;
}
h2 {
  font-weight:300;
  font-size:27px;
  margin:0px;
  text-align:center;
  text-transform:uppercase;
  margin-top:50px;
  padding-bottom:15px;
}
a {
  text-decoration: inherit;
  color: inherit;
}

.container {
  width:560px;
  height:530px;
  margin:auto;
  display:block;
  background-color:rgba(0,0,0,0.5);
  border-radius:15px;
  padding:15px;
  margin-bottom:50px;
}
.login-form {
  position:relative;
  border:2px solid rgba(255,255,255,0.2);
  width:99%;
  height:99%;
  margin:auto;
  display:block;
  vertical-align:middle;
  border-radius:15px;
}
.login-form hr.to-right {
  width: 45%;
  position:absolute;
  right:30px;
  border: 0px none;
  height: 3px;
  background-image: linear-gradient(to left,transparent, #F9E206);
}
.login-form hr.to-left {
  width: 45%;
  position:absolute;
  left:30px;
  border: 0px none;
  height: 3px;
  background-image: linear-gradient(to right,transparent, #F9E206);
}

.container-login {
  width:60%;
  margin:auto;
  display:block;
  margin-top:30px;
}

label {
  width: 100%;
  display: inline-block;
  padding:0px 0px 5px 5px;
  margin-top: 20px;
  font-size:18px;
}
input {
  border: 0px none;
  width: 94%;
  border-radius: 4px;
  height: 25px;
  padding: 5px 3%;
  font-size:15px;
  font-family: inherit;
  color:#222;
}
button {
	width:100%;
	background-color:rgba(74,129,51,0.4);
	border:2px solid #6FC149;
	color:#fff;
	border-radius:5px;
	height:50px;
	text-transform:uppercase;
	font-size:19px;
	cursor:pointer;
	transition:all 0.3s;
}

.login-footer {
	margin-top:50px;
}
.login-footer a {
	font-size: 16px;
	margin:5px 0px;
	text-align:center;
	color:rgba(255,255,255,0.4);
	font-weight:400;
	line-height:1.4;
	display: block;
	transition:all 0.2s;
}
.login-footer a:hover {
	color:rgba(255,255,255,0.7);
}
.login-footer i {
	padding:0px 6px 0px 0px;
}

.check {
	padding: 20px 0px;
}
.check label {
    display:inline;
	margin-top:5px;
	position: relative;
	top: 5px;
}
.check p {
    display:inline;
	margin-left: 8px;
}
.checkbox {
    display: none;
}

.checkbox:checked + svg .path-moving {
    -webkit-transition: stroke .4s,stroke-dasharray .4s,stroke-dashoffset .4s cubic-bezier(.3,.8,.6,1.5);
    transition: stroke .4s,stroke-dasharray .4s,stroke-dashoffset .4s cubic-bezier(.3,.8,.6,1.5);
    stroke-dasharray: 25 90;
    stroke-dashoffset: 0;
}

.path-moving,
.path-back {
    fill: none;
    stroke: #64A546;
    stroke-width: 3px;
    stroke-linecap: round;
    stroke-linejoin: round;
}

.path-moving {
    -webkit-transition: stroke .4s,stroke-dasharray .4s,stroke-dashoffset .4s;
    transition: stroke .4s,stroke-dasharray .4s,stroke-dashoffset .4s;
    stroke: #ffffff;
    stroke-dasharray: 110;
    stroke-dashoffset: -32;
}

</style>
<body>
  <h1>로그인</h1>
  <div class="info"><a href="https://www.grandvincent-marion.fr" target="_blank"><p>  <i class="fa fa-heart"></i> Login </p></a></div>
   <div class="container">
      <form name="loginForm" class="loginForm" action="login.kh" method="POST">
	<div class="login-form">
		
		<h2>Welcome to souLeaf</h2>
		<hr class="to-right">
		<hr class="to-left">
		
			<div class="container-login">
		
				<label>아이디(ID)</label>
				<input type="text"  name="memberId" placeholder="아이디를 입력하세요"></input>
			
				<label>비밀번호(Password)</label>
				<input type="password" name="memberPw" placeholder="●●●●●●●●●●" ></input>	
				
				<div class="check">
						<label>				
							<input id="check" type="checkbox" class="checkbox">
								<svg xmlns="http://www.w3.org/2000/svg" width="26px" height="23px">
									<path class="path-back"  d="M1.5,6.021V2.451C1.5,2.009,1.646,1.5,2.3,1.5h18.4c0.442,0,0.8,0.358,0.8,0.801v18.398c0,0.442-0.357,0.801-0.8,0.801H2.3c-0.442,0-0.8-0.358-0.8-0.801V6"/>
									<path class="path-moving" d="M24.192,3.813L11.818,16.188L1.5,6.021V2.451C1.5,2.009,1.646,1.5,2.3,1.5h18.4c0.442,0,0.8,0.358,0.8,0.801v18.398c0,0.442-0.357,0.801-0.8,0.801H2.3c-0.442,0-0.8-0.358-0.8-0.801V6"/>
								</svg>
						</label>
						<p>로그인 유지</p>
					</div>
				
				<button>Login </button>
				
				<div class="login-footer">
					<a href=""><i class="fa fa-exclamation-circle"></i> 비밀번호 찾기  </a>
					<a href="enrollView.kh"><i class="fa fa-thumbs-up"></i> 회원가입   </a>
				</div>
				
			</div>
	
	</form>
	</div>
  </div> 
    

 
</head>
</body>
<%-- <jsp:include page="common/footer.jsp"></jsp:include> --%>
</html>