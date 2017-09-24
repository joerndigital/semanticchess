package de.daug.semanticchess.Parser;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.query.QueryParseException;

import de.daug.semanticchess.Database.StringSimilarity;
import de.daug.semanticchess.Parser.Helper.Classes;
import de.daug.semanticchess.Parser.Helper.Entity;
import de.daug.semanticchess.Parser.Helper.Filters;
import de.daug.semanticchess.Parser.Helper.Values;

/**
 * assigns a sequence code to a sparql query
 */
public class Allocator {

	private String sequenceCode;
	private String sparqlQuery;

	private List<Entity> entities = new ArrayList<Entity>();
	private List<Classes> classes = new ArrayList<Classes>();
	private String options;
	private Filters filters;
	private StringSimilarity similar;

	/**
	 * constructor allocates the given sequence code to a sparql query
	 * 
	 * @param query:
	 *            user question
	 */
	public Allocator(String query) {
		Parser parser = new Parser(query);

		this.sequenceCode = parser.getSequence();
		this.entities = parser.getEntities();
		this.classes = parser.getClasses();
		this.options = parser.getOptions().toString();
		this.filters = parser.getFilters();
		this.similar = new StringSimilarity();
		// allocateSequence();
	}

	/**
	 * replace all placeholders in the sparql query with found entities and
	 * properties
	 * 
	 * @param query
	 * @return
	 */
	public String replaceOnly(String sparql) {

		for (Entity e : entities) {
			sparql = sparql.replaceAll(e.getEntityId(), e.getEntityName());
			sparql = sparql.replaceAll(e.getPropertyId(), e.getPropertyName());
			sparql = sparql.replaceAll(e.getResourceId(), e.getResourceName());
		}
		for (Classes c : classes) {
			sparql = sparql.replaceAll(c.getClassesId(), c.getClassesName());
			sparql = sparql.replaceAll(c.getPropertyId(), c.getPropertyName());
			sparql = sparql.replaceAll(c.getResourceId(), c.getResourceName());
		}

		sparql = sparql.replace("FILTER", this.filters.getFilterStr());

		return sparql;
	}

	public String regexEntities(String sparql) {
		int counter = 1;

		for (Entity e : entities) {
			String value = "?value" + counter;
			sparql = sparql.replaceAll(e.getEntityId(), value);
			filters.addRegex(value, e.getEntityName(), true);
			counter += 1;

			sparql = sparql.replaceAll(e.getPropertyId(), e.getPropertyName());
			sparql = sparql.replaceAll(e.getResourceId(), e.getResourceName());
			System.out.println(sparql);
		}

		for (Classes c : classes) {
			sparql = sparql.replaceAll(c.getClassesId(), c.getClassesName());
			sparql = sparql.replaceAll(c.getPropertyId(), c.getPropertyName());
			sparql = sparql.replaceAll(c.getResourceId(), c.getResourceName());
		}

		sparql = sparql.replace("FILTER", this.filters.getFilterStr());

		return sparql;
	}

	public String subStringEntities(String sparql) {

		Values values = new Values();

		sparql = sparql.replaceFirst("\\{", "\\{VALUE_PLACEHOLDER ");
		int counter = 1;

		for (Entity e : entities) {

			similar.setQuery(e.getPropertyName());

			ArrayList<String> subStrEntities = new ArrayList<String>();

			try {
				subStrEntities = similar.subStringMatch(e.getEntityName().replaceAll("'", ""));
			} catch (QueryParseException err) {

			}

			if (subStrEntities.size() > 0) {
				values.setValueVars("?value" + counter);
				sparql = sparql.replaceAll(e.getEntityId(), "?value" + counter);
				values.addResult(subStrEntities);
				counter++;
			}

			else {
				sparql = sparql.replaceAll(e.getEntityId(), e.getEntityName());
			}

			sparql = sparql.replaceAll(e.getPropertyId(), e.getPropertyName());
			sparql = sparql.replaceAll(e.getResourceId(), e.getResourceName());
		}

		String tempStr = "";
		values.generatePermutations(values.getResults(), Values.getPermutation(), 0, tempStr);
		sparql = sparql.replace("VALUE_PLACEHOLDER", values.toString());

		for (

		Classes c : classes) {
			sparql = sparql.replaceAll(c.getClassesId(), c.getClassesName());
			sparql = sparql.replaceAll(c.getPropertyId(), c.getPropertyName());
			sparql = sparql.replaceAll(c.getResourceId(), c.getResourceName());
		}

		sparql = sparql.replace("FILTER", this.filters.getFilterStr());

		return sparql;
	}

