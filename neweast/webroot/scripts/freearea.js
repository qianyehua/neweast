var areaMap;
var showDelBtn = true;
var provinces;
function init() {
	provinces = $.citysource();
	areaMap = new AreaMap($('#freeArea').val());
}

function setShowDelBtn(value) {
	showDelBtn = value;
}

$(function() {
	init();
	fresh();
});

function addAndFreshAreaMap(area) {
	areaMap.put(area.key(), area);
	$('#freeArea').val(areaMap)
	fresh();
}

function removeAndFreshAreaMap(key) {
	areaMap.remove(key);
	$('#freeArea').val(areaMap)
	fresh();
}

function fresh() {
	var content = '';
	var i = 0;
	for(var c in areaMap.area) {
		var area = new Area(c);
		content += getProvinceCityName(area.province, area.city);
		if(showDelBtn) {
			content += '<input type="button" value="删除" onclick="removeArea(' + area.key() + ');" \>';
		}
		if(i == 1) {
			content += '<br />';
			i = 0;
		} else {
			i++;
		}
	}
	
	$('#freeAreaL').html(content);
}

function getProvinceCityName(p, c, psuffix, csuffix) {
	if(psuffix == undefined) psuffix = '';
	if(csuffix == undefined) csuffix = '';
	
	var pname = '', cname = '';
	var province = provinces[p];
	if(province != undefined) {
		pname = province[0] + psuffix;
		var citys = province[1];
		var city = citys[c];
		if(city != undefined) {
			cname = city + csuffix;
		} else {
			cname = '全境';
		}
	}

	return $.format('<{0},{1}>', pname, cname);
}

function add() {
	var province = $('#province').val();
	var city = $('#city').val();
	var area;
	
	if(isValid(city)) {//城市
		area = new Area(city);
		if(areaMap.contain(province)) {
			return;
		}
		if(areaMap.contain(city)) {
			return;
		}
	} else {//省份
		area = new Area(province);
		if(areaMap.contain(province)) {
			return;
		}
		
		for (var i in areaMap.area) {
			if(i.length > 2 && i.indexOf(province) != -1) {
				areaMap.remove(i);
			}
		}
	}
	
	addAndFreshAreaMap(area);
}

function removeArea(key) {
	removeAndFreshAreaMap(key);
}

function isValid(value) {
	return value != undefined && value != null && value != '';
}

function Area(content) {
	this.province;
	this.city;
	if(isValid(content)) {
		if(content.length <= 2) {
			this.province = content;
		} else if(content.length > 2) {
			this.province = content.substring(0, content.length - 2);
			this.city = content;
		}
	}
}

Area.prototype = {
	key: function() {
		if(this.city != undefined) {
			return this.city;
		}
		return this.province; 
	},
	toString : function() {
		if(this.city != undefined) {
			return this.city;
		} else {
			return this.province;
		}
	}
}

function AreaMap(content) {
	this.area = {};
	if(content != undefined) {
		content = content.trim();
		if(content == '')
			return;
		var strs = content.split('@');
		for (var i in strs) {
			if(strs[i] != '') {
				var area = new Area(strs[i]);
				if(area != undefined) {
					this.put(area.key(), area);
				}
			}
		}
	}
}

AreaMap.prototype = {
	put : function(key, value) {
		this.area[key] = value;
	},
	get : function(key) {
		return this.area[key];
	},
	remove : function(key) {
		if (this.area.hasOwnProperty(key)) {
			return delete this.area[key];
		}
		return false;
	},
	contain : function(key) {
		return this.area.hasOwnProperty(key);
	},
	size : function() {
		return this.keySet().length;
	},
	toString : function() {
		var s = '';
		for ( var i in this.area) {
			s += this.area[i] + "@";
		}
		return s.substring(0, s.length - 1);
	}
}