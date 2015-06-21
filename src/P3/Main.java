package P3;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.sql.Date.*;
import java.text.*;

/**
 * Created by higuchijay on 3/11/15.
 */


/**
 * Created by shivani on 3/8/15.
 */

// Import Required Packages


public class Main {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/" + "healthmessagesexchange4";
    static final String Our_DB = "jdbc:mysql://localhost/" + "HealthInformationSystem";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Connection ourdatabase = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            ourdatabase = DriverManager.getConnection(Our_DB, USER, PASS);
            //STEP 4: Execute a query



            //Scanner in = new Scanner(System.in);
            //String s;
            System.out.println("Creating statement...");
            //System.out.println("What kind of user are you? P for patient, D for doctor, or A for administrator");
            //s = in.nextLine();

            //If user is a patient enter in info
            //if(s.equals("P"))
            //{

            //}


            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM " + "healthmessagesexchange4" + "." + "messages";
            String msg;
            msg = "SELECT * FROM " + "healthmessagesexchange4" + "." + "messages2";


            ResultSet resultSet = stmt.executeQuery(sql);


            //STEP 5: Extract data from result set
            while(resultSet.next()) {
                //Retrieve by column name
                String patientId = resultSet.getString("patientId");
                //grab all data from table
                //patient
                String name = resultSet.getString("GivenName");
                String famName = resultSet.getString("FamilyName");
                String birthTime = resultSet.getString("BirthTime");
                String providerId = resultSet.getString("providerId");
                //guardian
                String guardianNum = resultSet.getString("GuardianNo");
                String relationshipTo = resultSet.getString("Relationship");
                String first = resultSet.getString("FirstName");
                String last = resultSet.getString("LastName");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String zip = resultSet.getString("zip");
                //author
                String authorId = resultSet.getString("AuthorId");//here
                String authorTitle = resultSet.getString("AuthorTitle");
                String authorFirst = resultSet.getString("AuthorFirstName");
                String authorLast = resultSet.getString("AuthorLastName");
                //asigned
                String participatingRole = resultSet.getString("ParticipatingRole");
                //insurance company
                String payerId = resultSet.getString("PayerId");
                String payerName = resultSet.getString("Name");
                String policyHolder = resultSet.getString("PolicyHolder");
                String policyType = resultSet.getString("PolicyType");
                String purpose = resultSet.getString("Purpose");
                //relative
                String relativeId = resultSet.getString("RelativeId");
                String relation = resultSet.getString("Relation");
                String age = resultSet.getString("age");
                String diagnosis = resultSet.getString("Diagnosis");
                //allergy
                String allergyId = resultSet.getString("Id");
                //System.out.println("idStr = " + idStr);
                String substance = resultSet.getString("Substance");
                String reaction = resultSet.getString("Reaction");
                String status = resultSet.getString("Status");
                //lab test report
                String labTestResultId = resultSet.getString("LabTestResultId");
                String patientVisitId = resultSet.getString("PatientVisitId");
                String labTestDate = resultSet.getString("LabTestPerformedDate");
                String labType = resultSet.getString("LabTestType");
                String testResult = resultSet.getString("TestResultValue");
                String referenceHigh = resultSet.getString("ReferenceRangeHigh");
                String referenceLow = resultSet.getString("ReferenceRangeLow");
                //plan
                String planId = resultSet.getString("PlanId");
                String activity = resultSet.getString("Activity");
                String scheduled = resultSet.getString("ScheduledDate");

               String suffix = null;
                String gender = null;
                //String patientRole = " ";
                String xml = null;


                insertGuardian(ourdatabase,guardianNum,name,famName,phone,address,city,state,zip);
                insertPatient(ourdatabase,patientId,guardianNum,first,last,suffix,gender,birthTime,providerId,xml);
                insertAuthor(ourdatabase,authorId,authorTitle,authorFirst,authorLast,participatingRole);
                insertAssign(ourdatabase,patientId, authorId);
                insertInsuranceCompany(ourdatabase,payerId, payerName, purpose, policyType);
                insertPatientToInsurance(ourdatabase,payerId, patientId);
                insertFamilyHistory(ourdatabase,relativeId, relation, age, diagnosis);
                //insertAddHistory();
                insertAllergies(ourdatabase,allergyId,substance,reaction,status,patientId);
                insertLabTest(ourdatabase,labTestResultId,patientVisitId,labTestDate,labType,testResult,referenceHigh,referenceLow);
                //insertPatientToLab();
                insertPlan(ourdatabase,planId,activity,scheduled,patientId);



                //where does the relationshipTo data go???
               /* PreparedStatement guardian = ourdatabase.prepareStatement("INSERT INTO Guardian (" + guardianNum + "," + first + "," + last + "," + phone + "," + address + "," + city + "," + state + "," + zip + ")");
                PreparedStatement author = ourdatabase.prepareStatement("INSERT INTO Author (" + authorId + "," + authorTitle + "," + authorFirst + "," + authorLast + "," + address + "," + city + "," + state + "," + zip + ")");
                PreparedStatement assigned = ourdatabase.prepareStatement("INSERT INTO Assign (" + patientId + "," + authorId + "," + participatingRole + ")");
                PreparedStatement insuranceCompany = ourdatabase.prepareStatement("INSERT INTO InsuranceCompany (" + payerId + "," + insuranceName + "," + policyHolder + "," + purpose + "," + policyType + ")");
                PreparedStatement famHistory = ourdatabase.prepareStatement("INSERT INTO FamilyHistory (" + relativeId + "," + relation + "," + age + "," + diagnosis + ")");
                //no allergy id?!!?!
                PreparedStatement allergy = ourdatabase.prepareStatement("INSERT INTO Allergies (" + substance + "," + reaction + "," + status + ")");
                PreparedStatement labTest = ourdatabase.prepareStatement("INSERT INTO LabTestReports (" + labTestResultId + "," + patientVisitId + "," + labTestDate + labType + "," + testResult + "," + referenceHigh + "," + referenceLow + ")");
                PreparedStatement plan = ourdatabase.prepareStatement("INSERT INTO Plan_for_Patient (" + planId + "," + activity + "," + scheduled + patientId + ")");
*/

                // need xml creation date

                /*guardian.executeUpdate();
                author.executeUpdate();
                insuranceCompany.executeUpdate();
                famHistory.executeUpdate();
                allergy.executeUpdate();
                labTest.executeUpdate();
                plan.executeUpdate();
                assigned.executeUpdate();*/
            }

