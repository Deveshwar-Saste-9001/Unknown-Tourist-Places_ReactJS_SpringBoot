package com.example.unknownplaces.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.unknownplaces.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByRoleAndEmailAndPassword(Integer role,String email, String password);
	public User findByEmail(String email);
	public User findById(int id);
}
