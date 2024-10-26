Feature: Validation on Logout button


Background: Login with valid credentials
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should land on the login page
    Scenario: Verify back button function 
    When Admin clicks  browser back button
    Then Admin should receive error message
    
   
    Scenario: Verify logout function
    Given  Admin is in dashboard page
    When Admin clicks on the logout in the menu bar
   Then Admin should be redirected to login page 
    
    
    
    