package com.meetpaija.toDo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meetpaija.toDo.Model.toDo_model;
@Repository
public interface toDo_Repo extends JpaRepository<toDo_model, Long>{
	

}
