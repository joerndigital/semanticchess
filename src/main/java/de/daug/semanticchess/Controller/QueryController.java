package de.daug.semanticchess.Controller;


import org.apache.jena.query.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.daug.semanticchess.Service.QueryService;

@RestController
@RequestMapping("/query")
public class QueryController{
	
	@Autowired
	private QueryService queryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getResults(){	
		return queryService.getResults();
		
	}
	
}