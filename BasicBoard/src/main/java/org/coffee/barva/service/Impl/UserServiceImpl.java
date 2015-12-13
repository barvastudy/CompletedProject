package org.coffee.barva.service.Impl;

import java.util.List;

import org.coffee.barva.dao.UserMapper;
import org.coffee.barva.domain.UserVO;
import org.coffee.barva.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;
	


	@Override
	public int insertUser(UserVO user) {
		// TODO Auto-generated method stub
		
		return userMapper.inserUser(user);
	}

	@Override
	public UserVO loginUser(UserVO user) {
		// TODO Auto-generated method stub
		
		List<UserVO> users= userMapper.getUser(user);
		if(users.size()!=0)
			user=users.get(0);
		else
			user=null;
		return user;
	}
}
