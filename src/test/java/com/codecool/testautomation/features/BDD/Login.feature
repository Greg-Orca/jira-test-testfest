Feature: Test Jira login functionality

  Scenario: Check login is successful with valid credentials
    Given browser is open
    And user is on login page
    When user enters username and password
    And click login
    Then user profile page is visible

    Scenario Outline: Check login is unsuccessful with invalid credentials
      Given browser is open
      And user is on login page
      When user enters "<username>" and "<password>"
      And click login
      Then user profile page is not visible
      And restore user login

      Examples:
        | username   | password  |
        | invalid    | valid     |
        | valid      | invalid   |
        | invalid    | invalid   |