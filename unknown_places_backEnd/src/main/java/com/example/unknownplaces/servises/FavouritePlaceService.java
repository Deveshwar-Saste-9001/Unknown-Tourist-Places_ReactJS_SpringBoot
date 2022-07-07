package com.example.unknownplaces.servises;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.unknownplaces.model.FavouritePlace;
import com.example.unknownplaces.reposetory.FavouritePlaceRepository;

@Service
public class FavouritePlaceService {
	@Autowired
	private FavouritePlaceRepository favouritePlaceRepository;
	
	public FavouritePlace addFav(FavouritePlace favplace) {
		return favouritePlaceRepository.save(favplace);
	}
	
	public List<FavouritePlace> getall(){
		return favouritePlaceRepository.findAll();
	}
	
	public List<FavouritePlace> getFav(int id){
		return favouritePlaceRepository.getByUser(id);
	}
	
	public FavouritePlace getFavByUserAndPlace(int userid, int placeid) {
		return favouritePlaceRepository.getByUserAndPlace(userid, placeid);
	}
}

