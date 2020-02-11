package com.app.consumer;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CardConsumer {

	public static String createTx(String ciJson) {
		String URL="http://localhost:2019/CardProducerApp/rest/card/ctx";
		String msg=null;
		Client c=Client.create();
		WebResource wr=c.resource(URL);
		
		ClientResponse cr=wr
		.header("Content-Type", "application/json")
		.post(ClientResponse.class,ciJson);
		
		if(cr.getStatus()!=200) {
			msg="Unable to get details,Please contact Admin!!";
		}else {
			msg=cr.getEntity(String.class);
		}
		
		return msg;
	}
}
