package com.SpringBootJPA.demo.Dao;

import org.springframework.data.repository.CrudRepository;

import com.SpringBootJPA.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien,Integer>{
	
	

}
