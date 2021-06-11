package com.coap.server.main.resources;

import java.util.logging.Logger;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

import com.coap.server.main.utils.CurrentDateTime;


public class DHTResource extends CoapResource {
	
	final static Logger LOGGER = Logger.getLogger(DHTResource.class.getCanonicalName());
	
    public DHTResource() {
        super("dht");
        getAttributes().setTitle("DHT Resource");
    }
    
    public void handlePOST(CoapExchange exchange) {
    	LOGGER.info(new CurrentDateTime().getCurrentDateTime() + " " + getURI());
        System.out.println(exchange.getRequestText());
        exchange.respond("POST /dht");
    }
    
    public void handleGET(CoapExchange exchange) {
    	LOGGER.info(new CurrentDateTime().getCurrentDateTime() +" " + getURI());
        exchange.respond("GET /dht");
    }
    
}
