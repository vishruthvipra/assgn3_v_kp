package model;

public class Role {
	int id; 
	String devKey;
	String websiteId;
	String pageId;
	String role;
	
	public Role(int id, String devKey, String pageId, String role) {
		super();
		this.id = id;
		this.devKey = devKey;
		this.pageId = pageId;
		this.role = role;
	}
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Role(String devKey, String websiteId, String role) {
		super();
		this.devKey = devKey;
		this.websiteId = websiteId;
		this.role = role;
	}
	public String getDevKey() {
		return devKey;
	}
	public void setDevKey(String devKey) {
		this.devKey = devKey;
	}
	public String getWebsiteId() {
		return websiteId;
	}
	public void setWebsiteId(String websiteId) {
		this.websiteId = websiteId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
