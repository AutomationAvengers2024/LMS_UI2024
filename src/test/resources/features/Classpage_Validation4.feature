Feature: Manage Class Functionality

  Background: 
    Given Admin is on the Manage Class page after Valid Login

  Scenario: Search for classes
    When Admin enters the Batch Name in the search textbox
    Then Admin should see Class details are searched by Batch Name

    When Admin enters the Class topic in the search textbox
    Then Admin should see Class details are searched by Class topic

    When Admin enters the Staff Name in the search textbox
    Then Admin should see Class details are searched by Staff Name

  Scenario: Pagination functionality
    When Admin clicks Next page link on the class table
    Then Admin should see the next page record on the table with Pagination has next active link enabled

    When Admin clicks Last page link
    Then Admin should see the last page record on the table with Next page link disabled

    Given Admin is on the last page of the class table
    When Admin clicks First page link
    Then Admin should see the previous page record on the table with pagination has previous page link enabled

    Given Admin is on a previous class page
    When Admin clicks Start page link
    Then Admin should see the very first page record on the table with Previous page link disabled

  Scenario: Navigation validation
    Given Admin is on the dashboard page after login and clicks Class on the navigation bar
    When Admin clicks on Class link on Manage Class page
    Then Admin is re-directed to the class page

    When Admin clicks on any module link on Manage Class page
    Then Admin is re-directed to the module link they clicked

    When Admin clicks on Logout link on Manage Class page
    Then Admin is re-directed to the Login page
