Feature: To test SMT functionalities

  Scenario Outline: Validate that user is unable to login with invalid credential
    Given user is on log in page
    When user enters invalid <username> and invalid <password>
    And clicks the Sign In button
    Then user should not be able to sign in

    Examples: 
      | username      | password |
      | abc@gmail.com | shayo    |

  Scenario Outline: Validate that user can login with valid credential
  	Given user is on login page
    When user enters valid <username1> and valid <password1>
    And clicks the Sign In button for valid login
    Then user should be able to sign in successfully

    Examples: 
      | username1                 | password1 |
      | ooshodi@bluechiptech.biz | p@ssw0rd |

  Scenario: Validate that user can view inventory
    Given user is on landing page (Dashboard)
    When user clicks on Inventory
    And clicks on Stock Inquiry
    And clicks on user's name
    Then The list of stocks in the inventory should display successfully for the dealer

  Scenario: Validate that user can view downline stocks
    Given user is on stock inquiry page
    When user click on the partner button
    And click on any partner's name
    Then The list of stocks in the partner's inventory should display successfully for the subdealer

  Scenario: validate that user view location
    Given user is on the landing page Dashboard
    When user clicks on Settings
    And click on Manage Settings
    Then location page should display successfully
