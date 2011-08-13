package com.itap.callcenter.dao.impl.apc.agent;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itap.callcenter.dao.apc.agent.AgentScriptDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.agent.AgentScript;
import com.itap.callcenter.entity.apc.crm.CrmBusiness;
import com.itap.callcenter.entity.apc.knw.KnwTopic;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class AgentScriptDaoImpl extends GenericDaoImpl<AgentScript, Integer> implements AgentScriptDao {

	public AgentScriptDaoImpl() {
		super(AgentScript.class);
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<AgentScript> findAllByCrmBusinessAndKnwTopic(
			CrmBusiness crmBusiness, KnwTopic knwTopic) {
		return em.createQuery("select o from AgentScript o where o.business = :business and o.topic = :topic order by o.scriptStep asc")
					  .setParameter("business", crmBusiness)
					  .setParameter("topic", knwTopic)
					  .getResultList();
	}

}
