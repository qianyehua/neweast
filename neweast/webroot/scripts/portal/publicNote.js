jQuery(function() {

	jQuery.validator.setDefaults( {
		submitHandler : function(form) {
			form.submit();
		}
	});
	$("#publicNote").validate( {
		rules : {
			title : {
				required : true,
				maxlength : 64
			},
			type : {
				required : true
			}
		},
		messages:{
			title : {
				required: "请输入标题",
				maxlength: jQuery.format("标题最多为{0}个")
		},
			type: {
			   required: "请选择类型"
		}
		}
	});

});