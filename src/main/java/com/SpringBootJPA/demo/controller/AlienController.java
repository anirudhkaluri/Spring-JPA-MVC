package com.SpringBootJPA.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.SpringBootJPA.demo.Dao.AlienRepo;
import com.SpringBootJPA.demo.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp"; //for this to return jsp we need to add tomcat jasper.
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		
		ModelAndView mv=new ModelAndView("showAlien.jsp");
		Alien alien=repo.findById(aid).orElse(new Alien());
		System.out.println("\n\n\nAliens with ID greater than+"+aid);
		System.out.println(repo.findByAidGreaterThan(aid));
		mv.addObject(alien);
		return mv;
	}
	
	@RequestMapping("/getWithTech")
	public void getWithTech(@RequestParam String tech) {
		System.out.println(repo.findByTech(tech));
		
		System.out.println("\n\n\n\nAFTER SORTING");
		
		System.out.println(repo.findByTechSorted(tech));
		
	}
	
	@RequestMapping("/aliens")
	@ResponseBody
	public String getAllAliens() {
		return repo.findAll().toString();
	}
	
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public String getSpecificAlien(@PathVariable("aid") int aid) {
		return repo.findById(aid).toString();
	}
	
	
}
