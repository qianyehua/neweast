$(function() {
	jQuery.validator.setDefaults({
		submitHandler: function(form) {
			form.submit();
		}
	});

	jQuery.validator.addMethod("mobile", function(value, element) {
	  var length = value.length;
	  return this.optional(element) || (length == 11 && /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/.test(value));
	}, "��������ȷ�ֻ�����");


	jQuery.validator.addMethod("tel", function(value, element) {
	   var tel = /^0[0-9]{2,3}-[0-9]{5,9}$/;
	  return this.optional(element) || (tel.test(value));
	}, "��������ȷ�绰����");

	jQuery.validator.addMethod("loginName", function(value, element) {
		   var name =  $("#loginName").val();
		   if(name.toLowerCase() == "system"){
			   		return false;
		   }else
		   {
			   return true;
		   }
		}, "�û�������Ϊsystem");


	jQuery.validator.addMethod("telAndMobile", function(value, element) {
		  var isValidate = true;
		  var tel = jQuery("#tel").val().length;
		  var mobile = jQuery("#mobile").val().length;
		  if(tel==0 && mobile == 0)
		  {
			  isValidate = false;
		  }
		  return isValidate;
		}, "�绰���ֻ�����ͬʱΪ��");


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
		loginName: {required:"����д�û���",maxlength:"�û������Ȳ����Գ���12���ַ�"},
		realName: {required:"����д��ʵ����"},
		password: {required:"����д����"},
		rePassword: {required:"����дȷ������"},
		email: {required:"����дE-mail",
				email: "��������Ч��Email��ַ"}
	}
	});

});