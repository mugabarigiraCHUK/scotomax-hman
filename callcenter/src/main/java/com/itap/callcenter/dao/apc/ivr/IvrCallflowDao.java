package com.itap.callcenter.dao.apc.ivr;

import java.util.List;

import com.itap.callcenter.dao.GenericDao;
import com.itap.callcenter.entity.apc.ivr.IvrCallflow;

/**
 * 
 * @author scotomax
 *
 */
public interface IvrCallflowDao extends GenericDao<IvrCallflow, Integer> {
	
	public List<IvrCallflow> findByCallflowBackId(Integer callflowBackId);

}
