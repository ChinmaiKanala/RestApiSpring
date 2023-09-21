package com.version1.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	private FilteringService filteringService;
	
	public FilteringController(FilteringService filteringService) {
		super();
		this.filteringService = filteringService;
	}


	@GetMapping("filtering")
	public MappingJacksonValue filtering() {
		
		SomeBean someBean = new SomeBean("value1","value2","value3");
		
		MappingJacksonValue mappingJacksonValue = filteringService.filtering(someBean);
		 
		 return mappingJacksonValue;
		
	}
	

	@GetMapping("filtering-list")
	public MappingJacksonValue filteringList() {
		
		 List<SomeBean> someBean = Arrays.asList(new SomeBean("value1","value2","value3"),
				 new SomeBean("value1","value2","value3")); 
		
		 MappingJacksonValue mappingJacksonValue = filteringService.filteringList(someBean);
		 
		 return mappingJacksonValue;
	}
	
}
