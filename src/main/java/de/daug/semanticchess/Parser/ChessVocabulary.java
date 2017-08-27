package de.daug.semanticchess.Parser;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;


public class ChessVocabulary{
	
	public Map<String, ArrayList<String>> PROPERTIES = new HashMap<String,ArrayList<String>>();
	public Map<String, String> INVERSED_PROPERTIES = new HashMap<String,String>();
	
	public ChessVocabulary() {
		fillProperties();
		inverseProperties();
	}
	
	public void fillProperties(){
//		ArrayList<String> gameProperty = new ArrayList<String>();
//		gameProperty.add("game");
//		gameProperty.add("games");
//		gameProperty.add("plays");
//		gameProperty.add("match");
//		gameProperty.add("matchs");
//		gameProperty.add("matchup");
//		gameProperty.add("matchups");
//		gameProperty.add("pairing");
//		gameProperty.add("pairings");
//		gameProperty.add("encounter");
//		gameProperty.add("encounters");
//		//==============================
//		PROPERTIES.put("game", gameProperty);
		
		
		ArrayList<String> eventProperty = new ArrayList<String>();
		//TODO: sparql abfrage alle event Namen holen und hier eintragen.
		eventProperty.add("blitz");
		eventProperty.add("candidates");
		eventProperty.add("challengers");
		eventProperty.add("championship");
		eventProperty.add("championships");
		eventProperty.add("chess960");
		eventProperty.add("classics");
		eventProperty.add("congress");
		eventProperty.add("event");
		eventProperty.add("events");
		eventProperty.add("festival");
		eventProperty.add("fetstivals");
		eventProperty.add("kongress");
		eventProperty.add("masters");
		eventProperty.add("meeting");
		eventProperty.add("meetings");
		eventProperty.add("open");
		eventProperty.add("random chess");
		eventProperty.add("rapid");
		eventProperty.add("section");
		eventProperty.add("sections");
		eventProperty.add("simul");
		eventProperty.add("simultan");
		eventProperty.add("simultaneous");
		eventProperty.add("speed");
		eventProperty.add("tournament");
		eventProperty.add("tournaments");
		//==============================
		PROPERTIES.put("event", eventProperty);
		
		
		ArrayList<String> eloProperty = new ArrayList<String>();
		eloProperty.add("elo");
		eloProperty.add("rating");
		eloProperty.add("ratings");
		//==============================
		PROPERTIES.put("elo", eloProperty);
		
		ArrayList<String> openingProperty = new ArrayList<String>();
		openingProperty.add("opening");
		openingProperty.add("openings");
		openingProperty.add("system");
		openingProperty.add("systems");
		openingProperty.add("defence");
		openingProperty.add("defense");
		openingProperty.add("variation");
		openingProperty.add("variations");
		openingProperty.add("gambit");
		openingProperty.add("gambits");
		openingProperty.add("attack");
		openingProperty.add("opening");
		openingProperty.add("symmetrical");
		openingProperty.add("line");
		openingProperty.add("lines");
		//==============================
		PROPERTIES.put("opening", openingProperty);
		
		ArrayList<String> roundProperty = new ArrayList<String>();
		roundProperty.add("round");
		roundProperty.add("rounds");
		//==============================
		PROPERTIES.put("round", roundProperty);
		
		ArrayList<String> blackProperty = new ArrayList<String>();
		blackProperty.add("black");
		blackProperty.add("blacks");
		//==============================
		PROPERTIES.put("black", blackProperty);
		
		ArrayList<String> whiteProperty = new ArrayList<String>();
		whiteProperty.add("white");
		whiteProperty.add("whites");
		//==============================
		PROPERTIES.put("white", whiteProperty);
		
		ArrayList<String> fenProperty = new ArrayList<String>();
		fenProperty.add("fen");
		fenProperty.add("position");
		fenProperty.add("positions");
		fenProperty.add("pawn");
		fenProperty.add("pawns");
		fenProperty.add("bishop");
		fenProperty.add("bishops");
		fenProperty.add("knight");
		fenProperty.add("knights");
		fenProperty.add("rock");
		fenProperty.add("rocks");
		fenProperty.add("queen");
		fenProperty.add("queens");
		fenProperty.add("king");
		fenProperty.add("kings");
		fenProperty.add("rank");
		fenProperty.add("ranks");
		fenProperty.add("file");
		fenProperty.add("files");
		//==============================
		PROPERTIES.put("fen", fenProperty);
		
		ArrayList<String> resultProperty = new ArrayList<String>();
		resultProperty.add("1-0");
		resultProperty.add("0-1");
		resultProperty.add("1/2");
		resultProperty.add("1/1-1/2");
		resultProperty.add("draw");
		resultProperty.add("draws");
		resultProperty.add("drawn");
		resultProperty.add("remis");
		resultProperty.add("win");
		resultProperty.add("winning");
		resultProperty.add("wins");
		resultProperty.add("won");
		resultProperty.add("checkmate");
		resultProperty.add("mated");
		resultProperty.add("checkmated");
		resultProperty.add("checkmates");
		resultProperty.add("mates");
		resultProperty.add("stalemate");
		resultProperty.add("defeat");
		resultProperty.add("loose");
		resultProperty.add("looses");
		resultProperty.add("loss");
		resultProperty.add("lost");
		resultProperty.add("victory");
		resultProperty.add("victories");
		//==============================
		PROPERTIES.put("result", resultProperty);
		
		ArrayList<String> movesProperty = new ArrayList<String>();
		movesProperty.add("move");
		movesProperty.add("moves");
		//==============================
		PROPERTIES.put("moves", movesProperty);
				
	}
	
	public void inverseProperties(){
		for(HashMap.Entry<String, ArrayList<String>> entry : PROPERTIES.entrySet()){
			for(String prop : entry.getValue()){
				//System.out.println(prop + " " + entry.getKey());
				INVERSED_PROPERTIES.put(prop, entry.getKey());
			}
		}
//		System.out.println("=============");
//		for(HashMap.Entry<String, String> entry : INVERSED_PROPERTIES.entrySet()){
//			System.out.println(entry.getKey() + " " + entry.getValue());
//		}
		
	}
	
	public static void main (String[] args){
		//fillProperties();
		//inverseProperties();
	}
	
	
}