            ResultSet rs = stmt.executeQuery(msg);
            while(rs.next()) {
                //Retrieve by column name
                String patientId = rs.getString("patientId");
                //grab all data from table
                //patient
                String name = rs.getString("GivenName");
                String famName = rs.getString("FamilyName");
                String birthTime = rs.getString("BirthTime");
                String providerId = rs.getString("providerId");
                //guardian
                String guardianNum = rs.getString("GuardianNo");
                String relationshipTo = rs.getString("Relationship");
                String first = rs.getString("FirstName");
                String last = rs.getString("LastName");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String zip = rs.getString("zip");
                //author
                String authorId = rs.getString("AuthorId");//here
                String authorTitle = rs.getString("AuthorTitle");
                String authorFirst = rs.getString("AuthorFirstName");
                String authorLast = rs.getString("AuthorLastName");
                //asigned
                String participatingRole = rs.getString("ParticipatingRole");
                //insurance company
                String payerId = rs.getString("PayerId");
                String payerName = rs.getString("Name");
                String policyHolder = rs.getString("PolicyHolder");
                String policyType = rs.getString("PolicyType");
                String purpose = rs.getString("Purpose");
                //relative
                String relativeId = rs.getString("RelativeId");
                String relation = rs.getString("Relation");
                String age = rs.getString("age");
                String diagnosis = rs.getString("Diagnosis");
                //allergy
                String allergyId = rs.getString("Id");
                //System.out.println("idStr = " + idStr);
                String substance = rs.getString("Substance");
                String reaction = rs.getString("Reaction");
                String status = rs.getString("Status");
                //lab test report
                String labTestResultId = rs.getString("LabTestResultId");
                String patientVisitId = rs.getString("PatientVisitId");
                String labTestDate = rs.getString("LabTestPerformedDate");
                String labType = rs.getString("LabTestType");
                String testResult = rs.getString("TestResultValue");
                String referenceHigh = rs.getString("ReferenceRangeHigh");
                String referenceLow = rs.getString("ReferenceRangeLow");
                //plan
                String planId = rs.getString("PlanId");
                String activity = rs.getString("Activity");
                String scheduled = rs.getString("ScheduledDate");

                String suffix = null;
                String gender = null;
                //String patientRole = " ";
                String xml = null;


                insertGuardian(ourdatabase,guardianNum,name,famName,phone,address,city,state,zip);
                insertPatient(ourdatabase,patientId,guardianNum,first,last,suffix,gender,birthTime,providerId,xml);
                insertAuthor(ourdatabase,authorId,authorTitle,authorFirst,authorLast,participatingRole);
                insertAssign(ourdatabase,patientId, authorId);
                insertInsuranceCompany(ourdatabase,payerId, payerName, purpose, policyType);
                insertPatientToInsurance(ourdatabase,payerId, patientId);
                insertFamilyHistory(ourdatabase,relativeId, relation, age, diagnosis);
                //insertAddHistory();
                insertAllergies(ourdatabase,allergyId,substance,reaction,status,patientId);
                insertLabTest(ourdatabase,labTestResultId,patientVisitId,labTestDate,labType,testResult,referenceHigh,referenceLow);
                //insertPatientToLab();
                insertPlan(ourdatabase,planId,activity,scheduled,patientId);



                //where does the relationshipTo data go???
               /* PreparedStatement guardian = ourdatabase.prepareStatement("INSERT INTO Guardian (" + guardianNum + "," + first + "," + last + "," + phone + "," + address + "," + city + "," + state + "," + zip + ")");
                PreparedStatement author = ourdatabase.prepareStatement("INSERT INTO Author (" + authorId + "," + authorTitle + "," + authorFirst + "," + authorLast + "," + address + "," + city + "," + state + "," + zip + ")");
                PreparedStatement assigned = ourdatabase.prepareStatement("INSERT INTO Assign (" + patientId + "," + authorId + "," + participatingRole + ")");
                PreparedStatement insuranceCompany = ourdatabase.prepareStatement("INSERT INTO InsuranceCompany (" + payerId + "," + insuranceName + "," + policyHolder + "," + purpose + "," + policyType + ")");
                PreparedStatement famHistory = ourdatabase.prepareStatement("INSERT INTO FamilyHistory (" + relativeId + "," + relation + "," + age + "," + diagnosis + ")");
                //no allergy id?!!?!
                PreparedStatement allergy = ourdatabase.prepareStatement("INSERT INTO Allergies (" + substance + "," + reaction + "," + status + ")");
                PreparedStatement labTest = ourdatabase.prepareStatement("INSERT INTO LabTestReports (" + labTestResultId + "," + patientVisitId + "," + labTestDate + labType + "," + testResult + "," + referenceHigh + "," + referenceLow + ")");
                PreparedStatement plan = ourdatabase.prepareStatement("INSERT INTO Plan_for_Patient (" + planId + "," + activity + "," + scheduled + patientId + ")");
*/

                // need xml creation date

                /*guardian.executeUpdate();
                author.executeUpdate();
                insuranceCompany.executeUpdate();
                famHistory.executeUpdate();
                allergy.executeUpdate();
                labTest.executeUpdate();
                plan.executeUpdate();
                assigned.executeUpdate();*/
            }

