package de.daug.semanticchess.Parser.Utils;

/**
 * This class adds modifiers to the SPARQL query.
 */
public class Options {

	private static final String LIMIT = "LIMIT ";
	private static final String OFFSET = "OFFSET ";
	private static final String ORDERBY = "ORDER BY ";
	private static final String GROUPBY = "GROUP BY ";
	
	@SuppressWarnings("unused")
	private static final String HAVING = "HAVING ";

	private String limitStr ="";
	private String offsetStr = "";
	private String orderStr = "";
	private String groupStr = "";
	
	@SuppressWarnings("unused")
	private String havingStr ="";

	/**
	 * empty constructor
	 */
	public Options() {
	}

	/**
	 * get the LIMIT modifier
	 * @return limitStr
	 */
	public String getLimitStr() {
		return limitStr;
	}

	/**
	 * set limit string
	 * @param limit: integer
	 */
	public void setLimitStr(int limit) {
		if(limitStr.isEmpty()){
			this.limitStr = LIMIT + limit;
		}
	}

	/**
	 * get the OFFSET modifier
	 * @return offsetStr
	 */
	public String getOffsetStr() {
		return offsetStr;
	}

	/**
	 * set offset string
	 * @param offset: integer
	 */
	public void setOffsetStr(int offset) {
		this.offsetStr = OFFSET + offset;
	}

	/**
	 * get the ORDER BY modifier
	 * @return orderStr
	 */
	public String getOrderStr() {
		return orderStr;
	}

	/**
	 * set order String
	 * @param orderDirection: ASC or DESC
	 * @param order: class that should be ordered
	 */
	public void setOrderStr(String orderDirection, String order) {
		if (orderStr.equals("")) {
			this.orderStr = ORDERBY + orderDirection + "(" + order + ") ";
		} else {
			this.orderStr += orderDirection + "(" + order + ") ";
		}
	}
	
	/**
	 * get the GROUB BY modifier
	 * @return groupStr
	 */
	public String getGroupStr() {
		return groupStr;
	}

	/**
	 * set group String
	 * @param group
	 */
	public void setGroupStr(String group) {
		if (groupStr.equals("")) {
			this.groupStr = GROUPBY + group + " ";
		} else {
			this.groupStr += group + " ";
		}
	}

	/**
	 * returns a String with modifiers
	 */
	@Override
	public String toString() {

		if (limitStr == null && offsetStr == null && orderStr == null && groupStr == null) {
			return "";
		} else if (limitStr != null && offsetStr != null && orderStr == null && groupStr == null) {
			return limitStr + " " + offsetStr;
		} else if (limitStr != null && offsetStr != null && orderStr != null && groupStr == null) {
			return orderStr + " " + limitStr + " " + offsetStr;
		} else if (limitStr != null && offsetStr != null && orderStr != null && groupStr != null) {
			return groupStr+ " " +orderStr + " " + limitStr + " " + offsetStr;
		} else if (limitStr == null && offsetStr == null && orderStr != null && groupStr == null) {
			return orderStr;
		} else if (limitStr == null && offsetStr == null && orderStr != null && groupStr != null) {
			return groupStr + " " + orderStr;
		}
		else if (limitStr == null && offsetStr == null && orderStr == null && groupStr != null) {
			return groupStr;
		}

		return limitStr + " " + offsetStr;
	}

}