package com.url.encurtador.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.url.encurtador.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
	
	Optional<Url> findByLink(String Link);
	
	@Query("SELECT COUNT(u) FROM Url u WHERE u.urlencurtada=?1")
	long VerificarUrl(String UrlEncurtada);
	
	
	
}
