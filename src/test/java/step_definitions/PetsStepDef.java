package step_definitions;

import com.jayway.restassured.response.ResponseBody;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dto.Pet;
import dto.Type;
import org.junit.Assert;
import support.MyConfig;
import support.SupportFunctions;
import static support.JSONFileParser.convertClassDataToJSONString;

import java.util.Arrays;


public class PetsStepDef {

    private static ResponseBody body;
    private static String requestBody;
    private static Pet petDTO;

    @When("^I want to know all the pets in the clinic$")
    public void i_want_to_know_all_the_pets_in_the_clinic() {
        body = SupportFunctions.get(MyConfig.Endpoint + "api/pets");
        System.out.println(body.asString());
    }

    @Then("^I should receive 13 pets$")
    public void i_should_receive_pets() throws Throwable {
        Pet[] petsDTO = SupportFunctions.convertResponseArray(Pet[].class);
        int amountOfPets = petsDTO.length;
        Assert.assertEquals("the amount of pets is 13 | ",13,amountOfPets);
    }

    @When("^I add a new pet$")
    public void i_add_a_new_pet_of_category() throws Throwable {
        String ownerID = Integer.toString(OwnersStepDef.ownerDTO.getId());
        body = SupportFunctions.postWithRequestParameters(MyConfig.Endpoint + "api/owners/{ownerId}/pets", "ownerId", ownerID, requestBody);
        petDTO = SupportFunctions.convertResponse(Pet.class);
    }

    @Then("^I should see the newly added pet details$")
    public void i_should_see_the_newly_added_pet_details() throws Throwable {
        Pet[] petsDTO = SupportFunctions.convertResponseArray(Pet[].class);
        Pet newlyAddedPet = Arrays.stream(petsDTO).filter(pet -> pet.getId() == petDTO.getId()).findFirst()
                .orElseThrow(() -> new Exception("Newly added pet not found"));
        Assert.assertEquals(newlyAddedPet.getName(), petDTO.getName());
    }

    @Given("^I have the category details for pet \"([^\"]*)\"$")
    public void i_have_the_category_details(String category) throws Throwable {
        body = SupportFunctions.get(MyConfig.Endpoint + "api/pettypes");
        Type[] petTypes = SupportFunctions.convertResponseArray(Type[].class);
        Type petType = Arrays.stream(petTypes).filter(type -> type.getName().equals(category)).findFirst()
                .orElseThrow(() -> new Exception("Matching category not found"));
        Type typeDTO = new Type();
        typeDTO.setId(petType.getId());
        typeDTO.setName(petType.getName());
        Pet petDTO = new Pet("Tayyo", "2022-07-09", typeDTO);
        requestBody = convertClassDataToJSONString(petDTO);
    }

}
