$(function() {
	jQuery.validator.setDefaults({
		submitHandler: function(form) {
			form.submit();
		}
	});

	jQuery.validator.addMethod("mobile", function(value, element) {
	  var length = value.length;
	  return this.optional(element) || (length == 11 && /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/.test(value));
	}, "请输入正确手机号码");


	jQuery.validator.addMethod("tel", function(value, element) {
	   var tel = /^0[0-9]{2,3}-[0-9]{5,9}$/;
	  return this.optional(element) || (tel.test(value));
	}, "请输入正确电话号码");

	jQuery.validator.addMethod("loginName", function(value, element) {
		   var name =  $("#loginName").val();
		   if(name.toLowerCase() == "system"){
			   		return false;
		   }else
		   {
			   return true;
		   }
		}, "用户名不能为system");


	jQuery.validator.addMethod("telAndMobile", function(value, element) {
		  var isValidate = true;
		  var tel = jQuery("#tel").val().length;
		  var mobile = jQuery("#mobile").val().length;
		  if(tel==0 && mobile == 0)
		  {
			  isValidate = false;
		  }
		  return isValidate;
		}, "电话和手机不能同时为空");


	$("#systemUser").validate({
		rules: {
		loginName: {required: true, maxlength:12,loginName:true},
		realName: {required: true,maxlength:16},
		password: {required: true, maxlength:12,minlength:6},
		rePassword: {required: true, maxlength:12,minlength:6,equalTo:"#password"},
		email: {required: true,email:true},
		tel: {tel:true,telAndMobile:true},
		mobile: {mobile:true,telAndMobile:true}
	},
		messages:{
		loginName: {required:"请填写用户名",maxlength:"用户名长度不可以超过12个字符"},
		realName: {required:"请填写真实姓名"},
		password: {required:"请填写密码"},
		rePassword: {required:"请填写确认密码"},
		email: {required:"请填写E-mail",
				email: "请输入有效的Email地址"}
	}
	});

});