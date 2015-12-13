package org.coffee.barva.service;

import org.coffee.barva.dao.UserMapper;
import org.coffee.barva.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserVO userinfo() {
		return userMapper.userinfo();
	}

}
