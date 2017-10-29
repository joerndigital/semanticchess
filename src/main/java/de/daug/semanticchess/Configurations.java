package de.daug.semanticchess;

/**
 * Configurations
 */
public class Configurations{
	
	//Database
	public static final String DB = "jdbc:virtuoso://localhost:1111";
	public static final String DB_USER = "dba";
	public static final String DB_PASSWORD = "dba";
	public static final String DB_GRAPH = "http://www.example.com/";
	public static final String DB_OPENING_GRAPH = "";
	
	//SPARQL
	public static final String SPARQL_PREFIXES = "PREFIX ex:<http://example.com> " 
			+ "PREFIX res:<http://example.com/res/> "
			+ "PREFIX prop:<http://example.com/prop/> "
			+ "PREFIX cres:<http://pcai042.informatik.uni-leipzig.de/~swp13-sc/ChessOntology/Resources/> "
			+ "PREFIX cont:<http://pcai042.informatik.uni-leipzig.de/~swp13-sc/ChessOntology#> "
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>";

	//FILE PATHS
	public static final String JSON_CHESSOPENINGS = "src/main/resources/static/openings/chessopenings.json";
	public static final String TXT_CHESSOPENINGS = "src/main/resources/static/openings/chessopenings.txt";
	
}