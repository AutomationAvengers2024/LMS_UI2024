Feature: Edit New Class

  Background: 
    Given Admin is on the Manage Class page after login

  Scenario: Validate row level edit icon
    When Admin clicks on the edit icon
    Then A new pop up with class details appears

  Scenario: Check disabled batch name
    When Admin clicks on the edit icon
    Then Admin should see batch name field is disabled

  Scenario: Check disabled class topic
    When Admin clicks on the edit icon
    Then Admin should see class topic field is disabled

  Scenario: Check if the fields are updated with valid data
    Given Admin is on the Edit Class Popup window
    When Admin updates the fields with valid data and clicks save
    Then Admin gets message "class details updated Successfully" and sees the updated values in data table

  #Scenario: Check if the fields are updated with invalid values
    #Given Admin is on the Edit Class Popup window
    #When Admin updates the fields with invalid values and clicks save
    #Then Admin should get Error message

  Scenario: Check if the mandatory fields are updated with valid data
    Given Admin is on the Edit Class Popup window
    When Admin updates the mandatory fields with valid values and clicks save
    Then Admin gets message "Class details updated Successfully" and sees the updated values in data table

  Scenario: Check if the optional fields are updated with valid data
    Given Admin is on the Edit Class Popup window
    When Admin updates the optional fields with valid values and clicks save
    Then Admin gets message "Class details updated Successfully" and sees the updated values in data table

  Scenario: Validate invalid values in the text fields
    Given Admin is on the Edit Class Popup window
    When Admin enters only numbers or special characters in the text fields
    Then Admin should get Error message

  Scenario: Validate Cancel button on Edit popup
    Given Admin is on the Edit Class Popup window
    When Admin clicks Cancel button on edit popup
    Then Admin can see the class details popup disappears and can see nothing changed for particular Class

