Feature: User account login

      Scenario: Login an existing user
        Given a user tries to log in
        When the user exists
        Then the user is logged in
        And the user is redirected to home page

    Scenario: Login a user who does not exist
        Given a user tries to log in
        When The user does not exist
        Then there is an error

    Scenario: Login a user with a wrong password
        Given A user tries to log in
        When The password is wrong
        Then there is an error