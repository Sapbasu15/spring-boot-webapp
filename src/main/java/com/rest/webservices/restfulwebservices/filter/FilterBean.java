package com.rest.webservices.restfulwebservices.filter;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonFilter("my_filter")
public class FilterBean {
	private String field_1;	
	private String field_2;
	private String field_3;
	public FilterBean(String field_1, String field_2, String field_3) {
		super();
		this.field_1 = field_1;
		this.field_2 = field_2;
		this.field_3 = field_3;
	}
	public String getField_1() {
		return field_1;
	}
	public void setField_1(String field_1) {
		this.field_1 = field_1;
	}
	public String getField_2() {
		return field_2;
	}
	public void setField_2(String field_2) {
		this.field_2 = field_2;
	}
	public String getField_3() {
		return field_3;
	}
	public void setField_3(String field_3) {
		this.field_3 = field_3;
	}
}
