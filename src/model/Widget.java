package model;

public class Widget {
	int id;
	String name;
	int width;
	int height;
	String cssClass;
	String cssStyle;
	String text;
	int order;
	Page page;
	String type;
	String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Widget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Page page, String type) {
		super();
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
		this.page = page;
		this.type = type;
	}
	public Widget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Page page, String type) {
		super();
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
		this.page = page;
		this.type = type;
	}
	public Widget(String name, String type, String text, int order, int width, int height, String url) {
		super();
		this.name = name;
		this.width = width;
		this.height = height;
		this.text = text;
		this.order = order;
		this.type = type;
	}
	public Widget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, String type) {
		super();
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
		this.type = type;
	}

	public Widget(String string, int width, int height, String text, int order, String name) {
		super();
		this.name = name;
		this.width = width;
		this.height = height;
		this.text = text;
		this.order = order;
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
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	public String getCssStyle() {
		return cssStyle;
	}
	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
