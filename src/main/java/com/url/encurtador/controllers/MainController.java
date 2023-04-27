package com.url.encurtador.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.url.encurtador.model.Url;
import com.url.encurtador.repositories.UrlRepository;
import com.url.encurtador.services.UrlService;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private UrlService urlService;
	
	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("/s/{short}")
	public ResponseEntity<?> redirecionar(@PathVariable(value="short") String id) throws URISyntaxException{
		String Url = urlService.Redirecionar(id);
		if(Url==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		System.out.println("--"+Url+"--"+Url.length());
		URI yahoo = new URI("http://"+Url.toLowerCase());
	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setLocation(yahoo);
	    return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
		
	}
	
	@PostMapping("/encurtar")
	public ResponseEntity<Url> cadastrar(@RequestBody @Valid Url url) {
		System.out.println(url.toString());
		Url urltosave = new Url();
		urltosave = urlService.SaveUrl(url);
		HttpHeaders headers = new HttpHeaders();
//		if(urltosave==null) {
//			return new ResponseEntity<>(headers,HttpStatus.BAD_REQUEST);
//		}
		headers.add("Custom-Header", "foo");
		return new ResponseEntity<Url>(
				urltosave, 
				headers, 
				HttpStatus.CREATED);
	}
	
}
