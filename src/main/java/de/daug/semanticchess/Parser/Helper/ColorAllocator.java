package de.daug.semanticchess.Parser.Helper;

import java.util.ArrayList;
import java.util.List;

import de.daug.semanticchess.Annotation.Token;

public class ColorAllocator {

	private List<Token> tokens = new ArrayList<Token>();
	private List<Integer> personPositions = new ArrayList<Integer>();
	private int colorPosition;

	public ColorAllocator(List<Token> tokens) {
		this.tokens = tokens;
		this.personPositions = getPersonPositions();
		this.colorPosition = getFirstColorPosition();
	}

	/**
	 * finds all persons and save their positions in the query it is assumed
	 * that for the color allocation only two person exists in the query
	 * 
	 * @param tokens:
	 *            List of words, ner and pos
	 * @return List<Integer>: list of person positions
	 */
	public List<Integer> getPersonPositions() {
		List<Integer> personPositions = new ArrayList<Integer>();

		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i).getNe().equals("PERSON")) {
				while ((i + 1) < tokens.size() && tokens.get(i + 1).getNe().equals("PERSON")) {
					i += 1;
				}
				personPositions.add(i);
			}
		}
		return personPositions;
	}

	/**
	 * saves the first position of one color
	 * 
	 * @param tokens:
	 *            List of words, ner and pos
	 * @return int: color position
	 */
	public int getFirstColorPosition() {
		int colorPosition = 0;

		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i).getNe().equals("black") || tokens.get(i).getNe().equals("white")) {
				colorPosition = i;
				break;
			}
		}
		return colorPosition;
	}

	/**
	 * simple distance function the color is allocated to the person who has a
	 * smallest distance to the color
	 * 
	 * @param personPositions:
	 *            list of person positions
	 * @param colorPosition:
	 *            color position
	 * @return int[]: personPosition,colorPosition
	 */
	public int[] allocateColor() {
		int[] personHasColor = new int[2];
		int bestPosition = personPositions.get(0);
		personHasColor[0] = bestPosition;
		personHasColor[1] = colorPosition;


		for (int i = 1; i < personPositions.size(); i++) {


			if (Math.abs(personPositions.get(i) - colorPosition) < 
					Math.abs(personPositions.get(personPositions.indexOf(bestPosition)) - colorPosition)) {
				bestPosition = personPositions.get(i);
				personHasColor[0] = bestPosition;
				personHasColor[1] = colorPosition;
			}

		}
		return personHasColor;
	}

}