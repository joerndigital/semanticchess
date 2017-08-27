package de.daug.semanticchess.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.daug.semanticchess.Database.SparqlVirtuoso;


@Service
public class SparqlService{
	
	@Autowired
	private SparqlVirtuoso virtuosoQuery;
	
	public String getResults(){	
		return virtuosoQuery.getResults();
	}
	
	public String getCustomResult(String strQuery){
		return virtuosoQuery.getCustomResult(strQuery);
	}
	
}