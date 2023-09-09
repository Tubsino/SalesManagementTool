@B.E2E
Feature: User Management Validation
  This feature is to validate the the user management module

  @tag1
  Scenario: Validate that admin can create user roles
    Given that Admin is logged in
    When Admin clicks on the security module button
    And clicks on the manage role submodule button
    And clicks on the Add New button
    And input a role name
    And clicks the Save button
    Then Admin user should be able to successfully create a new user role
    And signs out

  Scenario: Validate that admin user can modify roles
    Given that Admin is logged in
    When Admin clicks on the security module button
    And clicks on the manage role submodule button
    And click on the edit icon attached to a role name
    And edit the role name in the role name field
    And clicks the update button role
    Then Admin should be able to update the role successfully
    And signs out

  Scenario: Validate that the user can activate role permission
    Given that Admin is logged in
    When Admin clicks on the security module button
    And clicks on the manage role submodule button
    And clicks on the settings icon
    And clicks to turn on the toggle button on a permission
    Then check that the permission toggle on or off is successful
    And signs out

  Scenario: Validate that admin can modify partner's profile
    Given that Admin is logged in
    When Admin clicks on the profiles button
    And clicks on the manage partners
    And clicks on the Operations button
    And click the edit button
    And edit any of the fields
    And click the update partner button
    Then the partner's profile modification should be successful
    And signs out

  Scenario: Validate that the admin can configure role based priviledges
    Given that Admin is logged in
    When Admin clicks on the security module button
    And clicks on the manage role submodule button
    And selects a role from the action button on listed of role
    And toggle on/off a permission that is off from the list of permission
    And login as a user that is assigned to that role to validate if the permission is assigned
    Then The permission should be assigned successfully
    And signs out

  Scenario: Validate that channel partner can upload a digital signature as jpeg
    Given that Admin is logged in
    And channel partner clicks on My Profile button
    And channel partner clicks on choose file
    And click on upload
    Then check that the digital signature is uploaded successfully
    And signs out

  Scenario: Validate that the solution can assign 9mobile staff to a channel partner
    Given that Admin is logged in
    And Admin clicks on the profiles button
    And clicks on the manage partners
    And filter by dealer partner
    And clicks on the Operations button
    And click the edit button
    And click on the Assign Upline
    And selects the 9mobile staff
    And click the update partner button
    Then it should be successful
    And signs out
  #Scenario: Validate that admin can assign sub-dealers to various channel members.
  #Given that Admin is logged in
    #When Admin clicks on the profiles button
    #And clicks on the manage partners
