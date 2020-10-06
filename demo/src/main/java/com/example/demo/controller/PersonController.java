package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.interfaces.UserInterface;
import com.google.gson.Gson;

import lombok.extern.log4j.Log4j2;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(path = "/usr", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@Log4j2
public class PersonController {
	
	//CRUD (Create, Retrieve, Update, Delete)

	//POST, GET, PUT, DELETE
	@Autowired
	private UserInterface userInterface;
    
	@GetMapping("/{nome}")
	public String listaPerson(@PathVariable(value="nome") String name){
		
		Optional<Person> person = this.userInterface.findFirstByNome(name);
		String usr = new Gson().toJson(person.get(), Person.class);

		return usr;
	}

}
