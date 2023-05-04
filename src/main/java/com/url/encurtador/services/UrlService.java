package com.url.encurtador.services;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.url.encurtador.model.Url;
import com.url.encurtador.repositories.UrlRepository;

@Service
public class UrlService {
	
	@Autowired
	UrlRepository repo;
	
	
	public Url SaveUrl(Url url) {
		String fullurl = formatUrl(url.getFullurl());
		if(!validarUrl(fullurl))return null;
		
		Url urltosave = new Url();	
		urltosave.setFullurl(fullurl);
		String encurtada = getRandom(5);
		while(repo.VerificarUrl(encurtada)>0) {
			encurtada = getRandom(5);
		}
		urltosave.setShortUrl(encurtada);
		repo.save(urltosave);
		return urltosave;
	}
	
	public List<Url> findAll(){
		return repo.findAll();
	}
	
	public String Redirecionar(String shortUrl) {
		Url urlRedirect = repo.findByShortUrl(shortUrl).orElse(null);
		if(urlRedirect==null) {
			return null;
		}
		return urlRedirect.getFullurl();
	}
	
	public String formatUrl(String url) {
		String[] prefixes = new String[]{"https://","https:/","http://","http:/"};
		for(String s:prefixes) {
			if(url.startsWith(s)) {
				return url.substring(s.length());
			}
		}
		return url;
	}
	
	
	public Boolean validarUrl(String url) {
        String regex = "(www.)"
              + "[a-zA-Z0-9@:%._\\+~#?&//=]"
              + "{2,256}\\.[a-z]"
              + "{2,6}\\b([-a-zA-Z0-9@:%"
              + "._\\+~#?&//=]*)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(url);
        return m.matches();
		
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
