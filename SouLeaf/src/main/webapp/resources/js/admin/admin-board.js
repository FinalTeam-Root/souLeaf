$(function(){
	
	getBoastList();
	getCuriosityList();
	$("#boast-delete").on("click", function(){
		deleteBoast();
	});
		

$("#check_all1").on("click", function(){
	var checked = $(this).is(":checked");
	if(checked){
		$(".checkbox_group1").prop("checked",true);
	}else{
		$(".checkbox_group1").prop("checked",false);
	}
});
$("#check_all2").on("click", function(){
	var checked = $(this).is(":checked");
	if(checked){
		$(".checkbox_group2").prop("checked",true);
	}else{
		$(".checkbox_group2").prop("checked",false);
	}
});

$("form").on("submit", function() {
	if($('.checkbox_group').is(":checked") == false){
		 alert('체크된 값이 없습니다.');
		return false;
	}else{
			 if (!confirm("정말 삭제하시겠습니까?")) {
		// 취소(아니오) 버튼 클릭 시 이벤트
			return false;
		} else {
			// 확인(예) 버튼 클릭 시 이벤트
		}
	}
});

});

function deleteBoast(){
	if($('.checkbox_group').is(":checked") == false){
		alert('체크된 값이 없습니다.');
	   return false;
   }else{
			if (!confirm("정말 삭제하시겠습니까?")) {
	   // 취소(아니오) 버튼 클릭 시 이벤트
		   return false;
	   } else {
		var checkVal = '';
		$("input:checkbox[name='boast-check']:checked").each(function(index){
			if(index != 0){
				checkVal += ',';
			}
			checkVal += $(this).val();
			
		});
		
		$.ajax({

			url: "adminBoastDelete.kh",
			type:"get",
			data:{"checkNo":checkVal},
			success: function(result){
				console.log(result);
				if(result > 0){
					getBoastList();
				}
			},
			error: function(){
				console.log('fail');
			}
		});

	   }
   }
	
}

function getBoastList(){
	let dataTable1 = $('#dataTable1').DataTable({
		destroy: true,
		"bLengthChange": false,
		"bInfo": false,		
		  order: [[4, 'desc']],
		  language: {
			paginate: {
				previous: '<span class="icon md-chevron-left"><</span>',
				next: '<span class="icon md-chevron-left">></span>'
			}
		},
			ajax:{
				url:"adminBoastList.kh",
				type:"get",
				dataType:"json",
				"dataSrc": function ( json ) {							
					$("#boast-count").text(json.data.length);
					return json.data;
				}    
			},
			columns:[
				{ orderable: false,
					data: "boastNo",
					className : "boast-check",
				render: function(data){					
					return '<input type="checkbox" class="checkbox_group1" name="boast-check" value="'+data+'">';
				}
			 },
				{  orderable: false,
					data: "boastReName" ,
				 "defaultContent": "<i>Not set</i>",
				 className : "boast-img",
				 render: function(data){
					 var img = '';
					 if(data == null){
							img = '<img src="resources/uploadFiles/boast/defaultplant.png">';
					 }else{
						 img = '<img src="resources/uploadFiles/boast/'+data+'">';
					 }
					 return img;

				 }
			    },
				{ data: "boastTitle",
				render: function(data, target, row){					
					return '<a href="boastDetail.kh?boastNo='+row.boastNo+'" class="boast-title">'+data+'</a>';
				}
			 },
				{ data: "memberName" },
				{ data: "boastDate" }
			]
			
		});
		$('#custom-filter1').keyup( function() {
			dataTable1.search( this.value ).draw();
		  } );
		
}


function getCuriosityList(){
	let dataTable3 = $('#dataTable3').DataTable({
		destroy: true,
		"bLengthChange": false,
		"bInfo": false,	
		fixedColumns: true,	
		  order: [[4, 'desc']],
		  language: {
			paginate: {
				previous: '<span class="icon md-chevron-left"><</span>',
				next: '<span class="icon md-chevron-left">></span>'
			}
		},
			ajax:{
				url:"adminCuriosityList.kh",
				type:"get",
				dataType:"json",
				"dataSrc": function ( json ) {							
					$("#curiosity-count").text(json.data.length);
					return json.data;
				}    
			},
			columnDefs: [
				{ width: 50, targets: 0 }
			],
			columns:[
				{ orderable: false,
					data: "curiosityNo",
					className : "curiosity-check",
				render: function(data){					
					return '<input type="checkbox" class="checkbox_group2" name="curiosity-check" value="'+data+'">';
				}
			 },
				{  orderable: false,
					data: "curiosityFileRename" ,
				 "defaultContent": "<i>Not set</i>",
				 className : "curiosity-img",
				 render: function(data){
					 var img = '';
					 if(data == null){
							img = '<img src="resources/uploadFiles/curiosity/defaultplant.png">';
					 }else{
						 img = '<img src="resources/uploadFiles/curiosity/'+data+'">';
					 }
					 return img;

				 }
			    },
				{ data: "curiosityContent",
				render: function(data, target, row){
					if(data.length>10){
						data = data.substr(0,10)+"...";
					}					
					return '<a href="curiosityDetail.kh?curiosityNo='+row.curiosityNo+'" class="curiosity-title">'+data+'</a>';
				}
			 },
				{ data: "memberNick" },
				{ data: "curiosityDate" }
			]
			
		});
		$('#custom-filter3').keyup( function() {
			dataTable3.search( this.value ).draw();
		  } );
		
}