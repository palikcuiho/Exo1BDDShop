
Feature: User account

    Scenario: User name already exists

        Given The user fills in the registration form
        When The user inputs an existing user name
        Then An error is sent