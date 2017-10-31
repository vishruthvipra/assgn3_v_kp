package model;

public class HeadingWidget extends Widget {
	private int id;
	private int size;
	public HeadingWidget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Page page, String type, int id, int size) {
		super(name, width, height, cssClass, cssStyle, text, order, page, type);
		this.id = id;
		this.size = size;
	}
	public HeadingWidget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Page page, String type) {
		super(name, width, height, cssClass, cssStyle, text, order, page, type);
	}
	public HeadingWidget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Page page, String type, int size) {
		super(name, width, height, cssClass, cssStyle, text, order, page, type);
		this.size = size;
	}
	public HeadingWidget(String string, String string2, int i, int object, int object2, String object3,
			String string3) {
		super(string, object, object2, string2, i, string3);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
