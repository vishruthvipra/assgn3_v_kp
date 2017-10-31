package model;

public class Page {
	int id;
	String title;
	String description;
	String created;
	String updated;
	int views;
	Website website;
	public Page(String title, String description, String created, String updated, int views, Website website) {
		super();
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
		this.website = website;
	}
	public Page(int id, String title, String description, String created, String updated, int views,
			Website website) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
		this.website = website;
	}
	public Page(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	public Page(String string, String string2, String string3, int i) {
		this.title = string;
		this.description = string2;
		this.website.name = string3;
		this.views = i;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getcreated() {
		return created;
	}
	public void setcreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public Website getWebsite() {
		return website;
	}
	public void setWebsite(Website website) {
		this.website = website;
	}
}

