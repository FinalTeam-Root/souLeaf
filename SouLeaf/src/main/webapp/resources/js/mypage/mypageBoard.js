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
        var $chooseDelete;
        var $delTr;
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
                        if(data[i].curiosityContent.length > 18){
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data[i].curiosityContent.substr(0,18)+"...</a>");
                        }else{
    
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data[i].curiosityContent+"</a>");
                        }
                        $writeDate = $("<td>").text(data[i].curiosityDate);
                        $readCount = $("<td>").text(data[i].curiosityCount);
                        $btnArea = $("<td>").append("<button type='button' class='btn btn-outline-success btnGreen' onclick='modifyCuriosity("+data[i].curiosityNo+")'>수정</button><button type='button' class='btn btn-outline-danger'>삭제</button>");
    
                        $chooseDelete = $("<td>").append("<button type='button' class='btn btn-outline-warning'>선택삭제</button>");
                        
                        $tr.append($check);
                        $tr.append($num);
                        $tr.append($title);
                        $tr.append($writeDate);
                        $tr.append($readCount);
                        $tr.append($btnArea);
                        if(i == (data.length-1)){
                            $delTr = $("<tr>");
                            $delTr.append($chooseDelete);
                            $delTr.append("<td colspan='5'></td>");
                        }
                        $tbody.append($tr);
                        $tbody.append($delTr);
                    }
                }
            },
            error : function(){
    
            }
        });
    }
    
    function modifyCuriosity(curiosityNo){
        location.href ='curiosityModifyView.kh?curiosityNo='+curiosityNo+'&page=1&count=0';
    }
    
    