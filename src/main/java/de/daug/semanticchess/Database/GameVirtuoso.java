package de.daug.semanticchess.Database;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.daug.semanticchess.Configurations;
import virtuoso.jena.driver.VirtModel;

//https://www.openlinksw.com/vos/main/Main/VirtTipsAndTricksLoadDataInTransactionMode
@Repository
public class GameVirtuoso {

	private ConnectVirtuoso conn;
	private VirtModel vModel;

	private static String PREFIX = "PREFIX ex:<http://example.com> " + "PREFIX res:<http://example.com/res/> "
			+ "PREFIX prop:<http://example.com/prop/> "
			+ "PREFIX cres:<http://pcai042.informatik.uni-leipzig.de/~swp13-sc/ChessOntology/Resources/> "
			+ "PREFIX cont:<http://pcai042.informatik.uni-leipzig.de/~swp13-sc/ChessOntology#> "
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>";

	/**
	 * constructor
	 */
	public GameVirtuoso() {
		conn = new ConnectVirtuoso();
		vModel = conn.connectDefault();
	}

	public String getMoves(String uri) {
		String moveList = "";
		int moveCounter = 0;

		String query = PREFIX + " SELECT DISTINCT ?moveNr ?move " + "WHERE {" + "<" + uri + "> "
				+ "prop:moves ?moves. ?moves prop:move ?move. ?moves prop:moveNr ?moveNr" + "} ORDER BY ?moveNr";

		// database connection

		System.out.println("=====================");
		System.out.println("Exec: " + query);
		// create the sparql query from the String
		Query jquery = QueryFactory.create(query);

		QueryExecution qexec = QueryExecutionFactory.create(jquery, vModel);
		ResultSet results = qexec.execSelect();

		for (; results.hasNext();) {
			QuerySolution soln = results.nextSolution();
			int moveNr = soln.getLiteral("moveNr").getInt(); // Get a result
																// variable by
																// name.
			String move = soln.getLiteral("move").getString();

			if (!move.equals("O-O") && !move.equals("O-O-O")) {
				move = move.replace("-", "");
			}

			if (moveNr % 2 != 0) {
				moveCounter++;
				moveList += moveCounter + ". " + move;
			} else {
				moveList += " " + move + " ";
			}

		}

		return moveList;
	}

	public String getStringProperty(String uri, String property) {
		String query = PREFIX + "SELECT DISTINCT ?" + property + " WHERE {<" + uri + "> prop:" + property + " ?"
				+ property + "}";

		System.out.println("=====================");
		System.out.println("Exec: " + query);
		// create the sparql query from the String
		Query jquery = QueryFactory.create(query);

		QueryExecution qexec = QueryExecutionFactory.create(jquery, vModel);
		ResultSet results = qexec.execSelect();
		String result = "";

		for (; results.hasNext();) {
			QuerySolution soln = results.nextSolution();
			try {
				result = soln.getLiteral(property).getString();
			} catch (Exception e) {

			}

		}

		if (result.isEmpty()) {
			result = "?";
		}

		if (property.equals("eco") && !result.equals("?")) {
			result = result.substring(0, 3);
		}

		return result;
	}

	public String getIntProperty(String uri, String property) {
		String query = PREFIX + "SELECT DISTINCT ?" + property + " WHERE {<" + uri + "> prop:" + property + " ?"
				+ property + "}";

		System.out.println("=====================");
		System.out.println("Exec: " + query);
		// create the sparql query from the String
		Query jquery = QueryFactory.create(query);

		QueryExecution qexec = QueryExecutionFactory.create(jquery, vModel);
		ResultSet results = qexec.execSelect();
		String result = "0";

		for (; results.hasNext();) {
			QuerySolution soln = results.nextSolution();
			try {
				result = String.valueOf(soln.getLiteral(property).getInt());
			} catch (Exception e) {

			}
		}

		if (result.equals("0")) {
			result = "?";
		}

		return result;
	}

	public String getPGN(String uri){
		
		String results = "[Event '" + this.getStringProperty(uri, "event") + "']" + " " + "[Site '"
				+ this.getStringProperty(uri, "site") + "']" + " " + "[Date '" + this.getStringProperty(uri, "date")
				+ "']" + " " + "[Round '" + this.getIntProperty(uri, "round") + "']" + " " + "[White '"
				+ this.getStringProperty(uri, "white") + "']" + " " + "[Black '"
				+ this.getStringProperty(uri, "black") + "']" + " " + "[ECO '" + this.getStringProperty(uri, "eco")
				+ "']" + " " + "[Result '" + this.getStringProperty(uri, "result") + "']" + " "
				+ this.getMoves(uri);
		
		
		
		String json = "{\"head\": {\"vars\": [ \"answer\" ] } , \"results\": {\"bindings\": [{ \"answer\": { \"type\": \"pgn\" , \"value\": \""
				+ results + "\" }}]}}";
		
		System.out.println(json);
		
		return json;
	}

	public static void main(String[] args) {
		GameVirtuoso game = new GameVirtuoso();
		String uri = "http://example.com/res/Beniamino_Vergani_Kurt_Von_Bardeleben_1895______";

		System.out.println(game.getPGN(uri));

		// System.out.println("[Event \"" + game.getStringProperty(uri, "event")
		// + "\"]" + "\n" + "[Site \""
		// + game.getStringProperty(uri, "site") + "\"]" + "\n" + "[Date \"" +
		// game.getStringProperty(uri, "date")
		// + "\"]" + "\n" + "[Round \"" + game.getIntProperty(uri, "round") +
		// "\"]" + "\n" + "[White \""
		// + game.getStringProperty(uri, "white") + "\"]" + "\n" + "[Black \""
		// + game.getStringProperty(uri, "black") + "\"]" + "\n" + "[ECO \"" +
		// game.getStringProperty(uri, "eco")
		// + "\"]" + "\n" + "[Result \"" + game.getStringProperty(uri, "result")
		// + "\"]" + "\n" + "\n"
		// + game.getMoves(uri));
	}

}