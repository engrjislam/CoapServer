package com.coap.server.main;

import java.net.SocketException;

public class CoapApplication {

	public static void main(String[] args) {
        try {
            Server server = new Server();
            server.start();
        } catch (SocketException e) {
            System.err.println("Failed to initialize server: " + e.getMessage());
        }
    }
	
}
