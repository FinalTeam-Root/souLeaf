$(function(){
	getQnaList(); // 함수 호출
	
		
});
function getQnaList(){ // 함수 선언
	let dataTable1 = $('#dataTable1').DataTable({
		'autoWidth': false,
		destroy: true,
		"bLengthChange": false,
		"bInfo": false,		
		  order: [[3, 'desc']],
		  language: {
			paginate: {
				previous: '<span class="icon md-chevron-left"><</span>',
				next: '<span class="icon md-chevron-left">></span>'
			}
		},
			ajax:{
				url:"adminQnaList.kh",
				type:"get",
				dataType:"json",
				"dataSrc": function ( json ) {							
					$("#qna-count").text(json.data.length);
					return json.data;
				}    
			},
			columns:[
			
				{ data: "qnaNo" },
				{ data: "qnaContent" },
				{ data: "memberNick" },
				{ data: "qnaDate" },
				{ data: "ansNo", 
			"defaultContent":"null"}
			]
			
		});
		$('#custom-filter1').keyup( function() {
			dataTable1.search( this.value ).draw();
		  } );
}