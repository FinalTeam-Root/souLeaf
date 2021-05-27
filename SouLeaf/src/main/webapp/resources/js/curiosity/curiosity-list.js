$(function(){
  getCuriosityList();
});

function getCuriosityList(){

  $.ajax({
    url : "curiosityList.kh",
    type:"get",
    data : {"current":1},
    dataType : "json",
    success : function(data){
            
      if(data.length > 0){
        var str = "";
        for(var i in data){
			str+='<div class="col-lg-4 sidebar pl-lg-4 ftco-animate fadeInUp ftco-animated">';
			str+='<div class="block-21 mb-3 d-flex">';

			if(data[i].curiosityFileRename == null){
				str+=' <a href="curiosityDetail.kh?curiosityNo='+data[i].curiosityNo+'" class="blog-img mr-4" style="background-image: url(resources/uploadFiles/curiosity/defaultplant.png);"></a>';
			}else{
				str+=' <a href="curiosityDetail.kh?curiosityNo='+data[i].curiosityNo+'" class="blog-img mr-4" style="background-image: url(resources/uploadFiles/curiosity/'+data[i].curiosityFileRename+');"></a>';
			}

			str+=' <div class="text mt-2">';
			str+='	<h3 class="heading curiosity-title"><a href="curiosityDetail.kh?curiosityNo='+data[i].curiosityNo+'">'+data[i].curiosityContent+'</a></h3>';
			str+='	<div class="meta">';
			str+='	  <div><span class="icon-calendar"></span>'+data[i].curiosityDate+'</div>';
			str+='	  <div><span class="icon-person"></span>'+data[i].memberNick+'</div>';
			str+='	  <div><span class="icon-chat"></span>'+data[i].curiosityCount+'</div>';
			str+='	</div></div></div></div>';
        }
        
        $("#curiosity-list").append(str);
      }
      
    },
    error : function(){
      console.log('fail');
    }

  });


}
