package com.coap.server.main.resources;

import org.eclipse.californium.core.CoapResource;


public class DynamicResource {
	
	private CoapResource coapResource = null;

	public DynamicResource(String targetResource) {
		this.setResource(targetResource);
	}
	
	public CoapResource getResource() {
		return this.coapResource;
	} 
	
	public void setResource(String targetResource) {
		switch (targetResource) {
		case "dht":
			this.coapResource = new DHTResource();
			break;
			
		case "berrymed":
			this.coapResource = new BerryMedResource();
			break;

		default:
			this.coapResource = null;
			break;
		}
	}
	
}
