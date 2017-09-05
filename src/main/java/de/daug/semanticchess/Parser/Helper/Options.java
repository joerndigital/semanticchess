package de.daug.semanticchess.Parser.Helper;


public class Options{
	
	private static final String LIMIT = "LIMIT ";
	private static final String OFFSET = "OFFSET ";
	private static final String ORDERBY = "ORDER BY ";
	private static final String GROUPBY = "GROUP BY ";
	private static final String HAVING = "HAVING ";
	
	private int limitProperty;
	private int offsetProperty;
	private String orderProperty;
	private String groupProperty;
	private String havingProperty;
	
	private String limitStr;
	private String offsetStr;
	private String orderStr;
	private String groupStr;
	private String havingStr;
	
	public Options(){
		this.limitProperty = 10000;
		this.offsetProperty = 0;
		
		this.limitStr = LIMIT + limitProperty;
		this.offsetStr = OFFSET + offsetProperty;
		
	}

	public Options(int limitProperty, int offsetProperty) {
		this.limitProperty = limitProperty;
		this.offsetProperty = offsetProperty;
		
		this.limitStr = LIMIT + limitProperty;
		this.offsetStr = OFFSET + offsetProperty;
	}

	public Options(int limitProperty, int offsetProperty, String orderProperty) {
		this.limitProperty = limitProperty;
		this.offsetProperty = offsetProperty;
		this.orderProperty = orderProperty;
		
		this.limitStr = LIMIT + limitProperty;
		this.offsetStr = OFFSET + offsetProperty;
		this.orderStr = ORDERBY + orderProperty;
	}

	String getLimitStr() {
		return limitStr;
	}

	void setLimitStr(String limitStr) {
		this.limitStr = limitStr;
	}

	String getOffsetStr() {
		return offsetStr;
	}

	void setOffsetStr(String offsetStr) {
		this.offsetStr = offsetStr;
	}

	String getOrderStr() {
		return orderStr;
	}

	void setOrderStr(String orderStr) {
		this.orderStr = orderStr;
	}
	
	
	
	
}