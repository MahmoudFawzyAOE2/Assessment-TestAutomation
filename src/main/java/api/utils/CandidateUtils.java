package api.utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;

public class CandidateUtils {
    private final Faker faker = new Faker();

    /*
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String keywords;
    private String comment;
    private String dateOfApplication;
    private boolean consentToKeepData;
    private Integer vacancyId;
    */

    public CandidatePojo validCandidate() {
        return new CandidatePojo(
                faker.name().firstName(),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                String.valueOf(faker.number().numberBetween(1000000000L, 1299999999L)),
                faker.lorem().word(),
                faker.lorem().sentence(),
                LocalDate.now().toString(),
                faker.bool().bool(),
                2
        );
    }

    public CandidatePojo invalidCandidate_missingEmail() {
        return new CandidatePojo(
                faker.name().firstName(),
                faker.name().firstName(),
                faker.name().lastName(),
                "",
                String.valueOf(faker.number().numberBetween(1000000000L, 1299999999L)),
                faker.lorem().word(),
                faker.lorem().sentence(),
                LocalDate.now().toString(),
                faker.bool().bool(),
                faker.number().numberBetween(1,8)
        );
    }

}