            Scanner ans = new Scanner(System.in);

            System.out.println("Press P if you are a Patient");
            System.out.println("Press D if you are a Doctor");
            System.out.println("Press A if you are an Admin");

            //ans.useDelimiter("\\n");


            String s = ans.next();


                if (s.equals("P") || s.equals("p")) {
                    while(!s.equals("E") && !s.equals("e")) {
                        patientInterface(ourdatabase);
                        System.out.println("\nPress E to exit, otherwise press C");
                        s=ans.next();
                    }
                }
                if (s.equals("D") || s.equals("d")) {
                    while(!s.equals("E") && !s.equals("e")) {
                        doctorInterface(ourdatabase);
                        System.out.println("\nPress E to exit, otherwise press C");
                        s = ans.next();
                    }

                }
                if (s.equals("A") || s.equals("a")) {
                    while (!s.equals("E") && !s.equals("e")) {
                        adminInterface(ourdatabase);
                        System.out.println("\nPress E to exit, otherwise press C");
                        s = ans.next();
                    }
                }

                //System.out.println("Enter E to exit");
                //s = ans.next();





            //STEP 6: Clean-up environment
            resultSet.close();
            stmt.close();
            conn.close();
            rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
    //end FirstExample
    public static void insertPatientToInsurance(Connection connection, String payerid, String patientid) throws SQLException
    {
        PreparedStatement patienttoinsurance= connection.prepareStatement(
                "INSERT INTO PatientToInsurance"
                    + "(PayerId, patientid)"
                    + "VALUES (?,?)"
                    + " on duplicate key update PayerId=PayerId, patientid=patientid");

        if(payerid != null && patientid != null)
        {
            patienttoinsurance.setString(1,payerid);
            patienttoinsurance.setString(2,patientid);
            patienttoinsurance.executeUpdate();
        }



    }

    public static void insertInsuranceCompany(Connection connection, String payerid, String payername, String purpose, String policytype) throws SQLException
    {
        PreparedStatement insurance = connection.prepareStatement(
                "INSERT INTO InsuranceCompany"
                    + "(PayerID, PayerName, Purpose, PolicyType)"
                    + "VALUES (?,?,?,?)"
                    + " on duplicate key update PayerID=PayerID, PayerName=PayerName, Purpose=Purpose, PolicyType=PolicyType");

        if(payerid != null)
        {
            insurance.setString(1, payerid);
            insurance.setString(2, payername);
            insurance.setString(3, purpose);
            insurance.setString(4,policytype);
            insurance.executeUpdate();
        }


    }

