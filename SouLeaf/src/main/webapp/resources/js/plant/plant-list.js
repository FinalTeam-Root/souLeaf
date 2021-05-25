$(function(){
  getPlantList();
});

function getPlantList(){

  $.ajax({
    url : "plantList.kh",
    type:"get",
    data : {"current":1},
    dataType : "json",
    success : function(data){
      
      console.log(data);
      if(data.length > 0){
        var str = "";
        for(var i in data){
          str+='<div class="col-md-6 col-lg-3 ftco-animate fadeInUp ftco-animated" onclick="location.href=\'plantDetail.kh?plantNo='+data[i].plantNo+'\'">';
          str+='<div class="staff">';
          str+='<div class="img-wrap d-flex align-items-stretch">';
          str+='<div class="img align-self-stretch" style="background-image: url(resources/uploadFiles/plant/'+data[i].plantFileRename+');"></div>';
          str+='</div>';
          str+='<div class="text pt-3 px-3 pb-4 text-center">';
          str+='<span class="position mb-2">'+data[i].plantEngname+'</span>';
          str+='<h3>'+data[i].plantName+'</h3>';          
          str+='<div class="faded">';          
          str+='</div></div></div></div>';
        }
        
        $("#plant-list").append(str);
      }
      
    },
    error : function(){
      console.log('fail');
    }

  });


}
