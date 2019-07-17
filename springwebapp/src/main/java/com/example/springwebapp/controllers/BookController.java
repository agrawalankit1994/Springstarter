package com.example.springwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springwebapp.repositories.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping("/books")
	public String getBooks(Model m) {
		m.addAttribute("books",bookRepository.findAll());
		return "books";
	}
}
