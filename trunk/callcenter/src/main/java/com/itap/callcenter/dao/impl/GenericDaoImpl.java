package com.itap.callcenter.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.itap.callcenter.dao.GenericDao;
import com.itap.callcenter.entity.DomainObject;

/**
 * 
 * @author scotomax
 *
 */
public class GenericDaoImpl<T extends DomainObject, ID extends Serializable> implements GenericDao<T, ID> {

	private Class<T> type;
    
    @PersistenceContext
    protected EntityManager em;

    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    /**
     * Find all objects
     */
    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return em.createQuery("select o from " + type.getName() + " o").getResultList();
    }
    
    /**
     * Find all by first and last
     */
    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<T> findAll(int start, int end) {
    	return em.createQuery("select o from " + type.getName() + " o").setFirstResult(start).setMaxResults(end).getResultList();
    }
    
    /**
     * Count all objects
     */
    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public int countFindAll() {
    	return ((Long) em.createQuery("select count(o) from " + type.getName() + " o").getSingleResult()).intValue();
    }

    /**
     * Find object by id
     * @return Object
     */
    @Override
    @Transactional(readOnly = true)
    public T findById(ID id) {
        return findByIdNativeType(id);
    }

    /**
     * Save object
     */
    @Override
    @Transactional(readOnly = false)
    public void save(T object) {
        em.persist(object);
    }

    /**
     * Update object
     */
    @Override
    @Transactional(readOnly = false)
    public void update(T object) {
        em.merge(object);
    }

    /**
     * Delete object
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(T object) {
        em.remove(object);
    }
    
    /**
     * Delete object by id(Long)
     */
    @Override
    @Transactional(readOnly = false)
    public void deleteById(ID id) {
    	T object =  findByIdNativeType(id);
		em.remove(object);
    }
    
    /**
     * Find object by id
     * @return Object
     */
    @Transactional(readOnly = true)
    protected T findByIdNativeType(Object id) {
        if (id == null) {
            return null;
        } else {
            return em.find(type, id);
        }
    }

}
