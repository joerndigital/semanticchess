package de.daug.semanticchess.Parser;

public class Sequences {

	// What is the capital of Germany? => (Annotation) Property_1 (P_1) Entity_1
	// (E_1) => (SPARQL template file) SELECT ?s {?s P_1 E_1.}

	static String E = "SELECT DISTINCT ?game " + "WHERE { " + " ?game prop:white|prop:black 'E_1'. " + "}";

	static String PM = "SELECT DISTINCT ?game " + "WHERE { " + " ?game prop:P_1 ?result. "
			+ " FILTER regex(?result, 'M_1', 'i')" + "}";
	
	static String PZ = "SELECT DISTINCT ?game " + "WHERE { " + " ?game prop:P_1 ?result. "
			+ " FILTER regex(?result, 'Z_1', 'i')" + "}";
	
	static String PL = "SELECT DISTINCT ?game " + "WHERE { " + " ?game prop:P_1 ?result. "
			+ " FILTER regex(?result, 'L_1', 'i')" + "}";

	static String EE = "SELECT DISTINCT ?game " + "WHERE { " + " ?game prop:white|prop:black 'E_1'. "
			+ " ?game prop:white|prop:black 'E_2'. " + "}";

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