package com.toanngo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toanngo.app.models.UserInfo;
import com.toanngo.app.repository.UserInfoRepository;


@Service
public class UserInfoService implements ServiceRepository<UserInfo> {

	@Autowired
	UserInfoRepository repository;
	
	@Override
	public void Add(UserInfo model) {
		repository.save(model);		
	}

	@Override
	public void Delete(int id) {
		repository.deleteById(id);		
	}

	@Override
	public void Update(UserInfo model) {
		UserInfo user = GetById(model.getId());
		user.setPassword(model.getPassword());
		user.setUsername(model.getPassword());
		user.setActive(model.isActive());
		
		repository.save(user);
		
	}

	@Override
	public List<UserInfo> GetAll() {
		return repository.findAll();
	}

	@Override
	public UserInfo GetById(int id) {
		Optional<UserInfo> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<UserInfo> Search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
