package de.daug.semanticchess.Parser;

public class Sequences {

	// What is the capital of Germany? => (Annotation) Property_1 (P_1) Entity_1
	// (E_1) => (SPARQL template file) SELECT ?s {?s P_1 E_1.}
	
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _0010 = "SELECT DISTINCT ?game WHERE { ?game P_1 E_1. }";

	//2a. Example: Show me games played at world championships.
	static String _0020 = "SELECT DISTINCT ?game WHERE { ?game P_1 E_1. ?game P_2 E_2. }";
	
	//3.
	static String _0030 = "SELECT DISTINCT ?game WHERE { ?game P_1 E_1. ?game P_2 E_2. ?game P_3 E_3. }";
	
	//
	static String _0040 = "SELECT DISTINCT ?game WHERE { ?game P_1 E_1. ?game P_2 E_2. ?game P_3 E_3. ?game P_4 E_4.}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _0100 = "SELECT DISTINCT C_1 WHERE { ?game D_1 C_1.}"; 
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _0110 = "SELECT DISTINCT C_1 WHERE { ?game D_1 C_1. ?game P_1 E_1.}"; 

	//2a. Example: Show me games played at world championships.
	static String _0120 = "SELECT DISTINCT C_1 WHERE { ?game D_1 C_1. ?game P_1 E_1. ?game P_2 E_2.}"; 
	
	//3.
	static String _0130 = "SELECT DISTINCT C_1 WHERE { ?game D_1 C_1. ?game P_1 E_1. ?game P_2 E_2. ?game P_3 E_3.}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _0140 = "SELECT DISTINCT C_1 WHERE { ?game D_1 C_1. ?game P_1 E_1. ?game P_2 E_2. ?game P_3 E_3. ?game P_4 E_4.}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _0200 = "SELECT DISTINCT C_1 C_2 WHERE { ?game D_1 C_1. ?game D_2 C_2.}"; 
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _0210 = "SELECT DISTINCT C_1 C_2 WHERE { ?game D_1 C_1. ?game D_2 C_2. ?game P_1 E_1.}"; 

	//2a. Example: Show me games played at world championships.
	static String _0220 = "SELECT DISTINCT C_1 C_2 WHERE { ?game D_1 C_1. ?game D_2 C_2. ?game P_1 E_1. ?game P_2 E_2.}"; 
	
	//3.
	static String _0230 = "SELECT DISTINCT C_1 C_2 WHERE { ?game D_1 C_1. ?game D_2 C_2. ?game P_1 E_1. ?game P_2 E_2. ?game P_3 E_3.}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _0240 = "SELECT DISTINCT C_1 C_2 WHERE { ?game D_1 C_1. ?game D_2 C_2. ?game P_1 E_1. ?game P_2 E_2. ?game P_3 E_3. ?game P_4 E_4.}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _1010 = "SELECT DISTINCT R_1 WHERE { R_1 P_1 E_1. }";

	//2a. Example: Show me games played at world championships.
	static String _1020 = "SELECT DISTINCT R_1 WHERE { R_1 P_1 E_1. R_1 P_2 E_2. }";
	
	//3.
	static String _1030 = "SELECT DISTINCT R_1 WHERE { R_1 P_1 E_1. R_1 P_2 E_2. R_1 P_3 E_3. }";
	
	//
	static String _1040 = "SELECT DISTINCT R_1 WHERE { R_1 P_1 E_1. R_1 P_2 E_2. R_1 P_3 E_3. R_1 P_4 E_4.}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _1100 = "SELECT DISTINCT R_1 C_1 WHERE { R_1 D_1 C_1.}"; 
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _1110 = "SELECT DISTINCT R_1 C_1 WHERE { R_1 D_1 C_1. R_1 P_1 E_1.}"; 

	//2a. Example: Show me games played at world championships.
	static String _1120 = "SELECT DISTINCT R_1 C_1 WHERE { R_1 D_1 C_1. R_1 P_1 E_1. R_1 P_2 E_2.}"; 
	
	//3.
	static String _1130 = "SELECT DISTINCT R_1 C_1 WHERE { R_1 D_1 C_1. R_1 P_1 E_1. R_1 P_2 E_2. R_1 P_3 E_3.}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _1140 = "SELECT DISTINCT R_1 C_1 WHERE { R_1 D_1 C_1. R_1 P_1 E_1. R_1 P_2 E_2. R_1 P_3 E_3. R_1 P_4 E_4.}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _1200 = "SELECT DISTINCT R_1 C_1 C_2 WHERE { R_1 D_1 C_1. R_1 D_2 C_2.}"; 
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _1210 = "SELECT DISTINCT R_1 C_1 C_2 WHERE { R_1 D_1 C_1. R_1 D_2 C_2. R_1 P_1 E_1.}"; 

