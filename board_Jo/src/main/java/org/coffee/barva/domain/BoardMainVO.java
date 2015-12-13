package org.coffee.barva.domain;

public class BoardMainVO {
	private String content;
	private String title;
	private int seq;

	public BoardMainVO() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardMainVO(String content, String title){
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
		return "BoardMainVO [content=" + content + ", title=" + title + ", seq=" + seq + "]";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
	
}