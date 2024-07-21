Feature:login
Background:
  Given user opens UltimateQA UI

  Scenario: Login
    Then user verifies page title then take screenshot and maximize page
    Then the user login to UltimateQA test
    And the user sign out and verify

  Scenario: Fill out Forms
    Then the user clicks on fill out form and submit

  Scenario: Fake Pricing Page
    And the user purchased the basic package
