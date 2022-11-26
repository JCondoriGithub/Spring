package com.myphotos.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.myphotos.demo.model.Photo;

@Service
public class DbPhotoService implements InterfacePhotoService {



	public DbPhotoService() {
		

	}
	
	@Override
	public Iterable<Photo> getAll() {
		
		return null;
	}
	
	@Override
	public Optional<Photo> getById(int id) {
		
		return null;
	}
	
	@Override
	public Photo create(Photo photo) {
		
		return null;
	}
	
	@Override
	public Optional<Photo> update(int id, Photo photo) {
		
		return null;
	}
	
	@Override
	public Boolean delete(int id) {
		
		return null;
	}
}
