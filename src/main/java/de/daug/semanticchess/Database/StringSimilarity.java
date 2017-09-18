package de.daug.semanticchess.Database;

import java.io.ByteArrayOutputStream;

public class StringSimilarity{
	
	private String property;
	private String entity;
	private ByteArrayOutputStream resultSet;
	
	public StringSimilarity(String property, String entity){
		this.property = property;
		this.entity = entity;
		
		String query = setQuery(property);
		
		SparqlVirtuoso sQuery = new SparqlVirtuoso();
		this.resultSet = sQuery.getResultSet(query);
	}
	
	
	public String setQuery(String property){
		switch(property){
			case "white":
			case "black":
			case "white|prop:black":
				return "SELECT ?player WHERE {?game prop:white|prop:black ?player.}";
			case "event":
				return "SELECT ?event WHERE {?game prop:event ?event.}";
			case "opening":
				return "SELECT ?opening WHERE {?game prop:opening ?opening.}";
			case "site":
				return "SELECT ?site WHERE {?game prop:site ?site.}";
		}
		
		
		return "";
	}
	
	public void exactMatch(){
		
	}
	
	public void subStringMatch(){
		
	}
	
	public void distanceMatch(){
		
	}
	
	
}