$plantKind='1,2,3,4',$plantProperty='1,2,3,4,5,6',$plantLeaf='1,2,3,4,5,6,7,8,9,10';

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

function getPlantSearchList(obj){
  var kind = $("input[name=plant-kind]:checked").val();
  var property = $("input[name=plant-property]:checked").val();
  var leaf = $("input[name=plant-leaf]:checked").val();  
  console.log($(obj).children().attr('name'));
  var label = $(obj).children().attr('name');
  switch(label){
    case 'plant-kind': $plantKind=$(obj).children().val();
    break;
    case 'plant-property': $plantProperty=$(obj).children().val();
    break;
    case 'plant-leaf' : $plantLeaf=$(obj).children().val();
    break;
  }
  console.log($plantKind,$plantProperty,$plantLeaf);

  $.ajax({
    url : "plantSelect.kh",
    type: "get",
    data: {"plantKind":$plantKind,"plantProperty":$plantProperty,"plantLeaf":$plantLeaf},
    dataType:"json",
    success: function(data){
      console.log(data);
      $("#plant-list").html("");
      var str = "";
      if(data.length>0){
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
      }else{
        str="<div class='ml-5'>데이터가 존재하지 않습니다.</div>";

      }
      $("#plant-list").append(str);
    },
    error : function(){
      console.log('fail');
    }


  });
  
}
