package com.itap.callcenter.dao.impl.apc.knw;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.knw.KnwCategoryDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.knw.KnwCategory;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class KnwCategoryDaoImpl extends GenericDaoImpl<KnwCategory, Integer> implements KnwCategoryDao {

	public KnwCategoryDaoImpl() {
		super(KnwCategory.class);
	}

}
