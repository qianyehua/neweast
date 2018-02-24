/**
 * ����className ��ȡָ��name�ĺ�׺
 * @param names  className����
 * @param prefix ָ��name��ǰ׺
 * @return
 */
function splitClassName(names, prefix) {
	var nameArr = names.split(' ');
	var subfix;
	for ( var i = 0; i < nameArr.length; i++) {
		if(nameArr[i].indexOf(prefix) == 0) {
			subfix = nameArr[i].split('_')[1];
			break;
		}
	}
	return subfix;
}

$(document).ready(function() {
	$("textarea[class^='maxlength_']").keyup(function(){
		var size = splitClassName($(this).attr('class'), 'maxlength_');
		
		if(size == undefined) return;
		if(isNaN(size)) return;
		
		var content = $(this).val();
		var length = content.length;
		if(length > size) {
			$(this).val(content.substring(0, size));
		}
	});
	
	$("input[class^='maxlength_']").keyup(function(){
		var size = splitClassName($(this).attr('class'), 'maxlength_');
		
		if(size == undefined) return;
		if(isNaN(size)) return;
		
		var content = $(this).val();
		var length = content.length;
		if(length > size) {
			$(this).val(content.substring(0, size));
		}
	});
});
