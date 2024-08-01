@test @logout
Feature: User can log out successfully

    Scenario: User log out successfully
        Given user clicks logout
        Then user is logged out successfully