package com.toanngo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.toanngo.app.models.DetailOrder;
import com.toanngo.app.repository.OrderDetailRepository;

@Service
@Component
public class OrderDetailService implements ServiceRepository<DetailOrder> {

	OrderDetailRepository repository;
	
	@Override
	public void Add(DetailOrder model) {
		repository.save(model);
		
	}

	@Override
	public void Delete(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public void Update(DetailOrder model) {
		DetailOrder item = GetById(model.getId());
		item.setActive(model.isActive());
		item.setQuantity(model.getQuantity());
		item.setTempTotal(model.getTempTotal());
		
		repository.save(item);
		
	}

	@Override
	public List<DetailOrder> GetAll() {
		return repository.findAll();
	}

	@Override
	public DetailOrder GetById(int id) {
		Optional<DetailOrder> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<DetailOrder> Search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
