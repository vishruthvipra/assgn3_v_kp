package model;

public class HtmlWidget extends Widget{
	int id;
	String html;
	public HtmlWidget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Page page, String type, int id, String html) {
		super(name, width, height, cssClass, cssStyle, text, order, page, type);
		this.id = id;
		this.html = html;
	}
	public HtmlWidget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Page page, String type) {
		super(name, width, height, cssClass, cssStyle, text, order, page, type);
	}
	public HtmlWidget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Page page, String type, String html) {
		super(name, width, height, cssClass, cssStyle, text, order, page, type);
		this.html = html;
	}
	public HtmlWidget(String string, String string2, int i, int j, int k, String l, String string3) {
		super(string, i, j, string2, i, string3);
		this.html = string2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	
}
