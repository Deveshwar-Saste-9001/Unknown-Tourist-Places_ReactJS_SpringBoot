package com.example.unknownplaces.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.unknownplaces.model.Message1;
import com.example.unknownplaces.model.OTP;
import com.example.unknownplaces.model.User;
import com.example.unknownplaces.reposetory.MessageRepo;
import com.example.unknownplaces.reposetory.UserRepository;

import com.example.unknownplaces.servises.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userservice;
	
	@Autowired
	private MessageRepo messageRepo;

	@PostMapping("/register")
	public void addUser(@RequestBody User user) {
		user.setRole(1);
		this.userservice.addUser(user);

	}
	@PostMapping("/getsingleuser")
	public User getSingUser(@RequestBody User user) {
		return userservice.getUserId(user.getId());
	}
	
	

	@Autowired
	private UserRepository userrepo;
	Random random = new Random(10000);

	@PostMapping("/login")
	public User confirmTourist(@RequestBody User tourist1) {
 System.out.println("fun called");
		User  tourist = this.userservice.getSingleUser(tourist1.getRole(), tourist1.getEmail(),
				tourist1.getPassword());
		if (tourist != null) {
			if (tourist.getRole() == 1) {
				return tourist;
			} else if (tourist.getRole() == 0) {
				return tourist;
			}
		} else {
			return null;
		}
		return null;
	}

	@PostMapping("/forgetPass")
	public OTP confirmTourist1(@RequestBody User tourist1) {

		OTP otp1 = new OTP();

		User tr = this.userservice.getUserByEmail(tourist1.getEmail());
		if (tr != null) {
			int otp = random.nextInt(999999);
		
			String subject = "OTP from Unknown Tourist Places";
			String message = "OTP = " + otp;
			String to = tr.getEmail();
			otp1.setOtp(otp);

			boolean flag = this.userservice.sendEmail(subject, message, to);

			if (flag == true) {
				
				otp1.setStatus("success");
				return otp1;
			} else {

			
				otp1.setStatus("not success");
				return otp1;
			}
		} else {

			System.out.println("not successfull");
			return otp1;
		}

	}

	@PostMapping("/resetPassaword")
	public String resetPassword(@RequestBody User tourist1) {
		User tourist = this.userservice.getUserByEmail(tourist1.getEmail());
		String pass = tourist1.getPassword();
		tourist.setPassword(pass);
		this.userrepo.save(tourist);
		return "success";
	}
	
	@GetMapping("/getallusers")
	public List<User> getAllUsers(){
		return userservice.getAll();
	}
	
	@PostMapping("/getUser")
	public User getUserId(@RequestBody User user) {
		return userservice.getUserId(user.getId());
	}
	
	@PostMapping("/message")
	public void message(@RequestBody Message1 message)
	{
		this.messageRepo.save(message);
	
		 
	
	}

}
