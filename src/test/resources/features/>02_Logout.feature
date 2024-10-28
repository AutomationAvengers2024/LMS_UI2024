Feature: Validation on Logout button


Background: Login with valid credentials
    
Given Admin is in Home Page
When Admin enter valid credentials and clicks login button
Then Admin should land on the login page
  Scenario: Verify back button function 
    When Admin clicks  browser back button
    Then Admin should receive error message
    
   
   
    