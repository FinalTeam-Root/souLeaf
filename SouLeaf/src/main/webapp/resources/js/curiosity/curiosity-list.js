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
      
      console.log(data);
      if(data.length > 0){
        var str = "";
        for(var i in data){
			str+='<div class="col-lg-6 sidebar pl-lg-5 ftco-animate fadeInUp ftco-animated">';
			str+='<div class="block-21 mb-4 d-flex">';
			str+=' <a class="blog-img mr-4" style="background-image: url(resources/uploadFiles/curiosity/'+data[i].curiosityFileRename+');"></a>';
			str+=' <div class="text">';
			str+='	<h3 class="heading"><a href="#">'+data[i].curiosityContent+'</a></h3>';
			str+='	<div class="meta">';
			str+='	  <div><span class="icon-calendar"></span>'+data[i].curiosityDate+'</div>';
			str+='	  <div><span class="icon-person"></span>'+data[i].memberNo+'</div>';
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
