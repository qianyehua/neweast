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
//					$("#stateMessage").val("���ĸ���ǩ������������50��");
//				} else {
//					$("#stateMessage").val(data.result);
//				}
//
//			},
//			error : function(e) {
//				// û�е�¼
//				window.location = appServer + '/login.htm';
//			},
//			dataType : "json"
//		});
//	});
}