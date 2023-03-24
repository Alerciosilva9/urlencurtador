package com.url.encurtador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.url.encurtador.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
	
}
