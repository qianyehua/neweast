$(function(){
	
  var URL = window.URL || window.webkitURL;
  var $image = $('#imageScrop');
  var options = {
        aspectRatio: 750/473,
        crop: function (e) {
        }
      };
  var originalImageURL = $image.attr('src');
  var uploadedImageType = 'image/jpeg';
  var uploadedImageURL;
  
  $("#fileButton").click(function(){
	  $("#inputImage").trigger("click");
  });
  
  // Import image
  var $inputImage = $('#inputImage');
      $inputImage.change(function () {
      var files = this.files;
      var file;
      file = files[0];
      $('#inputImage').val("");
      if (/^image\/\w+$/.test(file.type)) {
    	  uploadedImageType = file.type;
    	  if(file.size > 2*1024*1024){  //大于2m
    		  $(".err-p").html("图片不能大于2M").show();
    		  setTimeout(function(){
    			  $(".err-p").hide();
    		  },1000);
    	  }else{
    		  $(".pic-mask").show();
    		  if (uploadedImageURL) {
    			  URL.revokeObjectURL(uploadedImageURL);
    		  }
  
    		  uploadedImageURL = URL.createObjectURL(file);
    		  $('.img-container').show();
    		  $image.cropper('destroy').attr('src', uploadedImageURL).cropper(options);
    	  } 
      } else {
    	  window.alert('Please choose an image file.');
      }
  });
    
    
    
    
   $("#scrop-but").click(function(){
       $(".scrop-form .show-p").show();
   	   var dataURL = $image.cropper("getCroppedCanvas"); //获取裁剪出来的canvas图片
   	   var imgurl= dataURL.toDataURL("image/png",1.0);//这里转成base64 image，img的src可直接使用
   	   $(".test-img").attr("src",imgurl);
   });
   
   $("#save-but").click(function(){
	   var imgUrl = $(".test-img").attr("src");
	   if(imgUrl == ""){
		   alert("请先裁剪图片");
		   return;
	   }
	   $(".test-img").attr("src","");
		$("#thumbnail").attr("src",imgUrl);
		$("#thumbnail").show();
		$(".pic-mask").hide();
		$("#basePic").val(imgUrl);
   });
   
   $('.close-mask').click(function(){
	   $(".test-img").attr("src","");
	   $(".pic-mask").hide();
   });
});
