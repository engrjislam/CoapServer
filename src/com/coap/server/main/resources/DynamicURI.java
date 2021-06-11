package com.coap.server.main.resources;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.core.server.resources.Resource;

public class DynamicURI {
	
	CoapResource wildcard = new CoapResource("*") {
	    @Override
	    public void handleGET(CoapExchange exchange) {
	        exchange.respond("CALLING GET * URI ...");
	    }
	    
	    @Override
	    public void handlePOST(CoapExchange exchange) {
	    	System.out.println("Payload found: " + exchange.getRequestText());
	        exchange.respond("CALLING POST * URI ...");
	    };
	};
	
	CoapResource root = new CoapResource("root") {
	    @Override
	    public Resource getChild(String name) {
	    	System.out.println("Child URI: " + name);
	        return wildcard;
	    }
	};

	public DynamicURI() {
		root.getAttributes().setTitle("Root Resource");
		root.add(wildcard); // must call this to reach 'coap://<IP>:5683/root/*'
	}
	
	public CoapResource getResource() {
		return root;
	}
	
}
