package com.url.encurtador.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


import com.url.encurtador.model.Url;


public interface UrlRepository extends JpaRepository<Url, Long> {
	
	Optional<Url> findByShortUrl(String ShortUrl);
	
	
	//@Query("SELECT COUNT(u) FROM Url u WHERE u.shortUrl=?1")
	//long VerificarUrl(String UrlEncurtada);
	
	
	
}
