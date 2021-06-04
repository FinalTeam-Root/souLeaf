$(function(){
	
	let dataTable = $('#dataTable1').DataTable({
		"bLengthChange": false,
		"bInfo": false,
		columns: [
			{ orderable: false },
			{ orderable: false },
			null,
			null,
			null
		  ],
		  order: [[4, 'desc']],
		  language: {
			paginate: {
				previous: '<span class="icon md-chevron-left"><</span>',
				next: '<span class="icon md-chevron-left">></span>'
			},
			ajax:{
				url:"adminBoastList.kh",
				type:"get",
				dataType:"json"
			},
			columns:[
				{ data: "boastNo" },
				{ data: "boastReName" },
				{ data: "boastTitle" },
				{ data: "memberName" },
				{ data: "boastDate" }
			]
		}
	});
	$('#custom-filter').keyup( function() {
		dataTable.search( this.value ).draw();
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
