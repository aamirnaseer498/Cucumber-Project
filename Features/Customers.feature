Feature: Customers

  Scenario: Add a new Customer
    Given Launch chrome browser
    When Open URL "https://admin-demo.nopcommerce.com/login"
    Then Enter email as "admin@yourstore.com" and password as "admin"
    Then Click on login button
    And Dashboard is available now
    When Click on Customers menu
    Then Click on Customers menu item
    Then Click on Add new button
    And Add new customer is available now
    When Enter customer info
    Then Click on Save button
    Then Confirmation message "The new customer has been added successfully." will appear
    And Close browser