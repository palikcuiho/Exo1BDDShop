
Feature: User account registration

    Scenario: Message when user successfully registers

        Given The user fills in the registration form
        When The user registers
        Then The account was successfully registered
        And A confirmation message is sent

    Scenario: User name already exists

        Given The user fills in the registration form
        When The user name already exists
        Then An error is sent