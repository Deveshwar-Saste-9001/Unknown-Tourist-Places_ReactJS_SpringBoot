package com.example.unknownplaces.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.unknownplaces.model.FavouritePlace;
import com.example.unknownplaces.model.Places;
import com.example.unknownplaces.model.User;
import com.example.unknownplaces.reposetory.FavouritePlaceRepository;
import com.example.unknownplaces.reposetory.PlacesReposetory;
import com.example.unknownplaces.reposetory.UserRepository;
import com.example.unknownplaces.servises.FavouritePlaceService;
import com.example.unknownplaces.servises.PlaceService;
import com.example.unknownplaces.servises.UserService;

@RestController
@CrossOrigin
public class FavouritePlaceController {

	@Autowired
	private FavouritePlaceService favouritePlaceService;

	@Autowired
	private PlaceService placeService;

	@Autowired
	private UserService userService;

	@PostMapping("/addfavplace")
	public FavouritePlace addToFavPlace(@RequestBody FavouritePlace favplace) {
		Places place = favplace.getPlace();
		place = placeService.getPlaceById(place.getPlaceid());
		User user = favplace.getUser();
		user = userService.getUserId(user.getId());
		favplace.setUser(user);
		favplace.setPlace(place);
		FavouritePlace fav1 = favouritePlaceService.getFavByUserAndPlace(user.getId(), place.getPlaceid());
		if(fav1==null) {
			return favouritePlaceService.addFav(favplace);
		}else {
			return null;
		}
		
		
	}

	@GetMapping("/getAllFav")
	public List<FavouritePlace> getAll() {
		return favouritePlaceService.getall();
	}
	
	@PostMapping("/getfavplaces")
	public List<FavouritePlace> getMyFav(@RequestBody FavouritePlace fav){
		
		return favouritePlaceService.getFav(fav.getUser().getId());
	}

}
