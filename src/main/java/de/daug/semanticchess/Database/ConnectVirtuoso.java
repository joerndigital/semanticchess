package de.daug.semanticchess.Database;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.jena.rdf.model.impl.ModelCom;
import org.apache.jena.util.CollectionFactory;

import de.daug.semanticchess.Configurations;
import virtuoso.jena.driver.VirtModel;

public class ConnectVirtuoso {
	private String url = Configurations.DB;
	private String user = Configurations.DB_USER;
	private String pwd = Configurations.DB_PASSWORD;
	private String graph = Configurations.DB_GRAPH;
	
	
	public ConnectVirtuoso(){
		
	}
	
	public VirtModel connect(){
		VirtModel vModel = VirtModel.openDatabaseModel(graph, url, user, pwd);
				
		return vModel;
	}
	


	

	public static void main(String[] args) {
	
		
//		String query = "select distinct ?game where {?game ?s ?a} LIMIT 10";
//		String url = Configurations.DB;
//		String uid = Configurations.DB_USER;
//		String pwd = Configurations.DB_PASSWORD;
//		String graph = Configurations.DB_GRAPH;
//        
//		VirtModel vModel = VirtModel.openDatabaseModel(graph, url, uid, pwd);
//		
//        System.out.println("=====================");
//        System.out.println("Exec: "+ query);
//        Query jquery = QueryFactory.create(query) ;
//        QueryExecution qexec = QueryExecutionFactory.create(jquery, vModel) ;
//        ResultSet results =  qexec.execSelect();
//        ResultSetFormatter.out(System.out, results, jquery);
//        qexec.close();
//        System.out.println("============================\n");
//
		
		}

}