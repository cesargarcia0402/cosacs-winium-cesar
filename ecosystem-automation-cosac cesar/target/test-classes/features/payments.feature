@PaymentsCosacs
Feature: Regression in Cosacs

  @Payments
  Scenario: Disbursement in Cosacs
    Given the user login in Cosacs
    When the user selects the customer menu
    Then should complete the disbursement