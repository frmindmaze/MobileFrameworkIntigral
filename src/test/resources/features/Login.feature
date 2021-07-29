@test
Feature: Login scenarios

  Scenario Outline: Verify login with incorrect username
    When user enter the username as <username>
    And user enter the password as <password>
    And user click on the login button
    Then verify login failed with error message <errormsg>
    Examples:
      | username | password | errormsg |
      | Testuser | secret_sauce | Username and password do not match any user in this service. |

  Scenario Outline: Verify login with incorrect password
    When user enter the username as <username>
    And user enter the password as <password>
    And user click on the login button
    Then verify login failed with error message <errormsg>
    Examples:
      | username | password | errormsg |
      | standard_user | TestPassword | Username and password do not match any user in this service. |

  Scenario Outline: Verify login with correct username and password
    When user enter the username as <username>
    And user enter the password as <password>
    And user click on the login button
    Then verify homepage is displayed with title <title>
    Examples:
      | username | password | title |
      | standard_user | secret_sauce | PRODUCTS |