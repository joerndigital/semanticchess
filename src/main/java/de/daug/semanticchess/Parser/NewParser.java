package de.daug.semanticchess.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.daug.semanticchess.Annotation.PosTagger;
import de.daug.semanticchess.Annotation.PosTagger.Token;
import edu.stanford.nlp.ling.WordTag;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.process.Morphology;

public class NewParser {

	private List<Token> tokens;
	private ChessVocabulary vocabs = new ChessVocabulary();
	private int sequence = 0;
	private int index = 0;

	private String propertyLabel = "P_";
	private String entityLabel = "E_";

	private int counter = 0;
	private int optionCounter = 0;

	private List<Pair> properties = new ArrayList<Pair>();
	private List<Pair> entities = new ArrayList<Pair>();
	private List<Pair> options = new ArrayList<Pair>();
	private List<Pair> optionNames = new ArrayList<Pair>();

	private List<Flag> flags = new ArrayList<Flag>();

	public NewParser(String query) {
		this.tokens = initTokens(query);
		getSequences(this.tokens);

		System.out.println(entities.toString());
		System.out.println(properties.toString());
		System.out.println(flags.toString());
		System.out.println("Take Sequence: " + getSequence());
	}

	public static void main(String[] args) {
		NewParser np = new NewParser("Show me games by Magnus Carlsen from Berlin.");
	}

	private void getSequences(List<Token> tokens) {

		for (int i = 0; i < tokens.size(); i++) {
			String ner = tokens.get(i).getNe();
			String word = tokens.get(i).getWord();

			while (ner.equals("O")) {

				if (this.vocabs.INVERSED_PROPERTIES.get(word.toLowerCase()) != null) {
					ner = this.vocabs.INVERSED_PROPERTIES.get(word.toLowerCase());
				} else {
					if ((i + 1) < tokens.size()) {
						i += 1;
						ner = tokens.get(i).getNe();
					} else {
						break;
					}

				}
			}

			counter += 1;
			switch (ner) {
			case "PERSON":
				flags.add(new Flag(i, ner));

				putPair(i,"PERSON", "prop:white|prop:black");
				i = index;
				
				break;
			case "MISC":
				flags.add(new Flag(i, ner));

				putPair(i,"MISC", "");
				i = index;
				
				break;
			case "LOCATION":
				flags.add(new Flag(i, ner));

				putPair(i,"LOCATION", "prop:site");
				i = index;
				
				break;
			}
		}
	}

	public void putPair(int i, String ner, String propValue) {
		String entLabel = entityLabel + counter;
		String entValue = tokens.get(i).getWord();
		while (tokens.get(i + 1).getNe().equals(ner)) {
			entValue += " " + tokens.get(i + 1).getWord();
			i += 1;
		}
		Pair pair = new Pair(entLabel, entValue);
		entities.add(pair);

		String[] propertyCheck = entValue.split(" ");

		String propLabel = propertyLabel + counter;
		

		if (ner.equals("MISC")) {
			for (String checks : propertyCheck) {
				if (this.vocabs.INVERSED_PROPERTIES.get(checks.toLowerCase()) != null) {
					propValue = "prop:" + this.vocabs.INVERSED_PROPERTIES.get(checks.toLowerCase());
				}
			}
		}

		pair = new Pair(propLabel, propValue);
		properties.add(pair);

		this.sequence += 1;
		
		index = i;
	}

	/**
	 * initialize the POS tagger
	 * 
	 * @param query:
	 *            user question
	 * @return a list of tokens (word, ner, pos)
	 */
	private List<Token> initTokens(String query) {
		PosTagger tagger = new PosTagger();
		StanfordCoreNLP pipeline = tagger.getPipeline();
		tagger.setQuery(query);
		tagger.setDocument(tagger.setAnnotator(pipeline, tagger.getQuery()));
		tagger.initAnnotations();

		List<Token> tokens = tagger.getTokens();

		// basic morphology, for example changes "defeated" to "defeat"
		for (Token token : tokens) {
			WordTag lemma = Morphology.stemStatic(token.getWord(), token.getPos());
			token.setWord(lemma.value());
		}

		return tokens;
	}

	@Override
	public String toString() {
		return "NewParser [tokens=" + tokens + ", vocabs=" + vocabs + ", sequence=" + sequence + ", propertyLabel="
				+ propertyLabel + ", entityLabel=" + entityLabel + ", counter=" + counter + ", optionCounter="
				+ optionCounter + ", properties=" + properties + ", entities=" + entities + ", options=" + options
				+ ", optionNames=" + optionNames + ", flags=" + flags + "]";
	}

	List<Token> getTokens() {
		return tokens;
	}

	void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}

	ChessVocabulary getVocabs() {
		return vocabs;
	}

	void setVocabs(ChessVocabulary vocabs) {
		this.vocabs = vocabs;
	}

	int getSequence() {
		return sequence;
	}

	void setSequence(int sequence) {
		this.sequence = sequence;
	}

	String getPropertyLabel() {
		return propertyLabel;
	}

	void setPropertyLabel(String propertyLabel) {
		this.propertyLabel = propertyLabel;
	}

	String getEntityLabel() {
		return entityLabel;
	}

	void setEntityLabel(String entityLabel) {
		this.entityLabel = entityLabel;
	}

	int getCounter() {
		return counter;
	}

	void setCounter(int counter) {
		this.counter = counter;
	}

	int getOptionCounter() {
		return optionCounter;
	}

	void setOptionCounter(int optionCounter) {
		this.optionCounter = optionCounter;
	}

	List<Pair> getProperties() {
		return properties;
	}

	void setProperties(List<Pair> properties) {
		this.properties = properties;
	}

	List<Pair> getEntities() {
		return entities;
	}

	void setEntities(List<Pair> entities) {
		this.entities = entities;
	}

	List<Pair> getOptions() {
		return options;
	}

	void setOptions(List<Pair> options) {
		this.options = options;
	}

	List<Pair> getOptionNames() {
		return optionNames;
	}

	void setOptionNames(List<Pair> optionNames) {
		this.optionNames = optionNames;
	}

	List<Flag> getFlags() {
		return flags;
	}

	void setFlags(List<Flag> flags) {
		this.flags = flags;
	}

	class Pair {
		private String label;
		private String value;

		public Pair(String label, String value) {
			this.label = label;
			this.value = value;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Pair [label=" + label + ", value=" + value + "]";
		}
	}

	class Flag {
		private int position;
		private String nerLabel;

		public Flag(int position, String nerLabel) {
			this.position = position;
			this.nerLabel = nerLabel;
		}

		public int getPosition() {
			return position;
		}

		public void setPosition(int position) {
			this.position = position;
		}

		public String getNerLabel() {
			return nerLabel;
		}

		public void setNerLabel(String nerLabel) {
			this.nerLabel = nerLabel;
		}

		@Override
		public String toString() {
			return "Flag [position=" + position + ", nerLabel=" + nerLabel + "]";
		}

	}

}