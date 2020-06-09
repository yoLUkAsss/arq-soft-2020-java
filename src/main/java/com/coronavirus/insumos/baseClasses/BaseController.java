package com.coronavirus.insumos.baseClasses;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseController<T, DTO extends BaseDTO<T>> {
	
	public abstract BaseService<T, DTO> getBaseService();
	
	public abstract DTO toDto(T entity);
	
	public abstract T toEntity(DTO dto);
	
	public abstract void copyProperties(DTO dto, T entity);

	@GetMapping(value = "")
	public ResponseEntity<List<DTO>> getAll() {
		List<T> results = getBaseService().getAll();
		List<DTO> response = results.stream().map( (T t) -> {
			return toDto(t);
		}).collect(Collectors.toList());
		return new ResponseEntity<List<DTO>>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<DTO> getById(@PathVariable("id") Long id) {
		T entity = getBaseService().getById(id);
		DTO response = null;
		if (entity != null) {
			response = toDto(entity);
			return new ResponseEntity<DTO>(response, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<DTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "")
	public ResponseEntity<DTO> create(@RequestBody DTO dto) {
		try {
			T entity = toEntity(dto);
			T saved = getBaseService().create(entity);
			return new ResponseEntity<DTO>(toDto(saved), HttpStatus.CREATED);						
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<DTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<DTO> update(@PathVariable("id") Long id, @RequestBody DTO dto) {
		T entity = getBaseService().getById(id);
		if (entity != null) {
			try {
				copyProperties(dto, entity);
				T saved = getBaseService().update(entity);
				return new ResponseEntity<DTO>(toDto(saved), HttpStatus.CREATED);							
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<DTO>(HttpStatus.BAD_REQUEST);
			}
			
		} else {
			return new ResponseEntity<DTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		
		T toDelete = getBaseService().getById(id);
		if (toDelete != null) {
			getBaseService().delete(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);			
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
