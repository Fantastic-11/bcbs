@Smoke
Feature: Validation of Careers option

  Scenario: Checking Careers option
    Given user is on home page of Blue Cross Blue Shield
    And verify there is Careers option on the page
    When user clicks on Careers link
    Then user should see "Your Journey Starts Here" message