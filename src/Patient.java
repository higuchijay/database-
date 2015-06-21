/**
 * Created by higuchijay on 3/8/15.
 */
public class Patient {


    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientRole() {
        return patientRole;
    }

    public void setPatientRole(String patientRole) {
        this.patientRole = patientRole;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthtime() {
        return birthtime;
    }

    public void setBirthtime(String birthtime) {
        this.birthtime = birthtime;
    }

    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public String getXmlhealthCreation() {
        return xmlhealthCreation;
    }

    public void setXmlhealthCreation(String xmlhealthCreation) {
        this.xmlhealthCreation = xmlhealthCreation;
    }

    private String patientID;
    private String patientRole;
    private String givenName;
    private String familyName;
    private String suffix;
    private String gender;
    private String birthtime;
    private String providerID;
    private String xmlhealthCreation;

    public Patient(String patientid, String patientrole, String givenname, String familyname, String suff, String sex, String birth, String providerid, String xmlhealthcreation){
        patientID = patientid;
        patientRole = patientrole;
        givenName = givenname;
        familyName = familyname;
        suffix = suff;
        gender = sex;
        birthtime = birth;
        providerID = providerid;
        xmlhealthCreation = xmlhealthcreation;

    }

}
