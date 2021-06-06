




$(function(){ // code insert
	$(".classId").keyup(function() {
		 $.ajax({
		        url :"/idCheck.kh",
		        type:"post",
		        data: {"memberId": $("#id").val()},
		     	success : function(data) {
		          
			        if(data != 0){
			        	$("#checkId").html("중복된 아이디 입니다");
			        }else {
			           $("#checkId").html("사용 가능한 아이디 입니다");
			        }
	
		      	}  
	
			  
		 });
		  		  
	});

		$("#password").on("keyup",function(){
			passwordCheck();
		  });
		$("#signbtn").on("click",function(){
			//var test = alert("정보수정이 완료되었습니다.");
			if($('#id').val() == null || $('#id').val() == '' || $('#id').val() == undefined){
				alert('아이디는 필수 입력 항목입니다.');
				return;
			}
			if($('#nick').val() == null || $('#nick').val() == '' || $('#nick').val() == undefined){
				alert('닉네임은 필수 입력 항목입니다.');
				return;
			}
			if($('#isEmailAuthSuccess').val() != 'success'){
				alert('이메일 인증을 진행해주셔야 회원가입이 완료됩니다.');
				return;
			}
			
		});

		$('#emailAuthenticate').on("click", function(){
		
			$.ajax({
		        url :"emailAuthCheck.kh",
		        type:"post",
		        data: {"memberMail": $("#email").val()},
		     	success : function(data) {
					var date = new Date();
					date.setTime(date.getTime() + 3*60*1000); // 3분 뒤 만료.
					//$.cookie('authKeyValue', data, { expires: date });
					document.cookie = "authKeyValue" + "=" + data + "; path=/; expires=" + date.toGMTString() + ";";
					window.open('http://localhost:8888/emailAuthenticateView.kh', '이메일인증창', 'width=700px,height=800px,scrollbars=yes');
		      	}  
			  
		 	});
		
		});

		$(".passwordCheck").keyup(function() {
			if($("#password").val() == $("#password1").val()){
			$("#passwordCheck").html("패스워드가 일치합니다");
			}else {
			$("#passwordCheck").html("패스워드가 일치하지 않습니다");
			}
						
		});

		function passwordCheck(){

		var pw = $("#password").val();
		var num = pw.search(/[0-9]/g);
		var eng = pw.search(/[a-z]/ig);
		var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
		var msg = $("#pwMsg");
		if(pw.length < 8 || pw.length > 20){

			msg.text("8자리 ~ 20자리 이내로 입력해주세요.");
			
		}else if(pw.search(/\s/) != -1){
			msg.text("비밀번호는 공백 없이 입력해주세요.");
			
		}else if(num < 0 || eng < 0 || spe < 0 ){
			msg.text("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
			
		}else {
			console.log("통과"); 
			msg.text("");
		}

	}    
	
		$(".classId").keyup(function() {
		 $.ajax({
				url :"/idCheck.kh",
				type:"post",
				data: {"memberId": $("#id").val()},
			  success : function(data) {
				  
				   if(data != 0){
					$("#checkId").html("중복된 아이디 입니다");
				  }else {
				   $("#checkId").html("사용 가능한 아이디 입니다");
				   }
			  }  
	
			  
			  });
			  
			});
		
				$(".classNick").keyup(function() {
				 $.ajax({
						url :"/nickCheck.kh",
						type:"post",
						data: {"memberNick": $("#nick").val()},
					  success : function(data) {
						  
						   if(data != 0){
							$("#checkNick").html("중복된 닉네임 입니다");
						  }else {
						   $("#checkNick").html("사용 가능한 닉네임 입니다");
						   }
					  }  
			
					  
					  });
								
					});
				});
				
 
	       	
	        
	       
	     	
	
				
		
