package org.jzandag.web.JaxRsApp.service;

import java.util.ArrayList;
import java.util.List;

import org.jzandag.web.JaxRsApp.DataModel;
import org.jzandag.web.JaxRsApp.errors.NoSuchResourceException;
import org.jzandag.web.JaxRsApp.model.User;

public class UserService {
	private static UserService userService = new UserService();
	
	DataModel data = new DataModel();
	
	private UserService() {
		User user1 = new User();
			user1.setId(1L);
			user1.setUsername("Zidrex");
		User user2 = new User();
			user2.setId(2L);
			user2.setUsername("Admin");
		data.getUsers().put(user1.getId(), user1);
		data.getUsers().put(user2.getId(), user2);
	}
	
	//Singleton pattern
	public static UserService getInstance(){
       return userService;
	}
	
	public User getUser(Long id) {
		return data.getUsers().get(id);
	}

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		for( User user : data.getUsers().values()) users.add(user);
		return users;
	}

	public User saveUser(User user) {
		if(user.getId() == 0) {
			return null;
		}
		data.getUsers().put(data.getUsers().size() + 1L, user);
		return user;
	}

	public User updateUser(Long id, User user) {
		if(!data.getUsers().containsKey(id))
			throw new NoSuchResourceException();
		return data.getUsers().put(id, user);
	}

	public void deleteUser(Long id) {
		if(!data.getUsers().containsKey(id))
			throw new NoSuchResourceException();
		data.getUsers().remove(id);
	}
	
	
	
}
