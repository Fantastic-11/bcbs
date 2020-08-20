#As a user of Blue Cross Blue Shield web site
#I would like to
#1.  go to home page
#2. Then hover over on Individuals & Families
#4. and click on Help with finding Insurance
#5. and go to that page
#6. find VISIT BLUE365 link and click on it
#7. than switch to that page
#8. And verify "Welcome Blue Cross Blue
#Shield members" message is displayed
@smoke
Feature: validation of Help with insurance and member discounts

  Scenario: verification of help with finding insurance option
    Given the user is on Blue Cross Blue Shield website
    When user hovers over on Individuals & families
    Then user click on Help with Finding Insurance option
    And verifies "Individuals & Families" message is displayed
  Scenario: verification of Members Discount link
    Given the user is on "https://www.bcbs.com/individuals-families" page
    When user clicks on "VISIT BLUE365" link
    Then user verifies Welcome Blue Cross Blue Shield members message is displayed