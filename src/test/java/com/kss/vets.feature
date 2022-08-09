Feature: Vet APIs

  Scenario Outline: Create a vet with different specialities
    Given I have the speciality details of "<speciality>"
    When I add a new vet with "<firstName>", "<lastName>"
    Then the response code should be "201"
    Examples:
      | firstName | lastName | speciality |
      | Frank     | Bachmann | radiology  |
      | TTT       | DSouza   | surgery    |
      | Raymond   | George   | dentistry  |