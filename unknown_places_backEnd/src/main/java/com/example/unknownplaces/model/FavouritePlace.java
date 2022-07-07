package com.example.unknownplaces.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FavouritePlace {
	
	@Id
	@GeneratedValue
	private int favid;
	
	@OneToOne
	private User user;
	
	@OneToOne
	private Places place;


	public int getFavid() {
		return favid;
	}



	public void setFavid(int favid) {
		this.favid = favid;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Places getPlace() {
		return place;
	}



	public void setPlace(Places place) {
		this.place = place;
	}



	public FavouritePlace() {
		super();
		// TODO Auto-generated constructor stub
	}



	public FavouritePlace(int favid, User user, Places place) {
		super();
		this.favid = favid;
		this.user = user;
		this.place = place;
	}
	
	
	
	
}
