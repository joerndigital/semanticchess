package de.daug.semanticchess.Parser.Helper;

public class Classes {

	private final static String classesLabel = "C_";
	private final static String propertyLabel = "D_";
	private final static String resourceLabel = "S_";
	private final static String property = "prop:";

	private String classesId;
	private String propertyId;
	private String resourceId;

	private String classesName;
	private String propertyName;
	private String resourceName;

	private int position;

	public Classes(int counter, String classesName, String propertyName, int position, String resourceName) {
		this.classesId = classesLabel + counter;
		this.propertyId = propertyLabel + counter;
		this.resourceId = resourceLabel + counter;

		this.classesName = classesName;
		this.propertyName = property + propertyName;
		this.resourceName = resourceName;

		this.position = position;
	}

	public String getClassesId() {
		return classesId;
	}

	public void setClassesId(String classesId) {
		this.classesId = classesId;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getClassesName() {
		return classesName;
	}

	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Classes [classesId=" + classesId + ", propertyId=" + propertyId + ", resourceId=" + resourceId
				+ ", classesName=" + classesName + ", propertyName=" + propertyName + ", resourceName=" + resourceName
				+ ", position=" + position + "]";
	}

}