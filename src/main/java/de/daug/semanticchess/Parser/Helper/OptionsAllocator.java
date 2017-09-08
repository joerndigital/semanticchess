package de.daug.semanticchess.Parser.Helper;

import java.util.ArrayList;
import java.util.List;

import de.daug.semanticchess.Annotation.Token;

public class OptionsAllocator {

	private List<Token> tokens = new ArrayList<Token>();

	public OptionsAllocator(List<Token> tokens) {
		this.tokens = tokens;
	}

	public int findLimit() {
		int limitProperty = 10000;
		for (int i = 0; i < tokens.size(); i++) {
			if ((i + 1) < tokens.size() && !tokens.get(i + 1).getNe().equals("elo")) {
				if (tokens.get(i).getNe().equals("NUMBER")) {
					limitProperty = Integer.valueOf(tokens.get(i).getWord());
				}
			}
		}
		return limitProperty;
	}
	
	public int findOffset(){
		int offsetProperty = -1;
		
		for(int i = 0; i < tokens.size(); i++) {
			if ((i + 1) < tokens.size() && !tokens.get(i + 1).getNe().equals("round")) {
				if (tokens.get(i).getNe().equals("ORDINAL") && !tokens.get(i).getWord().equals("last")) {
					offsetProperty = Integer.valueOf(tokens.get(i).getWord().replaceAll("\\D+", ""));
				}
				if(tokens.get(i).getWord().equals("last")){
					offsetProperty = 1;
				}
			}
		}
		
		return offsetProperty;
		
	}
	
	public String findOrderBy(){
		String orderByProperty = "";
		String order = "ASC";
		
		for(int i = 0; i < tokens.size()-1; i++) {
			String ne = tokens.get(i+1).getNe();
			if(tokens.get(i).getWord().equals("last")){
				order = "DESC";
				orderByProperty = "?date";
			}
			
			if(tokens.get(i).getNe().equals("ORDINAL") && !tokens.get(i).getWord().equals("last")){
				
				switch(ne){
					case "1-0":
					case "0-1":
					case "1/2-1/2":
					case "game":
					case "event":
					case "site":
					case "white":
					case "black":
					case "opening":
					case "PERSON":
						orderByProperty = "?date";
						break;
					default:
						break;						
				}
				
			}
		}
		
		return order + "(" + orderByProperty + ")";
	}
	
	public String findGroupBy(){
		// important if there are 
		
		String groupByProperty = "";
		
		return groupByProperty;
	}

}