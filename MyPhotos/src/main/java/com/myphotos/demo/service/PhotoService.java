package com.myphotos.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.myphotos.demo.model.Photo;

// si vuole aggiungere un livello di astrazione per la gestione delle foto, perciò si crea questa classe-service per separare i controller dalla logica CRUD sulle foto, quindi i controller devono solo invocare i metodi CRUD del service

public class PhotoService implements InterfacePhotoService {

	private List<Photo> list = new ArrayList<Photo>();
	private int lastId;
	
	public PhotoService() {
		
		list.add(new Photo(1, "./img/01.png"));
		list.add(new Photo(2, "./img/02.png"));
		list.add(new Photo(3, "./img/03.png"));
		
		lastId = 3;
	}
	
	@Override
	public Iterable<Photo> getAll() {
		return list;
	}
	
	@Override
	public Optional<Photo> getById(int id) {
		
		Optional<Photo> photo = list.stream().filter(item -> item.getId() == id).findFirst();	// si filtra "list" in base al valore del parametro
		
		if(photo.isEmpty()) {
			return Optional.empty();
		}
		
		return photo;	// il service deve solo caricare i dati, poi il come essi vengano gestiti se ne occuperà il controller
	}
	
	@Override
	public Photo create(Photo photo) {
		
		lastId++;
		photo.setId(lastId);
		list.add(photo);
		
		return photo;
	}
	
	@Override
	public Optional<Photo> update(int id, Photo photo) {
		
		Optional<Photo> foundPhoto = list.stream().filter(item -> item.getId() == id).findFirst();		// si filtra "list" in base al valore del parametro
		
		if(foundPhoto.isEmpty()) {
			return Optional.empty();
		}
		
		foundPhoto.get().setUrl(photo.getUrl());	// si modifica la proprietà "url" dell'oggetto trovato con quello del parametro
		
		return foundPhoto;
	}
	
	@Override
	public Boolean delete(int id) {
		
		Optional<Photo> foundPhoto = list.stream().filter(item -> item.getId() == id).findFirst();		// si filtra "list" in base al valore del parametro
		
		if(foundPhoto.isEmpty()) {
			return false;
		}
		
		list.remove(foundPhoto.get());		// si rimuove l'oggetto da "list"
		
		return true;
	}
}
