package driverslicense;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;


public class DriversLicenseTest {

    DriversLicense testLicense;

    String name = "Mike Jones";
    String address = "123 Atl drive";
    String eyeColor = "Brown";
    Date expectedDOB = new Date(); // 3 times
    Date expectedIssueDate = expectedDOB;
    Date expectedExpirationDate = expectedDOB;
    String licenseNum = "007";
    String issuingState = "TX";
    String trump = "Trump";
    char male = 'M';
    boolean federallyCompliantStatus = false;
    char licenseClassification = 'C';

    @Before
    public void setUp() throws Exception {
        testLicense = new DriversLicense();

        testLicense.setName(name);
        testLicense.setAddress(address);
        testLicense.setEyeColor(eyeColor);
        testLicense.setDateOfBirth(expectedDOB);
        testLicense.setIssueDate(expectedIssueDate);
        testLicense.setExpirationDate(expectedExpirationDate);
        testLicense.setLicenseNumber(licenseNum);
        testLicense.setIssuingState(issuingState);
        testLicense.setEndorsements(trump);
        testLicense.setSex(male);
        testLicense.setFederallyCompliant(federallyCompliantStatus);
        testLicense.setLicenseClassification(licenseClassification);
    }

    @Test
    public void testSerializeToCSV() throws Exception {

        String actualCSVResult = testLicense.serializeToCSV();

        String expectedCSVResult = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%c,%b,%c",
                name, address, eyeColor, expectedDOB,expectedIssueDate, expectedExpirationDate,
                licenseNum, issuingState, trump, male, federallyCompliantStatus, licenseClassification);

        assertEquals("Actual CSV result did not match expectations.",expectedCSVResult, actualCSVResult);



    }

    @Test
    public void testGetCSVHeader(){
        /*
        order: name, address, eyeColor, expectedDOB,expectedIssueDate, expectedExpirationDate,
                licenseNum, issuingState, trump, male, federallyCompliantStatus, licenseClassification
         */
        String expectedHeader = "NAME,ADDRESS,EYE COLOR,DATE OF BIRTH,ISSUE DATE,EXPIRATION DATE," +
                "LICENSE NUMBER,STATE,ENDORSEMENTS,SEX,FEDERAL COMPLIANCE,CLASSIFICATION";

        String actualHeader = DriversLicense.getCSVHeader();

        assertEquals(expectedHeader, actualHeader);
    }

    @Test
    public void testDeserializeFromCSV(){
        ArrayList<DriversLicense> actualDeCSVResult= DriversLicense.deserializeFromCSV(testLicense.serializeToCSV());
        assertEquals(testLicense.serializeToCSV(),actualDeCSVResult.get(0).serializeToCSV());
    }

    @Test
    public void testDeserializeFromCSVWithMoreThanOneDriversLicense() {
        ArrayList<DriversLicense> actualDeCSVResult= DriversLicense.deserializeFromCSV(testLicense.serializeToCSV()+"\n"+testLicense.serializeToCSV()+
                "\n"+testLicense.serializeToCSV());
        assertEquals(testLicense.serializeToCSV(),actualDeCSVResult.get(2).serializeToCSV());

    }
}