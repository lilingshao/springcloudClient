package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@Service("userService")
public class UserService {
	
	@Autowired
    private UserDao userDao;

	@Autowired
	private SqlSessionTemplate sqlSession;

	public boolean addUser(User record) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<User> getUsers(Map<String, Object> params) {
		return userDao.getUsers(params);
	}

	public List<User> getUsers2(Map<String, Object> params) {
		List<User> list = sqlSession.selectList("test.getUsers",params);
		for(User user :list){
            System.out.println(user);
        }
		return list;
	}

}
