package de.daug.semanticchess.Converter;

import java.io.File;

import de.uni_leipzig.informatik.swp13_sc.converter.PGNToRDFConverterRanged;
import de.uni_leipzig.informatik.swp13_sc.datamodel.rdf.ChessRDFVocabulary;

public class PgnToRdf {

	/*
	 * ================================================================ This
	 * code is provided by https://github.com/TortugaAttack/CACADUS
	 */

	public static void main(String[] args) {
		ChessRDFVocabulary rdfv = new ChessRDFVocabulary();
		rdfv.init("http://example.com", "#", "http://example.com/prop/", "http://example.com/res/", "prop", "res",
				true);

		PGNToRDFConverterRanged pg = new PGNToRDFConverterRanged();

		File f = new File("src/test/resources/WijkaanZee2017.pgn");

		pg.setOutputFormat("TURTLE");
		pg.processToStream(f.getAbsolutePath(), new File("src/test/resources/complete.ttl").getAbsolutePath(), true);
		pg.setOutputFormat("RDF/XML");
		pg.processToStream(f.getAbsolutePath(), new File("src/test/resources/complete.rdf").getAbsolutePath(), true);

		rdfv.init("http://example.com", "#", "http://example.com/prop/", "http://example.com/res/", "prop", "res",
				false);

		pg.setOutputFormat("TURTLE");
		pg.processToStream(f.getAbsolutePath(), new File("src/test/resources/only_meta.ttl").getAbsolutePath(), true);
		pg.setOutputFormat("RDF/XML");
		pg.processToStream(f.getAbsolutePath(), new File("src/test/resources/only_meta.rdf").getAbsolutePath(), true);

	}
	/*
	 * ================================================================
	 */
}