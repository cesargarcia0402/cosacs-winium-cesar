@LoginCosacs
Feature: Regression in Cosacs

  @Login
  Scenario: Login in Cosacs
    Given the user opens Cosacs
    When the user into uat with the credentials
    Then should be visible menu