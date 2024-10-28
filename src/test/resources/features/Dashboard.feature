@Dashboard
Feature: Dashboard Page

  Background: 
    Given Admin is in Login Page
    When Admin enter valid credentials and clicks login button

  @DashboardTS1
  Scenario: Verify after login Admin lands on dashboard page
    Then Admin should see Dashboard

  @DashboardTS2
  Scenario: Verify response time
    Then Maximum navigation time in milliseconds,defaults to 30 seconds

  @DashboardTS3
  Scenario: Verify broken link
    Then Http response >= 400.then the link is broken

  @DashboardTS4
  Scenario: Verify LMS title
    Then Admin should see LMS Learning Management System as title

  @DashboardTS5
  Scenario: Verify LMS title alignment
    Then LMS title should be on the top left corner of page

  @DashboardTS6
  Scenario: Validate navigation bar text
    Then Admin should see correct spelling in navigation bar text

  @DashboardTS7
  Scenario: Validate LMS title has correct spelling and space
    Then Admin should see correct spelling and space in LMS title

  @DashboardTS8
  Scenario: Validate alignment for navigation bar
    Then Admin should see navigation bar text on the top right side

  @DashboardTS9
  Scenario: Validate navigation bar order 1st home
    Then Admin should see Home is in 1st place

  @DashboardTS10
  Scenario: Validate navigation bar order 2nd program
    Then Admin should see Program is in 2nd place

  @DashboardTS11
  Scenario: Validate navigation bar order 3rd batch
    Then Admin should see batch is in 3rd place

  @DashboardTS12
  Scenario: Validate navigation bar order 4th class
    Then Admin should see class is in 4th place

  @DashboardTS13
  Scenario: Validate navigation bar order 5th logout
    Then Admin should see Home is in 5th place
