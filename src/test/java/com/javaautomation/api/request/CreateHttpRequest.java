package com.javaautomation.api.request;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CreateHttpRequest extends BaseRequest{
	
	private URL httpURL;
	
	public static final String GET_ACTION= "GET";
	
	@Given("I have the methodName {string}")
	 public void i_have_the_methodName(String methodName) {
	    setMethodName(methodName);
	}

	@Given("I have the request parameters as {string} and {string}")
	public void i_have_the_request_parameters_as_and(String param1, String param2) {
	   
		String reqParam = API_KEY+AMP+param1+AMP+param2;
		setRequestParams(reqParam);
	}

	@When("I submit a http {string} Request")
	public void i_submit_a_http_Request(String actionName) {
		try {
		actionType = actionName;
		
		 httpURL = new URL(URL_NAME+"/"+methodName+"?"+requestParam);
		 requestConnection = (HttpURLConnection) httpURL.openConnection();
		 requestConnection.setRequestProperty("Content-Length", String.valueOf(requestParam.length()));
		 requestConnection.setRequestProperty("Content-Type",JSON_CONTENT_TYPE);
		
		 requestConnection.setRequestMethod(actionType);
		 requestConnection.setDoOutput(true);
		 requestConnection.setDoInput(true);

		OutputStream out = requestConnection.getOutputStream();
		out.write( requestParam.getBytes() );    
		out.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
