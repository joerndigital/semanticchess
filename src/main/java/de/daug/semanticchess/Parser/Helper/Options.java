package de.daug.semanticchess.Parser.Helper;


public class Options{
	
	private static final String LIMIT = "LIMIT ";
	private static final String OFFSET = "OFFSET ";
	private static final String ORDERBY = "ORDER BY ";
	private static final String GROUPBY = "GROUP BY ";
	private static final String HAVING = "HAVING ";
	
//	private int limitProperty = 10000;
//	private int offsetProperty = 0;
//	private String orderProperty = "";
//	private String groupProperty = "";
//	private String havingProperty = "";
	
	private String limitStr;
	private String offsetStr;
	private String orderStr;
	private String groupStr;
	private String havingStr;
	
	public Options(){

	}

//	public Options(int limitProperty, int offsetProperty) {
//		this.limitProperty = limitProperty;
//		this.offsetProperty = offsetProperty;
//		
//		this.limitStr = LIMIT + limitProperty;
//		this.offsetStr = OFFSET + offsetProperty;
//	}

//	public Options(int limitProperty, int offsetProperty, String orderProperty) {
//		this.limitProperty = limitProperty;
//		this.offsetProperty = offsetProperty;
//		this.orderProperty = orderProperty;
//		
//		this.limitStr = LIMIT + limitProperty;
//		this.offsetStr = OFFSET + offsetProperty;
//		this.orderStr = ORDERBY + orderProperty;
//	}

	public String getLimitStr() {
		return limitStr;
	}

	public void setLimitStr(int limit) {
		this.limitStr = LIMIT + limit;
	}

	public String getOffsetStr() {
		return offsetStr;
	}

	public void setOffsetStr(int offset) {
		this.offsetStr = OFFSET + offset;
	}

	public String getOrderStr() {
		return orderStr;
	}

	public void setOrderStr(String orderDirection, String order) {
		this.orderStr = ORDERBY + orderDirection + "(" + order + ")";
	}

	@Override
	public String toString() {
		
		if(limitStr == null && offsetStr == null && orderStr == null){
			return ""; 
		}
		else if(limitStr != null && offsetStr != null && orderStr == null){
			return limitStr + " " + offsetStr;
		}else if (limitStr != null && offsetStr != null && orderStr != null){
			return limitStr + " " + offsetStr + " " + orderStr;
		}
		
		
		return limitStr + " " + offsetStr;
	}	
	
	
	
	
	
}