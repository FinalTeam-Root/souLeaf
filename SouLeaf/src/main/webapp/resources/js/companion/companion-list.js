
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
          str+='										<form method="POST" id="contactForm" name="contactForm" class="contactForm">';
          str+='											<div class="row">';
          str+='												<div class="col-md-12">';
          str+='													<div class="row">';
          str+='														<div id="printName'+i+'">';
          str+='															<h3 class="mb-4">'+data[i].companionNick+'</h3>';
          str+='														</div>';
          str+='														<div id="updateName'+i+'" style="display: none;">';
          str+='															<input type="text" class="form-control" name="companionNick'+i+'" id="companionNick'+i+'" value="'+data[i].companionNick+'" maxlength="6" style="width: 263px; margin-top: -13px;">';
          str+='															<div class="countWord">';
          str+='																<span id="counter'+i+'">###</span>';
          str+='															</div>';
          str+='														</div>';
          str+='														<img id="updateForm'+i+'" src="resources/images/updateicon.jpg" style="width: 30px; height: 25px; margin-top: 7px;">';
          str+='													</div>';
          str+='												</div>';
          str+='												<div class="col-md-6">';
          str+='													<div class="form-group">';
          str+='														<label class="label" for="name">품종</label>';
          str+='														<input type="text" class="form-control" name="name" id="name" value="'+data[i].plantName+'" readonly>';
          str+='														<div class="top_line"></div>';
          str+='													</div>';
          str+='												</div>';
          str+='												<div class="col-md-6">';
          str+='													<div class="form-group">';
          str+='														<label class="label" for="regist">등록일</label>';
          str+='														<input type="text" class="form-control" name="regist" id="regist" value="'+data[i].companionDate+'" readonly>';
          str+='														<div class="top_line"></div>';
          str+='													</div>';
          str+='												</div>';
          str+='												<div class="col-md-6">';
          str+='													<div class="form-group">';
          str+='														<label class="label" for="subject">마지막 물 준날</label>';
          str+='														<div id="printWater'+i+'">';
          str+='															<input type="text" class="form-control" name="subject'+i+'" id="subject'+i+'" value="'+data[i].companionLastWater+'" readonly>';
          str+='															<div class="top_line"></div>';
          str+='														</div>';
          str+='														<div id="updateWater'+i+'" style="display: none">';
          str+='															<div class="form-group'+i+'">';
          str+='																<div class="input-group date" id="datetimepicker" data-target-input="nearest">';
          str+='																<input type="text" id="lastWater'+i+'" class="form-control datetimepicker-input" data-target="#datetimepicker1">';
          str+='																<div class="input-group-append" data-target="#datetimepicker1" data-toggle="datetimepicker"></div>';
          str+='															</div>';
          str+='															</div>';
          str+='														</div>';
          str+='													</div>';
          str+='												</div>';
          str+='												<div class="col-md-6">';
          str+='													<div class="form-group">';
          str+='														<label class="label" for="subject">tip!</label>';
          str+='														<input type="text" class="form-control" name="subject" id="subject" value="'+data[i].plantWater+'일마다 겉흙이 마르면 줘" readonly>';
          str+='														<div class="top_line"></div>';
          str+='													</div>';
          str+='												</div>';
          str+='												<div class="col-md-12">';
          str+='												  <div class="row"style=" margin-left: 0px; margin-right: 0px;">';
          str+='												    <div class="form-group">';
          str+='												      <div class="input-group">';
          str+='												        <div id="updateFile'+i+'" style="display: none">';
          str+='												          <div class="custom-file" style="width:400px">';
          str+='												            <input type="file" class="file-upload custom-file-input" id="uploadFile'+i+'" name="uploadFile'+i+'" aria-describedby="inputGroupFileAddon04">';
          str+='												            <label class="custom-file-label" for="uploadFile'+i+'">'+data[i].companionPicName+'</label>';
          str+='												          </div>';
          str+='												        </div>';
          str+='												        <button id="updateSubmit'+i+'" type="button" class="btn btn-outline-success backcolor" style="margin-left: 10px; padding-top: 8px; padding-bottom: 8px; height: 38px; display: none">수정</button>';
          str+='												        <button id="updateReset'+i+'" type="button" class="btn btn-outline-success backcolor" style="margin-left: 10px; padding-top: 8px; padding-bottom: 8px; height: 38px; display: none">취소</button>';
          str+='												        <button id="deleteSubmit'+i+'" type="button" class="btn btn-outline-success backcolor" style="margin-left: 10px; padding-top: 8px; padding-bottom: 8px; height: 38px ;margin-left: 482px;">삭제</button>';
          str+='											         </div>';
          str+='											      </div>';
          str+='											    </div>';
          str+='											  </div>';          
          str+='											</div>';
          str+='										</form>';
          str+='									</div>';
          str+='								</div>';
          str+='								  <div class="col-md-5 d-flex align-items-stretch">';
          str+='								    <div class="info-wrap w-100 p-5 img" style="background-image: url('+data[i].companionRepicName+');">';
          str+='  								    </div>';
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
