$(function(){
	
	let dataTable1 = $('#dataTable1').DataTable({
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
					return '<input type="checkbox" class="checkbox_group" value="'+data+'">';
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
				render: function(data, type, row, meta){
					console.log("data-"+data);
					console.log("type-"+type);
					console.log("row-"+row.boastNo);
					console.log("meta-"+meta);
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
	
$("#check_all").on("click", function(){
	var checked = $(this).is(":checked");
	if(checked){
		$(".checkbox_group").prop("checked",true);
	}else{
		$(".checkbox_group").prop("checked",false);
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