	//2a. Example: Show me games played at world championships.
	static String _1220 = "SELECT DISTINCT R_1 C_1 C_2 WHERE { R_1 D_1 C_1. R_1 D_2 C_2. R_1 P_1 E_1. R_1 P_2 E_2.}"; 
	
	//3.
	static String _1230 = "SELECT DISTINCT R_1 C_1 C_2 WHERE { R_1 D_1 C_1. R_1 D_2 C_2. R_1 P_1 E_1. R_1 P_2 E_2. R_1 P_3 E_3.}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _1240 = "SELECT DISTINCT R_1 C_1 C_2 WHERE { R_1 D_1 C_1. R_1 D_2 C_2. R_1 P_1 E_1. R_1 P_2 E_2. R_1 P_3 E_3. R_1 P_4 E_4.}";
	
	
	//2a. Example: Show me games played at world championships.
	static String _0021 = "SELECT DISTINCT ?game WHERE { {?game P_1 E_1.} UNION {?game P_2 E_2.} }";
	
	//
	static String _0041 = "SELECT DISTINCT ?game WHERE { {?game P_1 E_1. ?game P_2 E_2.} UNION {?game P_3 E_3. ?game P_4 E_4.}}";
	
	//
	static String _0061 = "SELECT DISTINCT ?game WHERE { {?game P_1 E_1. ?game P_2 E_2. ?game P_3 E_3.} UNION {?game P_4 E_4. ?game P_5 E_5. ?game P_6 E_6.}}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _0201 = "SELECT DISTINCT C_1 C_2 WHERE { {?game D_1 C_1.} UNION {?game D_2 C_2.}}"; 

	//2a. Example: Show me games played at world championships.
	static String _0221 = "SELECT DISTINCT C_1 C_2 WHERE { {?game D_1 C_1. ?game P_1 E_1. } UNION {?game D_2 C_2. ?game P_2 E_2.}}"; 
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _0241 = "SELECT DISTINCT C_1 C_2 WHERE { {?game D_1 C_1. ?game P_1 E_1. ?game P_2 E_2.} UNION {?game D_2 C_2.  ?game P_3 E_3. ?game P_4 E_4.}}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _0261 = "SELECT DISTINCT C_1 C_2 WHERE { {?game D_1 C_1. ?game P_1 E_1. ?game P_2 E_2. ?game P_3 E_3.} UNION {?game D_2 C_2.  ?game P_4 E_4. ?game P_5 E_5. ?game P_6 E_6.}}";

	//2a. Example: Show me games played at world championships.
	static String _1021 = "SELECT DISTINCT R_1 WHERE { {R_1 P_1 E_1.} UNION {R_1 P_2 E_2.} }";
	
	//
	static String _1041 = "SELECT DISTINCT R_1 WHERE { {R_1 P_1 E_1. R_1 P_2 E_2.} UNION {R_1 P_3 E_3. R_1 P_4 E_4.}}";
	
	//
	static String _1061 = "SELECT DISTINCT R_1 WHERE { {R_1 P_1 E_1. R_1 P_2 E_2. R_1 P_3 E_3.} UNION { R_1 P_4 E_4. R_1 P_5 E_5. R_1 P_6 E_6.}}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _1201 = "SELECT DISTINCT R_1 C_1 C_2 WHERE { {R_1 D_1 C_1.} UNION {R_1 D_2 C_2.}}"; 

	//2a. Example: Show me games played at world championships.
	static String _1221 = "SELECT DISTINCT R_1 C_1 C_2 WHERE { {R_1 D_1 C_1. R_1 P_1 E_1.} UNION {R_1 D_2 C_2. R_1 P_2 E_2. }}"; 
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _1241 = "SELECT DISTINCT R_1 C_1 C_2 WHERE { {R_1 D_1 C_1. R_1 P_1 E_1. R_1 P_2 E_2. } UNION {R_1 D_2 C_2. R_1 P_3 E_3. R_1 P_4 E_4.} }";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _1261 = "SELECT DISTINCT R_1 C_1 C_2 WHERE { {R_1 D_1 C_1. R_1 P_1 E_1. R_1 P_2 E_2. R_1 P_3 E_3.} UNION {R_1 D_2 C_2. R_1 P_4 E_4. R_1 P_5 E_5. R_1 P_6 E_6.} }";
}