package step_definitions;

import com.jayway.restassured.response.ResponseBody;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import dto.*;
import support.MyConfig;
import support.SupportFunctions;
import static support.JSONFileParser.convertClassDataToJSONString;

import java.util.Arrays;

public class VetsStepDef {

    private static ResponseBody body;
    public Speciality speciality;

    @Given("^I have the speciality details of \"([^\"]*)\"$")
    public void i_have_the_speciality_details_of(String specialityName) throws Throwable {
        body = SupportFunctions.get(MyConfig.Endpoint + "api/specialties");
        Speciality[] specialities = SupportFunctions.convertResponseArray(Speciality[].class);
        speciality = Arrays.stream(specialities).filter(speciality -> speciality.getName().equals(specialityName)).findFirst()
                .orElseThrow(() -> new Exception("Matching speciality not found"));
    }

    @When("^I add a new vet with \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_add_a_new_vet_with_and(String firstName, String lastName) throws Throwable {
        Speciality [] specialities = {speciality};
        Vet vetTestData = new Vet(firstName, lastName, specialities);
        body = SupportFunctions.post(MyConfig.Endpoint + "api/vets", convertClassDataToJSONString(vetTestData));
    }

}
