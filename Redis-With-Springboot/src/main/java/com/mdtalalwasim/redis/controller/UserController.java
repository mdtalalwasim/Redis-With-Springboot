package com.mdtalalwasim.redis.controller;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdtalalwasim.redis.DAO.UserDao;
import com.mdtalalwasim.redis.entity.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserDao userDao;

	// create new user
	@PostMapping("/save-user")
	public User saveNewUser(@RequestBody User user) {

		user.setUserId(UUID.randomUUID().toString());

		return userDao.save(user);
	}

	// create new user
	@PutMapping("/update-user")
	public User updateUser(@RequestBody User user) {

		//user.setUserId(UUID.randomUUID().toString());

		return userDao.updateUser(user);
	}

	// get single user
	@GetMapping("get-user/{userId}")
	public User getSingleUser(@PathVariable String userId) {
		return userDao.getUser(userId);
	}

	// get all user
	@GetMapping("/all-user")
	public Map<Object, Object> getAllUser() {
		return userDao.findAll();
	}

	// delete single user
	@DeleteMapping("/delete/{userId}")
	public void deleteUserByUserId(@PathVariable String userId) {
		userDao.deleteUser(userId);
	}

}