    public static void insertAuthor(Connection connection, String authorid, String authortitle, String authorfirstname, String authorlastname, String participatingrole) throws SQLException {
        PreparedStatement author = connection.prepareStatement(
                "INSERT INTO Author"
                    + "(AuthorID, AuthorTitle, AuthorFirstName, AuthorLastName, ParticipatingRole)"
                    + "VALUES (?,?,?,?,?)"
                    + " on duplicate key update AuthorID=AuthorID, AuthorTitle=AuthorTitle, AuthorFirstName=AuthorFirstName, AuthorLastName=AuthorLastName, ParticipatingRole=ParticipatingRole");

        if(authorid != null)
        {
            author.setString(1,authorid);
            author.setString(2,authortitle);
            author.setString(3,authorfirstname);
            author.setString(4,authorlastname);
            author.setString(5,participatingrole);
            author.executeUpdate();
        }


    }

    public static void insertAssign(Connection connection, String patientid, String authorid) throws SQLException
    {
        PreparedStatement assign = connection.prepareStatement(
                "INSERT INTO Assign"
                    +"(patientid, authorid)"
                    + "VALUES(?,?)"
                    + " on duplicate key update patientid=patientid, authorid=authorid");
        if(patientid!=null && authorid!=null)
        {
            assign.setString(1,patientid);
            assign.setString(2,authorid);
            assign.executeUpdate();
        }

    }


    public static void insertGuardian(Connection connection, String guardianno, String givenname, String familyname, String phone, String address, String city, String state, String zip) throws SQLException {
        PreparedStatement guardian = connection.prepareStatement(
                " INSERT INTO Guardian"
                    + "(GuardianNo, GivenName, FamilyName, Phone, Address, City, State, Zip)"
                    + "VALUES (?,?,?,?,?,?,?,?)"
                    + " on duplicate key update GuardianNo=GuardianNo, GivenName=GivenName, FamilyName=FamilyName, Phone=Phone, Address=Address, City=City, State=State, Zip=Zip");
        if(guardianno != null){
            guardian.setString(1, guardianno);
            guardian.setString(2,givenname);
            guardian.setString(3,familyname);
            guardian.setString(4,phone);
            guardian.setString(5,address);
            guardian.setString(6,city);
            guardian.setString(7,state);
            guardian.setString(8,zip);
            guardian.executeUpdate();
        }


    }

    public static void insertPatient(Connection connection, String patientId, String patientRole, String name, String famName, String suffix, String gender, String birthTime, String providerId, String xml) throws SQLException{
        PreparedStatement patient = connection.prepareStatement(
                "INSERT INTO Patient"
                        + "(PatientID, PatientRole, GivenName, FamilyName, Suffix, Gender, Birthtime, ProviderID, xmlhealthCreation )"
                        + " VALUES (?,?,?,?,?,?,?,?,?)"
                        + " on duplicate key update PatientID=PatientID, PatientRole=PatientRole, GivenName = GivenName, FamilyName=FamilyName,"
                        + "Suffix=Suffix, Gender=Gender, Birthtime = Birthtime, ProviderID=ProviderID, xmlhealthCreation=xmlhealthCreation");

        if (patientId != null && patientRole!= null) {
            patient.setString(1, patientId);
            patient.setString(2, patientRole);
            patient.setString(3, name);
            patient.setString(4, famName);
            patient.setString(5, suffix);
            patient.setString(6, gender);
            patient.setString(7, birthTime);
            patient.setString(8, providerId);
            patient.setString(9, xml);
            patient.executeUpdate();
        }



    }


    public static void insertPlan(Connection connection, String planID, String activity, String dateOfPlan, String pid) throws SQLException
    {
        PreparedStatement plan = connection.prepareStatement(
                "INSERT INTO Plan_for_Patient"
                        + "(planid, activity, dateofplan, pid)"
                        + " VALUES (?,?,?,?)"
                        + " on duplicate key update planid=planid, activity=activity, dateofplan = dateofplan, pid=pid");

        if (planID != null && pid != null)
        {
            plan.setString(1, planID);
            plan.setString(2, activity);
            plan.setString(3, dateOfPlan);
            plan.setString(4, pid);
            plan.executeUpdate();

        }


    }


    public static void insertLabTest(Connection connection, String labID, String patientVisit, String datePerformed, String type, String testResult, String rangeHigh, String rangeLow) throws SQLException
    {
        PreparedStatement lab = connection.prepareStatement(
                "INSERT INTO LabTestReports"
                        + "(LabTestResultId, PatientVisitId, LabTestPerformedDate, LabTestType, TestResultValue, ReferenceRangeHigh, ReferenceRangeLow)"
                        + " VALUES (?,?,?,?,?,?,?)"
                        + " on duplicate key update LabTestResultId= LabTestResultId, PatientVisitId = PatientVisitId,"
                        + "LabTestPerformedDate =LabTestPerformedDate, LabTestType =LabTestType, TestResultValue =TestResultValue,"
                        +" ReferenceRangeHigh =ReferenceRangeHigh, ReferenceRangeLow =ReferenceRangeLow");

        if (labID != null)
        {
            lab.setString(1, labID);
            lab.setString(2, patientVisit);
            lab.setString(3, datePerformed);
            lab.setString(4, type);
            lab.setString(5, testResult);
            lab.setString(6, rangeHigh);
            lab.setString(7, rangeLow);
            lab.executeUpdate();

        }


    }


