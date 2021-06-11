package com.coap.server.main;

import java.net.SocketException;

import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.CoapResource;

import com.coap.server.main.resources.PublishResource;
//import com.coap.server.main.resources.BerryMedResource;
//import com.coap.server.main.resources.DHTResource;
import com.coap.server.main.resources.DynamicResource;
import com.coap.server.main.resources.DynamicURI;


public class Server extends CoapServer {

    public Server() throws SocketException {
    	
    	// coap://<IP>:5683/publish
        add(new PublishResource());
        
        /*add(
        	new CoapResource("foo")
        		.add(new CoapResource("a")
        		 .add(new CoapResource("a1"))
        		 .add(new CoapResource("a2"))
        		 .add(new CoapResource("a3"))
        		 .add(new CoapResource("a4"))
        		)
        		.add(new CoapResource("b")
        		 .add(new CoapResource("b1")
        		 )
        		)
        );*/
        
        // coap://<IP>:5683/sensor/dht
        /*add(
        	new CoapResource("sensor")
        	  .add(new DHTResource())
        );*/
        
        // coap://<IP>:5683/sensor2/berrymed
        /*add(
        	new CoapResource("sensor2")
        	.add(new BerryMedResource())
        );*/
        
        // combining above both URL together which 
        // starts with 'sensors' where rest are dynamic
        // coap://<IP>:5683/sensor/<resource_name>
        /*add(
        	new CoapResource("sensor")
        	  .add(new DHTResource())
        	  .add(new BerryMedResource())
        );*/
        
        // replacing DHTResource & BerryMedResource
        // with DynamicResource 
        // coap://<IP>:5683/sensor/<resource_name>
        add(
        	new CoapResource("sensor")
        	  .add(new DynamicResource("dht").getResource())
        	  .add(new DynamicResource("berrymed").getResource())
        );
        
        // coap://<IP>:5683/root/*
        add(new DynamicURI().getResource());
    }
    
}
