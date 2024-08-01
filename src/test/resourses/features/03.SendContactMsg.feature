@test @contact
Feature: User can add item to cart successfully

    Scenario: User can send a contact message
        Given user clicks the contact link
        When user fills the contact data
        Then the message is sent successfully