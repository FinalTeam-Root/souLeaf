
  companionListView();


function companionListView(){

  $.ajax({
    url : "companionList.kh",
    type:"get",
    dataType : "json",
    success : function(data){
      console.log(data);
      if(data.length > 0){
        var str = "";
        for(var i in data){
        	str+='				<div class="row justify-content-center blockstyle">';
        	str+='					<div class="col-md-12">';
        	str+='						<div class="wrapper">';
        	str+='							<div class="row no-gutters">';
        	str+='								<div class="col-md-7">';
        	str+='									<div class="contact-wrap w-100 p-md-5 p-4">';
        	str+='										<h3 class="mb-4">'+data[i].companionNick+'</h3>';
        	str+='										<form method="POST" id="contactForm" name="contactForm" class="contactForm">';
        	str+='											<div class="row">';
        	str+='												<div class="col-md-6">';
        	str+='													<div class="form-group">';
        	str+='														<label class="label" for="name">품종</label>';
        	str+='														<input type="text" class="form-control" name="name" id="name" value="'+data[i].plantName+'" readonly>';
        	str+='														<div class="top_line"></div>';
        	str+='													</div>';
        	str+='												</div>';
        	str+='												<div class="col-md-6">';
        	str+='													<div class="form-group">';
        	str+='														<label class="label" for="email">등록일</label>';
        	str+='														<input type="email" class="form-control" name="email" id="email" value="'+data[i].companionDate+'" readonly>';
        	str+='														<div class="top_line"></div>';
        	str+='													</div>';
        	str+='												</div>';
        	str+='												<div class="col-md-6">';
        	str+='													<div class="form-group">';
        	str+='														<label class="label" for="subject">마지막 물 준날</label>';
        	str+='														<input type="text" class="form-control" name="subject" id="subject" value="'+data[i].companionLastWater+'" readonly>';
        	str+='														<div class="top_line"></div>';
        	str+='													</div>';
        	str+='												</div>';
        	str+='												<div class="col-md-6">';
        	str+='													<div class="form-group">';
        	str+='														<label class="label" for="subject">tip!</label>';
        	str+='														<input type="text" class="form-control" name="subject" id="subject" value="'+data[i].plantWater+'일마다 겉흙이 마르면 줘" readonly>';
        	str+='														<div class="top_line"></div>';
        	str+='													</div>';
        	str+='												</div>';
        	str+='											</div>';
        	str+='										</form>';
        	str+='									</div>';
        	str+='								</div>';
        	str+='								  <div class="col-md-5 d-flex align-items-stretch">';
        	str+='								    <div class="info-wrap w-100 p-5 img" style="background-image: url('+data[i].companionRepicName+');">';
          	str+='								    </div>';
        	str+='								  </div>';
        	str+='							</div>';
        	str+='						</div>';
        	str+='					</div>';
        	str+='				</div>';
          }
        
        $("#companion-list").html("");
        $("#companion-list").append(str);
      }
      
    },
    error : function(){
      console.log('fail');
    }
  });
}
