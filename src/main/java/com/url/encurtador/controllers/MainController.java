package com.url.encurtador.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.url.encurtador.model.Url;
import com.url.encurtador.services.UrlService;
import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private UrlService urlService;
	
	
	
	@GetMapping()
	public ResponseEntity<List<Url>> listar(){
		return new ResponseEntity<List<Url>>(urlService.findAll(),HttpStatus.OK);
	}
	
	
	@GetMapping("/s/{short}")
	public ResponseEntity<?> redirecionar(@PathVariable(value="short") String id) throws URISyntaxException{
		String Url = urlService.Redirecionar(id);
		if(Url==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		URI url = new URI("http://"+Url);
	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setLocation(url);
	    return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
	}
	
		
	@PostMapping("/encurtar")
	public ResponseEntity<?> cadastrar(@RequestBody @Valid Url url) {
		Url urltosave = new Url();
		urltosave = urlService.SaveUrl(url);
		if(urltosave==null)return new ResponseEntity<>("Informe uma URL Valída",HttpStatus.BAD_REQUEST);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "foo");
		return new ResponseEntity<Url>(urltosave, headers, HttpStatus.CREATED);
	}
}
