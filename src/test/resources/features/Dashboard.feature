@tag
Feature: Dashboard Page

  Background: 
    Given Admin is in Login Page
    When Admin enter valid credentials and clicks login button
   
   
  Scenario: Verify after login Admin lands on dashboard page
    Then Admin should see Dashboard

  Scenario: Verify response time
    Then Maximum navigation time in milliseconds,defaults to 30 seconds

  Scenario: Verify broken link
    Then Http response >= 400.then the link is broken

  Scenario: Verify LMS title
    Then Admin should see LMS Learning Management System as title

  Scenario: Verify LMS title alignment
    Then LMS title should be on the top left corner of page

  Scenario: Validate navigation bar text
    Then Admin should see correct spelling in navigation bar text

  Scenario: Validate LMS title has correct spelling and space
    Then Admin should see correct spelling and space in LMS title

  Scenario: Validate alignment for navigation bar
    Then Admin should see navigation bar text on the top right side

  Scenario: Validate navigation bar order 1st home
    Then Admin should see Home is in 1st place

  Scenario: Validate navigation bar order 2nd program
    Then Admin should see Program is in 2nd place

  Scenario: Validate navigation bar order 3rd batch
    Then Admin should see batch is in 3rd place

  Scenario: Validate navigation bar order 4th class
    Then Admin should see class is in 4th place

  Scenario: Validate navigation bar order 5th logout
    Then Admin should see Home is in 5th place

