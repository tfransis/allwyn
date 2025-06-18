@Authors
Feature: Get All Authors from the Library

  Scenario: Get all authors that have been added to the library
    When all authors are retrieved
    Then verify that the response status code is 200
    And verify that the authors in the library are 615

  Scenario: Get all authors who share the same book ID
    When authors with book id 1 are retrieved
    Then verify that the response status code is 200
    And verify that all authors have book id 1

  Scenario: Get all authors who share the same book ID
    When authors with book id 10000 are retrieved
    Then verify that the response status code is 200
    And verify that the authors in the library are 0