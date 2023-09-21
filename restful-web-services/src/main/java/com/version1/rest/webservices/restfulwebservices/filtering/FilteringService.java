package com.version1.rest.webservices.restfulwebservices.filtering;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Component
public class FilteringService {
		
	public MappingJacksonValue filteringList(List<SomeBean> someBean) {
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		 
		 SimpleBeanPropertyFilter filter = 
				 SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		 
		FilterProvider filters = 
				new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		
		mappingJacksonValue.setFilters(filters);
		 	
		return mappingJacksonValue;
	}
	
	public MappingJacksonValue filtering(SomeBean someBean) {
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		 
		 SimpleBeanPropertyFilter filter = 
				 SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		 
		FilterProvider filters = 
				new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
	}
	
}
