package com.example.unknownplaces.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message1 {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private long no;
	private String email;
	private String msg;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Message1(int id, String name, long no, String email, String msg) {
		super();
		this.id = id;
		this.name = name;
		this.no = no;
		this.email = email;
		this.msg = msg;
	}
	public Message1() {
		super();
	}
	
	
	
}
