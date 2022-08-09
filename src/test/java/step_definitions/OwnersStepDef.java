package step_definitions;

import com.jayway.restassured.response.ResponseBody;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dto.*;
import org.json.simple.JSONObject;
import support.MyConfig;
import support.SupportFunctions;


public class OwnersStepDef {

    public static Owner ownerDTO;

    @Given("^I have the owner details with lastname as \"([^\"]*)\"$")
    public void i_have_the_owner_details_with_lastname_as(String ownerLastName) throws Throwable {
        ResponseBody body = SupportFunctions.getUsingQueryParamter(MyConfig.Endpoint + "api/owners", "lastName", ownerLastName);
        Owner[] ownersDTO = SupportFunctions.convertResponseArray(Owner[].class);
        ownerDTO = ownersDTO[0];
    }
}
