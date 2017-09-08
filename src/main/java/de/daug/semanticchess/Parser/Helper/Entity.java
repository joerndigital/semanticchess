package de.daug.semanticchess.Parser.Helper;

public class Entity {

	private final static String entityLabel = "E_";
	private final static String propertyLabel = "P_";
	private final static String property = "prop:";

	private String entityId;
	private String propertyId;

	private String entityName;
	private String propertyName;
	
	private int startPosition;
	private int endPosition;

	public Entity(int counter, String entityName, String propertyName, int startPosition, int endPosition) {
		this.entityId = entityLabel + counter;
		this.propertyId = propertyLabel + counter;

		this.entityName = entityName;
		this.propertyName = property + propertyName;
		
		this.startPosition = startPosition;
		this.endPosition = endPosition;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public int getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(int startPosition) {
		this.startPosition = startPosition;
	}

	public int getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(int endPosition) {
		this.endPosition = endPosition;
	}

	@Override
	public String toString() {
		return "Entity [entityId=" + entityId + ", propertyId=" + propertyId + ", entityName=" + entityName
				+ ", propertyName=" + propertyName + ", startPosition=" + startPosition + ", endPosition=" + endPosition
				+ "]";
	}

	
}