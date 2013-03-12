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
package org.giwi.finistjug.finistjug.camel.demo.ws.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author Giwi Softwares
 * 
 */
public class JUGSession implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7665600271935034820L;
	private String nomSession;
	private String dateSession;
	private String description;
	private String identifiant;
	private List<Spectateur> listeDesParticipants;

	/**
	 * @return the nomSession
	 */
	public String getNomSession() {
		return nomSession;
	}

	/**
	 * @param nomSession
	 *            the nomSession to set
	 */
	public void setNomSession(String nomSession) {
		this.nomSession = nomSession;
	}

	/**
	 * @return the dateSession
	 */
	public String getDateSession() {
		return dateSession;
	}

	/**
	 * @param dateSession
	 *            the dateSession to set
	 */
	public void setDateSession(String dateSession) {
		this.dateSession = dateSession;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * @param identifiant
	 *            the identifiant to set
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * @return the listeDesParticipants
	 */
	public List<Spectateur> getListeDesParticipants() {
		return listeDesParticipants;
	}

	/**
	 * @param listeDesParticipants
	 *            the listeDesParticipants to set
	 */
	public void setListeDesParticipants(List<Spectateur> listeDesParticipants) {
		this.listeDesParticipants = listeDesParticipants;
	}
}
