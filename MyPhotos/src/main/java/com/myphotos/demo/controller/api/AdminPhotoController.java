package com.myphotos.demo.controller.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.myphotos.demo.model.Photo;
import com.myphotos.demo.service.InterfacePhotoService;

import jakarta.validation.Valid;

@RestController
public class AdminPhotoController {

	@Autowired
	@Qualifier("mainPhotoService")
	private InterfacePhotoService photoservice;		// questa dipendenza, quindi il bean con nome "mainPhotoService" di una classe che implementa l'interfaccia, verrà istanziata ed inniettata da spring
	
	public AdminPhotoController() {
		
	}

	@RequestMapping("admin/api/photos")
	public Iterable<Photo> getAll() {	// nel path si restituisce una lista che contiene degli oggetti di tipo "Photo" in json
		return photoservice.getAll();
	}
	
	@RequestMapping("admin/api/photos/{id}")		// in questo path si trova un valore dinamico "{id}"
	public Photo getById(@PathVariable int id) {	// si indica che il valore dinamico del path lo si deve inserire nel parametro "id"
		
		Optional<Photo> photo = photoservice.getById(id);
		
		if(photo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'elemento non è stato trovato");		// se la foto non è stata trovata si genera l'eccezione
		}
		
		return photo.get();
	}

	@RequestMapping(value="admin/api/photos", method=RequestMethod.POST)	// si indica che la action risponde solo a richieste POST
	public Photo create(@Valid @RequestBody Photo photo) {		// si indica che il body della richiesta deve essere inserito nel parametro "photo"
		return photoservice.create(photo);
	}
	
	@RequestMapping(value="admin/api/photos/{id}", method=RequestMethod.PUT)	// si indica che la action risponde solo a richieste PUT
	public Photo update(@Valid @PathVariable int id, @RequestBody Photo photo) {	// l'annotazione @Valid, indica che è in questo metodo che deve scattare la validazione impostata in "Photo"
		
		Optional<Photo> foundPhoto = photoservice.update(id, photo);
		
		if(foundPhoto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'elemento non è stato trovato");
		}
		
		return foundPhoto.get();
	}
	
	@RequestMapping(value="/admin/api/photos/{id}", method=RequestMethod.DELETE)	// si indica che la action risponde solo a richieste DELETE
	public void delete(@PathVariable int id) {
		
		Boolean isDeleted = photoservice.delete(id);
		
		if(isDeleted == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'elemento non è stato trovato");
		}		
	}
}

