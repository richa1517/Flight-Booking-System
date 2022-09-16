package com.capg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.IUserDao;
import com.capg.entities.User;
import com.capg.exceptions.UserAlreadyExistsException;
import com.capg.exceptions.UserNotFoundException;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserDao userDao;
	@Override
	public List<User> getUsers() {
		return userDao.findAll();
	}

	@Override
	public User getUser(int userId) {
		if(userDao.findById(userId).isEmpty()) {
			throw new UserNotFoundException();
		}
		return userDao.findById(userId).get();
	}

	@Override
	public User addUser(User user) {
		if(userDao.existsById(user.getUserId())) {
			throw new UserAlreadyExistsException();
		}
		userDao.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		if(userDao.findById(user.getUserId()).isEmpty()) {
			throw new UserNotFoundException();
		}
		userDao.save(user);
		return user;
	}

	@Override
	public void deleteUser(int userId) {
		if(userDao.findById(userId).isEmpty()) {
			throw new UserNotFoundException();
		}
		User u = userDao.findById(userId).get();
		userDao.delete(u);
	}
	
}
