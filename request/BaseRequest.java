package com.javaautomation.api.request;

import java.net.HttpURLConnection;

public class BaseRequest {
	
	public static final String URL_NAME= "http://api.weatherbit.io/v2.0/" ;
	protected static String actionType;
	protected static String methodName;
	protected static String requestParam;
	public static final String API_KEY = "Key=5534bab05cc8456f9baa88a36d8bee06";
	public static final String AMP = "&";
	public static  HttpURLConnection requestConnection;
	public static final String JSON_CONTENT_TYPE = "application/json";
	
	protected void setMethodName(String methodName1) {
		methodName = methodName1;
		
	}
	
	protected void setRequestParams(String reqParam) {
		requestParam = reqParam;
		
	}


}
