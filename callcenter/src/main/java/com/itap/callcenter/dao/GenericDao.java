package com.itap.callcenter.dao;

import java.io.Serializable;
import java.util.List;

import com.itap.callcenter.entity.DomainObject;

/**
 * 
 * @author scotomax
 *
 * @param <T>
 * @param <ID>
 */
public interface GenericDao <T extends DomainObject, ID extends Serializable> {

	public T findById(ID id);
	
	public List<T> findAll();
	
	public void save(T object);
	
	public void update(T object);
	
	public void delete(T object);

	public void deleteById(ID id);

}
