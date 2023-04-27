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
	private String link;
	
	private String urlencurtada;
	
	
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "Url [id=" + id + ", link=" + link + ", urlencurtada=" + urlencurtada + "]";
	}
	public String getUrlencurtada() {
		return urlencurtada;
	}
	public void setUrlencurtada(String urlencurtada) {
		this.urlencurtada = urlencurtada;
	}
	
}
