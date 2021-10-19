package com.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int usersCount = 0;
	
	static {
		users.add(new User(1, "Sapta", new Date()));
		users.add(new User(2, "Adam", new Date()));
		users.add(new User(3, "John", new Date()));
		usersCount += 3;
	}

	// Get All Users
	public List<User> findAll(){
		return users;
	}
	
	// Get user by ID
	public User getUserByID(int id){
		for(User user : users) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}
	
	// Save User
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	// Delete User by ID
	public User deleteUserByID(int id){
		for(User user : users) {
			if(user.getId() == id) {
				users.remove(user);
				return user;
			}
		}
		return null;
	}
	
	
	
}
