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
		realName: {required: true,maxlength:12},
		oldPassword:{required: true},
		password: {required: true, maxlength:12,minlength:6},
		rePassword: {required: true, maxlength:12,minlength:6,equalTo:"#password"},
		email: {required: true,email:true},
		tel: {telAndMobile:true},
		mobile: {telAndMobile:true}
	},
	  messages: {

		oldPassword:{
	    required: "����дԭ����"
	    },
		     realName: {
		     required: "����д������ʵ����"
		    },
		     password: {
		     required: "����д����",
		     minlength: jQuery.format("����������{0}λ")
		    },
		    rePassword: {
		     required: "����дȷ������",
			 minlength: jQuery.format("����������{0}λ"),
		     equalTo: "�����������벻��ͬ"
		    },
		    email: {
		     required: "����������Email��ַ",
		     email: "��������Ч��Email��ַ"
			}
		   }
	});

});