Feature: A Hudl user can securely log in with valid credentials

  Background:
    Given the user is on the log in page

  Scenario: User logs in with valid Credentials and is navigated to the home page
    When the user logs in with a valid email and password
    Then the user is taken to the Home page

  Scenario: User logs in with valid Credentials and the user menu is displayed on the home page
    When the user logs in with a valid email and password
    Then the user menu is displayed

  Scenario: User attempts to log in with no email
    When the user logs in with  a valid password and no email
    Then the user sees a helpful error message

  Scenario: User attempts to log in with no password
    When the user logs in with a valid email and no password
    Then the user sees a helpful error message

  Scenario: User attempts to log in with no email and no password
    When the user logs in with a no email and no password
    Then the user sees a helpful error message

  Scenario: User attempts to log in with invalid email and valid password
    When the user logs in with an invalid email and a valid password
    Then the user sees a helpful error message

  Scenario: User attempts to log in with valid email and invalid password
    When the user logs in with a valid email and an invalid password
    Then the user sees a helpful error message