    public static void insertAllergies(Connection connection, String allergyid, String substance, String reaction, String status, String pid) throws SQLException
    {
        PreparedStatement allergy = connection.prepareStatement(
                "INSERT INTO Allergies"
                        + "(allergyid, substance, reaction, allergystatus, pid)"
                        + " VALUES (?,?,?,?,?)"
                        + " on duplicate key update allergyid = allergyid, substance = substance, reaction= reaction, allergystatus = allergystatus, pid= pid");

        if (pid != null && substance != null)
        {
            allergy.setString(1,allergyid);
            allergy.setString(2, substance);
            allergy.setString(3, reaction);
            allergy.setString(4, status);
            allergy.setString(5, pid);
            allergy.executeUpdate();

        }


    }


    public static void insertFamilyHistory(Connection connection, String ID, String relationship, String age, String diagnosis) throws SQLException
    {
        PreparedStatement famHistory = connection.prepareStatement(
                "INSERT INTO FamilyHistory"
                        + "(id, relationship, age, diagnosis)"
                        + " VALUES (?,?,?,?)"
                        + " on duplicate key update id = id, relationship= relationship, age= age, diagnosis = diagnosis");

        if (ID != null)
        {
            famHistory.setString(1, ID);
            famHistory.setString(2, relationship);
            famHistory.setString(3, age);
            famHistory.setString(4, diagnosis);
            famHistory.executeUpdate();

        }


    }



public static void patientInterface(Connection driver) throws SQLException{


    //String person = ans.next();


    //whaatttt
    //Connection driver = DriverManager.getConnection(IDKK)
    Scanner ans = new Scanner(System.in);
    Statement statement = driver.createStatement();

    //ResultSet resultSet = statement.executeQuery("GRANT UPDATE, SELECT ON Patient, Guardian TO Patient");
    System.out.println("Would you like to view or edit? (1 for view 2 for edit)");
    int option = ans.nextInt();
    ans.nextLine();

//view records
    if (option == 1) {
        System.out.println("Enter 1 to view Patient Records or 2 or view Guardian Records");
        option = ans.nextInt();
        ans.nextLine();
        if (option == 1) {
            System.out.println("Enter PatientId");
            String pid = ans.nextLine();
            viewPatientRecord(driver, pid);
        } else if (option == 2) {
            System.out.println("Enter PatientRole (GuardianNo)");
            String gid = ans.nextLine();
            viewGuardianRecord(driver, gid);

        }
    }


    //edit records
    else if (option == 2) {
        System.out.println("Enter 1 to edit Patient Records or 2 or edit Guardian Records");
        option = ans.nextInt();
        ans.nextLine();

        //edit patient records
        if (option == 1) {
            System.out.println("Enter PatientId");
            String pid = ans.nextLine();

            System.out.println("Enter 1 to edit first name");
            System.out.println("2 to edit last name");
            System.out.println("3 to edit suffix");
            System.out.println("4 to edit gender");
            System.out.println("5 to edit birth time");
            System.out.println("6 to edit providerID");

            option = ans.nextInt();
            ans.nextLine();

            if (option == 1) {
                System.out.println("Enter new name");
                String name = ans.nextLine();
                editFirstName(driver, pid, name);
            } else if (option == 2) {
                System.out.println("Enter new name");
                String name = ans.nextLine();
                editLastName(driver, pid, name);
            } else if (option == 3) {
                System.out.println("Enter new suffix");
                String suf = ans.nextLine();
                editSuffix(driver, pid, suf);
            } else if (option == 4) {
                System.out.println("Enter new gender");
                String gender = ans.nextLine();
                editGender(driver, pid, gender);
            } else if (option == 5) {
                System.out.println("Enter new birth time");
                String birth = ans.nextLine();
                editBirthTime(driver, pid, birth);
            } else if (option == 6) {
                System.out.println("Enter new providerID");
                String provider = ans.nextLine();
                editProviderID(driver, pid, provider);
            }
        }

        if (option == 2) {
            System.out.println("Enter PatientRole (GuardianNo)");
            String gid = ans.nextLine();


            System.out.println("Enter 1 to edit first name");
            System.out.println("2 to edit last name");
            System.out.println("3 to edit phone");
            System.out.println("4 to edit address");
            System.out.println("5 to edit city");
            System.out.println("6 to edit state");
            System.out.println("7 to edit zip");

            option = ans.nextInt();
            ans.nextLine();

            if (option == 1) {
                System.out.println("Enter new name");
                String name = ans.nextLine();
                editGuardianFirst(driver, gid, name);
            } else if (option == 2) {
                System.out.println("Enter new name");
                String name = ans.nextLine();
                editGuardianLast(driver, gid, name);
            } else if (option == 3) {
                System.out.println("Enter new phone number");
                String phone = ans.nextLine();
                editGuardianPhone(driver, gid, phone);
            } else if (option == 4) {
                System.out.println("Enter new address");
                String address = ans.nextLine();
                editGuardianAddress(driver, gid, address);
            } else if (option == 5) {
                System.out.println("Enter new city");
                String city = ans.nextLine();
                editGuardianCity(driver, gid, city);
            } else if (option == 6) {
                System.out.println("Enter new state");
                String state = ans.nextLine();
                editGuardianState(driver, gid, state);
            } else if (option == 7) {
                System.out.println("Enter new zip");
                String zip = ans.nextLine();
                editGuardianZip(driver, gid, zip);
            }

        }
    }
}


