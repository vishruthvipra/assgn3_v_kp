package model;

import java.util.ArrayList;

public class Developer extends Person {
	private int id;
	private String developerKey;
	private ArrayList<Website> website;
	
	public Developer(String username, String password, String first_name, String last_name, String email,
			String developerKey) {
		super(username, password, first_name, last_name, email);
		this.developerKey = developerKey;
	}
	public Developer(String username, String password, String first_name, String last_name, String email) {
		super(username, password, first_name, last_name, email);
	}
	public Developer(String username, String password, String first_name, String last_name, String email, int id,
			String developerKey, ArrayList<Website> website) {
		super(username, password, first_name, last_name, email);
		this.id = id;
		this.developerKey = developerKey;
		this.website = website;
	}
	public Developer(int id, String username, String password, String first_name, String last_name, String email,
			String developerKey) {
		super(username, password, first_name, last_name, email);
		this.id = id;
		this.developerKey = developerKey;
	}
	public ArrayList<Website> getWebsite() {
		return website;
	}
	public void setWebsite(ArrayList<Website> website) {
		this.website = website;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeveloperKey() {
		return developerKey;
	}
	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}
	
}
