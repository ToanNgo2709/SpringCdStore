package com.toanngo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.toanngo.app.models.Order;
import com.toanngo.app.repository.OrderRepository;

public class OrderService implements ServiceRepository<Order> {

	@Autowired
	OrderRepository repository;
	
	@Override
	public void Add(Order model) {
		repository.save(model);
		
	}

	@Override
	public void Delete(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public void Update(Order model) {
		Order order = repository.getById(model.getId());
		order.setActive(model.isActive());
		order.setCreateDate(model.getCreateDate());
		order.setTotalPrice(model.getTotalPrice());
		
		repository.save(order);
		
	}

	@Override
	public List<Order> GetAll() {
		return repository.findAll();
	}

	@Override
	public Order GetById(int id) {
		Optional<Order> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
		
	}

	@Override
	public List<Order> Search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