    public static void viewPatientRecord(Connection driver, String pid) throws SQLException
    {
        // creates connection with driver
        Statement statement = driver.createStatement();

        System.out.println("Patient Record ");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Patient p WHERE p.PatientID='" + pid + "'");
        //resultSet.next();


        while(resultSet.next())
        {

            System.out.println("ID: " + resultSet.getString("PatientID"));
            System.out.println("PatientRole: " + resultSet.getString("PatientRole"));
            System.out.println("Name: " + resultSet.getString("GivenName") + " " + resultSet.getString("FamilyName"));
            System.out.println("Suffix: " + resultSet.getString("Suffix"));
            System.out.println("Gender: " + resultSet.getString("Gender"));
            System.out.println("Birth Time: " + resultSet.getDate("Birthtime"));
            System.out.println("ProviderID: " + resultSet.getString("ProviderID"));
        }
    }

    public static void viewGuardianRecord(Connection driver, String gid) throws SQLException
    {
        //create connection with driver
        Statement statement = driver.createStatement();

        System.out.println("Guardian Record ");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Guardian g WHERE g.guardianNo='" + gid + "'");
        while(resultSet.next())
        {
            System.out.println("GuardianPNo: " + resultSet.getString("GuardianNo"));
            System.out.println("Name: " + resultSet.getString("GivenName") + " " + resultSet.getString("FamilyName"));
            System.out.println("Phone: " + resultSet.getString("Phone"));
            System.out.println("Address (City, State, Zip): " + resultSet.getString("Address") + " " + resultSet.getString("City") + " " +
                    resultSet.getString("State") + " " + resultSet.getString("Zip"));

        }
    }

    //EDITS for Patient
    public static void editFirstName(Connection driver, String pid, String newName) throws SQLException
    {
        PreparedStatement s = driver.prepareStatement("UPDATE Patient SET GivenName = '" + newName + "' WHERE PatientID = '" + pid + "'");
        s.executeUpdate();

    }

    public static void editLastName(Connection driver, String pid, String newName) throws SQLException
    {
        PreparedStatement s = driver.prepareStatement("UPDATE Patient SET FamilyName = '" + newName + "' WHERE PatientID = '" + pid + "'");
        s.executeUpdate();

    }

    public static void editSuffix(Connection driver, String pid, String newSuf) throws SQLException
    {
        PreparedStatement s = driver.prepareStatement("UPDATE Patient SET Suffix = '" + newSuf + "' WHERE PatientID = '" + pid + "'");
        s.executeUpdate();

    }

    public static void editGender(Connection driver, String pid, String newGen) throws SQLException
    {
        PreparedStatement s = driver.prepareStatement("UPDATE Patient SET Gender = '" + newGen + "' WHERE PatientID = '" + pid + "'");
        s.executeUpdate();

    }

    public static void editBirthTime(Connection driver, String pid, String newTime) throws SQLException
    {
        PreparedStatement s = driver.prepareStatement("UPDATE Patient SET Birthtime = '" + newTime + "' WHERE PatientID = '" + pid + "'");
        s.executeUpdate();

    }

    public static void editProviderID(Connection driver, String pid, String newProvider) throws SQLException
    {
        PreparedStatement s = driver.prepareStatement("UPDATE Patient SET ProviderID = '" + newProvider + "' WHERE PatientID = '" + pid + "'");
        s.executeUpdate();

    }

//EDITS for Guardian

//gid refers to PatientRole in Patient (which corresponds to GuardianNo in Guardian

    public static void editGuardianFirst(Connection driver, String gid, String newName) throws SQLException
    {
        PreparedStatement s = driver.prepareStatement("UPDATE Guardian SET GivenName = '" + newName + "' WHERE GuardianNo = '" + gid + "'");
        s.executeUpdate();

    }
    public static void editGuardianLast(Connection driver, String gid, String newName) throws SQLException
    {
        PreparedStatement s = driver.prepareStatement("UPDATE Guardian SET FamilyName = '" + newName + "' WHERE GuardianNo = '" + gid +"'");
        s.executeUpdate();

    }

