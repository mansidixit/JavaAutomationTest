#Author: mansi.4288@gmail.com

@apiTesting
Feature: Weather Service API Feature

 
  Scenario Outline: Get StateCode from Latitude and Longitude
    Given I have the methodName "<methodName>"
    And I have the request parameters as "<Latitude>" and "<Longitude>"
    When I submit a http "GET" Request
    Then I validate the response for statecode "<statecode>"

    Examples: 
      | methodName  | Latitude | Longitude  |statecode|
      | current |    lat=40.730610  | lon=-73.935242 |NY|
        | current |     lat=38.123 | lon=-78.543    |VA|
      
      
 Scenario Outline: Get timestamp and weather from STATECODE
    Given I have the methodName "<methodName>"
    And I have the request parameters as "<postal_code>" and "<country>"
    When I submit a http "GET" Request
    Then I display the response for timestamp and weather on console
    
    Examples: 
      |methodName| postal_code |country|
      | forecast/daily | postal_code=28546|country=US  |  
      | forecast/daily | postal_code=28573|country=US  |   
