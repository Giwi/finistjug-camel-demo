/**
 * 
 */
package org.giwi.finistjug.finistjug.camel.demo.ws.model;

import java.util.List;

/**
 * @author Giwi Softwares
 * 
 */
public class JUGSession {
	private String nomSession;
	private String dateSession;
	private String description;
	private String identifiant;
	private List<Utilisateur> listeDesParticipants;

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
	public List<Utilisateur> getListeDesParticipants() {
		return listeDesParticipants;
	}

	/**
	 * @param listeDesParticipants
	 *            the listeDesParticipants to set
	 */
	public void setListeDesParticipants(List<Utilisateur> listeDesParticipants) {
		this.listeDesParticipants = listeDesParticipants;
	}
}
