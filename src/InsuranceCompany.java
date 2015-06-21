/**
 * Created by higuchijay on 3/8/15.
 */
public class InsuranceCompany {
    public String payerID;
    public String payerName;
    public String purpose;
    public String policyName;

    public InsuranceCompany(String payerID, String payerName, String purpose, String policyName) {
        this.payerID = payerID;
        this.payerName = payerName;
        this.purpose = purpose;
        this.policyName = policyName;
    }

    public String getPayerID() {
        return payerID;
    }

    public void setPayerID(String payerID) {
        this.payerID = payerID;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }
}


