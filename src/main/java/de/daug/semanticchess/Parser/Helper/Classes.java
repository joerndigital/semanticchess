package de.daug.semanticchess.Parser.Helper;

public class Classes {

	private final static String classesLabel = "C_";
	private final static String propertyLabel = "D_";
	private final static String property = "prop:";

	private String classesId;
	private String propertyId;

	private String classesName;
	private String propertyName;

	public Classes(int counter, String classesName, String propertyName) {
		this.classesId = classesLabel + counter;
		this.propertyId = propertyLabel + counter;

		this.classesName = classesName;
		this.propertyName = propertyName;
	}

	String getClassesId() {
		return classesId;
	}

	void setClassesId(String classesId) {
		this.classesId = classesId;
	}

	String getPropertyId() {
		return propertyId;
	}

	void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	String getClassesName() {
		return classesName;
	}

	void setClassesName(String classesName) {
		this.classesName = classesName;
	}

	String getPropertyName() {
		return propertyName;
	}

	void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

}