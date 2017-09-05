package de.daug.semanticchess.Parser;

public class Sequences {

	// What is the capital of Germany? => (Annotation) Property_1 (P_1) Entity_1
	// (E_1) => (SPARQL template file) SELECT ?s {?s P_1 E_1.}
	
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _010 = "SELECT DISTINCT ?game " + "WHERE { " + " ?game P_1 'E_1'. " + "}";

	//2a. Example: Show me games played at world championships.
	static String _020 = "SELECT DISTINCT ?game " + "WHERE { " + " ?game P_1 'E_1'. " + " ?game P_2 'E_2'. " + "}";
	
	//3.
	static String _030 = "SELECT DISTINCT ?game " + "WHERE { " + " ?game P_1 'E_1'. " + " ?game P_2 'E_2'. " + " ?game P_3 'E_3'. " + "}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _011 = "SELECT DISTINCT ?game " + "WHERE { " + " {?game P_1 'E_1'.} UNION {?game PU_1 'EU_1'.} " + "}";

	//2a. Example: Show me games played at world championships.
	static String _021 = "SELECT DISTINCT ?game " + "WHERE { " + " {?game P_1 'E_1'. " + " ?game P_2 'E_2'.} UNION {?game PU_1 'EU_1'. " + " ?game PU_2 'EU_2'.}" + "}";
	
	//3.
	static String _031 = "SELECT DISTINCT ?game " + "WHERE { " + " {?game P_1 'E_1'. " + " ?game P_2 'E_2'. " + " ?game P_3 'E_3'. } UNION {?game PU_1 'EU_1'. " + " ?game PU_2 'EU_2'. " + " ?game PU_3 'EU_3'. }" + "}";

	
	//1. Example: Show me games by Magnus Carlsen.
	static String _100 = "SELECT DISTINCT C_1 " + "WHERE { " + " ?game D_1 C_1. " + "}";

	//2a. Example: Show me games played at world championships.
	static String _110 = "SELECT DISTINCT C_1 " + "WHERE { " + " ?game D_1 C_1. " + " ?game P_1 'E_1'. " + "}";
		
	//3.
	static String _120 = "SELECT DISTINCT C_1 " + "WHERE { " + " ?game D_1 C_1. " + " ?game P_1 'E_1'. " + " ?game P_2 'E_2'. " + "}";
	
	//1. Example: Show me games by Magnus Carlsen.

	
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