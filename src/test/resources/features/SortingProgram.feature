Feature: Manage Program - Sorting Program

  Background: 
    Given Admin is in HomePage
    When Admin enter valid credentials lms and clicks login button
    And Admin is on click program on module after reaching dashboard


  Scenario: Verify sorting of  Program name in Ascending order/Descending order
    When Admin clicks on Arrow next to program Name
    Then Admin See the Program Name is sorted in Ascending order/Descending order

  Scenario: Verify sorting of  Program Descriptionin  Ascending order/Descending order
    When Admin clicks on Arrow next to ProgramDescription
    Then Admin See the program Description is sorted in Ascending order/Descending order

  Scenario: Verify sorting of   Program status in Ascending order/Descending order
    When Admin clicks on Arrow next to Program status
    Then Use See the  Program Status is sorted in Ascending order/Descending order
