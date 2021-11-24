Feature: Login

  Scenario: Login with phone number
    Given on the "Landing Page"
    When click button login
    And input phone number
    And click on the button lanjut
    Then show verification popup

#  Scenario: Login with input password
#    Given already on verification popup
#    When click on section password
#    Then show input password page
#
#  Scenario: Login with OTP
#    Given already on verification popup
#    When click on the section otp
#    Then show input otp page