package com.skyjoo.neweast.biz.datadic.domain;

import java.util.ArrayList;
import java.util.List;

public class SimpleCity {
	private Long id;
	private String value;
	private String name;
	private List<SimpleCity> cities = new ArrayList<SimpleCity>();
	
	public SimpleCity(CommDatadic datadic) {
		this.id = datadic.getId();
		this.value = datadic.getValue();
		this.name = datadic.getName();
	}

	public Long getId() {
		return id;
	}
	
	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public List<SimpleCity> getCities() {
		return cities;
	}
	
}
