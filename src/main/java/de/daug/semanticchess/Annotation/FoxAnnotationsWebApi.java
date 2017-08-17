package de.daug.semanticchess.Annotation;


import org.aksw.fox.binding.java.*;


//TODO: 			work in progress
public class FoxAnnotationsWebApi{
	public static void main(String[] args){
		IFoxApi fox = new FoxApi();

		//URL api = new URL("http://0.0.0.0:4444/api");
		//fox.setApiURL(api);

		fox.setTask(FoxParameter.TASK.NER);
		fox.setOutputFormat(FoxParameter.OUTPUT.TURTLE);
		fox.setLang(FoxParameter.LANG.EN);
		fox.setInput("The philosopher and mathematician Leibniz was born in Leipzig.");
		// fox.setLightVersion(FoxParameter.FOXLIGHT.ENStanford);

		FoxResponse response = fox.send();

		System.out.println(response.getInput());
		System.out.println(response.getOutput());
		System.out.println(response.getLog());
	}

}