package com.myphotos.demo.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity		// si indica che questa è una classe associata ad una tabella nel DB
public class Photo {

	@Id		// si indica che questa proprietà è il campo chiave della classe-entity
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// si indica che questo pk deve essere generato automaticamente e in modo autoincrement
	private int id;
	
	@NotBlank(message = "this field is required")	// si indica a spring che se una foto non ha "url", si stampa nei log il messaggio
	@Length(min = 2, message = "min length is 2 chars")		// si fa in modo che la foto non venga salvata se l'url non è almeno di 2 caratteri
	private String url;
	
	public Photo() {

	}

	public Photo(int id, String url) {
		this.id = id;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", url=" + url + "]";
	}
	
}
