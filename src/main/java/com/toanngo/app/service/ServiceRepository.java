package com.toanngo.app.service;

import java.util.List;

public interface ServiceRepository<T> {
	public void Add(T model);
	public void Delete(int id);
	public void Update(T model);
	
	public List<T> GetAll();
	public T GetById(int id);
	public List<T> Search(String keyword);
}
