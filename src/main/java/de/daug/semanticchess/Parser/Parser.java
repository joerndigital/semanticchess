package de.daug.semanticchess.Parser;

import java.util.ArrayList;
import java.util.List;

import de.daug.semanticchess.Annotation.PosTagger;
import de.daug.semanticchess.Annotation.Token;
import edu.stanford.nlp.ling.WordTag;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.process.Morphology;

/**
 * parses the user query to a sequence to find a suitable sparql query
 */
public class Parser {
	private static List<Token> tokens;
	private static String query = "Show me games with an player who comes two the second round";
	

	public static void main(String[] args) {
		
	}



}