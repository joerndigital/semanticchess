package de.daug.semanticchess.Parser.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FenRegex{
	
	List<Piece> piecesWhite = new ArrayList<Piece>();
	List<Piece> piecesBlack = new ArrayList<Piece>();
	
	private String fen = "^";
	
	private static String MIN = "(?=(.*X){Y})";
	private static String MAX = "(?!(.*X){Z})";
	private static String notOnBoard = "((?![QqRrBbNnPp]).)*$";
	
	public FenRegex(){

	}
	
	public void addPieceWhite(int counter, String piece){
		Piece p = new Piece(counter, piece);
		piecesWhite.add(p);
	}
	
	public void addPieceBlack(int counter, String piece){
		Piece p = new Piece(counter, piece);
		piecesBlack.add(p);
	}
	
	public void createFen(){
		boolean whitePawnIsCalled = false;
		boolean blackPawnIsCalled = false;
		
		for(Piece piece : piecesWhite){
			
			
			switch(piece.getName()){
				case "queen":
					setFen("Q", piece.getCounter() , piece.getCounter()+1);
					break;
				case "rook":
					setFen("R", piece.getCounter() , piece.getCounter()+1);
					break;
				case "bishop":
					setFen("B", piece.getCounter() , piece.getCounter()+1);
					break;	
				case "knight":
					setFen("N", piece.getCounter() , piece.getCounter()+1);
					break;
				case "pawn":
					setFen("P", piece.getCounter() , piece.getCounter()+1);
					whitePawnIsCalled = true;
					break;
				default:
					break;
			}
		}
		
		for(Piece piece : piecesBlack){
			
			switch(piece.getName()){
				case "queen":
					setFen("q", piece.getCounter() , piece.getCounter()+1);
					break;
				case "rook":
					setFen("r", piece.getCounter() , piece.getCounter()+1);
					break;
				case "bishop":
					setFen("b", piece.getCounter() , piece.getCounter()+1);
					break;	
				case "knight":
					setFen("n", piece.getCounter() , piece.getCounter()+1);
					break;
				case "pawn":
					setFen("p", piece.getCounter() , piece.getCounter()+1);
					blackPawnIsCalled = true;
					break;
				default:
					break;
			}
		}
		
		if(!whitePawnIsCalled && !blackPawnIsCalled){
			this.notOnBoard = this.notOnBoard.replace("P", "");
			this.notOnBoard = this.notOnBoard.replace("p", "");	
		}
		
		if(piecesWhite.size() > 0){
			fen += this.notOnBoard;
		}
		
		
	}
	
	private void setFen(String piece, int min, int max){
		if(piece.equals("b")){
			String pieceTemp = "[^ ]b";
			this.fen += MIN.replace("X", pieceTemp).replace("Y", Integer.toString(min));
			this.fen += MAX.replace("X", pieceTemp).replace("Z", Integer.toString(max));
		}else {
			this.fen += MIN.replace("X", piece).replace("Y", Integer.toString(min));
			this.fen += MAX.replace("X", piece).replace("Z", Integer.toString(max));
		}
		

		this.notOnBoard = this.notOnBoard.replace(piece, "");		
	}
	
	
	
	public String getFen() {
		return fen;
	}

	public void setFen(String fen) {
		this.fen = fen;
	}
	
	

	public List<Piece> getPiecesWhite() {
		return piecesWhite;
	}

	public void setPiecesWhite(List<Piece> piecesWhite) {
		this.piecesWhite = piecesWhite;
	}

	public List<Piece> getPiecesBlack() {
		return piecesBlack;
	}

	public void setPiecesBlack(List<Piece> piecesBlack) {
		this.piecesBlack = piecesBlack;
	}

	public static void main (String[] args){
		
		FenRegex reg = new FenRegex();
		reg.addPieceWhite(1, "queen");
		reg.addPieceBlack(1, "rook");
		reg.addPieceBlack(1, "pawn");
		
		reg.createFen();
		
		System.out.println(reg.getFen());
		
//		Pattern p = Pattern.compile("^(?!(.*r){3})(?!(.*p){2})(?=(.*r){2})(?=(.*p){1})((?![qnb]).)*$");
//		p = Pattern.compile("^(?!(.*(B|b)){2})(?!(.*(N|n)){2})(?=(.*(B|b)){1})(?=(.*(N|n)){1})((?![qr]).)*$");
//		Matcher m = p.matcher("rp");
//
//		System.out.println(m.find());
	}
	
	public class Piece{
		
		private int counter;
		private String name;
		public Piece(int counter, String name) {
			this.counter = counter;
			this.name = name;
		}
		public int getCounter() {
			return counter;
		}
		public void setCounter(int counter) {
			this.counter = counter;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
		
		
	}
	
}