/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.giwi.finistjug.camel.demo.processor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.DozerBeanMapper;
import org.eclipse.persistence.expressions.ExpressionBuilder;
import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.queries.ReadAllQuery;
import org.giwi.finistjug.camel.demo.jpa.EntityManagerUtil;
import org.giwi.finistjug.camel.demo.jpa.model.Jugpresentation;
import org.giwi.finistjug.camel.demo.ws.model.JUGSession;
import org.giwi.finistjug.camel.demo.ws.model.ListeDesSessionsResponse;

/**
 * @author Giwi Softwares
 * 
 */
public class ListOfSessionsProcessor implements Processor {
    private static final Log LOG = LogFactory
	    .getLog(ListOfSessionsProcessor.class);

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
     */
    @SuppressWarnings("unchecked")
    @Override
    public void process(final Exchange exchange) throws Exception {
	final List<JUGSession> listOfSessions = new ArrayList<JUGSession>();
	exchange.getIn().setBody(null);

	// Récupération de l'entityManager
	final EntityManager em = EntityManagerUtil.getEntityManager();
	final ExpressionBuilder builder = new ExpressionBuilder();
	final ReadAllQuery databaseQuery = new ReadAllQuery(
		Jugpresentation.class, builder);
	final Query query = ((JpaEntityManager) em.getDelegate())
		.createQuery(databaseQuery);
	// exécution de la requête
	try {
	    final List<Jugpresentation> jugPres = query.getResultList();
	    final DozerBeanMapper mapper = exchange.getContext().getRegistry()
		    .lookup("mapper", DozerBeanMapper.class);
	    for (final Jugpresentation jugP : jugPres) {
		em.refresh(jugP);
		// mapping Dozer
		listOfSessions.add(mapper.map(jugP, JUGSession.class));
	    }
	} catch (final NoResultException e) {
	    // pas de résultat trouvé, c'est pas bien grave
	    if (LOG.isInfoEnabled()) {
		LOG.info(e);
	    }
	}
	final ListeDesSessionsResponse resp = new ListeDesSessionsResponse();
	resp.setListeDesSessions(listOfSessions);
	exchange.getIn().setBody(resp);
    }
}
