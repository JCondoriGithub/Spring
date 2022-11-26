package com.myphotos.demo.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.myphotos.demo.model.Photo;

@RestController
public class AdminPhotoController {

	private List<Photo> list = new ArrayList<Photo>();
	private int lastId;
	
	public AdminPhotoController() {
		
		list.add(new Photo(1, "./img/01.png"));
		list.add(new Photo(2, "./img/02.png"));
		list.add(new Photo(3, "./img/03.png"));
		
		lastId = 3;
	}

	@RequestMapping("admin/api/photos")
	public Iterable<Photo> getAll() {	// nel path si restituisce una lista che contiene degli oggetti di tipo "Photo" in json
		return list;
	}
	
	@RequestMapping("admin/api/photos/{id}")		// in questo path si trova un valore dinamico "{id}"
	public Photo getById(@PathVariable int id) {	// si indica che il valore dinamico del path lo si deve inserire nel parametro "id"
		
		Optional<Photo> photo = list.stream().filter(item -> item.getId() == id).findFirst();	// si filtra "list" in base al valore del parametro
		
		if(photo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'elemento non è stato trovato");		// se la foto non è stata trovata si genera l'eccezione
		}
		
		return photo.get();
	}

	@RequestMapping(value="admin/api/photos", method=RequestMethod.POST)	// si indica che la action risponde solo a richieste POST
	public Photo create(@RequestBody Photo photo) {		// si indica che il body della richiesta deve essere inserito nel parametro "photo"
		
		lastId++;
		photo.setId(lastId);
		list.add(photo);
		
		return photo;
	}
	
	@RequestMapping(value="admin/api/photos/{id}", method=RequestMethod.PUT)	// si indica che la action risponde solo a richieste PUT
	public Photo update(@PathVariable int id, @RequestBody Photo photo) {
		
		Optional<Photo> foundPhoto = list.stream().filter(item -> item.getId() == id).findFirst();		// si filtra "list" in base al valore del parametro
		
		if(foundPhoto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'elemento non è stato trovato");
		}
		
		foundPhoto.get().setUrl(photo.getUrl());	// si modifica la proprietà "url" dell'oggetto trovato con quello del parametro
		
		return foundPhoto.get();
	}
	
	@RequestMapping(value="/admin/api/photos/{id}", method=RequestMethod.DELETE)	// si indica che la action risponde solo a richieste DELETE
	public void delete(@PathVariable int id) {
		
		Optional<Photo> foundPhoto = list.stream().filter(item -> item.getId() == id).findFirst();		// si filtra "list" in base al valore del parametro
		
		if(foundPhoto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'elemento non è stato trovato");
		}
		
		list.remove(foundPhoto.get());		// si rimuove l'oggetto da "list"
	}
}




