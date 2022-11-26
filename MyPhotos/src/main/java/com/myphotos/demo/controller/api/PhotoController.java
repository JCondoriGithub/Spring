package com.myphotos.demo.controller.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.myphotos.demo.model.Photo;
import com.myphotos.demo.service.InterfacePhotoService;

@RestController		// si indica che questo è un controller di tipo rest
public class PhotoController {
	
	@Autowired
	@Qualifier("mainPhotoService")		
	private InterfacePhotoService photoservice;		// questa dipendenza, quindi il bean con nome "mainPhotoService" di una classe che implementa l'interfaccia, verrà istanziata ed inniettata da spring
	
	public PhotoController() {
		
	}

	@RequestMapping("api/photos")
	public Iterable<Photo> getAll() {	// nel path si restituisce una lista che contiene degli oggetti di tipo "Photo" in json
		return photoservice.getAll();
	}
	
	@RequestMapping("api/photos/{id}")		// in questo path si trova un valore dinamico "{id}"
	public Photo getById(@PathVariable int id) {	// si indica che il valore dinamico del path lo si deve inserire nel parametro "id"
		
		Optional<Photo> photo = photoservice.getById(id);	// il controller non deve "sapere" come caricare i dati, se ne occupa il service
		
		if(photo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'elemento non è stato trovato");		// se la foto non è stata trovata si genera l'eccezione
		}
		
		return photo.get();
	}
}
