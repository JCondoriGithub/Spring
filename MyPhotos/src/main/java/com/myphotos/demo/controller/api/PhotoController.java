package com.myphotos.demo.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.myphotos.demo.model.Photo;

@RestController		// si indica che questo è un controller di tipo rest
public class PhotoController {
	
	List<Photo> list = new ArrayList<Photo>();
	
	public PhotoController() {
		
		list.add(new Photo(1, "./img/13.png"));
		list.add(new Photo(2, "./img/20.png"));
		list.add(new Photo(3, "./img/21.png"));
	}

	@RequestMapping("api/photos")
	public Iterable<Photo> getAll() {	// nel path si restituisce una lista che contiene degli oggetti di tipo "Photo" in json
		return list;
	}
	
	@RequestMapping("api/photos/{id}")		// in questo path si trova un valore dinamico "{id}"
	public Photo getById(@PathVariable int id) {	// si indica che il valore dinamico del path lo si deve inserire nel parametro "id"
		
		Optional<Photo> photo = list.stream().filter(item -> item.getId() == id).findFirst();	// si filtra "list" in base al valore del parametro
		
		if(photo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'elemento non è stato trovato");		// se la foto non è stata trovata si genera l'eccezione
		}
		
		return photo.get();
	}
}
