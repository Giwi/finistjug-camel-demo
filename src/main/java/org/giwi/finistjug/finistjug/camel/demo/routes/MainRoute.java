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

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.Main;
import org.giwi.finistjug.finistjug.camel.demo.jpa.model.Participant;
import org.giwi.finistjug.finistjug.camel.demo.ws.model.JUGSession;
import org.giwi.finistjug.finistjug.camel.demo.ws.model.Utilisateur;

/**
 * A Camel Router
 */
public class MainRoute extends RouteBuilder {

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
		from("cxf://finistJugService?serviceClass=org.giwi.finistjug.finistjug.camel.demo.ws.WebServiceIFace")

		.recipientList(simple("direct:${header.operationName}"));

		from("direct:ajouterParticipant")

		.convertBodyTo(Participant.class)

		.to("jpa:org.giwi.finistjug.finistjug.camel.demo.jpa.model.Participant?persistenceUnit=finistjug-camel-demo")

		.convertBodyTo(Utilisateur.class);

		from("direct:listeDesSession").setBody(simple("select * from JUGSESSION"))

		.to("sql:select * from JUGSESSION?dataSourceRef=finistjug-camel-demo")

		.convertBodyTo(JUGSession.class)

		.process(new Processor() {

			@Override
			public void process(Exchange arg0) throws Exception {
				if (arg0.getIn().getBody() != null) {
					System.out.println(arg0.getIn().getBody(JUGSession.class).getNomSession());
				}

			}
		});

		from("timer:foo?fixedRate=true&period=5000").to("direct:listeDesSession");

		// from("timer:bar?fixedRate=true&period=1000").process(new Processor()
		// {
		//
		// @Override
		// public void process(Exchange arg0) throws Exception {
		// Utilisateur u = new Utilisateur();
		// u.setIdSession("1");
		// u.setNom(String.valueOf(System.currentTimeMillis()));
		// u.setPrenom("toto");
		// arg0.getIn().setBody(u);
		//
		// }
		// }).to("direct:ajouterParticipant");

	}
}
