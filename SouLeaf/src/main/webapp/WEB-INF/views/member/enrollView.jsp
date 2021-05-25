<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
  <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include> 
  
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="fonts/icomoon/style.css">
     <link rel="stylesheet" href="resources/css/login/registermember.css">

    <link rel="stylesheet" href="resources/css/login/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/login/bootstrap.min.css">
    
    <!-- Style -->

    <title>Sign Up #9</title>
  </head>
  <body>
  

  
  <div class="content">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-6 contents">
          <div class="row justify-content-center">
            <div class="col-md-12">
              <div class="form-block">
                  <div class="mb-4">
                  <h3>Sign Up</h3>
                  <p class="mb-4">Lorem ipsum dolor sit amet elit. Sapiente sit aut eos consectetur adipisicing.</p>
                </div>
                <form action="memberRegister.kh" method="post">
                  <div class="form-group first">
                    <label for="name">Name</label>
                    <input type="text" name="memberName" class="form-control" id="name">

                  </div>
                  <div class="form-group first">
                    <label for="id">Id</label>
                    <input type="text" name="memberId" class="form-control classId" id="id">

                  </div>
                  <div class="form-group">
                     <p id="checkId">
                  </div>
                  <div class="form-group first">
                    <label for="nickname">NickName</label>
                    <input type="text" name="memberNick" class="form-control" id="name">

                  </div>
                  <div class="form-group first">
                    <label for="email">Email</label>
                    <input type="text" name="memberMail" class="form-control" id="email">
					
				  
                  </div>
                  <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="memberPw" class="form-control passwordCheck" id="password">
                    
                  </div>
                  <div class="form-group last mb-4">
                    <label for="re-password">Re-type Password</label>
                    <input type="password" name="password1" class="form-control passwordCheck" id="password1">
                    
                  </div>
                  <div class="form-group">
                     <p id="passwordCheck">
                  </div>
                  <div class="d-flex mb-5 align-items-center">
                    <label class="control control--checkbox mb-3 mb-sm-0"><span class="caption">Agree our <a href="#">Terms and Conditions</a></span>
                    <input type="checkbox" checked="checked"/>
                    <div class="control__indicator"></div>
                  </label>
                    <span class="ml-auto"><a href="#" class="forgot-pass">Sign In</a></span> 
                  </div>

                  <input type="submit" value="가입하기" class="btn btn-pill text-white btn-block btn-primary">

                  
                
                </form>
              </div>
            </div>
          </div>
          
        </div>
        
      </div>
    </div>
  </div>

  
    <script src="resources/js/login/jquery-3.3.1.min.js"></script>
    <script src="resources/js/login/popper.min.js"></script>
    <script src="resources/js/login/bootstrap.min.js"></script>
    <script src="resources/js/login/enrollView.js"></script>
    <script src="resources/js/login/main.js"></script>
  </body>
</html>