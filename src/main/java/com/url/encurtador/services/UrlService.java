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
		urltosave.setFullurl(url.getFullurl());
		String encurtada = getRandom(5);
		while(repo.VerificarUrl(encurtada)>0) {
			encurtada = getRandom(5);
		}
		urltosave.setShortUrl(encurtada);
		repo.save(urltosave);
		return urltosave;
	}
	
	public String Redirecionar(String shortUrl) {
		Url urlRedirect = repo.findByShortUrl(shortUrl).orElse(null);
		if(urlRedirect==null) {
			return null;
		}else {
			return urlRedirect.getFullurl();
		}
	}
	
	public boolean validarUrl(String url) {
		return true;
	}
	
	
	//FUNÇÃO QUE GERA URL ENCURTADA ALEATORIA
	public String getRandom(int n){
		
		
		byte[] array = new byte[256];
		new Random().nextBytes(array);
		
		String randomString = new String(array, Charset.forName("UTF-8"));
		
		StringBuffer r = new StringBuffer();
		

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
