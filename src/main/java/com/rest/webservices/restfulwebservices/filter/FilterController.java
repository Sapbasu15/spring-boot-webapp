package com.rest.webservices.restfulwebservices.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {
	@GetMapping("/filter")
	public MappingJacksonValue getFilterBean() {
		FilterBean filterBean = new FilterBean("val_1", "val_2", "val_3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field_1","field_2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("my_filter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(filterBean);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/filter-list")
	public MappingJacksonValue getFilterBeanList() {
		List<FilterBean> fbList = new ArrayList<>();
		fbList.add(new FilterBean("val_11", "val_12", "val_13"));
		fbList.add(new FilterBean("val_21", "val_22", "val_23"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field_1","field_3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("my_filter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(fbList);
		mapping.setFilters(filters);
		return mapping;
	}
}
