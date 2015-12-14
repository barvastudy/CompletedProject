package org.coffee.barva.service;

import java.util.List;

import org.coffee.barva.domain.UserVO;

public interface UserService {
	public int insertUser(UserVO user);
	public UserVO loginUser(UserVO user);
}
