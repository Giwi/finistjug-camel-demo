/**
 * 
 */
package org.giwi.finistjug.finistjug.camel.demo.ws;
import javax.jws.WebParam;
import javax.jws.WebResult;
/**
 * @author Giwi Softwares
 *
 */
@javax.jws.WebService(name = "sayHelloService", targetNamespace = "http://giwi.free.fr")
public interface WebServiceIFace {
	 @WebResult(name = "status")
	 public String sayHello(@WebParam(name = "name") String name);
	 
	 @WebResult(name = "status")
	 public String sayGoodby(@WebParam(name = "name") String name);
}
