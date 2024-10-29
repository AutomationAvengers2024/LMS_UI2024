 
Feature: Validation on Logout button

Background: Login with valid credentials

Given Admin is in Home Page
When Admin enter valid credentials and clicks login button
Then Admin should land on the login page
    
 
 Scenario: Verify logout function
   
    When Admin clicks on the logout in the menu bar
   Then Admin should be redirected to login page 
    
    
    
