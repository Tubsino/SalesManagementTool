@A.E2E
Feature: Onboarding Validation
  This is to validate the onboarding features

  
  Scenario: Validate that admin can login successfully
    Given that user is on the login page
    When Admin enters username in the username field
    And enters password in the password field and click on sign in
    Then Admin should be logged in successfully

  Scenario: Validate that admin can enroll channel members
    Given that admin is logged in
    When Admin click on the profile submenu button
    And Admin clicks manage partners
    And clicks the enroll partner button
    And fills the form
    And clicks the Add Partner button
    Then it should be successfull

  Scenario: Validate that the solution can prevent duplicate of channel members at the point of creation
    Given Admin is on the landing page
    When Admin clicks on the profile submenu btn
    And Admin clicks manage partners btn
    And clicks the enroll partner btn
    And fills the form in the page
    And clicks the Add Partner btn
    Then it should not be successfull

  Scenario: Validate that the system allow single user access at a time
    Given that Admin launches the app on a new window
    When Admin logs into the application
    And goes back to the previous tab
    And refreshing the page
    Then a error message should display
