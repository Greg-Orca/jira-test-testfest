Feature: Test Jira edit issue functionality

  Scenario: edit existing issue
    Given user is logged in
    When user edit an issue summary to "Happy Path Edit"
    Then issue is renamed to "Happy Path Edit"
    And user restore the issue to "Happy Path"