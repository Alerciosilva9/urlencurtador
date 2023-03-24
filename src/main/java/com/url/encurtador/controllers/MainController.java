package com.url.encurtador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.url.encurtador.model.Url;
import com.url.encurtador.repositories.UrlRepository;

@Controller

@RequestMapping("/")
public class MainController {
	
	@Autowired
	private UrlRepository repo;
	
	@GetMapping
	@ResponseBody
	public List<Url> princial() {
		return repo.findAll();
	}
}
