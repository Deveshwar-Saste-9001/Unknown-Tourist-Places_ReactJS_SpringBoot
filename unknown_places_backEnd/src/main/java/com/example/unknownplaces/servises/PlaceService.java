package com.example.unknownplaces.servises;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.unknownplaces.model.Places;
import com.example.unknownplaces.reposetory.PlacesReposetory;

@Service
public class PlaceService {
	
	@Autowired
	private PlacesReposetory placeRepo;
	
	
	public Places addPlace(Places place) {
		return placeRepo.save(place);
	}


	public List<Places> getPlaces() {
		return placeRepo.findAll();
	}
	
	public List<Places> getCatPlaces(String category){
		return placeRepo.getByCategory(category);
	}

	
	public Places getPlaceById(int id) {
		return placeRepo.findByPlaceid(id);
	}
	
	public List<Places> getSearch(String keyword){
		return placeRepo.placeSearch(keyword);
	}
}
