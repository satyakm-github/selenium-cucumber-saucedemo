Feature: Login feature

  Scenario Outline: Login with valid credentials
    Given user is on login page
    When user enters valid "<username>" and "<password>"
    When user clicks on login button
    Then user navigates to Products page
    When user selects the highest priced items to add to cart
    Then user verifies the cart should contain the selected product
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |