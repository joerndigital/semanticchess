package de.daug.semanticchess.Parser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Allocator {
	
	private String sequenceCode;
	private HashMap<Integer, String[]> sequence = new HashMap<Integer, String[]>();
	private String sparqlQuery;
	
	public Allocator(String query){
		
		Parser parser = new Parser(query);
		this.sequenceCode = parser.getSequenceCode();
		this.sequence = parser.getSequence();
		allocateSequence();
	}
	
	private String replaceCodes(String query){
		
		Iterator<Entry<Integer, String[]>> iter = this.sequence.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<Integer, String[]> pair = (Map.Entry<Integer, String[]>) iter.next();
			String[] code = (String[]) pair.getValue();
			System.out.println(code[0] +" "+ code[1]);
			query = query.replaceAll(code[0], code[1]);
		}
		return query;
	}
	
	private void allocateSequence(){
		String sparqlQuery = "";
		//System.out.println(this.sequenceCode);
		switch(this.sequenceCode){
			case "E":
				sparqlQuery = replaceCodes(Sequences.E);
				break;
			case "EE":
				sparqlQuery = replaceCodes(Sequences.EE);
				break;
			case "PM":
				sparqlQuery = replaceCodes(Sequences.MP);
				break;
			case "PZ":
				sparqlQuery = replaceCodes(Sequences.PZ);
				break;
			case "PL":
				sparqlQuery = replaceCodes(Sequences.LP);
				break;
			case "EPR":
				sparqlQuery = replaceCodes(Sequences.EPR);
				break;
		}
		this.sparqlQuery = sparqlQuery;
	}
	
	
	
	public String getSparqlQuery() {
		return sparqlQuery;
	}


	public void setSparqlQuery(String sparqlQuery) {
		this.sparqlQuery = sparqlQuery;
	}


	public static void main(String[] args){
		Allocator alloc = new Allocator("Show me games from the DSB Kongress.");
		System.out.println(alloc.getSparqlQuery());
	}
	
}