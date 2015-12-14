package org.coffee.barva.domain;

import org.apache.ibatis.type.Alias;

@Alias("board")
public class BoardVO {
	private int seq;
	private String content;
	private String title;
	private int user;
	
	
	
	public int getSeq() {
		return seq;
	}



	public void setSeq(int seq) {
		this.seq = seq;
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



	public int getUser() {
		return user;
	}



	public void setUser(int user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", content=" + content + ", title=" + title + ", user=" + user + "]";
	}

}
