package de.daug.semanticchess;

//TODO comment code
//TODO fox entities to object

import org.aksw.qa.annotation.index.IndexDBO_classes;
import org.aksw.qa.annotation.index.IndexDBO_properties;
import org.aksw.qa.annotation.spotter.ASpotter;
import org.aksw.qa.annotation.spotter.Fox;
import org.aksw.qa.annotation.spotter.Spotlight;
import org.aksw.qa.annotation.util.NifEverything;
import org.aksw.qa.commons.datastructure.Entity;
import org.apache.jena.rdf.model.Resource;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.aksw.hawk.datastructures.HAWKQuestion;

/**
 * @desc Analyzes the input question of the user and finds entities, classes and
 *       properties
 * @author jorn-henningdaug
 *
 */
public class Annotations {

	// attributes
	private String query = "";
	private String language = "";
	private HashMap<String, List<String>> queryClasses = null;
	private HashMap<String, List<String>> queryProperties = null;

	/**
	 * constructor
	 * 
	 * @param query:
	 *            input question
	 * @param language:
	 *            choosen query language
	 */
	public Annotations(String query, String language) {
		this.query = query;
		this.language = language;
		// init();
	}

	/**
	 * gets entities fox.aksw.org
	 */
	public void initFox() {
		HAWKQuestion q = new HAWKQuestion();
		q.getLanguageToQuestion().put(this.language, this.query);
		ASpotter fox = new Fox();
		q.setLanguageToNamedEntites(fox.getEntities(q.getLanguageToQuestion().get(this.language)));
		for (String key : q.getLanguageToNamedEntites().keySet()) {
			System.out.println(key);
			for (Entity entity : q.getLanguageToNamedEntites().get(key)) {
				System.out.println(
						"\t" + entity.getLabel() + " ->" + entity.getType() + entity.getPosTypesAndCategories());
				for (Resource r : entity.getPosTypesAndCategories()) {

					System.out.println("\t\tpos: " + r.getLocalName());
				}
				for (Resource r : entity.getUris()) {
					System.out.println("\t\turi: " + r);
				}
			}
		}
	}

	/**
	 * gets classes like 'art' and 'dog'
	 */
	private void initIndexDBO_classes() {

		queryClasses = new HashMap<String, List<String>>();
		IndexDBO_classes classes = new IndexDBO_classes();
		String[] words = query.split("\\W+");

		for (String word : words) {
			List<String> wordClasses = classes.search(word);
			queryClasses.put(word, wordClasses);
		}

		// Iterator it = queryClasses.entrySet().iterator();
		//
		// while (it.hasNext()) { HashMap.Entry pair = (HashMap.Entry)
		// it.next(); System.out.println(pair.getKey() + " = " +
		// pair.getValue()); it.remove(); // avoids a
		// ConcurrentModificationException
		// }

		// https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap

	}

	/**
	 * gets properties like 'win', 'come' and 'can'
	 */
	private void initIndexDBO_properties() {
		queryProperties = new HashMap<String, List<String>>();
		IndexDBO_properties properties = new IndexDBO_properties();
		String[] words = query.split("\\W+");

		for (String word : words) {
			List<String> wordProperties = properties.search(word);
			queryProperties.put(word, wordProperties);
		}

		/*
		 * Iterator it = queryProperties.entrySet().iterator();
		 * 
		 * while (it.hasNext()) { HashMap.Entry pair = (HashMap.Entry)
		 * it.next(); System.out.println(pair.getKey() + " = " +
		 * pair.getValue()); it.remove(); // avoids a
		 * ConcurrentModificationException }
		 */
		// https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
	}

	/**
	 * @return user query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @return choosen language for analysis
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param query:
	 *            sets a new query
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @param language:
	 *            seta a new language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * main method for testing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Annotations annotate = new Annotations("Which buildings in art dog style did Shreve, Lamb and Harmon design?",
				"en");
		annotate.initIndexDBO_classes();
		// annotate.initIndexDBO_properties();

	}
}