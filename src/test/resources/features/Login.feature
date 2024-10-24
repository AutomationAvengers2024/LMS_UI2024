Feature: Home Page Verification

Background: Admin gives the correct LMS portal URL

Scenario: Validate login with valid credentials

Given Admin is in Home Page
When Admin enter valid credentials and clicks login button 
Then Admin should land on dashboard page