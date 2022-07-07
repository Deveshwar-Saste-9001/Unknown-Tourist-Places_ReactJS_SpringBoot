package com.example.unknownplaces.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.unknownplaces.model.Message1;

@Repository
public interface MessageRepo extends JpaRepository<Message1, Integer> {

}
