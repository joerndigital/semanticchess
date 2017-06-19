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

public class Annotations {

	// attributes
	private String query = "";
	private String language = "";
	private HashMap<String, List<String>> queryClasses = null;
	private HashMap<String, List<String>> queryProperties = null;

	public Annotations(String query, String language) {
		this.query = query;
		this.language = language;
		// init();
	}

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

	private void initIndexDBO_classes() {

		queryClasses = new HashMap<String, List<String>>();
		IndexDBO_classes classes = new IndexDBO_classes();
		String[] words = query.split("\\W+");

		for (String word : words) {
			List<String> wordClasses = classes.search(word);
			queryClasses.put(word, wordClasses);
		}

		/*
		 * Iterator it = queryClasses.entrySet().iterator();
		 * 
		 * while (it.hasNext()) { HashMap.Entry pair = (HashMap.Entry)
		 * it.next(); System.out.println(pair.getKey() + " = " +
		 * pair.getValue()); it.remove(); // avoids a
		 * ConcurrentModificationException }
		 */
		// https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap

	}

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

	public String getQuery() {
		return query;
	}

	public String getLanguage() {
		return language;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public static void main(String[] args) {

		Annotations annotate = new Annotations("win can come", "en");
		//annotate.initIndexDBO_classes();
		annotate.initIndexDBO_properties();

	}
}