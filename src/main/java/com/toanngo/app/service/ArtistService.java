package com.toanngo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.toanngo.app.models.Artist;
import com.toanngo.app.repository.ArtistRepository;

@Service
@Component
public class ArtistService implements ServiceRepository<Artist> {

	@Autowired
	ArtistRepository repository;
	
	@Override
	public void Add(Artist model) {
		repository.save(model);
		
	}

	@Override
	public void Delete(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public void Update(Artist model) {
		Artist artist = GetById(model.getId());
		artist.setName(model.getName());
		artist.setActive(model.isActive());
		repository.save(artist);
		
	}

	@Override
	public List<Artist> GetAll() {
		return repository.findAll();
		
	}

	@Override
	public Artist GetById(int id) {
		Optional<Artist> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Artist> Search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
