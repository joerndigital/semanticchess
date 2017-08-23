package de.daug.semanticchess.Database;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.apache.jena.graph.Node;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.core.TriplePath;
import org.apache.jena.sparql.core.Var;
import org.apache.jena.sparql.core.VarExprList;
import org.apache.jena.sparql.syntax.ElementPathBlock;
import org.apache.jena.sparql.syntax.ElementVisitorBase;
import org.apache.jena.sparql.syntax.ElementWalker;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import de.daug.semanticchess.Database.ConnectVirtuoso;
import de.daug.semanticchess.Entity.ChessGame;
import slib.graph.model.graph.elements.E;
import virtuoso.jena.driver.VirtModel;

@Repository
public class VirtuosoQuery {

	private String prefix = "PREFIX ex:<http://example.com>" + " PREFIX res:<http://example.com/res/>"
			+ " PREFIX prop:<http://example.com/prop/>";
	private String virtQuery = "select distinct ?player where {?s prop:black ?player.} LIMIT 100";

	public VirtuosoQuery(String virtQuery) {
		this.virtQuery = virtQuery;
	}

	public VirtuosoQuery() {
	}

	public String getQuery() {
		return virtQuery;
	}

	public void setQuery(String query) {
		this.virtQuery = query;
	}

	public String getResults() {
		String query = this.prefix + " " + this.virtQuery;

		ConnectVirtuoso conn = new ConnectVirtuoso();
		VirtModel vModel = conn.connect();

		System.out.println("=====================");
		System.out.println("Exec: " + query);

		String json = "";


		Query  jquery = QueryFactory.create(query);

		QueryExecution qexec = QueryExecutionFactory.create(jquery, vModel);
		ResultSet results = qexec.execSelect();
		ResultSetFormatter.out(System.out, results, jquery);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		// ResultSetFormatter.outputAsJSON(outputStream, results);
		json = new String(outputStream.toByteArray());
		System.out.println("============================\n");

		return json;

	}

	public String getCustomResult(String strQuery) {
		String query = this.prefix + " " + strQuery;

		ConnectVirtuoso conn = new ConnectVirtuoso();
		VirtModel vModel = conn.connect();

		System.out.println("=====================");
		System.out.println("Exec: " + query);
		Query jquery = QueryFactory.create(query);
		Gson gson = new GsonBuilder().create();
		String json = "";
		
		if(jquery.isSelectType()){
			QueryExecution qexec = QueryExecutionFactory.create(jquery, vModel);
			ResultSet results = qexec.execSelect();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ResultSetFormatter.outputAsJSON(outputStream, results);
			json = new String(outputStream.toByteArray());
			System.out.println("============================\n");

			return json;
		}
		
		if(jquery.isAskType()){
			QueryExecution qexec = QueryExecutionFactory.create(jquery, vModel);
			Boolean results = qexec.execAsk();

			json = "{\"head\": {\"vars\": [ \"answer\" ] } , \"results\": {\"bindings\": [{ \"answer\": { \"type\": \"boolean\" , \"value\": \""+Boolean.valueOf(results)+"\" }}]}}";
			
			return json;
		}
		
		
        json = gson.toJson("Unkown statement.");
        
		return json;
	}

	public static void main(String[] args) {
		VirtuosoQuery virtQuery = new VirtuosoQuery();
		String json = virtQuery.getCustomResult(
				"select ?game ?black WHERE {?game prop:white 'Wilhelm Steinitz'. ?game prop:black ?black}");

		System.out.println(json);

	}
}