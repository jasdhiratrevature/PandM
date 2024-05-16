Feature: Login to the Site
  Scenario: Successful Login with valid Credentials
    Given User is on Login Page
    When User enters UserName and Password
    Then Then User should see the logout button