/**
 * 
 */
package org.giwi.finistjug.finistjug.camel.demo.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;

import org.giwi.finistjug.finistjug.camel.demo.ws.model.JUGSession;
import org.giwi.finistjug.finistjug.camel.demo.ws.model.Utilisateur;

/**
 * @author Giwi Softwares
 * 
 */
@javax.jws.WebService(name = "finistJugService", targetNamespace = "http://giwi.free.fr/finistJug/camel")
public interface WebServiceIFace {
	@WebResult(name = "utilisateur")
	public Utilisateur ajouterParticipant(@WebParam(name = "utilisateur") Utilisateur utilisateur);

	@WebResult(name = "listeDesSession")
	public List<JUGSession> listeDesSession();
}
