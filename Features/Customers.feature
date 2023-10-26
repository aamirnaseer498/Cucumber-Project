Feature: Customers

  Background: Below are the common steps for each scenario
    Given Launch chrome browser
    When Open URL "https://admin-demo.nopcommerce.com/login"
    Then Enter email as "admin@yourstore.com" and password as "admin"
    Then Click on login button
    And Dashboard is available now
    When Click on Customers menu
    Then Click on Customers menu item

  @sanity
  Scenario: Add a new Customer
    Then Click on Add new button
    And Add new customer is available now
    When Enter customer info
    Then Click on Save button
    Then Confirmation message "The new customer has been added successfully." will appear
    And Close browser

  @regression
  Scenario: Search Customer by email ID
    Then Enter Customer email ID
    And Click on Search button
    Then User email should appear in search result
    And Close browser

  @regression
  Scenario: Search Customer by Name
    Then Enter Customer FirstName
    Then Enter Customer LastName
    And Click on Search button
    Then User name should appear in search result
    And Close browser