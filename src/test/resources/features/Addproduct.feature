@test
Feature: Verify and Add product to the Cart scenarios.

  Scenario Outline: Verify the product on the homepage
    Given user login to the app with user <user> and pass <pass>
    Then verify the product is listed in the home page with name <title> and price <price>
    When user click on the Logout button
    Examples:
      | user          | pass         | title               | price  |
      | standard_user | secret_sauce | Sauce Labs Backpack | $29.99 |


  Scenario Outline: Verify product info on Product Details page
    Given user login to the app with user <user> and pass <pass>
    When user click on the product <Product>
    Then verify the product details page with product <Product>, price <price> and description <description>
    When user click on the Logout button
    Examples:
      | user          | pass         | Product               | price | description                                                                                                                                                     |
      | standard_user | secret_sauce | Sauce Labs Bike Light | $9.99 | A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included. |

  Scenario Outline: Add the product to the cart from Product page
    Given user login to the app with user <user> and pass <pass>
    When user click on the product <Product>
    Then verify the product details page with product <Product>, price <price> and description <description>
    Then verify add to cart button is visible
    When user click on the add to cart button in product page
    Then verify <NoofItems> product added to the cart
    When user click on the Logout button
    Examples:
      | user          | pass         | Product               | NoofItems | price | description                                                                                                                                                     |
      | standard_user | secret_sauce | Sauce Labs Bike Light | 1         | $9.99 | A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included. |

  Scenario Outline: Add the product to the cart from Home page and Checkout
    Given user login to the app with user <user> and pass <pass>
    When user add the product <Product> from homepage
    Then verify <NoofItems> product added to the cart
    And verify the product is listed in the cart page with name <Product> and price <price>
    When user click on the Checkout in the cart
    And user enter the checkout details with firstname <FirstName>, lastname <LastName> and zipcode <zip> and continue
    And verify the order info with paymentInfo <paymentInfo>, Shipping <Shipping> and total <total>
    When user click on the finish button in the checkout
    Then verify the order sucess msg <Sucessmsg> is displayed
    When user click on the Logout button

    Examples:
      | user          | pass         | Product             | price  | NoofItems | FirstName | LastName | zip  | paymentInfo      | Shipping                    | total  | Sucessmsg               |
      | standard_user | secret_sauce | Sauce Labs Backpack | $29.99 | 1         | Francis   | Ruban    | 1000 | SauceCard #31337 | FREE PONY EXPRESS DELIVERY! | $32.39 | THANK YOU FOR YOU ORDER |
