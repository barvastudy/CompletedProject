package org.coffee.barva.domain;

import org.apache.ibatis.type.Alias;

@Alias("user")
public class UserVO {
	private int seq;
	private String userId;
	private String userPw;
	
	public UserVO(){
		
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	@Override
	public String toString() {
		return "UserVO [seq=" + seq + ", userId=" + userId + ", userPw=" + userPw + "]";
	}
	
}