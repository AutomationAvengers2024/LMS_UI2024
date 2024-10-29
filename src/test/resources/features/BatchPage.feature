Feature: Batch Page Navigation and Validation

  Background: Admin successfully logs in to the LMS Portal
    Given Admin is on the Dashboard Page after login

  @Test1
  Scenario: Verify Admin navigates to Batch page successfully
    When Admin clicks on the Batch menu from the header
    Then Admin should be on the Manage Batch Page

  @Test2
  Scenario: Validate "Title" in Batch Page
    When Admin clicks on the Batch menu from the header
    Then Admin should see the "LMS" Title

  @Test3
  Scenario: Validate "Heading" in the Batch Page
    When Admin clicks on the Batch menu from the header
    Then Admin should see the "Manage Batch" Heading

  @Test4
  Scenario: Validate disabled "Delete Icon" under the header in the Batch Page
    When Admin clicks on the Batch menu from the header
    Then Admin should see the disabled Delete Icon under the header

  @Test5
  Scenario: Validate pagination in the Batch Page
    When Admin clicks on the Batch menu from the header
    Then Admin should see the enabled pagination controls under the data table

  @Test6
  Scenario: Validate edit icon in each data row
    When Admin clicks on the Batch menu from the header
    Then Admin should see the edit icon in each row

  @Test7
  Scenario: Validate delete icon in each data row
    When Admin clicks on the Batch menu from the header
    Then Admin should see the delete icon in each row

  @Test8
  Scenario: Validate checkbox in each data row
    When Admin clicks on the Batch menu from the header
    Then Admin should see the checkbox in each row

  @Test9
  Scenario: Validate Datatable headers
    When Admin clicks on the Batch menu from the header
    Then Admin should see the datatable headers:
      | Batch Name        |
      | Batch Description |
      | Batch Status      |
      | No Of Classes     |
      | Program Name      |
      | Edit / Delete     |

  @Test10
  Scenario: Validate "Checkbox" in the Datatable header row
    When Admin clicks on the Batch menu from the header
    Then Admin should see the checkbox in the datatable header row

  @Test11
  Scenario: Validate "Sort Icon" next to all Datatable headers
    When Admin clicks on the Batch menu from the header
    Then Admin should see the sort icon next to all Datatable headers

  @Test12
  Scenario: Verify sub menu displayed in batch menu bar
    When Admin clicks "Batch" on the navigation bar
    Then Admin should see sub menu in menu bar as "Add New Batch"

  @Test13
  Scenario: Validate Admin able to click on the Add New Batch option
    When Admin clicks on "Add New Batch" under the "Batch" menu bar
    Then Admin should see the Batch Details pop-up window

   @Test23
  Scenario: Validate logout option in the header is visible and enabled from the batch page
    When Admin clicks on the logout in the menu bar
    Then Admin should be redirected to login page