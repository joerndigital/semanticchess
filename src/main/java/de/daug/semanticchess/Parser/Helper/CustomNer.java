package de.daug.semanticchess.Parser.Helper;

import java.util.ArrayList;
import java.util.List;

import de.daug.semanticchess.Annotation.Token;
import de.daug.semanticchess.Parser.ChessVocabulary;
import edu.stanford.nlp.ling.WordTag;
import edu.stanford.nlp.process.Morphology;

public class CustomNer {
	private List <Token> tokens = new ArrayList<Token>();
	private ChessVocabulary  vocabulary = new ChessVocabulary();
	
	public CustomNer (List<Token> tokens){
		this.tokens = tokens;
	}
	
	/**
	 * does a stemming for all words to their basic forms
	 * @param tokens: List of words, ner and pos
	 * @return list of Token
	 */
	public List<Token> stemming(List<Token> tokens){
		for (Token token : tokens) {
			WordTag lemma = Morphology.stemStatic(token.getWord(), token.getPos());
			token.setWord(lemma.value());
		}	
		return tokens;
	}
	
	/**
	 * check the chess vocabulary to find consistencies with the tokens
	 * @param tokens: List of words, ner and pos
	 * @return list of Token
	 */
	public List<Token> checkChessVocabulary(List<Token> tokens){
		for (Token token : tokens) {
			if (token.getNe().equals("O")) {
				String word = token.getWord().toLowerCase();
				if (vocabulary.INVERSED_PROPERTIES.get(word) != null) {
					token.setNe(vocabulary.INVERSED_PROPERTIES.get(word));
				} else if (word.matches("[a-e][0-9]{2}")) {
					token.setNe("eco");
				}
			}
		}
		
		return tokens;
	}
	
	/**
	 * check all dates, especially years if they are elo numbers or not
	 * @param tokens: List of words, ner and pos
	 * @return list of Token
	 */
	public List<Token> checkElo(List<Token> tokens){
		for (int i = 0; i < tokens.size(); i++) {
			String word = tokens.get(i).getWord().toLowerCase();
			if (tokens.get(i).getNe().equals("DATE")) {
				try {
					int elo = Integer.parseInt(word);
					boolean isElo = false;

					for (int j = 2; j >= -2; j--) {
						if ((i - j) < tokens.size()) {
							if (tokens.get(i - j).getNe().equals("elo")) {
								isElo = true;
								break;
							}
						}
					}
					if (isElo || (elo > 2025 && elo < 3000)) {
						tokens.get(i).setNe("elo");
					}
				} catch (Exception e) {}
			}
		}
		
		return tokens;
	}
	
	//TODO misc checker

	List<Token> getTokens() {
		return tokens;
	}

	void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}
	
	
}