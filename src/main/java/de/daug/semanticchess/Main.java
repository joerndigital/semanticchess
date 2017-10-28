package de.daug.semanticchess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import de.daug.semanticchess.Converter.EcoToRdf;
//import de.daug.semanticchess.Converter.PgnToRdf;
//import de.daug.semanticchess.Database.LoadData;


@SpringBootApplication
public class Main 
{
	
	//TODO: add args from to console to start PgnToRdf, LoadData, EcoToRdf
    public static void main( String[] args )
    {
    	//PgnToRdf.main(null);
    	//LoadData.main(null);
    	
    	//EcoToRdf.main(null);
    	
    	
		SpringApplication.run(Main.class, args);
    }
}
