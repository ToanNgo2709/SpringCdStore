package com.toanngo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.toanngo.app.models.CdProduct;
import com.toanngo.app.repository.CdProductRepository;

@Service
@Component
public class CdProductService implements ServiceRepository<CdProduct> {

	@Autowired
	CdProductRepository repository;
	
	@Override
	public void Add(CdProduct model) {
		repository.save(model);
		
	}

	@Override
	public void Delete(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public void Update(CdProduct model) {
		CdProduct cd = GetById(model.getId());
		cd.setActive(model.isActive());
		cd.setCreateDate(model.getCreateDate());
		cd.setDescription(model.getDescription());
		cd.setPrice(model.getPrice());
		cd.setName(model.getName());
		cd.setSalePrice(model.getSalePrice());
		
		repository.save(cd);
		
	}

	@Override
	public List<CdProduct> GetAll() {
		return repository.findAll();
	}

	@Override
	public CdProduct GetById(int id) {
		Optional<CdProduct> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();			
		}
		return null;
	}

	@Override
	public List<CdProduct> Search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
