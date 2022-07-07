package com.example.unknownplaces.servises;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.unknownplaces.model.User;
import com.example.unknownplaces.reposetory.UserRepository;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void addUser(User user) {
		
		this.userRepo.save(user);

	}
	
	

	@Override
	public User getSingleUser(Integer role,String email, String password) {
		System.out.println(role+" "+email+" "+password);
		User user=this.userRepo.findByRoleAndEmailAndPassword(role,email,password);
		return user; 
		
	}

	@Override
	public User getUserByEmail(String email) {
		System.out.println(email);
		User user=this.userRepo.findByEmail(email);
		return user; 
	
		}	

	@Override
	public boolean sendEmail(String subject, String message, String to)
	{
		boolean bool=false;
		String from="deveshwarsaste7@gmail.com";
		String host="smtp.gmail.com";
		
		//get system property
		Properties properties=System.getProperties();
		///.out.println("PROPERTIES "+properties);
		
		//host set
		
		properties.put("mail.smtp.host",host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//step1: to get the session object
		
		Session session=Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("deveshwarsaste7@gmail.com","Dev@love1432");
			}}
			);
		
		session.setDebug(true);
		
		MimeMessage m=new MimeMessage(session);
		
		try {
			
			m.setFrom(from);
			
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			m.setSubject(subject);
			
			//adding text
			m.setText(message);
			
			//step3 send the message 
			Transport.send(m);
			System.out.println("sent success......");
			bool=true;
			
			
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return bool;
	}



	@Override
	public User getUserId(int Id) {
		return userRepo.findById(Id);
	}



	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

	

}
