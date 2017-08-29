package de.daug.semanticchess.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.daug.semanticchess.Database.QueryVirtuoso;
import de.daug.semanticchess.Parser.Allocator;

@Service
public class QueryService{
	
	@Autowired
	private QueryVirtuoso virtuosoQuery;
	
	public String getResults(){	
		return virtuosoQuery.getResults();
	}
	
	public String getCustomResult(String strQuery){
		Allocator alloc = new Allocator(strQuery);
		strQuery = alloc.getSparqlQuery();
		
		return virtuosoQuery.getCustomResult(strQuery);
	}
	
}