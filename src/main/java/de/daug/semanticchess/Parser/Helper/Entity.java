package de.daug.semanticchess.Parser.Helper;

public class Entity {

	private final static String entityLabel = "E_";
	private final static String propertyLabel = "P_";
	private final static String property = "prop:";

	private String entityId;
	private String propertyId;

	private String entityName;
	private String propertyName;

	public Entity(int counter, String entityName, String propertyName) {
		this.entityId = entityLabel + counter;
		this.propertyId = propertyLabel + counter;

		this.entityName = entityName;
		this.propertyName = propertyName;
	}

	String getEntityId() {
		return entityId;
	}

	void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	String getPropertyId() {
		return propertyId;
	}

	void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	String getEntityName() {
		return entityName;
	}

	void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	String getPropertyName() {
		return propertyName;
	}

	void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

}