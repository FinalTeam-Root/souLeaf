$(function(){
// 체크 박스 전체선택 및 전체 해제
$("#chk_all").click(function(){
    if($("#chk_all").is(":checked")){
        $(".chk").prop("checked",true);
    }else {
        $(".chk").prop("checked",false);
    }
});

getMyCuriosityList();
});

// 내가 쓴 궁금해요 리스트 뿌려주기
function getMyCuriosityList() {
    var memberNo = $("#memberNo").val();
    var $tr;
    var $check;
    var $num;
    var $title;
    var $writeDate;
    var $readCount;
    var $btnArea;
    $.ajax({
        url : "myCuriosityList.kh",
        type : "get",
        data : {"memberNo" : memberNo},
        dataType : "json",
        success : function(data) {
            var $tbody = $("#myPage-curiosity tbody");
            $tbody.html("");
            if(data.length > 0){
                for(var i in data){
                    $tr = $("<tr>");
                    $check = $("<td><input type='checkbox' name='del-select' class='chk' value='selectOne'>");
                    $num = $("<td scope='row'>").text(data[i].num);
                    $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?"+data[i].curiosityNo+"'class='noColor'>"+data[i].curiosityContent+"</a>");
                    $writeDate = $("<td>").text(data[i].curiosityDate);
                    $readCount = $("<td>").text(data[i].curiosityCount);
                    $btnArea = $("<td>").append("<button type='button' class='btn btn-outline-success btnGreen' onclick=curiosityModifyView.kh?"+data[i].curiosityNo+">수정</button><button type='button' class='btn btn-outline-danger'>삭제</button>");

                    $tr.append($check);
                    $tr.append($num);
                    $tr.append($title);
                    $tr.append($writeDate);
                    $tr.append($readCount);
                    $tr.append($btnArea);
                    $tbody.append($tr);
                }
            }
        },
        error : function(){

        }
    });
}