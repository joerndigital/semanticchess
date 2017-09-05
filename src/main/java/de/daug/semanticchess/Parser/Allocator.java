package de.daug.semanticchess.Parser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import de.daug.semanticchess.Parser.NewParser.Pair;

/**
 * assign a sequence code to a sparql query
 */
public class Allocator {
	
	private String sequenceCode;
	private String sparqlQuery;
	private List<Pair> entities;
	private List<Pair> properties;
	private List<Pair> options;
	private List<Pair> optionNames;
	private List<Pair> classes;
	private List<Pair> classProperties;
	
	/**
	 * constructor
	 * allocates the given sequence code to a sparql query
	 * @param query: user question
	 */
	public Allocator(String query){
		NewParser parser = new NewParser(query);
		this.sequenceCode = "_" + parser.getClassSequence() + parser.getSequence() + parser.getUnionSequence();
		this.entities = parser.getEntities();
		this.properties = parser.getProperties();
		this.options = parser.getOptions();
		this.optionNames = parser.getOptionNames();
		this.classes = parser.getClasses();
		this.classProperties = parser.getClassProperties();

		allocateSequence();
	}
	
	/**
	 * replace all placeholders in the sparql query with found entities and properties
	 * @param query
	 * @return
	 */
	private String replaceCodes(String sparql){
		for(int i = 0; i < entities.size(); i++){
			sparql = sparql.replaceAll(entities.get(i).getLabel(), entities.get(i).getValue());
			sparql = sparql.replaceAll(properties.get(i).getLabel(), properties.get(i).getValue());
		}
		for(int i = 0; i < options.size(); i++){
			sparql = sparql.replaceAll(options.get(i).getLabel(), options.get(i).getValue());
			sparql = sparql.replaceAll(optionNames.get(i).getLabel(), optionNames.get(i).getValue());
		}
		for(int i = 0; i < classes.size(); i++){
			sparql = sparql.replaceAll(classes.get(i).getLabel(), classes.get(i).getValue());
			sparql = sparql.replaceAll(classProperties.get(i).getLabel(), classProperties.get(i).getValue());
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
			case "_010":
				sparqlQuery = replaceCodes(Sequences._010);
				break;
			case "_020": 
				sparqlQuery = replaceCodes(Sequences._020);
				break;
			case "_030": 
				sparqlQuery = replaceCodes(Sequences._030);
				break;
			case "_011":
				sparqlQuery = replaceCodes(Sequences._011);
				break;
			case "_021": 
				sparqlQuery = replaceCodes(Sequences._021);
				break;
			case "_031": 
				sparqlQuery = replaceCodes(Sequences._031);
				break;
			case "_100": 
				sparqlQuery = replaceCodes(Sequences._100);
				break;
			default:
				break;
		}
		this.sparqlQuery = sparqlQuery;
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
		Allocator alloc = new Allocator("Show me all tournaments in the database");
		System.out.println(alloc.getSparqlQuery());
	}
	
}