;(function($){
	$.citysource = function(options){
		var defaults = {
			type	:	'GET',
			url		:	appServer + '/ajax/city.htm',
			async	:	false
		};
		var provinces = new Array();
		var options = $.extend(defaults, options);
		
		$.ajax({
			type: options.type,
			url: options.url,
			async: options.async,
			cache: false,
			dataType: 'json',
			success: function(data){
				for (var pi in data) {
					var p = data[pi];
					provinces[p.value] = new Array();
					provinces[p.value][0] = p.name;
					provinces[p.value][1] = new Array();
					
					var citys = provinces[p.value][1];
					for ( var ci in p.cities) {
						var c = p.cities[ci];
						citys[c.value] = c.name;
					}
				}
			}
		});
		
		return provinces;
	};
	
	$.fn.citypicker = function(options){
		var defaults = {
			dataSource				:	appServer + '/ajax/city.htm',
			hasDefaultProvince		:	true,
			defaultProvinceValue	:	'',
			defaultProvinceDes		:	'请选择',
			hasDefaultCity			:	true,
			defaultCityValue		:	'',
			defaultCityDes			:	'请选择',
			selectedProvice			:	null,
			selectedCity			:	null,
			initialized				:	function(){}
		};
		
		var province, city;
		var provinces = new Array();
		var options = $.extend(defaults, options);
		
		_init = function(){
			provinces = $.citysource({url: options.dataSource});
			
			_show(options.selectedProvice, options.selectedCity);

			options.initialized();
			
			$(province).change(function(){
				_show($(this).val(), null);
			});
			
		};
		
		_show = function(selectp, selectc) {
			if(selectp == '') selectp = null;
			if(selectc == '') selectc = null;
			
			$(province).empty();
			$(city).empty();
			
			if(options.hasDefaultProvince) {
				$(province).append(_defaultOption(true));
			}
			var first = null;
			for ( var pi in provinces) {
				$(province).append(_option(pi, provinces[pi][0], pi == selectp));
				if(first == null) {
					first = pi;
				}
			}
			
			if(!options.hasDefaultProvince) {
				if(selectp == null) {
					selectp = first;
				}
			}
			
			if(options.hasDefaultCity) {
				$(city).append(_defaultOption(false));
			}
			if(selectp != null) {
				var citys = provinces[selectp][1];
				for ( var ci in citys) {
					$(city).append(_option(ci,  citys[ci], ci == selectc));
				}
			}
		};
		
		_defaultOption = function(province) {
			if(province) {
				return '<option value="' + options.defaultProvinceValue + '">' + options.defaultProvinceDes + '</option>'
			} else {
				return '<option value="' + options.defaultCityValue + '">' + options.defaultCityDes + '</option>'
			}
		};
		
		_option = function(value, des, selected) {
			if(selected) {
				return '<option value="' + value + '" selected>' + des + '</option>'
			} else {
				return '<option value="' + value + '">' + des + '</option>'
			}
		};
		
		this.each(function(i){
			if(i == 0) {
				province = this;
			} else {
				city = this;
			}
		});
		
		_init();
	}
})(jQuery);