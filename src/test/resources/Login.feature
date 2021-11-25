Feature: Login

  Scenario: Login with phone number
    Given on the "Landing Page"
    When click button login
    And input phone number
    And click on the button lanjut
    Then show verification popup