    public static void editGuardianPhone(Connection driver, String gid, String newNum) throws SQLException
    {
        PreparedStatement s = driver.prepareStatement("UPDATE Guardian SET Phone = '" + newNum + "' WHERE GuardianNo = '" + gid + "'");
        s.executeUpdate();

    }
    public static void editGuardianAddress(Connection driver, String gid, String newAdd) throws SQLException
    {
        PreparedStatement s = driver.prepareStatement("UPDATE Guardian SET Address = '" + newAdd + "' WHERE GuardianNo = '" + gid + "'");
        s.executeUpdate();

    }

    public static void editGuardianCity(Connection driver, String gid, String newCity) throws SQLException
    {
        PreparedStatement s = driver.prepareStatement("UPDATE Guardian SET City = '" + newCity + "' WHERE GuardianNo = '" + gid +"'");
        s.executeUpdate();


    }
    public static void editGuardianState(Connection driver, String gid, String newState) throws SQLException
    {
        PreparedStatement s = driver.prepareStatement("UPDATE Guardian SET State = '" + newState + "' WHERE GuardianNo = '" + gid + "'");
        s.executeUpdate();

    }
    public static void editGuardianZip(Connection driver, String gid, String newZip) throws SQLException
    {
        PreparedStatement s = driver.prepareStatement("UPDATE Guardian SET Zip = '" + newZip + "' WHERE GuardianNo = '" + gid + "'");
        s.executeUpdate();

    }


public static void doctorInterface(Connection driver) throws SQLException{
//Doctor Interface
//has permission to view or edit patient plan and allergies data


    Scanner ans = new Scanner(System.in);


    //whaatttt
    //Connection driver = DriverManager.getConnection(IDKK)


        //ResultSet resultSet = statement.executeQuery("GRANT UPDATE, SELECT ON Allergies, Plan_for_Patient TO Author");

        System.out.println("Would you like to view or edit? (1 for view 2 for edit)");
        int option = ans.nextInt();
    ans.nextLine();

//view records
        if (option == 1) {
            System.out.println("Enter 1 to view Patient Plan or 2 or view Patient Allergies");
            option = ans.nextInt();
            ans.nextLine();


            System.out.println("Enter PatientId");
            String pid = ans.nextLine();

            if (option == 1) {
              //  System.out.println("Enter PatientId");
              //  String pid = ans.next();

                viewPatientPlan(driver, pid);
            } else if (option == 2) {
                //System.out.println("Enter PatientId");
                //String pid = ans.next();


                viewPatientAllergies(driver, pid);
            }
        }


        //edit records
        else if (option == 2) {
            System.out.println("Enter 1 to edit Patient Plan or 2 or edit Patient Allergies");
            option = ans.nextInt();
            ans.nextLine();

            System.out.println("Enter PatientId");
            String pid = ans.nextLine();

            //edit patient plan
            if (option == 1) {

                System.out.println("Enter 1 to edit activity");
                System.out.println("2 to edit date of plan");


                option = ans.nextInt();
                ans.nextLine();

                if (option == 1) {
                    System.out.println("Enter new activity");
                    String activity = ans.nextLine();
                    editActivity(driver, pid, activity);
                } else if (option == 2) {
                    System.out.println("Enter new date");
                    String date = ans.nextLine();
                    editDateOfPlan(driver, pid, date);
                }

            }

//edit patient allergies

            else if (option == 2) {

                System.out.println("Enter 1 to add a new allergy or 2 to edit allergy status");

                option = ans.nextInt();
                ans.nextLine();

                if (option == 1) {
                    System.out.println("Enter new substance");
                    String sub = ans.nextLine();

                    System.out.println("Enter new reaction");
                    String reaction = ans.nextLine();

                    System.out.println("Enter allergy status");
                    String status = ans.nextLine();

                    addSubstance(driver, pid, sub, reaction, status);
                } else if (option == 2) {
                    System.out.println("Enter new allergy status");
                    String stat = ans.nextLine();
                    editAllergyStatus(driver, pid, stat);
                }

            }
        }

}







//VIEWS

    public static void viewPatientPlan(Connection driver, String pid) throws SQLException
    {
        // creates connection with driver
        Statement statement = driver.createStatement();

        System.out.println("Patient Plan ");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Plan_for_Patient p WHERE p.pid ='" + pid + "'");
       // resultSet.next();

        while(resultSet.next())
        {

            System.out.println("ID: " + resultSet.getString("planid"));
            System.out.println("Activity: " + resultSet.getString("activity"));
            System.out.println("Date of Plan: " + resultSet.getString("dateofplan"));
            System.out.println("\n");

        }
    }


    public static void viewPatientAllergies(Connection driver, String pid) throws SQLException
    {
        //create connection with driver
        Statement statement = driver.createStatement();

        System.out.println("Patient Allergies");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Allergies a WHERE a.pid='" + pid + "'");
        while(resultSet.next())
        {
            System.out.println("Substance: " + resultSet.getString("substance"));
            System.out.println("Reaction: " + resultSet.getString("reaction"));
            System.out.println("Allergy status: " + resultSet.getString("allergystatus"));
            System.out.println("\n");

        }
    }




