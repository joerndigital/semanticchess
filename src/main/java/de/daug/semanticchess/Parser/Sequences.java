package de.daug.semanticchess.Parser;

public class Sequences {

	// What is the capital of Germany? => (Annotation) Property_1 (P_1) Entity_1
	// (E_1) => (SPARQL template file) SELECT ?s {?s P_1 E_1.}
	
	
	//1. Example: Show me games by Magnus Carlsen.
	static String E = "SELECT DISTINCT ?game " + "WHERE { " + " ?game prop:white|prop:black 'E_1'. " + "}";

	//2a. Example: Show me games played at world championships.
	static String MP = "SELECT DISTINCT ?game " + "WHERE { " + " ?game prop:P_1 ?result. "
			+ " FILTER regex(?result, 'M_1', 'i')" + "}";
	
	//2b.
	static String PZ = "SELECT DISTINCT ?game " + "WHERE { " + " ?game prop:P_1 ?result. "
			+ " FILTER regex(?result, 'Z_1', 'i')" + "}";
	
	//3. Example: Show me games played in Berlin.
	static String LP = "SELECT DISTINCT ?game " + "WHERE { " + " ?game prop:P_1 ?result. "
			+ " FILTER regex(?result, 'L_1', 'i')" + "}";

	//4. Example: Show me games between Magnus Carlsen and Vladimir Kramnik.
	static String EE = "SELECT DISTINCT ?game " + "WHERE { " + " ?game prop:white|prop:black 'E_1'. "
			+ " ?game prop:white|prop:black 'E_2'. " + "}";
	
	//5. Example: Show me blitz games by Hikaru Nakamura.
	static String EP = "SELECT DISTINCT ?game " + "WHERE { " + " ?game prop:white|prop:black 'E_1'. "
			+ " ?game prop:P_1 ''. " + "}";
	
	
	//6. Example: Show me won games by Magnus Carlsen against Vladimir Kramnik. 
	//TODO function for switch
	static String EPR = "SELECT DISTINCT ?game " + "WHERE {{ " + " ?game prop:white 'E_1'. "
			+ " ?game prop:P_1 'R_1'. " + "} UNION { "+ "?game prop:black 'E_1.' "+ "?game prop:P_1 'SWITCH'." +"}";

	
	// Show me all won games of Carlsen against Anand
	// private String gamePersonResultPerson = "SELECT DISTINCT ?game " +
	// "WHERE {{ " +
	// " ?game P_1 E_1 " +
	// " ?game P_2 E_2 " +
	// " ?game P_3 C_1 } " +
	// "UNION {" +
	// " ?game P_2 E_1 " +
	// " ?game P_1 E_2 " +
	// " ?game P_3 C_2 } " +
	// " }";
	//
	//
	//
	
	
}