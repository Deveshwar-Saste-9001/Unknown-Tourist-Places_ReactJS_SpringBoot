package com.example.unknownplaces.servises;

import java.util.List;

import com.example.unknownplaces.model.User;



public interface UserService {

	public void addUser(User user);
	

	User getSingleUser(Integer role,String email, String password);
	User getUserByEmail(String email);
	public boolean sendEmail(String subject, String message, String to);
	public User getUserId(int Id);
	public List<User> getAll();
}

