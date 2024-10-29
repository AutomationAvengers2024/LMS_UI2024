@Program
Feature: Add new program

Background: Admin is on program module after reaching dashboard
Given Admin is in Home Page
When Admin enter valid credentials and clicks login button
And Admin clicks "Program" on the navigation bar

@TS1
Scenario: Verify add new program

Given Admin is on Manage Program Page
When Admin clicks <New Program>button
Then Admin should see a popup open for Program details

@TS2
Scenario: Verify title of the popup window

 Given Admin is on Manage Program Page
 When Admin clicks <New Program>button
 Then Admin should see the window title as "Program Details"
 
@TS3 
Scenario: Empty form submission 

Given Admin is on Manage Program Page
When Admin clicks <New Program>button and clicks <Save>button without entering any data
Then Admin gets a Error message alert 

@TS4
Scenario: Enter only Program Name

Given Admin is on Manage Program Page
When Admin clicks <New Program>button and enters only <Program Name> in text box and clicks Save button
Then Admin gets a message alert 'Description is required'

@TS5
Scenario: Enter only Program Description

Given Admin is on Manage Program Page
When Admin clicks <New Program>button and enters only<Program description> in text box and clicks Save button
Then Admin gets a message alert 'Name is required'

@TS6
Scenario: Select Status only

Given Admin is on Manage Program Page
When Admin clicks <New Program>button and selects only Status and clicks Save button
Then Admin gets a message alert 'Name and Description required'

@TS7
Scenario: Validate invalid values on the text column

Given Admin is on Manage Program Page
When Admin clicks <New Program>button and enters only numbers in name and desc column and clicks Save button
Then Admin gets a Error message alert 

@TS8
Scenario: Validate Cancel/Close(X) icon on Program Details form

Given Admin is on Manage Program Page
When Admin clicks <New Program>button and click Cancel Icon on Program Detail form
Then Program Details popup window should be closed without saving

@TS9
Scenario: Validate Save button on Program Details form

Given Admin is on Manage Program Page
When Admin clicks <New Program>button and enter all the required fields with valid values and click Save button
Then Admin gets a message "Successful Program Created" alert and able to see the new program added in the data table

@TS10
Scenario: Validate Cancel button on Program Details form

Given Admin is on Manage Program Page
When Admin clicks <New Program>button and clicks <Cancel>button 
Then Admin can see the Program details popup disappears without creating any program

@TS11
Scenario: Validate Program Details Popup window

Given Admin is on Manage Program Page
When Admin clicks <New Program>button
Then Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window

@TS12
Scenario: Validate input fields and their text boxes in Program details form

Given Admin is on Manage Program Page 
When Admin clicks <New Program>button
Then Admin should see two input fields and their respective text boxes in the program details window

@TS13
Scenario: Validate radio button for Program Status 

Given Admin is on Manage Program Page   
When Admin clicks <New Program>button
Then Admin should see two radio button for Program Status



