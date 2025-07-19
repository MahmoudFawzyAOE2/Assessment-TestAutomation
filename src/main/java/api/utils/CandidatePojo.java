package api.utils;


public class CandidatePojo {

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

    // Default constructor
    public CandidatePojo() {}

    // Constructor with all fields
    public CandidatePojo(String firstName, String middleName, String lastName, String email,
                         String contactNumber, String keywords, String comment,
                         String dateOfApplication, boolean consentToKeepData, Integer vacancyId) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.keywords = keywords;
        this.comment = comment;
        this.dateOfApplication = dateOfApplication;
        this.consentToKeepData = consentToKeepData;
        this.vacancyId = vacancyId;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getComment() {
        return comment;
    }

    public String getDateOfApplication() {
        return dateOfApplication;
    }

    public boolean isConsentToKeepData() {
        return consentToKeepData;
    }

    public Integer getVacancyId() {
        return vacancyId;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDateOfApplication(String dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

    public void setConsentToKeepData(boolean consentToKeepData) {
        this.consentToKeepData = consentToKeepData;
    }

    public void setVacancyId(Integer vacancyId) {
        this.vacancyId = vacancyId;
    }

    @Override
    public String toString() {
        return "CandidatePojo{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", keywords='" + keywords + '\'' +
                ", comment='" + comment + '\'' +
                ", dateOfApplication='" + dateOfApplication + '\'' +
                ", consentToKeepData=" + consentToKeepData +
                ", vacancyId=" + vacancyId +
                '}';
    }
}
