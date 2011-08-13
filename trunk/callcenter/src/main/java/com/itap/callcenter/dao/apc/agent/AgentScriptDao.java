package com.itap.callcenter.dao.apc.agent;

import java.util.List;

import com.itap.callcenter.dao.GenericDao;
import com.itap.callcenter.entity.apc.agent.AgentScript;
import com.itap.callcenter.entity.apc.crm.CrmBusiness;
import com.itap.callcenter.entity.apc.knw.KnwTopic;

/**
 * 
 * @author scotomax
 *
 */
public interface AgentScriptDao extends GenericDao<AgentScript, Integer> {
	
	/**
	 * Find all entity of Agent script by CRM business and Know topic
	 * 
	 * @param crmBusiness
	 * @param knwTopic
	 * @return List of Agent script entity data.
	 */
	List<AgentScript> findAllByCrmBusinessAndKnwTopic(CrmBusiness crmBusiness, KnwTopic knwTopic);
	
}
