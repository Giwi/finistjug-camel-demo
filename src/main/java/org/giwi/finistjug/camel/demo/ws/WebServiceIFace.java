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
package org.giwi.finistjug.camel.demo.ws;

import org.giwi.finistjug.camel.demo.ws.model.JUGSession;
import org.giwi.finistjug.camel.demo.ws.model.ListeDesSessionsResponse;
import org.giwi.finistjug.camel.demo.ws.model.Spectateur;

/**
 * @author Giwi Softwares
 * 
 */
public interface WebServiceIFace {

	/**
	 * @param spectateur
	 *            un spectateur
	 * @return un spectateur créé
	 */
	Spectateur ajouterParticipant(Spectateur spectateur);

	/**
	 * @param session
	 *            une session du JUG
	 * @return une session créée
	 */
	JUGSession ajouterSession(JUGSession session);

	/**
	 * @return la liste des sessions dispo
	 */
	ListeDesSessionsResponse listeDesSessions();
}
