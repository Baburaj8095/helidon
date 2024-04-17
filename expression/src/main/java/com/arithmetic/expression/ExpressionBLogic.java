package com.arithmetic.expression;

import java.net.URI;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

@ApplicationScoped
public class ExpressionBLogic {
	public int processExpression(int num1, int num2, int num3) throws Exception{
		//Invoke Addition Service
		URI addURI = new URI("http://localhost:8080");
		AdditionClient addClient = RestClientBuilder.newBuilder()
									.baseUri(addURI)
									.build(AdditionClient.class);
		Addition addRequest = new Addition();
		addRequest.setNum1(num1);
		addRequest.setNum2(num2);
		Addition addResponse = addClient.execute(addRequest);
		int exprResult = addResponse.getResult();
		return exprResult;
	}
}
