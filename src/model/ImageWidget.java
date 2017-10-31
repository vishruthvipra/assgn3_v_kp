package model;

public class ImageWidget extends Widget{
	int id;
	String src;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public ImageWidget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Page page, String type, int id, String src) {
		super(name, width, height, cssClass, cssStyle, text, order, page, type);
		this.id = id;
		this.src = src;
	}
	public ImageWidget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Page page, String type, String src) {
		super(name, width, height, cssClass, cssStyle, text, order, page, type);
		this.src = src;
	}
	public ImageWidget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Page page, String type) {
		super(name, width, height, cssClass, cssStyle, text, order, page, type);
	}
	public ImageWidget(String name, String img, int width, int height, int order, String link, String page) {
		super(name, width, height, order, page);
		this.src = link;
	}
	
}
