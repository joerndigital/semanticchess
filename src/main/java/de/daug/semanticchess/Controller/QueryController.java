package de.daug.semanticchess.Controller;


import java.util.List;

import org.apache.jena.query.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.daug.semanticchess.Entity.ChessGame;
import de.daug.semanticchess.Service.QueryService;

@RestController
@RequestMapping("/query")
public class QueryController{
	
	@Autowired
	private QueryService queryService;
	
//	@RequestMapping(method = RequestMethod.GET)
//	public String getResults(){	
//		return queryService.getResults();
//		
//	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getCustomResult(@RequestBody String strQuery){
		System.out.println("Controller: " + strQuery);
		return queryService.getCustomResult(strQuery);
	}
	
}