	public String distanceEntities(String sparql) {

		for (Entity e : entities) {
			similar.setQuery(e.getPropertyName());

			try {
				String subStrEntity = similar.distanceMatch(e.getEntityName().replaceAll("'", ""));

				sparql = sparql.replaceAll(e.getEntityId(), subStrEntity);
			} catch (QueryParseException err) {
				sparql = sparql.replaceAll(e.getEntityId(), e.getEntityName());
			}

			sparql = sparql.replaceAll(e.getPropertyId(), e.getPropertyName());
			sparql = sparql.replaceAll(e.getResourceId(), e.getResourceName());
		}

		for (Classes c : classes) {
			sparql = sparql.replaceAll(c.getClassesId(), c.getClassesName());
			sparql = sparql.replaceAll(c.getPropertyId(), c.getPropertyName());
			sparql = sparql.replaceAll(c.getResourceId(), c.getResourceName());
		}
		
		sparql = sparql.replace("FILTER", this.filters.getFilterStr());

		return sparql;
	}

	/**
	 * allocate sequence code
	 */
	public void allocateSequence() {
		String sparqlQuery = "";
		System.out.println(this.sequenceCode);
		switch (this.sequenceCode) {
		case "_010":
			sparqlQuery = Sequences._010;
			break;
		case "_020":
			sparqlQuery = Sequences._020;
			break;
		case "_030":
			sparqlQuery = Sequences._030;
			break;
		case "_040":
			sparqlQuery = Sequences._040;
			break;
		case "_100":
			sparqlQuery = Sequences._100;
			break;
		case "_110":
			sparqlQuery = Sequences._110;
			break;
		case "_120":
			sparqlQuery = Sequences._120;
			break;
		case "_130":
			sparqlQuery = Sequences._130;
			break;
		case "_140":
			sparqlQuery = Sequences._140;
			break;
		case "_200":
			sparqlQuery = Sequences._200;
			break;
		case "_210":
			sparqlQuery = Sequences._210;
			break;
		case "_220":
			sparqlQuery = Sequences._220;
			break;
		case "_230":
			sparqlQuery = Sequences._230;
			break;
		case "_240":
			sparqlQuery = Sequences._240;
			break;
		case "_021":
			sparqlQuery = Sequences._021;
			break;
		case "_041":
			sparqlQuery = Sequences._041;
			break;
		case "_061":
			sparqlQuery = Sequences._061;
			break;
		case "_201":
			sparqlQuery = Sequences._201;
			break;
		case "_221":
			sparqlQuery = Sequences._221;
			break;
		case "_241":
			sparqlQuery = Sequences._241;
			break;
		case "_261":
			sparqlQuery = Sequences._261;
			break;
		case "_401":
			sparqlQuery = Sequences._401;
			break;
		case "_421":
			sparqlQuery = Sequences._421;
			break;
		case "_441":
			sparqlQuery = Sequences._441;
			break;
		case "_461":
			sparqlQuery = Sequences._461;
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
	 * 
	 * @param sparqlQuery
	 */
	public void setSparqlQuery(String sparqlQuery) {
		this.sparqlQuery = sparqlQuery;

	}

	/**
	 * for testing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Allocator alloc = new Allocator("Show me games between Wiliam Steinitz and Johannes Zukertort with elo of 2016.");

		alloc.allocateSequence();
		System.out.println(alloc.distanceEntities(alloc.getSparqlQuery()));

	}

}