package com.mdtalalwasim.redis.DAO;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.mdtalalwasim.redis.entity.User;

@Repository
public class UserDao {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	
	private static final String KEY = "USER";
	
	//save user
	
	public User save(User user) {
		redisTemplate.opsForHash().put(KEY, user.getUserId(), user);
		return user;
	}
	
	//update user
	public User updateUser(User user) {
		
		Object oldUser = redisTemplate.opsForHash().get(KEY, user.getUserId());
		if (oldUser != null) {
		    // oldUser is not null
		    System.out.println("Old user exists: " + oldUser);
		   User oldUserInDB = (User) oldUser;
		   oldUserInDB.setUserId(user.getUserId());
		   oldUserInDB.setName(user.getName());
		   oldUserInDB.setEmail(user.getEmail());
		   oldUserInDB.setPhone(user.getPhone());
		   redisTemplate.opsForHash().put(KEY, user.getUserId(), oldUserInDB);
		   return oldUserInDB;
		}else {
			 System.out.println("User with ID " + user.getUserId() + " does not exist.");
			return null;
		}
	}
	
	// get user

	public User getUser(String userId) {
		return (User) redisTemplate.opsForHash().get(KEY, userId);
		
	}
	
	//findAll
	public Map<Object, Object> findAll(){
		return redisTemplate.opsForHash().entries(KEY);
	}
	
	// delete user
	public void deleteUser(String userId) {
		 redisTemplate.opsForHash().delete(KEY, userId);
	}
	
	
}