    //EDITS for Patient Plan
    public static void editActivity(Connection driver, String pid, String newAct) throws SQLException
    {
        PreparedStatement s = driver.prepareStatement("UPDATE Plan_for_Patient SET activity = '" + newAct + "' WHERE pid = '" + pid + "'");
        s.executeUpdate();

    }

    public static void editDateOfPlan(Connection driver, String pid, String newDate) throws SQLException
    {
        PreparedStatement s = driver.prepareStatement("UPDATE Plan_for_Patient SET dateofplan =' " + newDate + "' WHERE pid = '" + pid + "'");
        s.executeUpdate();

    }



//EDITS for Allergies

    public static void addSubstance(Connection driver, String pid, String newSub, String newReaction, String newStatus) throws SQLException
    {

        String query = "INSERT INTO Allergies(substance, reaction, allergystatus, pid) VALUES (?, ?, ?, ?)";
        PreparedStatement s = driver.prepareStatement(query);
        s.setString(1,newSub);
        s.setString(2,newReaction);
        s.setString(3,newStatus);
        s.setString(4,pid);
        s.executeUpdate();

    }


    public static void editAllergyStatus(Connection driver, String pid, String newStat) throws SQLException
    {
        PreparedStatement s = driver.prepareStatement("UPDATE Allergies SET allergystatus = '" + newStat + "' WHERE pid = '" + pid+"'");
        s.executeUpdate();

    }



    public static void adminInterface(Connection driver) throws SQLException {

        //ADMINISTRATOR INTERFACE
//has the ability of view number of patients for each type of allergy
//view patients with more than one allergy
//view patients with plan for surgery today
//view authors with more than one patient

        Scanner ans = new Scanner(System.in);
        //System.out.println("Enter A if you are an Administrator");
        //String person = ans.next();


        //whaatttt
        //Connection driver = DriverManager.getConnection(IDKK)



            //ResultSet resultSet = statement.executeQuery("GRANT VIEW, SELECT ON Patients, Allergies, Plan_for_Patient, Authors TO Public");

            System.out.println("Enter 1 to view number of patients for a given allergy");
            System.out.println("2 to view patients with more than one allergy");
            System.out.println("3 to view patients with a plan for surgery today");
            System.out.println("4 to view authors with more than one patient");

            int option = ans.nextInt();
        ans.nextLine();

            //number of patients for given allergy
            if (option == 1) {
                viewNumPatients(driver);

            } else if (option == 2) {
                viewNumAllergies(driver);
            } else if (option == 3) {
                viewSurgeryToday(driver);
            } else if (option == 4) {
                viewAuthors(driver);
            }


    }



    public static void viewNumPatients(Connection driver) throws SQLException
    {
        Statement statement = driver.createStatement();
        String query = "SELECT A.substance, COUNT(*) FROM Allergies A WHERE A.substance IS NOT NULL GROUP BY A.substance";
        ResultSet set = statement.executeQuery(query);
        while(set.next())
        {
            System.out.println("Number of Patients: " + set.getString("COUNT(*)") + " for substance " + set.getString("substance"));
            System.out.println("\n");
        }
    }


    public static void viewNumAllergies(Connection driver) throws SQLException
    {
        Statement statement = driver.createStatement();

        String query = "SELECT A.pid FROM Allergies A GROUP BY A.pid HAVING COUNT(*) > 1";
        ResultSet set = statement.executeQuery(query);
        while(set.next())
        {
            System.out.println("Id of patients with more than one allergy: " + set.getString("pid"));
            System.out.println("\n");
        }
    }


    public static void viewSurgeryToday(Connection driver) throws SQLException
    {
        Statement statement = driver.createStatement();
        //java.util.Date

        //Date today = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
        /*DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        String today = dateFormat.format(date);
        today += " 12:00:00 AM";*/

        String today = "3/12/2015 12:00:00 AM";
        //System.out.println(today);
        //format.parse(today);

        String query = "SELECT P.pid FROM Plan_for_Patient P WHERE P.dateofplan='" + today + "' AND P.activity='Surgery'";
        ResultSet result = statement.executeQuery(query);

        System.out.println("Patients who are scheduled for a surgery today ");
        while(result.next())
        {
            System.out.println("ID: " + result.getString("pid"));
            System.out.println("\n");
        }
    }

    public static void viewAuthors(Connection driver) throws SQLException
    {
        Statement statement = driver.createStatement();

        String query = "SELECT A.authorid FROM Assign A GROUP BY A.authorid HAVING COUNT(*) > 1";
        ResultSet result = statement.executeQuery(query);
        System.out.println("Authors who have more than one patient ");
        while(result.next())
        {
            System.out.println("ID: " + result.getString("authorID"));
            System.out.println("\n");
        }
    }

}

