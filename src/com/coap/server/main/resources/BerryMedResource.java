package com.coap.server.main.resources;

import java.util.logging.Logger;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

import com.coap.server.main.utils.CurrentDateTime;


public class BerryMedResource extends CoapResource {

	private final static String resource = "berrymed";
	private final static String title    = "BerryMed Resource";	
	
	private final static String gPayload = "GET  sensor/berrymed";
	private final static String ppayload = "POST sensor/berrymed";
	
	final static Logger LOGGER = Logger.getLogger(BerryMedResource.class.getCanonicalName());
	
	public BerryMedResource() {
		super(resource);
		getAttributes().setTitle(title);
	}
    
    public void handleGET(CoapExchange exchange) {
    	String time, host, url, method, payload;
		int port;
    	
    	time    = new CurrentDateTime().getCurrentDateTime();
    	host    = exchange.getSourceAddress().getHostAddress();
    	port    = exchange.getSourcePort();
    	url     = getURI();
    	method  = exchange.getRequestCode().name();
		payload = exchange.getRequestText();
		
		LOGGER.info(time + " " + host + " " + port + " " + url + " " + method + " '" + payload + "'");
		System.out.println("Payload: " + payload);
		
        exchange.respond(gPayload);
    }
	
	public void handlePOST(CoapExchange exchange) {
		String time, host, url, method, payload;
		int port;
    	
    	time    = new CurrentDateTime().getCurrentDateTime();
    	host    = exchange.getSourceAddress().getHostAddress();
    	port    = exchange.getSourcePort();
    	url     = getURI();
    	method  = exchange.getRequestCode().name();
		payload = exchange.getRequestText();
		
		LOGGER.info(time + " " + host + " " + port + " " + url + " " + method + " '" + payload + "'");
		System.out.println("Payload: " + payload);
        
        exchange.respond(ppayload);
    }

}
