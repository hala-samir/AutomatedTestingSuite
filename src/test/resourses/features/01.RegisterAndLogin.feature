@test @registerLogin
Feature: User can register and log in successfully

    Scenario: User registers successfully
      Given user is in home page
      When user fills the required data
      Then user clicks register

    Scenario: User logs in successfully
      Given user enters correct username and password
      Then user logs in successfully