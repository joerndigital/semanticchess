package de.daug.semanticchess.Parser.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FenRegex{
	
	List<String> pieces = new ArrayList<String>();
	List<String> piecesOpponent = new ArrayList<String>();
	
	String fen;
	
	public FenRegex(List<String> pieces, List<String> piecesOpponent){
		this.pieces = pieces;
		this.piecesOpponent = piecesOpponent;
	}
	
	public void createFen(){
		
	}
	
	public static void main (String[] args){
		Pattern p = Pattern.compile("^(?!(.*r){3})(?!(.*p){2})(?=(.*r){2})(?=(.*p){1})((?![qnb]).)*$");
		p = Pattern.compile("^(?!(.*(B|b)){2})(?!(.*(N|n)){2})(?=(.*(B|b)){1})(?=(.*(N|n)){1})((?![qr]).)*$");
		Matcher m = p.matcher("rp");
		
		System.out.println(m.find());
	}
	
}