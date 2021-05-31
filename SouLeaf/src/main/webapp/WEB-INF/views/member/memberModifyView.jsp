<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<html>
<head>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include> 
<meta charset="UTF-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<title>Insert title here</title>
</head>
<body>
<div id="fullscreen_bg" class="fullscreen_bg"/>
 <form class="form-signin" action="memberModify.kh" method="get">
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
        <div class="panel panel-default">
        <div class="panel panel-primary">
        
            <h3 class="text-center">
                        Update my information</h3>
        
        <div class="panel-body">   
        
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span>
                            </span>
                            <input type="text" class="form-control" placeholder="First Name" />
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <input type="text" class="form-control" placeholder="Nick" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
                            <input type="text" class="form-control" placeholder="Email" />
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input type="password" class="form-control" placeholder="New Password" />
                        </div>
                    </div>
                    
                    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                            <input type="text" class="form-control" placeholder="Age" />
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-credit-card"></span></span>
                            <input type="text" class="form-control" placeholder="Credit card" />
                        </div>
                    </div>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">
			Save
		</button>
                      
      
      </div>
       </div>
        </div>
    </div>
</div>
</form>


</div> 
<jsp:include page="../common/footer.jsp"></jsp:include> 
<script src="resources/js/member/main.js"></script>
</body>
</html>