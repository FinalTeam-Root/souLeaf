$(function(){
// 체크 박스 전체선택 및 전체 해제
$("#chk_all").click(function(){
    if($("#chk_all").is(":checked")){
        $(".chk").prop("checked",true);
    }else {
        $(".chk").prop("checked",false);
    }
});



});

