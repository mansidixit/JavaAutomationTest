#Author: mansi.4288@gmail.com
#Feature: Find the nearest NSW Service Centre

@tag
Feature: Find the NSW service centre 

 
  Scenario Outline: NSW Service Centre Search
    Given I am on NSW Service Centre Site
    And I search and navigate to "Apply for a number plate" 
    When I click "Find Locations"
    And I search for locateText as "<suburbAndPostcode>"
    Then I can find "<serviceCentreName>" in the search results
    
    Examples:
    |suburbAndPostcode|serviceCentreName|
    |Sydney 2000|Marrickville Service Centre|
    |Sydney Domestic Airport 2020|Rockdale Service Centre|
    
   

  