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
		Query jquery = QueryFactory.create(query);
		QueryExecution qexec = QueryExecutionFactory.create(jquery, vModel);
		ResultSet results = qexec.execSelect();
		// ResultSetFormatter.out(System.out, results, jquery);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		ResultSetFormatter.outputAsJSON(outputStream, results);
		String json = new String(outputStream.toByteArray());
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

		List<String> vars = jquery.getResultVars();
		System.out.println(vars.toString());
		System.out.println(jquery.getQueryPattern());
		List<GrammarProp> grammarList = new ArrayList<GrammarProp>();

		ElementWalker.walk(jquery.getQueryPattern(), new ElementVisitorBase() {

			public void visit(ElementPathBlock el) {

				// when it's a block of triples, add in some triple

				for (String v : vars) {

					Iterator<TriplePath> triples = el.patternElts();
					boolean onlySubject = true;
					String prop = "";
					Stack<String> propTemp = new Stack<String>();
					int index = 0;
					int counter = 0;
					while (triples.hasNext()) {
						counter++;
						TriplePath t = triples.next();

						if (v.matches(t.getObject().toString().replace("?", ""))) {
							onlySubject = false;

							GrammarProp gp = new GrammarProp(v,
									t.getPredicate().toString().replace("http://example.com/prop/", ""), false);
							grammarList.add(gp);
							break;
						} else {

							propTemp.push(t.getPredicate().toString().replace("http://example.com/prop/", ""));
						}

						if (v.matches(t.getSubject().toString().replace("?", ""))) {
							index = counter;
						}

					}
					counter = 0;
					if (onlySubject) {

						GrammarProp gp = new GrammarProp(v, propTemp.get(index - 1), true);
						grammarList.add(gp);
					}

					System.out.println(propTemp);
				}

				System.out.println("Object: ");
				for (GrammarProp g : grammarList) {
					System.out.println(g.getName() + " : " + g.getProp() + " : " + g.getSubject());
				}

			}
		});

		QueryExecution qexec = QueryExecutionFactory.create(jquery, vModel);

		ResultSet results = qexec.execSelect();

		ArrayList<ChessGame> list = new ArrayList<ChessGame>();
		int queryType = 0;
		for (; results.hasNext();) {
			QuerySolution soln = results.nextSolution();

			RDFNode node = null;
			ChessGame game = new ChessGame();
			
			
			for (int i = 0; i < grammarList.size(); i++) {
				GrammarProp gp = grammarList.get(i);

				node = soln.get(gp.getName());
				String prop = gp.getProp();

				

				if (gp.isSubject) {
					switch (prop) {
					case "game":
						game.setNode(node.toString());
						queryType = 0;
						break;
					case "event":
						game.setNode(node.toString());
						queryType = 0;
						break;
					case "site":
						game.setNode(node.toString());
						queryType = 0;
						break;
					case "date":
						game.setNode(node.toString());
						queryType = 0;
						break;
					case "round":
						game.setNode(node.toString());
						queryType = 0;
						break;
					case "white":
						game.setNode(node.toString());
						queryType = 0;
						break;
					case "black":
						game.setNode(node.toString());
						queryType = 0;
						break;
					case "opening":
						game.setNode(node.toString());
						queryType = 0;
						break;
					case "eco":
						game.setNode(node.toString());
						queryType = 0;
						break;
					case "result":
						game.setNode(node.toString());
						queryType = 0;
						break;
					default: // TODO weitere Resscurcen einarbeiten: Züge,
								// Spiele Eröffnungen
					}
				} else {
					switch (prop) {
					case "event":
						game.setEvent(node.toString());
						break;
					case "site":
						game.setSite(node.toString());
						break;
					case "date":
						game.setDate(node.toString());
						break;
					case "round":
						game.setRound(node.toString());
						break;
					case "white":
						game.setWhite(node.toString());
						break;
					case "black":
						game.setBlack(node.toString());
						break;
					case "opening":
						game.setOpening(node.toString());
						break;
					case "eco":
						game.setEco(node.toString());
						break;
					case "result":
						game.setResult(node.toString());
						break;
					default: // TODO weitere Eigenschaften einarbeiten: Züge,
								// Spiele Eröffnungen
					}

				}

				
			}
			list.add(game);
			// System.out.println(pattern.get(0).getSubject());

			// Resource r = soln.getResource("VarR") ; // Get a result variable
			// - must be a resource
			// Literal l = soln.getLiteral("VarL") ; // Get a result variable -
			// must be a literal
		}

		// ResultSetFormatter.out(System.out, results, jquery);

		// ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		// ResultSetFormatter.outputAsJSON(outputStream, results);
		// String json = new String(outputStream.toByteArray());
		System.out.println("============================\n");

		String json = new Gson().toJson(list);
		
		if(queryType == 0){
			json = "{ \"games\" : "+ json + "}";
		}
		
	
		return json;

	}

	public static void main(String[] args) {
		VirtuosoQuery virtQuery = new VirtuosoQuery();
		String json = virtQuery.getCustomResult(
				"select ?game ((COUNT(?moves)/2) as ?nr) WHERE {?game prop:black 'Wilhelm Steinitz'. ?game prop:moves ?moves} GROUP BY ?game ORDER BY DESC(?nr)");

		System.out.println(json);

		// VirtuosoQuery virtQuery = new VirtuosoQuery("select distinct ?game
		// where {?game ?s ?a} LIMIT 10");
		//
		// String query = virtQuery.getQuery();
		//
		// ConnectVirtuoso conn = new ConnectVirtuoso();
		// VirtModel vModel = conn.connect();
		//
		//
		// System.out.println("=====================");
		// System.out.println("Exec: "+ query);
		// Query jquery = QueryFactory.create(query) ;
		// QueryExecution qexec = QueryExecutionFactory.create(jquery, vModel) ;
		// ResultSet results = qexec.execSelect();
		// ResultSetFormatter.out(System.out, results, jquery);
		// qexec.close();
		// System.out.println("============================\n");
	}

	class GrammarProp {
		private String name;
		private String prop;
		private boolean isSubject;

		public GrammarProp(String name, String prop, boolean isSubject) {
			this.name = name;
			this.prop = prop;
			this.isSubject = isSubject;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getProp() {
			return prop;
		}

		public void setProp(String prop) {
			this.prop = prop;
		}

		public boolean getSubject() {
			return isSubject;
		}

		public void setSubject(boolean isSubject) {
			this.isSubject = isSubject;
		}

	}

}