package com.javaautomation.api.response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.javaautomation.api.request.CreateHttpRequest;

public class BaseResponse {

	private InputStreamReader isr;
	private BufferedReader in;
	protected JSONParser parser;
	private static JSONObject jsonResponse;

	public static HttpURLConnection getHttpRequestConnection() {
		return CreateHttpRequest.requestConnection;
	}

	protected JSONObject getHTTPJSONResponse() {
		String inputLine="";
		try {
	    	isr = new InputStreamReader(getHttpRequestConnection().getInputStream());
			in = new BufferedReader(isr);
			parser = new JSONParser();
			jsonResponse =  (JSONObject) parser.parse(in);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jsonResponse;
		
		
	}

	protected void closeHTTPConnection() {
		try {
			in.close();
			getHttpRequestConnection().disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

}
