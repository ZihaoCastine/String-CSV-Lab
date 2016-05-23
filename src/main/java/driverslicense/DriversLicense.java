package driverslicense;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DriversLicense {

    private String name, address, licenseNumber, endorsements, issuingState, eyeColor;

    private int height;
    private double weight;
    private char licenseClassification, sex;
    private boolean organDonor, federallyCompliant;
    private Date dateOfBirth, issueDate, expirationDate;

    //private Restriction[] restrictions;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public char getLicenseClassification() {
        return licenseClassification;
    }

    public void setLicenseClassification(char licenseClassification) {
        this.licenseClassification = licenseClassification;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public boolean isOrganDonor() {
        return organDonor;
    }

    public void setOrganDonor(boolean organDonor) {
        this.organDonor = organDonor;
    }

    public boolean isFederallyCompliant() {
        return federallyCompliant;
    }

    public void setFederallyCompliant(boolean federallyCompliant) {
        this.federallyCompliant = federallyCompliant;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

//    public Restriction[] getRestrictions() {
//        return restrictions;
//    }
//
//    public void setRestrictions(Restriction[] restrictions) {
//        this.restrictions = restrictions;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getEndorsements() {
        return endorsements;
    }

    public void setEndorsements(String endorsements) {
        this.endorsements = endorsements;
    }

    public String getIssuingState() {
        return issuingState;
    }

    public void setIssuingState(String issuingState) {
        this.issuingState = issuingState;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * (include description of field order here)
     * @return
     */
    public String serializeToCSV(){

        StringBuilder csvBuilder = new StringBuilder();

        csvBuilder.append(name).append(',')
                .append(address).append(',')
                .append(eyeColor).append(',')
                .append(dateOfBirth).append(',')
                .append(issueDate).append(',')
                .append(expirationDate).append(',')
                .append(licenseNumber).append(',')
                .append(issuingState).append(',')
                .append(endorsements).append(',')
                .append(sex).append(',')
                .append(federallyCompliant).append(',')
                .append(licenseClassification);

        return csvBuilder.toString();
    }

    public static String getCSVHeader(){
        return "NAME,ADDRESS,EYE COLOR,DATE OF BIRTH,ISSUE DATE,EXPIRATION DATE," +
                "LICENSE NUMBER,STATE,ENDORSEMENTS,SEX,FEDERAL COMPLIANCE,CLASSIFICATION";
    }

    public static ArrayList<DriversLicense> deserializeFromCSV(String csv){
        ArrayList<DriversLicense>driversLicenseArrayList=new ArrayList<>();
        Scanner csvInput=new Scanner(csv);
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("mm/dd/yyyy");
        while(csvInput.hasNextLine()){
            String csvString=csvInput.nextLine();
            if(!csvString.equals(getCSVHeader())) {
                DriversLicense driversLicense=new DriversLicense();
                String csvArray[] = csvString.split(",");
                driversLicense.setName(csvArray[0]);
                driversLicense.setAddress(csvArray[1]);
                driversLicense.setEyeColor(csvArray[2]);
                try {
                    driversLicense.setDateOfBirth(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(csvArray[3]));
                    driversLicense.setIssueDate(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(csvArray[4]));
                    driversLicense.setExpirationDate(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(csvArray[5]));
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("parse data error");
                }
                driversLicense.setLicenseNumber(csvArray[6]);
                driversLicense.setIssuingState(csvArray[7]);
                driversLicense.setEndorsements(csvArray[8]);
                driversLicense.setSex(csvArray[9].charAt(0));
                driversLicense.setFederallyCompliant(Boolean.valueOf(csvArray[10]));
                driversLicense.setLicenseClassification(csvArray[11].charAt(0));
                driversLicenseArrayList.add(driversLicense);
            }
        }
        return driversLicenseArrayList;
    }


}
