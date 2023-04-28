package com.url.encurtador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Url {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Informe um Link Valido")
	@Column(name = "full_url")
	private String fullUrl;
	
	@Column(name = "short_url")
	private String shortUrl;

	public String getFullurl() {
		return fullUrl;
	}

	public void setFullurl(String fullurl) {
		this.fullUrl = fullurl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	
	
	
}
