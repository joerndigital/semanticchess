package de.daug.semanticchess.Entity;

import java.net.URI;
import java.util.Date;

import org.apache.jena.rdf.model.RDFNode;

public class ChessGame{
	
	private String event;
	private String site;
	private String date;
	private String round;
	private String white;
	private String black;
	private String opening;
	private String eco;
	private String result;
	
	private String game;
	
//	public ChessGame(String event, String site, 
//			Date date, int round, String white, 
//			String black, String opening,
//			String eco, String result) {
//		this.event = event;
//		this.site = site;
//		this.date = date;
//		this.round = round;
//		this.white = white;
//		this.black = black;
//		this.opening = opening;
//		this.eco = eco;
//		this.result = result;
//	}
//	
//	public ChessGame(String url){
//		this.url = url;
//	}
	
	public ChessGame() {
	}
	
	public String getNode(){
		return game;
	}
	
	public void setNode(String url){
		this.game = url;
	}
	
	public String getEvent() {
		return event;
	}


	public void setEvent(String event) {
		this.event = event;
	}


	public String getSite() {
		return site;
	}


	public void setSite(String site) {
		this.site = site;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getRound() {
		return round;
	}


	public void setRound(String round) {
		this.round = round;
	}


	public String getWhite() {
		return white;
	}


	public void setWhite(String white) {
		this.white = white;
	}


	public String getBlack() {
		return black;
	}


	public void setBlack(String black) {
		this.black = black;
	}


	public String getOpening() {
		return opening;
	}


	public void setOpening(String opening) {
		this.opening = opening;
	}


	public String getEco() {
		return eco;
	}


	public void setEco(String eco) {
		this.eco = eco;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}
	
	
	
}