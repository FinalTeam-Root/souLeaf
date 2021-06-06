$(function(){
    // 체크 박스 전체선택 및 전체 해제
    $(".chk_all").click(function(){
        if($(".chk_all").is(":checked")){
            $(".chk").prop("checked",true);
        }else {
            $(".chk").prop("checked",false);
        }
    });
    var memberNo = $("#memberNo").val();
    var pageInfo = $("#pageInfo").val();
    getMyCuriosityList(memberNo,pageInfo);

     // 마이페이지 궁금해요 검색 버튼 클릭
     var pageInfo = $("#pageInfo").val();
     $("#curiositySearchBtn").on("click",function(){
         var searchCondition =  $("#searchCondition").val();
         var searchValue = $("#searchValue").val();
 
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
             url : "curiositySearch.kh",
             type : "get",
             data : {"searchCondition" : searchCondition, "searchValue" : searchValue, "page":pageInfo},
             dataType : "json",
             success : function(data) {
                 $("#searchValue").val(searchValue);
                 $("#searchCondition").val(searchCondition).prop("selected",true);
 
                 var $tbody = $("#myPage-curiosity tbody");
                 var $paging = $("#curiosity-page");
 
                 var page = data.pi.currentPage;
                 var startPage = data.pi.startPage;
                 var endPage = data.pi.endPage;
                 var maxPage = data.pi.maxPage;
                 console.log(maxPage,endPage);
 
                 $tbody.html("");
                 $paging.html("");
                 if(data.searchList.length > 0){
                     for(var i in data.searchList){
                         $tr = $("<tr>");
                         $check = $("<td><input type='checkbox' name='del-select' class='chk' value='"+data.searchList[i].curiosityNo+"'>");
                         $num = $("<td scope='row'>").text(data.searchList[i].num);
                         if(data.searchList[i].curiosityContent.length > 18){
                             $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data.searchList[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data.searchList[i].curiosityContent.substr(0,18)+"...</a>");
                         }else{
     
                             $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data.searchList[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data.searchList[i].curiosityContent+"</a>");
                         }
                         $writeDate = $("<td>").text(data.searchList[i].curiosityDate);
                         $readCount = $("<td>").text(data.searchList[i].curiosityCount);
                         $btnArea = $("<td>").append("<button type='button' class='btn btn-outline-success btnGreen' onclick='modifyCuriosity("+data.searchList[i].curiosityNo+")'>수정</button><button type='button' class='btn btn-outline-danger'>삭제</button>");
     
                         $chooseDelete = $("<td>").append("<button type='button' onclick='deleteCuriositySelectList("+data.searchList[i].memberNo+","+page+")' class='btn btn-outline-warning'>선택삭제</button>");
                         
                         $tr.append($check);
                         $tr.append($num);
                         $tr.append($title);
                         $tr.append($writeDate);
                         $tr.append($readCount);
                         $tr.append($btnArea);
                         if(i == (data.searchList.length-1)){
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
                     $lt = $("<li><a href='#' onclick='getSearchCuriosityList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+(Number(page)-1)+"); return false;'>&lt;</a></li>");
                     $paging.append($lt);
                 }
                 for(var j = startPage; j<=endPage; j++){
                     if(j == page){
                         $aActive = $('<li class="active"><span>'+j+'</span></li>');
                         $paging.append($aActive);
                     }else {
                         $a = $("<li><a name='page' href='#' onclick='getSearchCuriosityList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+j+"); return false;'>"+j+"</a></li>");
                         $paging.append($a);
                     }
                 }
                 if(page >= maxPage){
                     $gt = $('<li><a href="#">&gt;</a></li>');
                     $paging.append($gt);
                 } else {
                     $gt = $("<li><a href='#' onclick='getSearchCuriosityList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+(Number(page)+1)+"); return false;'>&gt;</a></li>");
                     $paging.append($gt);
                 }
 
 
             },
             error : function(){
     
             }
         })
 
     });


});
    // 내가 쓴 궁금해요 리스트 뿌려주기
    function getMyCuriosityList(memberNo, pageInfo) {
        var memberNo = $("#memberNo").val();
        //var pageInfo = $("#pageInfo").val();
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
            data : {"page" : pageInfo,"memberNo" : memberNo},
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
                        $check = $("<td><input type='checkbox' name='del-select' class='chk' value='"+data.curList[i].curiosityNo+"'>");
                        $num = $("<td scope='row'>").text(data.curList[i].num);
                        if(data.curList[i].curiosityContent.length > 18){
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data.curList[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data.curList[i].curiosityContent.substr(0,18)+"...</a>");
                        }else{
    
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data.curList[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data.curList[i].curiosityContent+"</a>");
                        }
                        $writeDate = $("<td>").text(data.curList[i].curiosityDate);
                        $readCount = $("<td>").text(data.curList[i].curiosityCount);
                        $btnArea = $("<td>").append("<button type='button' class='btn btn-outline-success btnGreen' onclick='modifyCuriosity("+data.curList[i].curiosityNo+")'>수정</button><button type='button' class='btn btn-outline-danger'>삭제</button>");
    
                        $chooseDelete = $("<td>").append("<button type='button' onclick='deleteCuriositySelectList("+data.curList[i].memberNo+","+page+");' class='btn btn-outline-warning'>선택삭제</button>");
                        
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
        location.href ='curiosityModifyView.kh?curiosityNo='+curiosityNo+'';
    }

    function getSearchCuriosityList(searchCondition,searchValue,pageInfo){
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
            url : "curiositySearch.kh",
            type : "get",
            data : {"searchCondition" : searchCondition, "searchValue" : searchValue, "page":pageInfo},
            dataType : "json",
            success : function(data) {
                var $tbody = $("#myPage-curiosity tbody");
                var $paging = $("#curiosity-page");

                var page = data.pi.currentPage;
                var startPage = data.pi.startPage;
                var endPage = data.pi.endPage;
                var maxPage = data.pi.maxPage;
                console.log(maxPage,endPage);

                $tbody.html("");
                $paging.html("");
                if(data.searchList.length > 0){
                    for(var i in data.searchList){
                        $tr = $("<tr>");
                        $check = $("<td><input type='checkbox' name='del-select' class='chk' value='"+data.searchList[i].curiosityNo+"'>");
                        $num = $("<td scope='row'>").text(data.searchList[i].num);
                        if(data.searchList[i].curiosityContent.length > 18){
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data.searchList[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data.searchList[i].curiosityContent.substr(0,18)+"...</a>");
                        }else{

                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data.searchList[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data.searchList[i].curiosityContent+"</a>");
                        }
                        $writeDate = $("<td>").text(data.searchList[i].curiosityDate);
                        $readCount = $("<td>").text(data.searchList[i].curiosityCount);
                        $btnArea = $("<td>").append("<button type='button' class='btn btn-outline-success btnGreen' onclick='modifyCuriosity("+data.searchList[i].curiosityNo+")'>수정</button><button type='button' class='btn btn-outline-danger'>삭제</button>");

                        $chooseDelete = $("<td>").append("<button type='button' onclick='deleteCuriositySelectList("+data.searchList[i].memberNo+","+page+")' class='btn btn-outline-warning'>선택삭제</button>");
                        
                        $tr.append($check);
                        $tr.append($num);
                        $tr.append($title);
                        $tr.append($writeDate);
                        $tr.append($readCount);
                        $tr.append($btnArea);
                        if(i == (data.searchList.length-1)){
                            $delTr = $("<tr>");
                            $delTr.append($chooseDelete);
                            $delTr.append("<td colspan='5'></td>");
                        }
                        $tbody.append($tr);
                        $tbody.append($delTr);
                    }
                }else if(data.searchList.length == 0) {
                    $tbody.append("<span>검색결과가 없습니다.</span>"); // 안뜸!!! ㅗ애 안떠~!!!
                }

                if(page <= 1){
                    $lt = $("<li><a href='#'>&lt;</a></li>");
                    $paging.append($lt);
                }else {
                    $lt = $("<li><a href='#' onclick='getSearchCuriosityList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+(Number(page)-1)+"); return false;'>&lt;</a></li>");
                    $paging.append($lt);
                }
                for(var j = startPage; j<=endPage; j++){
                    if(j == page){
                        $aActive = $('<li class="active"><span>'+j+'</span></li>');
                        $paging.append($aActive);
                    }else {
                        $a = $("<li><a name='page' href='#' onclick='getSearchCuriosityList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+j+"); return false;'>"+j+"</a></li>");
                        $paging.append($a);
                    }
                }
                if(page >= maxPage){
                    $gt = $('<li><a href="#">&gt;</a></li>');
                    $paging.append($gt);
                } else {
                    $gt = $("<li><a href='#' onclick='getSearchCuriosityList(\""+data.pageSearch.searchCondition+"\",\""+data.pageSearch.searchValue+"\","+(Number(page)+1)+"); return false;'>&gt;</a></li>");
                    $paging.append($gt);
                }
            },
            error : function(){

            }
        })
    }


    function deleteCuriositySelectList(memberNo,page){
        if($(".chk").is(":checked") == false){
            alert("선택된 삭제 목록이 없습니다.");
            return false;
        }else {
            if(!confirm("정말 삭제하시겠습니까?")){
                return false;
            }else {
                var chkVal;
                $("input:checkbox[name='del-select']:checked").each(function(index){
                    if(index != 0){
                        chkVal += ',';
                    }
                    chkVal += $(this).val();
                });
                chkVal = chkVal.substr(9);
                console.log(chkVal);
                $.ajax({
                    url : 'curiositydelete.kh',
                    type : 'get',
                    data : {"chkNo" : chkVal },
                    success : function(data){
                        if(data == "success"){
                            getMyCuriosityList(memberNo, page);
                        }
                    },
                    error : function(){}
                });
            }
        }

    }


    // 내가 쓴 클리닉 리스트 뿌려주기
    function getMyClincList(memberNo, pageInfo) {
        var memberNo = $("#memberNo").val();
        //var pageInfo = $("#pageInfo").val();
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
            url : "myClinicList.kh",
            type : "get",
            data : {"page" : pageInfo,"memberNo" : memberNo},
            dataType : "json",
            success : function(data) {
                console.log(data);
                var $tbody = $("#myPage-clinic tbody");
                var $paging = $("#clinic-page");

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
                        $check = $("<td><input type='checkbox' name='del-select' class='chk' value='"+data.curList[i].curiosityNo+"'>");
                        $num = $("<td scope='row'>").text(data.curList[i].num);
                        if(data.curList[i].curiosityContent.length > 18){
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data.curList[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data.curList[i].curiosityContent.substr(0,18)+"...</a>");
                        }else{
    
                            $title = $("<td stlye='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'><a href='curiosityDetail.kh?curiosityNo="+data.curList[i].curiosityNo+"&page=1&count=0'class='noColor'>"+data.curList[i].curiosityContent+"</a>");
                        }
                        $writeDate = $("<td>").text(data.curList[i].curiosityDate);
                        $readCount = $("<td>").text(data.curList[i].curiosityCount);
                        $btnArea = $("<td>").append("<button type='button' class='btn btn-outline-success btnGreen' onclick='modifyCuriosity("+data.curList[i].curiosityNo+")'>수정</button><button type='button' class='btn btn-outline-danger'>삭제</button>");
    
                        $chooseDelete = $("<td>").append("<button type='button' onclick='deleteCuriositySelectList("+data.curList[i].memberNo+","+page+");' class='btn btn-outline-warning'>선택삭제</button>");
                        
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
