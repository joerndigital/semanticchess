package de.daug.semanticchess.Database;


import java.io.ByteArrayOutputStream;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.springframework.stereotype.Repository;

import de.daug.semanticchess.Database.ConnectVirtuoso;
import virtuoso.jena.driver.VirtModel;

@Repository
public class VirtuosoQuery{
	
	
	private String virtQuery = "select distinct ?game where {?game ?s ?a} LIMIT 10";
	
	public VirtuosoQuery(String virtQuery){
		this.virtQuery = virtQuery;
	}
	
	public VirtuosoQuery(){
	}

	public String getQuery() {
		return virtQuery;
	}

	public void setQuery(String query) {
		this.virtQuery = query;
	}
	
	
	public String getResults(){	
		String query = this.virtQuery;

		ConnectVirtuoso conn = new ConnectVirtuoso();
        VirtModel vModel = conn.connect();
		
		
        System.out.println("=====================");
        System.out.println("Exec: "+ query);
        Query jquery = QueryFactory.create(query) ;
        QueryExecution qexec = QueryExecutionFactory.create(jquery, vModel) ;
        ResultSet results =  qexec.execSelect();
        //ResultSetFormatter.out(System.out, results, jquery);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        ResultSetFormatter.outputAsJSON(outputStream, results);
        String json = new String(outputStream.toByteArray());
        System.out.println("============================\n");
		return json;
		
	}
	
	public static void main(String[] args){
		VirtuosoQuery virtQuery = new VirtuosoQuery();
		virtQuery.getResults();
		
//		VirtuosoQuery virtQuery = new VirtuosoQuery("select distinct ?game where {?game ?s ?a} LIMIT 10");
//		
//		String query = virtQuery.getQuery();
//
//		ConnectVirtuoso conn = new ConnectVirtuoso();
//        VirtModel vModel = conn.connect();
//		
//		
//        System.out.println("=====================");
//        System.out.println("Exec: "+ query);
//        Query jquery = QueryFactory.create(query) ;
//        QueryExecution qexec = QueryExecutionFactory.create(jquery, vModel) ;
//        ResultSet results =  qexec.execSelect();
//        ResultSetFormatter.out(System.out, results, jquery);
//        qexec.close();
//        System.out.println("============================\n");
	}
	
	
	
}