package de.daug.semanticchess.Converter;

import java.io.File;

import de.uni_leipzig.informatik.swp13_sc.converter.PGNToRDFConverterRanged;
import de.uni_leipzig.informatik.swp13_sc.datamodel.rdf.ChessRDFVocabulary;


/**
 * converts pgn files to rdf data
 */
public class PgnToRdf {

	/**
	 * This code is provided by https://github.com/TortugaAttack/CACADUS
	 */
	public static void main(String[] args) {
		ChessRDFVocabulary rdfv = new ChessRDFVocabulary();
		rdfv.init("http://example.com", "#", "http://example.com/prop/", "http://example.com/res/", "prop", "res",
				true);
		
		PGNToRDFConverterRanged pg = new PGNToRDFConverterRanged();
		
		String fileName = "Nimzowitsch";

		File f = new File("src/test/resources/"+fileName+".pgn");

		pg.setOutputFormat("TURTLE");
		pg.processToStream(f.getAbsolutePath(), new File("src/test/resources/"+fileName+".ttl").getAbsolutePath(), true);
		pg.setOutputFormat("RDF/XML");
		pg.processToStream(f.getAbsolutePath(), new File("src/test/resources/"+fileName+".rdf").getAbsolutePath(), true);

		rdfv.init("http://example.com", "#", "http://example.com/prop/", "http://example.com/res/", "prop", "res",
				false);

		pg.setOutputFormat("TURTLE");
		pg.processToStream(f.getAbsolutePath(), new File("src/test/resources/"+fileName+"_meta.ttl").getAbsolutePath(), true);
		pg.setOutputFormat("RDF/XML");
		pg.processToStream(f.getAbsolutePath(), new File("src/test/resources/"+fileName+"_meta.rdf").getAbsolutePath(), true);
		
	}
}