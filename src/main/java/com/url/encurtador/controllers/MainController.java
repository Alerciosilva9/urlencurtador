package com.url.encurtador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.url.encurtador.model.Url;
import com.url.encurtador.repositories.UrlRepository;
import com.url.encurtador.services.UrlService;

@Controller

@RequestMapping("/")
public class MainController {
	
	@Autowired
	private UrlService urlService;
	
//	@GetMapping
//	@ResponseBody
//	public List<Url> princial() {
//		return repo.findAll();
//	}
	@GetMapping
	public String index() {
		return "index";
	}
	
	@PostMapping
	public String cadastrar(@Validated @RequestBody Url url) {
		System.out.println("REQUISICAO....."+url.getLink()+"--"+url.getUrlencurtada());
		Url urltosave = new Url();
		urltosave.setUrlencurtada(url.getUrlencurtada());
		urltosave.setLink(url.getLink());
		urlService.SaveUrl(urltosave);
		return "index";
	}
	
}
