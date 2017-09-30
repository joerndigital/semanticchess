package de.daug.semanticchess.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.commons.text.similarity.JaccardDistance;
//import org.apache.commons.text.similarity.LongestCommonSubsequenceDistance;

public class StringSimilarity {

	private String variable;
	public String query;
	private ResultSet resultSet;

	public StringSimilarity() {

	}

	public String setQuery(String property) {
		switch (property) {
		case "prop:white":
		case "prop:black":
		case "prop:white|prop:black":
			this.variable = "player";
			return this.query = "SELECT DISTINCT ?player WHERE {?game prop:white|prop:black ?player. ?game prop:whiteelo|prop:blackelo ?elo.} ORDER BY DESC(?elo)";
		case "prop:event":
			this.variable = "event";
			return this.query = "SELECT DISTINCT ?event WHERE {?game prop:event ?event. ?game prop:date ?date.} ORDER BY ASC(?date)";
		case "cont:openingName":
			this.variable = "openingName";
			return this.query = "SELECT DISTINCT ?openingName WHERE {?res cont:openingName ?openingName. ?res cont:openingCode ?eco} ORDER BY ?eco";
		case "prop:site":
			this.variable = "site";
			return this.query = "SELECT DISTINCT ?site WHERE {?game prop:site ?site.} ORDER BY ?site";
		case "prop:eco":
			this.variable = "eco";
			return this.query = "SELECT DISTINCT ?site WHERE {?game prop:eco ?eco.} ORDER BY ?eco";
		}

		return this.query = "";
	}

	public List<String> exactMatch(String entity) {
		List<String> foundEntities = new ArrayList<String>();

		SparqlVirtuoso sQuery = new SparqlVirtuoso();
		this.resultSet = sQuery.getResultSet(this.query);

		for (; this.resultSet.hasNext();) {
			QuerySolution soln = this.resultSet.next();
			if (soln.getLiteral(this.variable).getString().equals(entity)) {

				foundEntities.add(entity.replaceAll("\'", "\\\\'"));
			}

		}

		return foundEntities;
	}

	public ArrayList<String> subStringMatch(String entity) {
		ArrayList<String> foundEntities = new ArrayList<String>();

		SparqlVirtuoso sQuery = new SparqlVirtuoso();

		this.resultSet = sQuery.getResultSet(this.query);

		for (; this.resultSet.hasNext();) {
			QuerySolution soln = this.resultSet.next();
			if (soln.getLiteral(this.variable).getString().indexOf(entity) > -1) {

				foundEntities.add("'" + soln.getLiteral(this.variable).getString().replaceAll("\'", "\\\\'") + "'");
			}

		}

		return foundEntities;
	}

	public String distanceMatch(String entity) {
		String foundEntity = "";
		
		SparqlVirtuoso sQuery = new SparqlVirtuoso();

		this.resultSet = sQuery.getResultSet(this.query);
		double distance = 999;
		// LongestCommonSubsequenceDistance lcsd = new
		// LongestCommonSubsequenceDistance();
		JaccardDistance jd = new JaccardDistance();
		HashMap<String,Double> candidatesList = new HashMap<String,Double>();
		
		for (; this.resultSet.hasNext();) {
			QuerySolution soln = this.resultSet.next();
			String candidateEntity = soln.getLiteral(this.variable).getString();
			double candidateDistance = jd.apply(entity, candidateEntity);
			
			
//			if(candidateEntity.indexOf(entity) > -1){
//				System.out.println(candidateEntity);
//				System.out.println(candidateDistance);
//				System.out.println(candidateEntity.indexOf(entity));
//			}
			
			
			// if(distance > lcsd.apply(entity, candidateEntity)){
			//
			// distance = lcsd.apply(entity, candidateEntity);
			// System.out.println(distance);
			// foundEntity = candidateEntity;
			//
			//
			// System.out.println("LCSD " +candidateEntity);
			// }
			
			
			
			if (candidateEntity.indexOf(entity) > -1) {
				candidatesList.put(candidateEntity, candidateDistance);
				//System.out.println(candidatesList.toString());
			}
			

			if (distance > candidateDistance) {

				distance = candidateDistance;
				// System.out.println(distance);
				foundEntity = candidateEntity;
				// System.out.println("JD " + candidateEntity);
			}

			

			


		}
		
		if(!candidatesList.isEmpty()){
			Entry<String, Double> min = null;
			for (Entry<String, Double> entry : candidatesList.entrySet()) {
			    if (min == null || min.getValue() > entry.getValue()) {
			        min = entry;
			    }
			}
			
			return "'" + min.getKey().replaceAll("\'", "\\\\\\\\'") + "'"; 
		}
		
		return "'" + foundEntity.replaceAll("\'", "\\\\\\'") + "'";
	}

	public String getQuery() {
		return this.query;
	}

	public static void main(String[] args) {
		StringSimilarity similar = new StringSimilarity();
		similar.setQuery("cont:openingName");
		System.out.println(similar.distanceMatch("Kings Pawn"));

	}

}