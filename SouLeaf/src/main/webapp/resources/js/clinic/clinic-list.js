var currentCount = $("#currentCount").val();
var currentPage = $("#currentPage").val();
$(function(){
    
  getClinicList(currentPage);
  
});


function getPageInfo(page){
  $.ajax({
    url : "clinicPage.kh",
    type: "get",
    data:{"page":page},
    dataType : "json",
    success : function(data){      
      str = "";
      if(data.startPage == 1){

      }else{
        str+='<li><a style="color:#00bd56; cursor:pointer" onclick="getPrevMove('+data.pageLimit+')">&lt;</a></li>';
      }

      for(var i = data.startPage; i <= data.endPage; i++){        
        if(page == i){
          str +='<li class="active"><a style="cursor:pointer" onclick="getClinicList('+i+')">'+i+'</a></li>';
        }else{
          str +='<li><a style="color:#00bd56; cursor:pointer" onclick="getClinicList('+i+')">'+i+'</a></li>';
        }
      }

      if(data.endPage == data.maxPage){

      }else{
        str+='<li><a style="color:#00bd56; cursor:pointer" onclick="getNextMove('+data.endPage+')">&gt;</a></li>';       
      }
      
     
      $("#clinic-page").html(str);
    },
    error: function(){
      console.log("nopage");
    },
    complete : function(){
      currentPage = page;
    }

  });

}



function getPrevMove(pageLimit){ 
 getClinicList(pageLimit*currentCount);
 currentCount --;
}
function getNextMove(endPage){  
  getClinicList(endPage+1);
  currentCount ++;
}

function getClinicList(page){
  $("#clinic-list").html("");
  $.ajax({
    url : "clinicList.kh",
    type:"get",
    data : {"page":page},
    dataType : "json",
    success : function(data){
      currentPage = page;            
      if(data.length > 0){
        var str = "";
        for(var i in data){
			str+='<div class="col-lg-4 sidebar pl-lg-4 ftco-animate fadeInUp ftco-animated">';
			str+='<div class="block-21 mb-3 d-flex">';

			if(data[i].clinicFileRename == null){
				str+=' <a href="clinicDetail.kh?clinicNo='+data[i].clinicNo+'&page='+currentPage+'&count='+currentCount+'" class="blog-img mr-4 mt-2" style="background-image: url(resources/uploadFiles/clinic/defaultplant.png);"></a>';
			}else{
				str+=' <a href="clinicDetail.kh?clinicNo='+data[i].clinicNo+'&page='+currentPage+'&count='+currentCount+'" class="blog-img mr-4 mt-2" style="background-image: url(resources/uploadFiles/clinic/'+data[i].clinicFileRename+');"></a>';
			}

			str+=' <div class="text mt-2">';
			str+='	<h3 class="heading clinic-title"><a href="clinicDetail.kh?clinicNo='+data[i].clinicNo+'&page='+currentPage+'&count='+currentCount+'">'+data[i].clinicContent+'</a></h3>';
			str+='	<div class="meta">';
      str+='	  <div><span class="icon-person"></span>'+data[i].memberNick+'</div>';
			str+='	  <div><span class="icon-calendar"></span>'+data[i].clinicDate+'</div><br>';			
      str+='<div class="meta-chat"><span class="far fa-eye"></span> '+data[i].clinicCount+'</div>';
      str+='<div class="meta-chat"><span class="fa fa-comment"></span> '+data[i].replyCount+'</div>';
			str+='	</div></div></div></div>';
        }
        
        $("#clinic-list").append(str);
      }
      
    },
    error : function(){
      console.log('fail');
    },
    complete : function(){     
      getPageInfo(page);     
    }

  });


}