package com.coap.server.main.resources;

import java.util.logging.Logger;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

import com.coap.server.main.utils.CurrentDateTime;


public class PublishResource extends CoapResource {
	
	final static Logger LOGGER = Logger.getLogger(PublishResource.class.getCanonicalName());
	
    public PublishResource() {
        super("publish");
        getAttributes().setTitle("Publish Resource");
    }
    
    public void handlePOST(CoapExchange exchange) {
    	LOGGER.info(new CurrentDateTime().getCurrentDateTime() +" " + getURI());
        System.out.println(exchange.getRequestText());
        exchange.respond("POST_REQUEST_SUCCESS");
    }
    
    public void handleGET(CoapExchange exchange) {
    	LOGGER.info(new CurrentDateTime().getCurrentDateTime() +" " + getURI());
        exchange.respond("GET_REQUEST_SUCCESS");
    }
    
}
