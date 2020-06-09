package com.coronavirus.insumos.baseClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public abstract class BaseService<T, DTO extends BaseDTO<T>> {
	
	public abstract BaseRepository<T> getBaseRepository();
	
	public List<T> getAll() {
		Iterable<T> all = getBaseRepository().findAll();
		List<T> results = new ArrayList<T>();
		for (T t : all) {
			results.add(t);
		}
		return new ArrayList<T>(results);
	}

	public T getById(Long id) {
		Optional<T> optional = getBaseRepository().findById(id);
		return optional.orElse(null);
	}
	
	public T create(T entity) {
		return getBaseRepository().save(entity);
	}
	
	public T update(T entity) {
		return getBaseRepository().save(entity);
	}
	
	public void delete(Long id) {
		getBaseRepository().deleteById(id);
	}
	
}
