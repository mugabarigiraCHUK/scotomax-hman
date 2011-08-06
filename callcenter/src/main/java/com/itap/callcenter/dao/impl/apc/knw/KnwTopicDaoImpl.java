package com.itap.callcenter.dao.impl.apc.knw;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.knw.KnwTopicDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.knw.KnwTopic;


/**
 * @author phamon
 */
@Repository
public class KnwTopicDaoImpl extends GenericDaoImpl<KnwTopic, Integer> implements KnwTopicDao {

	public KnwTopicDaoImpl() {
		super(KnwTopic.class);
	}
	
}
