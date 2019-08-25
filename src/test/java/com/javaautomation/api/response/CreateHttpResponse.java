package com.javaautomation.api.response;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;

import cucumber.api.java.en.Then;

public class CreateHttpResponse extends BaseResponse{
	
	
	@Then("I validate the response for statecode {string}")
	public void i_validate_the_response_for_statecode(String stateCode) {
		
		JSONObject  jsonResponse = getHTTPJSONResponse();
		JSONArray jsonArray = (JSONArray)jsonResponse.get("data");

        for(int i=0;i<jsonArray.size();i++)
        {
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
            String value1 = (String) jsonObject1.get("state_code");
            Assert.assertEquals(value1 ,stateCode) ;
            
            System.out.println(" The state_code is " + value1);
        }
		closeHTTPConnection();
        
	}

	@Then("I display the response for timestamp and weather on console")
	public void i_display_the_response_for_timestamp_and_weather_on_console() {
		
		JSONObject  jsonResponse = getHTTPJSONResponse();
		JSONArray jsonArray = (JSONArray)jsonResponse.get("data");
		System.out.println(" ****************************************************************** ");
		for(int i=0;i<jsonArray.size();i++)
        {
			JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
			JSONObject weatherObj = (JSONObject)jsonObject1.get("weather");
			
			System.out.println( "Response " + i+" : "+ jsonObject1.get("ts") +" , " + weatherObj.get("code")+" , " + weatherObj.get("icon")+" , " + weatherObj.get("description"));
			
        }
		
		System.out.println(" ****************************************************************** ");
	}
}
