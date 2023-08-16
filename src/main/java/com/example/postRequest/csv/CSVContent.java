package com.example.postRequest.csv;

public class CSVContent {
    String index;
    String userId;
    String firstName;
    String lastName;
    String sex;
    String email;
    String phone;
    String dateOfBirth;
    String jobTitle;
    Boolean isValidLine;

    public CSVContent(String index, String userId, String firstName, String lastName, String sex, String email, String phone, String dateOfBirth, String jobTitle, Boolean isValidLine) {
        this.index = index;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.jobTitle = jobTitle;
        this.isValidLine = isValidLine;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Boolean getValidLine() {
        return isValidLine;
    }

    public void setValidLine(Boolean validLine) {
        isValidLine = validLine;
    }
}
