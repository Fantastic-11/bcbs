Feature: Shop for Insurance Button

  As a user of BlueCrossBlueShield web site
  I want to go to the homepage, click "Shop for Insurance" button
  So that the message "Find the health insurance option that is right for you, your family, or your business." is displayed

  Scenario: Shop for Insurance Button Verification
    Given the user is on the home page
    And the Shop for Insurance button is displayed
    When the user clicks the Shop for Insurance button
    Then the message "Find the health insurance option that is right for you, your family, or your business." is displayed
