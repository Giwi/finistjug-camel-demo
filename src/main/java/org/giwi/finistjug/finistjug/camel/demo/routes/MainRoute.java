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
package org.giwi.finistjug.finistjug.camel.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.Main;
import org.giwi.finistjug.finistjug.camel.demo.jpa.model.Jugpresentation;
import org.giwi.finistjug.finistjug.camel.demo.jpa.model.Participant;
import org.giwi.finistjug.finistjug.camel.demo.ws.model.JUGSession;
import org.giwi.finistjug.finistjug.camel.demo.ws.model.Spectateur;

/**
 * @author Giwi Softwares
 * 
 *         A Camel Router
 */
public class MainRoute extends RouteBuilder {

	private static String SERVICE_IFACE = "org.giwi.finistjug.finistjug.camel.demo.ws.WebServiceIFace";
	private static String SOAP_LOGGIN = "true";

	/**
	 * A main() so we can easily run these routing rules in our IDE
	 */
	public static void main(String... args) throws Exception {
		Main.main(args);
	}

	/**
	 * Lets configure the Camel routing rules using Java code...
	 */
	@Override
	public void configure() {

		/** Endpoint CXF **/
		from(
				"cxf://finistJugService?serviceClass=" + SERVICE_IFACE
						+ "&loggingFeatureEnabled=" + SOAP_LOGGIN)

		.routeId("cxf")

		.recipientList(simple("direct:${header.operationName}"));

		/****************************************************************** */
		/** Méthode : ajouterParticipant **/
		from("direct:ajouterParticipant").routeId("direct:ajouterParticipant")

		.convertBodyTo(Participant.class)

		.to("jpa:?persistenceUnit=finistjug-camel-demo")

		.convertBodyTo(Spectateur.class);

		/****************************************************************** */
		/** Méthode : ajouterSession **/
		from("direct:ajouterSession").routeId("direct:ajouterSession")

		.convertBodyTo(Jugpresentation.class)

		.to("jpa:?persistenceUnit=finistjug-camel-demo")

		.convertBodyTo(JUGSession.class);

		/****************************************************************** */
		/** Méthode : listeDesSessions **/
		from("direct:listeDesSessions").routeId("direct:listeDesSessions")

		.processRef("ListOfSessionsProcessor");

	}
}
