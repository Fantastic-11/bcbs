@temp
Feature: Validation of Careers option

  Background: Navigating to BCBS
    Given user is on home page of Blue Cross Blue Shield

  Scenario: Checking Careers option
    And verify there is Careers option on the page
    When user clicks on Careers link
    Then user should see "Your Journey Starts Here" message



    #User story: (continuation of Careers feature from prev sprint)
    #As a user of Blue Cross Blue Shield website
    #1. I want to go to the careers link
    #2. and verify that I'm in careers page
    #3. then I want to click on Choose State option
    #4. and verify I get a drop down menu with list of states
    #5. I want to pick "Illinois" and click on GO button
    #6. And verify that I get a message that shows what companies serve members in "<state>" --> (members in that state)
    #Note(if any steps are repeating, you may omit it)

  Scenario:Verifying Choose State option
    When user clicks on Careers link
    Then user should be in careers page
    And user clicks on Choose State option
    Then user should see a drop down menu with list of states
    When user picks "Illinois" and clicks on Go button
    Then user should get "The following Blue Cross and Blue Shield companies serve members in Illinois."
    And user should see "Blue Cross and Blue Shield of Illinois" link


