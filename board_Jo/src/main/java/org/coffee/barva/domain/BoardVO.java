package org.coffee.barva.domain;

public class BoardVO {

	private String content;
	private String title;
	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public BoardVO(String content, String title) {
		super();
		this.content = content;
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "BoardVO [content=" + content + ", title=" + title + "]";
	}
	
}
