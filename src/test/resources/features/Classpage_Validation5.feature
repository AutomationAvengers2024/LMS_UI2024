Feature: Delete Class

Background:
Given Admin is on the Manage Class page after login.

Scenario: Validate Row Level Delete Icon
When Admin clicks the delete icon,
Then Admin should see an alert open with the heading "Confirm" along with a button for deletion.

Scenario: Click Yes on Deletion Window
Given Admin is on the Confirm Deletion alert,
When Admin clicks the yes option,
Then Admin gets a message "Successful Class Deleted" alert and does not see that Class in the data table.

Scenario: Click No on Deletion Window
Given Admin is on the Confirm Deletion alert,
When Admin clicks the no option,
Then Admin can see the deletion alert disappears without deleting.

Scenario: Validate Close (X) Icon on Confirm Deletion Alert
Given Admin is on the Confirm Deletion alert,
When Admin clicks on the close button,
Then Admin can see the deletion alert disappears without any changes.

Scenario: Validate Common Delete Button Enabled After Clicking on Any Checkbox
Given Admin is on the Manage Class page after login
When Admin clicks any checkbox in the data table,
Then Admin should see the common delete option enabled under the header Manage Class.

Scenario: Validate Multiple Class Deletion by Selecting Single Checkbox
Given Admin is on the Confirm Deletion alert,
When Admin clicks the button on the alert,
Then Admin should land on the Manage Class page and can see the selected class is deleted from the data table.

Scenario: Validate Multiple Class Deletion by Selecting Multiple Checkboxes
Given Admin is on the Confirm Deletion alert,
When Admin clicks the button on the alert,
Then Admin should land on the Manage Class page and can see the selected classes are deleted from the data table.
