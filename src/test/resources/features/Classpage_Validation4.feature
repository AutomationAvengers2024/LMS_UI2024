Feature: Sort Class details

  Background: 
    Given Admin is on the Manage Class page after login

  Scenario: Sort Class by Batch name
    When Admin clicks on the Batchname sort icon
    Then Admin should see Class details are sorted by Batch Name

  Scenario: Sort Class by Class topic
    When Admin clicks on the Class topic sort icon
    Then Admin should see Class details are sorted by Class Topic

  Scenario: Sort Class by Class Description
    When Admin clicks on the Class description sort icon
    Then Admin should see Class details are sorted by Class Description

  Scenario: Sort Class by Status
    When Admin clicks on the Status sort icon
    Then Admin should see Class details are sorted by Status

  Scenario: Sort Class by Class date
    When Admin clicks on the Class Date sort icon
    Then Admin should see Class details are sorted by Class Date

  Scenario: Sort Class by staff name
    When Admin clicks on the Staff Name sort icon
    Then Admin should see Class details are sorted by Staff name
