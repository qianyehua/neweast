$(function() {	


	$("#but").click(function() {
	
		var message = $.trim($("#subjectName").val());
		alert(message);
		$(".focus-p").attr("style","display:block");

//		var url = appServer + '/ajax/updateStateMessage.htm';
//		$.ajax({
//			type : 'POST',
//			url : url,
//			data : {
//				"stateMessage" : message
//			},
//			success : function(data) {
//				if (data.result == '') {
//					$("#stateMessage").val("您的个性签名，建议少于50字");
//				} else {
//					$("#stateMessage").val(data.result);
//				}
//
//			},
//			error : function(e) {
//				// 没有登录
//				window.location = appServer + '/login.htm';
//			},
//			dataType : "json"
//		});
//	});
}