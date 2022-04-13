@OMT-171
  Feature: validating search existing user

    Scenario: validating search existing user
      Given user navigates to orangeHRM application
      When user provide username "Admin" and password "admin123"
      And user search for "Omkar"
      Then validates if the user is listed