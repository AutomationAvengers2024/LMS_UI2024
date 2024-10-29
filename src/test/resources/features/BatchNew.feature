Feature: Add New Batch Details Pop-up

  Background: Admin is on the Add New Batch pop-up Window
    Given Admin is on the Batch Details Pop Up Window

  @Test14
  Scenario: Validate all the fields exist in pop-up
    When Admin checks all the fields are enabled
    Then the pop-up should include the fields Batch Name Number of classes and Description as text box Program Name as drop down and Status as radio button

  @Test15
  Scenario: Validate batch name prefix selected program name
    When Admin selects program name present in the dropdown
    Then Admin should see selected program name in the batch name prefix box

  @Test16
  Scenario: Validate batch name suffix box should accept only numbers
    When Admin enters alphabets in the batch name suffix box
    Then Admin should get an error message below the text box of the respective field

  @Test17
  Scenario: Validate batch name prefix box is not editable
    When Admin enters alphabets in the batch name prefix box
    Then Admin should see an empty text box

  @Test18
  Scenario: Validate input data only for mandatory fields
    When Admin enters data only in the mandatory fields and clicks the save button
    Then Admin should get a successful message

  @Test19
  Scenario: Validate input data missing for mandatory fields
    When Admin leaves blank one of the mandatory fields
    Then Admin should get an error message on the respective mandatory field

  @Test20
  Scenario: Validate save button in Batch details pop-up
    When Admin enters valid data in all the mandatory fields and clicks the save button
    Then Admin should get a successful message

  @Test21
  Scenario: Validate cancel button in Batch details pop-up
    When Admin enters valid data in all the mandatory fields and clicks the cancel button
    Then Admin can see the Batch Details pop-up closes without creating any batch

  @Test22
  Scenario: Validate close icon on the batch details pop-up
    When Admin clicks on the close icon
    Then Batch Details pop-up closes
    
 
    
    
