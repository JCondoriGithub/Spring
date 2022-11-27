package com.myphotos.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myphotos.demo.model.Photo;
import com.myphotos.demo.repository.InterfacePhotoRepo;

@Service("mainPhotoService")	// si indica che questo è un componente di tipo service e il bean che ne deriva avrà il nome "mainPhotoService"
public class DbPhotoService implements InterfacePhotoService {

	@Autowired		// spring cercherà il bean che si chiama come l'attributo, altrimenti cerca qualsiasi bean di quell'interfaccia
	private InterfacePhotoRepo photorepository;

	public DbPhotoService() {
		
	}
	
	@Override
	public Iterable<Photo> getAll() {
		return photorepository.findAll();	// si usa il metodo "findAll" del repository
	}
	
	@Override
	public Optional<Photo> getById(int id) {
		return photorepository.findById(id);
	}
	
	@Override
	public Photo create(Photo photo) {
		return photorepository.save(photo);		// si usa il metodo "save" del repository per salvare l'oggetto-entity nel DB
	}
	
	@Override
	public Optional<Photo> update(int id, Photo photo) {
		
		Optional<Photo> foundPhoto = photorepository.findById(id);
		
		if(foundPhoto.isEmpty()) {		// se nel DB non è stato trovato
			return Optional.empty();
		}
		
		foundPhoto.get().setUrl(photo.getUrl());
		photorepository.save(foundPhoto.get());		// spring-data-jpa "sa" se l'oggetto-entity è da inserire nel DB o solo da modificare
		
		return foundPhoto;
	}
	
	@Override
	public Boolean delete(int id) {
		
		Optional<Photo> foundPhoto = photorepository.findById(id);
		
		if(foundPhoto.isEmpty()) {
			return false;
		}
		
		photorepository.delete(foundPhoto.get());	// si cancella l'oggetto-entity dal DB
		return true;
	}
}
