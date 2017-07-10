package de.daug.semanticchess;

import de.daug.semanticchess.Annotation.PosTagger;

/**
 * work in progress
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		PosTagger tagger = new PosTagger("What does Anand play against the Sicilian Defense?");
		System.out.println("================================================================");
		System.out.println(tagger.getQuery());
		System.out.println(tagger.getTaggedQuery());
		
    }
}
