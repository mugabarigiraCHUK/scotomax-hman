package com.itap.callcenter.dao.impl.apc.ivr;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itap.callcenter.dao.apc.ivr.IvrCallflowDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.ivr.IvrCallflow;

/**
 * 
 * @author phamon
 * 
 */
@Repository
public class IvrCallflowDaoImpl extends GenericDaoImpl<IvrCallflow, Integer>
		implements IvrCallflowDao {

	public IvrCallflowDaoImpl() {
		super(IvrCallflow.class);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<IvrCallflow> findByCallflowBackId(Integer callflowBackId) {
		String sql = " select o from IvrCallflow o ";

		if (callflowBackId == null) {
			sql += " where o.callflowBack IS NULL";
		} else {
			sql += " where o.callflowBack.callflowId = :callflowBackId ";
		}
		Query query = em.createQuery(sql);
		
		if (callflowBackId != null) {
			query.setParameter("callflowBackId", callflowBackId);
		}
		return query.getResultList();
	}
	
}
