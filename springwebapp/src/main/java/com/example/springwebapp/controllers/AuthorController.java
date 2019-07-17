package com.example.springwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.springwebapp.repositories.AuthorRepository;

@Controller
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepository;
	
	@RequestMapping("/authors")
	public String getAuthors(Model m) {
		m.addAttribute("authors",authorRepository.findAll());
		return "authors";
	}
}
