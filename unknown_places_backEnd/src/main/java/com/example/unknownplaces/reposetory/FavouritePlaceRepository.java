package com.example.unknownplaces.reposetory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.unknownplaces.model.FavouritePlace;

@Repository
public interface FavouritePlaceRepository extends JpaRepository<FavouritePlace, Integer>{
	
	@Query("select f from FavouritePlace f where user_id=:key")
	public List<FavouritePlace> getByUser(@Param("key") int id);
	
	@Query("select f from FavouritePlace f where user_id=:userid and place_placeid=:key")
	public FavouritePlace getByUserAndPlace(@Param("userid") int userid, @Param("key") int placeid);

}
