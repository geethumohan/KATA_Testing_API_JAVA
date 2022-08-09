Feature: Pets APIs

  @get_pets
  Scenario: Get all the PETS
    When I want to know all the pets in the clinic
    Then I should receive 13 pets

    Scenario: Add a pet to an owner
      Given I have the owner details with lastname as "Franklin"
      And I have the category details for pet "dog"
      When I add a new pet
      And I want to know all the pets in the clinic
      Then I should see the newly added pet details

