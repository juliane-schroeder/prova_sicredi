@provaSicredi
Feature: Customers
  I want to add and delete a customer successfully

  @desafio1
  Scenario: Add a new customer
    Given I open the grocery crud website
    When I create a new customer
    Then I can see the message Your data has been successfully stored into the database. on the screen
    
  @desafio2
  Scenario: Delete a customer
    Given I add a new customer
    When I search for a customer and delete it with the message Are you sure that you want to delete this 1 item?
    Then I can see the message Your data has been successfully deleted from the database. on an alert
    