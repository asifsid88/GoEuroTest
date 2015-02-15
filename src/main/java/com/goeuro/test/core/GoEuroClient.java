package com.goeuro.test.core;

import javax.ws.rs.core.MediaType;

import com.goeuro.test.utils.GoEuroUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

class GoEuroClient {
	private static GoEuroClient goEuroClient;
	private Client client;
	
	private GoEuroClient() {}
	
	public static GoEuroClient getInstance() {
		if(goEuroClient == null) {
			synchronized (GoEuroClient.class) {
				if(goEuroClient == null) {
					goEuroClient = new GoEuroClient();
					goEuroClient.client = Client.create();	
				}	
			}
		}
		
		return goEuroClient;
	}

	public String doGet(String restUrl) {
		String response = "";
		try {			
			System.out.println("GoEuroClient.doGet("+restUrl+")");
			WebResource resource = getClient().resource(restUrl);
			ClientResponse clientResponse = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			response = clientResponse.getEntity(String.class);
			System.out.println("Exiting GoEuroClient.doGet");
		} catch(Exception e) {
			System.out.println(GoEuroUtils.formatExceptionString("Exception while making call to "+restUrl, e));
		}
		
		return response;
	}
	
	private Client getClient() {
		return goEuroClient.client;
	}
}
