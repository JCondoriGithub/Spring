package com.myphotos.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myphotos.demo.model.Photo;

@Repository		// si indica a spring che l'interfaccia è un componente di tipo repository, quindi potrà essere inniettato come dipendenza
public interface InterfacePhotoRepo extends CrudRepository<Photo, Integer> {	// l'interfaccia "CrudRepository" deve conoscere la classe del progetto che verrà associata alla tabella del DB e il tipo del suo campo chiave 
																				// "CrudRepository" contiene tutti i metodi-crud per i dati di una tabella del database
}
