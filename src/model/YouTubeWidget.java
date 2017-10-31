package model;

public class YouTubeWidget {
	int id;
	Widget widget;
	boolean shareable;
	boolean expandable;
	String url;
	public YouTubeWidget(int id, Widget widget, boolean shareable, boolean expandable, String url) {
		super();
		this.id = id;
		this.widget = widget;
		this.shareable = shareable;
		this.expandable = expandable;
		this.url = url;
	}
	public YouTubeWidget(Widget widget, boolean shareable, boolean expandable, String url) {
		super();
		this.widget = widget;
		this.shareable = shareable;
		this.expandable = expandable;
		this.url = url;
	}
	public YouTubeWidget(String string, Object object, int i, int j, int k, String string2, String string3) {
		super(string, i, j, k, string3);
		this.url = string2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Widget getWidget() {
		return widget;
	}
	public void setWidget(Widget widget) {
		this.widget = widget;
	}
	public boolean isShareable() {
		return shareable;
	}
	public void setShareable(boolean shareable) {
		this.shareable = shareable;
	}
	public boolean isExpandable() {
		return expandable;
	}
	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
