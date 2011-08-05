package com.itap.callcenter.dao.impl.apc.ivr;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.ivr.IvrVoicepromptDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.ivr.IvrVoiceprompt;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class IvrVoicepromptDaoImpl extends GenericDaoImpl<IvrVoiceprompt, Integer> implements IvrVoicepromptDao {

	public IvrVoicepromptDaoImpl() {
		super(IvrVoiceprompt.class);
	}

}
