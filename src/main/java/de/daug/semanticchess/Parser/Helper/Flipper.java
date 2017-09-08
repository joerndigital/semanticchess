package de.daug.semanticchess.Parser.Helper;

public class Flipper {


	public Flipper() {
	}

	public String toFlip(String s) {

		String result = "";

		switch (s) {
		case "'1-0'":
			return "'0-1'";
		case "'0-1'":
			return "'1-0'";
		case "prop:white":
			return "prop:black";
		case "prop:black":
			return "prop:white";
		case "prop:whiteelo":
			return "prop:blackelo";
		case "prop:blackelo":
			return "prop:whiteelo";
		default:
			result = s;
			break;
		}

		return result;
	}


}