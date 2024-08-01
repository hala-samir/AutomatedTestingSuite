@test @cart
Feature: User can add item to cart successfully

    Scenario: User adds item to the cart
        Given user clicks "Laptops" category
        When user clicks the first displayed item
        Then the item is added to the cart