package de.daug.semanticchess.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import de.daug.semanticchess.Service.UriService;

/**
 * sets up a REST API
 * the page /sparql delivers a result json for sparql queries
 */
@RestController
@RequestMapping("/uri")
public class UriController{
	
	/**
	 * service that connects to the database
	 */
	@Autowired
	private UriService uriService;
	
	/**
	 * connects to SparqlService.java 
	 * @param strQuery: sparql query
	 * @return a json with the results from the database
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getGame(@RequestBody String gameUri){
		System.out.println("Controller: " + gameUri);
		//System.out.println(uriService.getGame(gameUri));
		return uriService.getGame(gameUri);
	}
	
}