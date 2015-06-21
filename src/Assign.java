/**
 * Created by higuchijay on 3/8/15.
 */
public class Assign {
    public String patientid;
    public String authorid;

    public Assign(String patientid, String authorid) {
        this.patientid = patientid;
        this.authorid = authorid;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getAuthorid() {
        return authorid;
    }

    public void setAuthorid(String authorid) {
        this.authorid = authorid;
    }
}
