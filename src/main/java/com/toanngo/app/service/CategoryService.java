package com.toanngo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.toanngo.app.models.Category;
import com.toanngo.app.repository.CategoryRepository;

@Service
@Component
public class CategoryService implements ServiceRepository<Category> {

	@Autowired
	CategoryRepository repository;
	
	@Override
	public void Add(Category model) {
		repository.save(model);
		
	}

	@Override
	public void Delete(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public void Update(Category model) {
		Category item = GetById(model.getId());
		item.setName(model.getName());
		item.setActive(model.isActive());
		repository.save(item);
		
	}

	@Override
	public List<Category> GetAll() {
		return repository.findAll();
	}

	@Override
	public Category GetById(int id) {
		Optional<Category> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Category> Search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
