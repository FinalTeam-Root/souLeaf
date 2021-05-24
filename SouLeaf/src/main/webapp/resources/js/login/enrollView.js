$(function(){ // code insert
	$(".classId").focusout(function() {
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
		$(".passwordCheck").keyup(function() {
			if($("#password").val() == $("#password1").val()){
			$("#passwordCheck").html("패스워드가 일치합니다");
			}else {
			$("#passwordCheck").html("패스워드가 일치하지 않습니다");
			}
		})
 });
	          
	       	
	        
	       
	     	
	
	        

