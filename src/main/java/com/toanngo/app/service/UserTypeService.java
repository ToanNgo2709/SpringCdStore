package com.toanngo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.toanngo.app.models.UserType;
import com.toanngo.app.repository.UserTypeRepository;

@Service
@Component
public class UserTypeService implements ServiceRepository<UserType> {

	@Autowired
	UserTypeRepository repository;
	
	@Override
	public void Add(UserType model) {
		repository.save(model);
		
	}

	@Override
	public void Delete(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public void Update(UserType model) {
		UserType type = GetById(model.getId());
		type.setName(model.getName());
		type.setActive(model.isActive());
		
		repository.save(type);
		
	}

	@Override
	public List<UserType> GetAll() {
		return repository.findAll();
	}

	@Override
	public UserType GetById(int id) {
		Optional<UserType> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<UserType> Search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
