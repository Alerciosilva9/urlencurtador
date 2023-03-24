package com.url.encurtador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "encurtar.url")
public class Url {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String link;
	private String urlencurtada;
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getUrlencurtada() {
		return urlencurtada;
	}
	public void setUrlencurtada(String urlencurtada) {
		this.urlencurtada = urlencurtada;
	}
	
}
