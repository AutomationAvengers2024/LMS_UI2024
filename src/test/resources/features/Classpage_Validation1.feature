Feature: Class Page Validation

  Background: 
    
  Scenario: Validating the class manage page
    Given Admin is logged on the Dashboard page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should land on the Manage class page

  Scenario: Validating the Title in the Manage class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the "LMS-Learning Management System" Title

  Scenario: Validating the Header in the Manage class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the "Manage Class" Header

  Scenario: Validating Search bar in class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Searchbar in Manage class page

  Scenario: Validating the data table headers in the class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the datatable heading like Batchname, class topic, class description, status, class Date, staff name, Edit/Delete

  Scenario: Validating the text and pagination icon in the class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see "showing x to y of z entries" and enabled pagination controls under the data table

  Scenario: Validate the sort icon of all the fields in the datatable
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Sort icon of all the fields in the datatable

  Scenario: Validating the Delete button under the Manage class
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Delete button under the Manage class page header

  Scenario: Validate the total number of classes in manage class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see Total number of classes below the data table
    
    
