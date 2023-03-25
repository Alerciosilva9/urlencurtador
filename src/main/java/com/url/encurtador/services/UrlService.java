package com.url.encurtador.services;

import java.nio.charset.Charset;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.url.encurtador.model.Url;
import com.url.encurtador.repositories.UrlRepository;

@Service
public class UrlService {
	@Autowired
	UrlRepository repo;
	
	
	public Url SaveUrl(Url url) {
		Url urltosave = new Url();
		urltosave = repo.findByLink(url.getLink()).orElse(null);
		if(urltosave!=null) {
			return urltosave;
		}
		urltosave = new Url();
		urltosave.setLink(url.getLink());
		String encurtada = getRandom(5);
		while(verificarurl(encurtada)) {
			encurtada = getRandom(5);
		}
		urltosave.setUrlencurtada(encurtada);
		repo.save(urltosave);
		return urltosave;
	}
	//FUNÇÃO QUE VERIFICA SE URL GERADA JÁ EXISTE NO BANCO
	public Boolean verificarurl(String urlencurtada) {
		System.out.println("Verificando..."+urlencurtada);
		System.out.println(repo.VerificarUrl(urlencurtada));
		if(repo.VerificarUrl(urlencurtada)>0){
			return true;
		}
		return false;
	}
	
	//FUNÇÃO QUE GERA URL ENCURTADA ALEATORIA
	public String getRandom(int n){
		// length is bounded by 256 Character
		byte[] array = new byte[256];
		new Random().nextBytes(array);
		
		String randomString
		= new String(array, Charset.forName("UTF-8"));
		
		// Create a StringBuffer to store the result
		StringBuffer r = new StringBuffer();
		
		// Append first 20 alphanumeric characters
		// from the generated random String into the result
		for (int k = 0; k < randomString.length(); k++) {
		
		char ch = randomString.charAt(k);
		
		if (((ch >= 'a' && ch <= 'z')
			|| (ch >= 'A' && ch <= 'Z')
			|| (ch >= '0' && ch <= '9'))
			&& (n > 0)) {
		
			r.append(ch);
			n--;
		}
		}
		
		// return the resultant string
		return r.toString();
	}
	
}
