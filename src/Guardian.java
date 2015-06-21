/**
 * Created by higuchijay on 3/8/15.
 */
public class Guardian {
    public String guardianNo;
    public String givenName;
    public String familyName;
    public String phone;
    public String address;
    public String city;
    public String state;
    public String zip;

    public Guardian(String guardianNo, String givenName, String familyName, String phone, String address, String city, String state, String zip) {
        this.guardianNo = guardianNo;
        this.givenName = givenName;
        this.familyName = familyName;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getGuardianNo() {
        return guardianNo;
    }

    public void setGuardianNo(String guardianNo) {
        this.guardianNo = guardianNo;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
