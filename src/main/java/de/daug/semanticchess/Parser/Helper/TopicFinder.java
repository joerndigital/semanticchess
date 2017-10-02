package de.daug.semanticchess.Parser.Helper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopicFinder {

	Set<String> topics = new HashSet<String>();
	String countThis = "";
	Set<String> blacklist = new HashSet<String>();

	public TopicFinder() {

	}

	public Set<String> collectTopics(List<Entity> entities, List<Classes> classes) {
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
		try {

			try {
				if (entities.get(0).getEntityName().isEmpty()) {
					topics.add(entities.get(0).getResourceName());
					entityIsEmpty = true;
				}
			} catch (Exception err) {
				entityIsEmpty = true;
			}
			System.out.println(classes.toString());
			for (Classes c : classes) {
				
				if (!entityIsEmpty) {
					if (c.getPosition() < firstEntityPosition) {
						if(!blacklist.contains(c.getClassesName())){
							topics.add(c.getClassesName());
							
						}
						
					}
				} else {

					if (c.getPosition() < secondEntityPosition) {
						if(!blacklist.contains(c.getClassesName())){
							topics.add(c.getClassesName());
							
						}
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

		} catch (Exception err) {

		}

		return this.topics;
	}

	public void addCount(String countThis) {
		this.topics.add("(COUNT(" + countThis + ") AS ?nr)");

	}
	
	public void addMax(String maxThis) {
		this.topics.add("(MAX(" + maxThis + ") AS ?nr)");

	}
	
	public void addAvg(String avgThis) {
		this.topics.add("(MAX(" + avgThis + ") AS ?nr)");

	}

	public Set<String> getTopics() {
		return topics;
	}

	public void setTopics(Set<String> topics) {
		this.topics = topics;
	}
	
	public void addToBlacklist(String topic){
		this.blacklist.add(topic);
	}

	public String getString() {
		String topicStr = "";
		String[] topicArray = topics.toArray(new String[topics.size()]);
		for (int i = topicArray.length - 1; i >= 0; i--) {
			
			topicStr += topicArray[i] + " ";
		}

		return topicStr;
	}

}