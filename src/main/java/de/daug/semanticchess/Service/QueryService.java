package de.daug.semanticchess.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.daug.semanticchess.Database.ConnectVirtuoso;
import de.daug.semanticchess.Database.VirtuosoQuery;
import de.daug.semanticchess.Entity.ChessGame;
import virtuoso.jena.driver.VirtModel;

@Service
public class QueryService{
	
	@Autowired
	private VirtuosoQuery virtuosoQuery;
	
	public String getResults(){	
		return virtuosoQuery.getResults();
	}
	
	public String getCustomResult(String strQuery){
		return virtuosoQuery.getCustomResult(strQuery);
	}
	
}