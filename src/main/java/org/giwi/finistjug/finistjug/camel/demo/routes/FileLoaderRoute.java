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
import org.giwi.finistjug.finistjug.camel.demo.ws.model.Spectateur;

/**
 * @author Giwi Softwares
 * 
 */
public class FileLoaderRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("file:input?move=.done/backup/${date:now:yyyyMMdd}/${file:name}")

		.split(body(String.class).tokenize("\n")).parallelProcessing()

		.process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
				String[] line = exchange.getIn().getBody(String.class)
						.split(";");

				Spectateur s = new Spectateur();
				s.setNom(line[0]);
				s.setPrenom(line[1]);
				s.setCourriel(line[2]);
				s.setIdSession(line[3]);

				exchange.getIn().setBody(s);

			}
		})

		.to("direct:ajouterParticipant");

	}
}
