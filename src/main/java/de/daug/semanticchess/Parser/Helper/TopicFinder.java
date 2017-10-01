package de.daug.semanticchess.Parser.Helper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopicFinder {

	Set<String> topics = new HashSet<String>();
	List<Entity> entities;
	List<Classes> classes;

	public TopicFinder(List<Entity> entities, List<Classes> classes) {
		this.entities = entities;
		this.classes = classes;
		this.topics = getTopics();
	}

	public Set<String> getTopics() {
		int firstEntityPosition = 999;
		int secondEntityPosition = 999;
		int firstClassesPosition = 999;
		
		try {
			firstEntityPosition = entities.get(0).getStartPosition();

		} catch (Exception err) {

		}

		try {
			secondEntityPosition = entities.get(1).getStartPosition();
		} catch (Exception err) {

		}
		
		try {
			firstClassesPosition = classes.get(0).getPosition();
		} catch (Exception err) {

		}
		
		boolean entityIsEmpty = false;
		if(entities.get(0).getEntityName().isEmpty()){
			topics.add(entities.get(0).getResourceName());
			entityIsEmpty = true;
		}
		
		for (Classes c : classes) {
			
			if(!entityIsEmpty){
				if (c.getPosition() < firstEntityPosition) {
					topics.add(c.getClassesName());
				}
			} else {
				
				if (c.getPosition() < secondEntityPosition) {
					
					topics.add(c.getClassesName());
				}
			}

		}

		if (topics.isEmpty()) {
			for (Entity e : entities) {
				if (e.getStartPosition() < firstClassesPosition && e.getEntityName().isEmpty()) {
					topics.add(e.getResourceName());
				} 
			}

		}

		return this.topics;
	}
	

	public String getString(){
		String topicStr = "";
		
		for(String t : topics){
			topicStr += t + " ";
		}
		
		return topicStr;
	}
	
	

}