package de.daug.semanticchess.Parser;

public class Sequences {

	//1. Example: Show me games by Magnus Carlsen.
	static String _010 = "SELECT DISTINCT * WHERE { R_1 P_1 E_1. }";

	//2a. Example: Show me games played at world championships.
	static String _020 = "SELECT DISTINCT * WHERE { R_1 P_1 E_1. R_2 P_2 E_2. }";
	
	//3.
	static String _030 = "SELECT DISTINCT * WHERE { R_1 P_1 E_1. R_2 P_2 E_2. R_3 P_3 E_3. }";
	
	//
	static String _040 = "SELECT DISTINCT * WHERE { R_1 P_1 E_1. R_1 P_2 E_2. R_1 P_3 E_3. R_1 P_4 E_4.}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _100 = "SELECT DISTINCT * WHERE { S_1 D_1 C_1.}"; 
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _110 = "SELECT DISTINCT * WHERE { S_1 D_1 C_1. R_1 P_1 E_1.}"; 

	//2a. Example: Show me games played at world championships.
	static String _120 = "SELECT DISTINCT * WHERE { S_1 D_1 C_1. R_1 P_1 E_1. R_2 P_2 E_2.}"; 
	
	//3.
	static String _130 = "SELECT DISTINCT * WHERE { S_1 D_1 C_1. R_1 P_1 E_1. R_3 P_2 E_2. R_3 P_3 E_3.}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _140 = "SELECT DISTINCT * WHERE { S_1 D_1 C_1. R_1 P_1 E_1. R_2 P_2 E_2. R_3 P_3 E_3. R_4 P_4 E_4.}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _200 = "SELECT DISTINCT * WHERE { S_1 D_1 C_1. S_2 D_2 C_2.}"; 
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _210 = "SELECT DISTINCT * WHERE { S_1 D_1 C_1. S_2 D_2 C_2. R_1 P_1 E_1.}"; 

	//2a. Example: Show me games played at world championships.
	static String _220 = "SELECT DISTINCT * WHERE { S_1 D_1 C_1. S_2 D_2 C_2. R_1 P_1 E_1. R_2 P_2 E_2.}"; 
	
	//3.
	static String _230 = "SELECT DISTINCT * WHERE { S_1 D_1 C_1. S_2 D_2 C_2. R_1 P_1 E_1. R_2 P_2 E_2. R_3 P_3 E_3.}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _240 = "SELECT DISTINCT * WHERE { S_1 D_1 C_1. S_2 D_2 C_2. R_1 P_1 E_1. R_2 P_2 E_2. R_3 P_3 E_3. R_4 P_4 E_4.}";	
	
	
	
	
	//2a. Example: Show me games played at world championships.
	static String _021 = "SELECT DISTINCT * WHERE { {R_1 P_1 E_1.} UNION {R_2 P_2 E_2.} }";
	
	//
	static String _041 = "SELECT DISTINCT * WHERE { {R_1 P_1 E_1. R_2 P_2 E_2.} UNION {R_3 P_3 E_3. R_4 P_4 E_4.}}";
	
	//
	static String _061 = "SELECT DISTINCT * WHERE { {R_1 P_1 E_1. R_2 P_2 E_2. R_3 P_3 E_3.} UNION { R_4 P_4 E_4. R_5 P_5 E_5. R_6 P_6 E_6.}}";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _201 = "SELECT DISTINCT * WHERE { {S_1 D_1 C_1.} UNION {S_2 D_2 C_2.}}"; 

	//2a. Example: Show me games played at world championships.
	static String _221 = "SELECT DISTINCT * WHERE { {S_1 D_1 C_1. R_1 P_1 E_1.} UNION {S_2 D_2 C_2. R_2 P_2 E_2. }}"; 
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _241 = "SELECT DISTINCT * WHERE { {S_1 D_1 C_1. R_1 P_1 E_1. R_2 P_2 E_2. } UNION {S_2 D_2 C_2. R_3 P_3 E_3. R_4 P_4 E_4.} }";
	
	//1. Example: Show me games by Magnus Carlsen.
	static String _261 = "SELECT DISTINCT * WHERE { {S_1 D_1 C_1. R_1 P_1 E_1. R_2 P_2 E_2. R_3 P_3 E_3.} UNION {R_2 D_2 C_2. R_4 P_4 E_4. R_5 P_5 E_5. R_6 P_6 E_6.} }";
}