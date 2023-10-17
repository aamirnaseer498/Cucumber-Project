Feature: OrangeHRM Login

  Scenario: Logo presence on OrangeHRM homepage
    Given Launch chrome browser
    When Open orangehrm homepage
    Then Verify that the logo present on page
    And Close browser