package com.itap.callcenter.dao.impl.apc.knw;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.knw.KnwSolutionDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.knw.KnwSolution;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class KnwSolutionDaoImpl extends GenericDaoImpl<KnwSolution, Integer> implements KnwSolutionDao {

	public KnwSolutionDaoImpl() {
		super(KnwSolution.class);
	}

}
