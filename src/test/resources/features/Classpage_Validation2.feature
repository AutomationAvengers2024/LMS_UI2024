Feature: Add New Class

  Background: 
    Given Admin is on the Manage class page after login

  Scenario: Validate Class Details Popup window
    When Admin clicks add new class under the class menu bar
    Then Admin should see a popup open for class details with an empty form along with save and cancel button and Close(X) Icon on the top right corner of the window

  Scenario: Validate input fields and their text boxes in Class details form
    When Admin clicks add new class under the class menu bar
    Then Admin should see few input fields and their respective text boxes in the class details window

  Scenario: Check if class is created when only mandatory fields are entered with valid data
    Given Admin is on the Class Popup window
    When Admin enters mandatory fields in the form and clicks on save button
    Then Admin gets message "Class added Successfully"

	#--- Scenario: Check no classes value added when selecting class dates
    #---Given Admin is on the Class Popup window
   #--- When Admin selects class date in date picker
    #---Then Admin should see number of class value is added automatically

 #--- Scenario: Check weekend dates are disabled in calendar
    #Given Admin is on the Class Popup window
    #When Admin clicks date picker
    #Then Admin should see weekends dates are disabled to select

  Scenario: Check if class is created when only optional fields are entered with valid data
    Given Admin is on the Class Popup window
    When Admin skips to add value in mandatory field and enters only the optional field
    Then Admin should see error message below the text field and the field will be highlighted in red color

  #Scenario: Check if class is created when invalid data is entered in all of the fields
    #Given Admin is on the Class Popup window
    #When Admin enters invalid data in all of the fields in the form and clicks on save button
    #Then Admin gets error message and class is not created

  Scenario: Empty form submission
    Given Admin is on the Class Popup window
    When Admin clicks on save button without entering data
    Then class won't be created and Admin gets error message

  Scenario: Validate Cancel/Close(X) icon on class Details form
    Given Admin is on the Class Popup window
    When Admin clicks Cancel/Close(X) Icon on Admin Details form
    Then Class Details popup window should be closed without saving

  Scenario: Validate Save button on class Details form
    Given Admin is on the Class Popup window
    When Admin clicks save button
    Then Admin can see the class details popup closed and adding new class
