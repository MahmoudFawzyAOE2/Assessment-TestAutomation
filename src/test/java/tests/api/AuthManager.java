package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import testData.TestData;
import static testData.URLs.*;

public class AuthManager {

    public static String authenticateAndGetSessionCookie(
            io.restassured.specification.RequestSpecification request,
            String userName,
            String password) {

        System.out.println("---------------Getting CSRF Token & cookies-----------------");
        // Get login page to get CSRF token + cookies
        Response loginPageResponse = RestAssured.given()
                .spec(request)
                .when()
                .get(LOGIN_ENDPOINT);

        // Extract CSRF token from response HTML
        String html = loginPageResponse.getBody().asString();
        String token = TokenExtractor.extractToken(html);
        System.out.println("Extracted CSRF token: " + token);

        String loginBody = "_token=" + token +
                "&username=" + userName +
                "&password=" + password;

        System.out.println("---------------Authenticating-----------------");
        Response re = RestAssured.given()
                .spec(request)
                .contentType("application/x-www-form-urlencoded")
                .cookies(loginPageResponse.getCookies())
                .body(loginBody)
                .when().post(VALIDATE_ENDPOINT)
                .then()
                .extract().response();

        System.out.println("---------------Processing Cookies-----------------");
        String sessionCookie = re.getCookie("orangehrm");
        System.out.println("Session Cookie: " + sessionCookie);

        System.out.println("---------------Finalizing Authentication-----------------");
        RestAssured.given()
                .spec(request)
                .contentType("application/x-www-form-urlencoded")
                .cookie("orangehrm", sessionCookie)
                .body(loginBody)
                .when().post(DASHBOARD_ENDPOINT)
                .then()
                .extract().response();

        System.out.println("---------------Authentication Done-----------------");

        return sessionCookie;
    }

    public class TokenExtractor {
        public static String extractToken(String html) {
            Document doc = Jsoup.parse(html);
            Element authLogin = doc.selectFirst("auth-login");

            if (authLogin != null) {
                String tokenAttr = authLogin.attr(":token"); // Raw attribute
                // Decode HTML quotes: &quot;...&quot; → "..."
                String decoded = org.jsoup.parser.Parser.unescapeEntities(tokenAttr, true);

                // Remove surrounding quotes if present
                return decoded.replaceAll("^\"|\"$", "");
            }
            return "";
        }
    }
}
