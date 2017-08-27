package de.daug.semanticchess.Parser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import de.daug.semanticchess.Annotation.PosTagger;
import de.daug.semanticchess.Annotation.PosTagger.Token;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class Parser {

	private List<Token> tokens;
	private HashMap<Integer, String[]> sequence = new HashMap<Integer, String[]>();
	private String sequenceCode = "";
	private ChessVocabulary vocabs;

	private int allCounter = 0;
	private int entityCounter = 0;
	private int propertyCounter = 0;
	private int miscCounter = 0;
	private int locationCounter = 0;
	private int dateCounter = 0;
	private int numberCounter = 0;
	private int ordinalCounter = 0;
	private int organizationCounter = 0;
	
	private String entity = "E_";
	private String misc = "M_";
	private String property = "P_";
	private String location = "L_";
	private String date = "D_";
	private String number = "N_";
	private String ordinal = "O_";
	private String organization = "Z_";
	
	private String nerEntity = "PERSON";
	private String nerMisc = "MISC";
	private String nerLocation = "LOCATION";
	private String nerDate = "DATE";
	private String nerNumber = "NUMBER";
	private String nerOrdinal = "ORDINAL";
	private String nerOrganization = "ORGANIZATION";

	public Parser(String query) {
		this.tokens = initTokens(query);
		ChessVocabulary cv = new ChessVocabulary();
		cv.fillProperties();
		cv.inverseProperties();
		this.vocabs = cv;
		getStanfordEntities(getTokens());
		setSequenceCode(getSequence());
		System.out.println(getSequenceCode());
	}

	public static void main(String[] args) {
		
		Parser p = new Parser("Show me games from the DSB Kongress.");
		// p.getStanfordEntities(p.getTokens());
		// p.getCustomClass(p.getTokens());
		// p.setSequenceCode(p.getSequence());
		System.out.println(p.getSequenceCode());

		Iterator<Entry<Integer, String[]>> it = p.getSequence().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, String[]> pair = (Map.Entry<Integer, String[]>) it.next();
			int key = (int) pair.getKey();
			String[] seq = (String[]) pair.getValue();
			System.out.println(key + " = " + seq[0] + " " + seq[1]);
			it.remove(); // avoids a ConcurrentModificationException
		}
	}

	private List<Token> initTokens(String query) {
		PosTagger tagger = new PosTagger();
		// initialize pipeline to use it more often, does not have to load again
		// for a new query
		StanfordCoreNLP pipeline = tagger.getPipeline();
		// select distinct * where { ?person a dbo:ChessPlayer. ?person
		// foaf:name ?name. FILTER regex(?name, 'müller', 'i') }
		tagger.setQuery(query);
		tagger.setDocument(tagger.setAnnotator(pipeline, tagger.getQuery()));
		tagger.initAnnotations();

		List<Token> tokens = tagger.getTokens();

		return tokens;
	}

	private void getStanfordEntities(List<Token> tokens) {
		// TODO: implement FOX-java
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i).getNe().equals(nerEntity)) {
				entityCounter +=1;
				i = checkTypes(i,entityCounter, nerEntity, entity);
			}
			if (tokens.get(i).getNe().equals(nerMisc)) {
				miscCounter += 1;
				i = checkTypes(i,miscCounter, nerMisc, misc);	
			}
			if (tokens.get(i).getNe().equals(nerLocation)) {
				locationCounter += 1;
				i = checkTypes(i,locationCounter, nerLocation, location);
			}
			if (tokens.get(i).getNe().equals(nerDate)) {
				dateCounter += 1;
				i = checkTypes(i,dateCounter, nerDate, date);
			}
			if (tokens.get(i).getNe().equals(nerNumber)) {
				numberCounter += 1;
				i = checkTypes(i,numberCounter, nerNumber, number);
			}
			if (tokens.get(i).getNe().equals(nerOrdinal)) {
				ordinalCounter += 1;
				i = checkTypes(i,ordinalCounter, nerOrdinal, ordinal);
			}
			if (tokens.get(i).getNe().equals(nerOrganization)) {
				organizationCounter += 1;
				i = checkTypes(i,organizationCounter, nerOrganization, organization);
			}
			// LOCATION
			// NUMBER
			// DATE
			// own map
		}

	}
	
	private int checkTypes(int i, int counter, String nerLabel, String codeLabel){
		
		String type = tokens.get(i).getWord();
		String code = codeLabel + counter;

		while ((i + 1) < tokens.size() && tokens.get(i + 1).getNe().equals(nerLabel)) {
			type += " " + tokens.get(i + 1).getWord();
			i += 1;
		}
		checkEntity(type, property);
		allCounter += 1;
		putSequence(allCounter, code, type);
		
		return i;
	}
	
	private void checkEntity(String entity, String property){
		String[] entityChecker = entity.split(" ", -1);

		for (String e : entityChecker) {

			try {

				if (this.vocabs.INVERSED_PROPERTIES.get(e.toLowerCase()) != null) {
					propertyCounter += 1;
					String propertyCode = property + propertyCounter;
					allCounter += 1;
					putSequence(allCounter, propertyCode, this.vocabs.INVERSED_PROPERTIES.get(e.toLowerCase()));
				}
			} catch (NullPointerException err) {

			}

		}
	}
	
	private void putSequence(int index, String code, String word) {
		String[] seq = new String[] { code, word };
		this.sequence.put(index, seq);
	}

	private void setSequenceCode(HashMap<Integer, String[]> sequence) {
		Iterator<Entry<Integer, String[]>> iter = getSequence().entrySet().iterator();
		String code = "";
		while (iter.hasNext()) {
			Map.Entry<Integer, String[]> pair = (Map.Entry<Integer, String[]>) iter.next();
			String[] seq = (String[]) pair.getValue();
			code += seq[0].substring(0, 1);

			// iter.remove(); // avoids a ConcurrentModificationException
		}

		this.sequenceCode = code;
	}

	public String getSequenceCode() {
		return this.sequenceCode;
	}

	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}

	public List<Token> getTokens() {
		return this.tokens;
	}

	public HashMap<Integer, String[]> getSequence() {
		return sequence;
	}

	public void setSequence(HashMap<Integer, String[]> sequence) {
		this.sequence = sequence;
	}

}