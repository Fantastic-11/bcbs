Feature: HomePage

  Background:
    Given the user is on the BCBS Homepage

  Scenario: Member Services
    When user navigates to "Member Services"
    And clicks on "Visit Blue365"
    Then user should be able to switch to the new window
    And user should see "Welcome Blue Cross Blue Shield members" message
