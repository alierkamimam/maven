@tag
Feature: Purchase the order from Ecommerce Website

  Background:
    Given I landed on Ecommerce Page

  @Tag2
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <userName> and password <email>
    When  I fill password <password> and birthday <day> and <month> and <year>
    And Switch to productPage with product button
    Then Close to window
    Examples:
      | userName | email           | password | day | month | year |
      | erkam    | erkam@gmail.com | 12345    | 22  | March | 1997 |
