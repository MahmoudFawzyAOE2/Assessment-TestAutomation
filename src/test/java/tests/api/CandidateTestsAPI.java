package tests.api;


import api.utils.CandidatePojo;
import api.utils.CandidateUtils;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testData.TestData;

import static io.restassured.RestAssured.given;
import static testData.URLs.*;

public class CandidateTestsAPI extends BaseTestAPI {

    private CandidateUtils candidateUtils;

    @BeforeMethod
    public void setUp() {
    }

    @DataProvider(name = "candidateDataProvider")
    public Object[][] userDataProvider() {
        candidateUtils = new CandidateUtils();
        return new Object[][]{
                {candidateUtils.validCandidate(), 200},
                {candidateUtils.invalidCandidate_missingEmail(), 422} // Empty FirstName shall return invalid parameter
        };
    }

    @Test(dataProvider = "candidateDataProvider")
    @Description("verify that a candidate can be created successfully")
    public void addCandidate(CandidatePojo requestBody, int statusCode) {

        given().spec(request)
                .body(requestBody)
                .contentType("application/json")
                .cookie("orangehrm", AuthManager.authenticateAndGetSessionCookie(request, TestData.AdminUserName, TestData.AdminPassword))
                .when().post(CANDIDATES_API_ENDPOINT)
                .then().log().all()
                .assertThat().statusCode(statusCode)
                .extract().response();
    }

}
