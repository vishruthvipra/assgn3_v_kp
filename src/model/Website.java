package model;

import java.util.ArrayList;

public class Website {
	int id;
	String name;
	String description;
	String created;
	String updated;
	int visits;
	ArrayList<Developer> devKey;
	
	public Website() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}

	public ArrayList<Developer> getDevKey() {
		return devKey;
	}

	public void setDevKey(ArrayList<Developer> devKey) {
		this.devKey = devKey;
	}

	public Website(int id, String name, String description, String created, String updated, int visits,
			ArrayList<Developer> devKey) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
		this.devKey = devKey;
	}

	public Website(String name, String description, int visits) {
		super();
		this.name = name;
		this.description = description;
		this.visits = visits;
	}

	public Website(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Website(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Website(String name, String description, ArrayList<Developer> devKey) {
		super();

		this.name = name;
		this.description = description;
		this.devKey = devKey;
	}
	

}
