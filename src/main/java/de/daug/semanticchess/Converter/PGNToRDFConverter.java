/**
 * PGNToRDFConverter.java
 */
package de.daug.semanticchess.Converter;

/**
 * The command line interface (CLI) of the PGN Parser.
 *
 * @author Erik
 *
 */
public class PGNToRDFConverter
{

    /**
     * Main method. Entry point of jar file.
     * 
     * @param   args
     */
    public static void main(String[] args)
    {
        // chosen converter ...
        PGNToRDFConverterRanged converter = new PGNToRDFConverterRanged();
        converter.start(args);
    }

}
