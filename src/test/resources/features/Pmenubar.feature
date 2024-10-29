@MenubarProgram
Feature: Validating Menu bar

Background: Admin gives the correct LMS portal URL

Scenario: Validate login with valid credentials

Given Admin is in Home Page
When Admin enter valid credentials and clicks login button 
Then Admin is on dashboard page after Login
@TS1
Scenario: Verify any broken links on program page  

When Admin clicks "Program" on the navigation bar
Then Admin should not have any broken links for Program module
