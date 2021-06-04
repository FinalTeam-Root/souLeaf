$(function(){
    // 체크 박스 전체선택 및 전체 해제
    $("#chk_all").click(function(){
        if($("#chk_all").is(":checked")){
            $(".chk").prop("checked",true);
        }else {
            $(".chk").prop("checked",false);
        }
    });
    var memberNo = $("#memberNo").val();
    var pageInfo = $("#pageInfo").val();

    getMyCuriosityList(memberNo,pageInfo);
    });
    
    // 내가 쓴 궁금해요 리스트 뿌려주기
    var memberNo = $("#memberNo").val();
    var pageInfo = $("#pageInfo").val();
    function getMyCuriosityList(memberNo, pageInfo) {
        var $tr;
        var $check;
        var $num;
        var $title;
        var $writeDate;
        var $readCount;
        var $btnArea;
        var $chooseDelete;
        var $delTr;

        var $lt;
        var $gt;
        var $aActive;
        var $a;

        $.ajax({
            url : "myCuriosityList.kh",
            type : "get",
            data : {"page" : pageInfo,"memberNo" : memberNo,},
            dataType : "json",
            success : function(data) {
                console.log(data);
                var $tbody = $("#myPage-curiosity tbody");
                var $paging = $("#curiosity-page");

                var page = data.pi.currentPage;
                var startPage = data.pi.startPage;
                var endPage = data.pi.endPage;
                var maxPage = data.pi.maxPage;
                console.log(maxPage,endPage);
                $tbody.html("");
                $paging.html("");
                if(data.curList.length > 0){
                    for(var i in data.curList){
                        $tr = $("<tr>");
                        $check = $("<td><input type='checkbox' name='del-select' class='chk' value='selectOne'>");
                        $num = $("<td scope='row'>").text(data.curList[i].num);
                        if(data.curList[i].curiosityContent.length > 18){
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data.curList[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data.curList[i].curiosityContent.substr(0,18)+"...</a>");
                        }else{
    
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data.curList[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data.curList[i].curiosityContent+"</a>");
                        }
                        $writeDate = $("<td>").text(data.curList[i].curiosityDate);
                        $readCount = $("<td>").text(data.curList[i].curiosityCount);
                        $btnArea = $("<td>").append("<button type='button' class='btn btn-outline-success btnGreen' onclick='modifyCuriosity("+data.curList[i].curiosityNo+")'>수정</button><button type='button' class='btn btn-outline-danger'>삭제</button>");
    
                        $chooseDelete = $("<td>").append("<button type='button' class='btn btn-outline-warning'>선택삭제</button>");
                        
                        $tr.append($check);
                        $tr.append($num);
                        $tr.append($title);
                        $tr.append($writeDate);
                        $tr.append($readCount);
                        $tr.append($btnArea);
                        if(i == (data.curList.length-1)){
                            $delTr = $("<tr>");
                            $delTr.append($chooseDelete);
                            $delTr.append("<td colspan='5'></td>");
                        }
                        $tbody.append($tr);
                        $tbody.append($delTr);
                    }
                }
                if(page <= 1){
                    $lt = $("<li><a href='#'>&lt;</a></li>");
                    $paging.append($lt);
                }else {
                    $lt = $("<li><a href='#' onclick='getMyCuriosityList("+data.curList[0].memberNo+","+(Number(page)-1)+"); return false;'>&lt;</a></li>");
                    $paging.append($lt);
                }
                for(var j = startPage; j<=endPage; j++){
                    if(j == page){
                        $aActive = $('<li class="active"><span>'+j+'</span></li>');
                        $paging.append($aActive);
                    }else {
                        $a = $("<li><a name='page' href='#' onclick='getMyCuriosityList("+data.curList[0].memberNo+","+j+"); return false;'>"+j+"</a></li>");
                        $paging.append($a);
                    }
                }
                if(page >= maxPage){
                    $gt = $('<li><a href="#">&gt;</a></li>');
                    $paging.append($gt);
                } else {
                    $gt = $("<li><a href='#' onclick='getMyCuriosityList("+data.curList[0].memberNo+","+(Number(page)+1)+"); return false;'>&gt;</a></li>");
                    $paging.append($gt);
                }


            },
            error : function(){
    
            }
        });
    }
    
    // 마이페이지 궁금해요 수정버튼 클릭시 수정화면 이동
    function modifyCuriosity(curiosityNo){
        location.href ='curiosityModifyView.kh?curiosityNo='+curiosityNo+'&page=1&count=0';
    }

    
    // 마이페이지 궁금해요 검색 버튼 클릭
    $("#curiositySearchBtn").on("click",function(){
        var searchCondition =  $("#searchCondition").val();
        var searchValue = $("#searchValue").val();
        console.log(searchCondition,searchValue);
        $.ajax({
            url : "curiositySearch.kh",
            type : "get",
            data : {"searchCondition" : searchCondition, "searchValue" : searchValue, "memberNo" :memberNo},
            dataType : "json",
            success : function(data) {
                console.log("궁금해요 검색리스트 :");
                console.log(data);
                getMyCuriosityList(memberNo, pageInfo);
                $("#searchValue").val(searchValue);
                $("#searchCondition").val(searchCondition).prop("selected",true);
            }
        })
    });
