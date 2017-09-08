package de.daug.semanticchess.Parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import de.daug.semanticchess.Parser.NewParser.Pair;
import de.daug.semanticchess.Parser.Helper.Classes;
import de.daug.semanticchess.Parser.Helper.Entity;
import de.daug.semanticchess.Parser.Helper.Resource;

/**
 * assign a sequence code to a sparql query
 */
public class Allocator {
	
	private String sequenceCode;
	private String sparqlQuery;

	private List<Entity> entities = new ArrayList<Entity>();
	private List<Classes> classes = new ArrayList<Classes>();
	private List<Resource> resources = new ArrayList<Resource>();
	private String options;
	
	
	/**
	 * constructor
	 * allocates the given sequence code to a sparql query
	 * @param query: user question
	 */
	public Allocator(String query){
		Parser parser = new Parser(query);
		
		this.sequenceCode = parser.getSequence();
		this.entities = parser.getEntities();
		this.classes = parser.getClasses();
		this.resources = parser.getResources();
		this.options = parser.getOptions();
		
		allocateSequence();
	}
	
	/**
	 * replace all placeholders in the sparql query with found entities and properties
	 * @param query
	 * @return
	 */
	private String replaceCodes(String sparql){
		for(Entity e : entities){
			sparql = sparql.replaceAll(e.getEntityId(), e.getEntityName());
			sparql = sparql.replaceAll(e.getPropertyId(), e.getPropertyName());
		}
		for(Classes c : classes){
			sparql = sparql.replaceAll(c.getClassesId(), c.getClassesName());
			sparql = sparql.replaceAll(c.getPropertyId(), c.getPropertyName());
		}
		for(Resource r : resources){
			sparql = sparql.replaceAll(r.getResourceId(), r.getResourceName());
		}
		
		return sparql;
	}
	
	/**
	 * allocate sequence code
	 */
	private void allocateSequence(){
		String sparqlQuery = "";
		System.out.println(this.sequenceCode);
		switch(this.sequenceCode){
			case "_0010":
				sparqlQuery = replaceCodes(Sequences._0010);
				break;
			case "_0020":
				sparqlQuery = replaceCodes(Sequences._0020);
				break;
			case "_0030":
				sparqlQuery = replaceCodes(Sequences._0030);
				break;
			case "_0040":
				sparqlQuery = replaceCodes(Sequences._0040);
				break;
			case "_0100":
				sparqlQuery = replaceCodes(Sequences._0100);
				break;
			case "_0110":
				sparqlQuery = replaceCodes(Sequences._0110);
				break;
			case "_0120":
				sparqlQuery = replaceCodes(Sequences._0120);
				break;
			case "_0130":
				sparqlQuery = replaceCodes(Sequences._0130);
				break;
			case "_0140":
				sparqlQuery = replaceCodes(Sequences._0140);
				break;
			case "_0200":
				sparqlQuery = replaceCodes(Sequences._0200);
				break;
			case "_0210":
				sparqlQuery = replaceCodes(Sequences._0210);
				break;
			case "_0220":
				sparqlQuery = replaceCodes(Sequences._0220);
				break;
			case "_0230":
				sparqlQuery = replaceCodes(Sequences._0230);
				break;
			case "_0240":
				sparqlQuery = replaceCodes(Sequences._0240);
				break;
			case "_1010":
				sparqlQuery = replaceCodes(Sequences._1010);
				break;
			case "_1020":
				sparqlQuery = replaceCodes(Sequences._0020);
				break;
			case "_1030":
				sparqlQuery = replaceCodes(Sequences._0030);
				break;
			case "_1040":
				sparqlQuery = replaceCodes(Sequences._1040);
				break;
			case "_1100":
				sparqlQuery = replaceCodes(Sequences._1100);
				break;
			case "_1110":
				sparqlQuery = replaceCodes(Sequences._1110);
				break;
			case "_1120":
				sparqlQuery = replaceCodes(Sequences._1120);
				break;
			case "_1130":
				sparqlQuery = replaceCodes(Sequences._1130);
				break;
			case "_1140":
				sparqlQuery = replaceCodes(Sequences._1140);
				break;
			case "_1200":
				sparqlQuery = replaceCodes(Sequences._1200);
				break;
			case "_1210":
				sparqlQuery = replaceCodes(Sequences._1210);
				break;
			case "_1220":
				sparqlQuery = replaceCodes(Sequences._1220);
				break;
			case "_1230":
				sparqlQuery = replaceCodes(Sequences._1230);
				break;
			case "_1240":
				sparqlQuery = replaceCodes(Sequences._1240);
				break;
			case "_0021":
				sparqlQuery = replaceCodes(Sequences._0021);
				break;
			case "_0041":
				sparqlQuery = replaceCodes(Sequences._0041);
				break;
			case "_0061":
				sparqlQuery = replaceCodes(Sequences._0061);
				break;
			case "_0221":
				sparqlQuery = replaceCodes(Sequences._0221);
				break;
			case "_0241":
				sparqlQuery = replaceCodes(Sequences._0241);
				break;
			case "_0261":
				sparqlQuery = replaceCodes(Sequences._0261);
				break;
			case "_1021":
				sparqlQuery = replaceCodes(Sequences._1021);
				break;
			case "_1041":
				sparqlQuery = replaceCodes(Sequences._1041);
				break;
			case "_1061":
				sparqlQuery = replaceCodes(Sequences._1061);
				break;
			case "_1201":
				sparqlQuery = replaceCodes(Sequences._1201);
				break;
			case "_1221":
				sparqlQuery = replaceCodes(Sequences._1221);
				break;
			case "_1241":
				sparqlQuery = replaceCodes(Sequences._1241);
				break;
			case "_1261":
				sparqlQuery = replaceCodes(Sequences._1261);
				break;
			default:
				break;
		}
		this.sparqlQuery = sparqlQuery + " " + options;
	}
	
	
	/**
	 * @return sparql query
	 */
	public String getSparqlQuery() {
		return sparqlQuery;
	}

	/**
	 * set the sparql query
	 * @param sparqlQuery
	 */
	public void setSparqlQuery(String sparqlQuery) {
		this.sparqlQuery = sparqlQuery;
	}

	/**
	 * for testing
	 * @param args
	 */
	public static void main(String[] args){
		Allocator alloc = new Allocator("1st game by Magnus Carlsen");
		System.out.println(alloc.getSparqlQuery());
		
	}
	
}