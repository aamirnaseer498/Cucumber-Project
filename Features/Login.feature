Feature: Login

  Scenario: Login with valid credentials
    Given Launch chrome browser
    When Open URL "https://admin-demo.nopcommerce.com/login"
    Then Enter email as "admin@yourstore.com" and password as "admin"
    Then Click on login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When Click on Logout link
    Then Page title should be "Your store. Login"
    And Close browser

  Scenario Outline: Login with invalid credentials
    Given Launch chrome browser
    When Open URL "https://admin-demo.nopcommerce.com/login"
    Then Enter email as "<email>" and password as "<password>"
    Then Click on login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When Click on Logout link
    Then Page title should be "Your store. Login"
    And Close browser

    Examples:
    | email | password |
    | admin1@yourstore.com | admin123 |
    | admin4@yourstore.com | admin456 |
    | admin7@yourstore.com | admin789 |