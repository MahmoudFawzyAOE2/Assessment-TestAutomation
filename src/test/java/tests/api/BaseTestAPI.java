package tests.api;
import jdk.jfr.Description;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;
import static testData.URLs.BASE_URL;

public class BaseTestAPI {

    public RequestSpecification request;
    @BeforeMethod
    @Description("adding necessary Headers to the requests")
    public void beforeMethod (){
        request = given().baseUri(BASE_URL);
    }

}
