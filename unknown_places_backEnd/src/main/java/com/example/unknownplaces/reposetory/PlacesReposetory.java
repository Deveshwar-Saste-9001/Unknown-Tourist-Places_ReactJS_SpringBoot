package com.example.unknownplaces.reposetory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.unknownplaces.model.Places;

@Repository
public interface PlacesReposetory extends JpaRepository<Places, Integer> {
	@Query("select p from Places p where category=:cat")
	public List<Places> getByCategory(@Param("cat") String category);
	
	@Query("select p from Places p where placeid=:id")
	public Places findByPlaceid(@Param("id") int id);
	
	@Query("select p from Places p where concat(p.placename, p.placecity, p.address, p.placestate,p.placecountry, p.category) like %:key%")
	public List<Places> placeSearch(@Param("key") String keyword);
}

