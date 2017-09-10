package de.daug.semanticchess.Parser.Helper;


public class Filters{
	
	public String filter = "";
	private boolean isFirstFilter = true;
	
	
	public Filters(){
		
	}
	
	
	public void addGreaterThan(){
		
	}
	
	public void addLowerThan(){
		
	}
	
	public void addRegex(String classesName, String regex, boolean caseSensitiv){
		if(isFirstFilter){
			if(!caseSensitiv){
				this.filter += "FILTER regex( " + classesName + ", '" + regex + "')";
			} else {
				this.filter += "FILTER regex( " + classesName + ", '" + regex + "' "+ ",'i' " + ")";
			}
		}else {
			if(!caseSensitiv){
				this.filter += " && regex( " + classesName + ", '" + regex + "')";
			} else {
				this.filter += " && regex( " + classesName + ", '" + regex + "' "+ ",'i' " + ")";
			}
		}
		
	}


	public String getFilterStr() {
		return filter;
	}


	public void setFilterStr(String filter) {
		this.filter = filter;
	}
	
	
	
}