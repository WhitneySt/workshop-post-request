package com.example.postRequest.excel;

public class ExcelContent {
    String date;
    String injuryLocation;
    String gender;
    String ageGroup;
    String incidentType;
    Double daysLost;
    String plant;
    String reportType;
    String shift;
    String department;
    String incidentCost;
    String weekDay;
    int month;
    int year;

    Boolean isValidLine;

    public ExcelContent() {
        this.date = "";
        this.injuryLocation = "";
        this.gender = "";
        this.ageGroup = "";
        this.incidentType = "";
        this.daysLost = 0.0;
        this.plant = "";
        this.reportType = "";
        this.shift = "";
        this.department = "";
        this.incidentCost = "";
        this.weekDay = "";
        this.month = 0;
        this.year = 0;
        this.isValidLine = false;
    }

    public ExcelContent(String date, String injuryLocation, String gender, String ageGroup, String incidentType, Double daysLost, String plant, String reportType, String shift, String department, String incidentCost, String weekDay, int month, int year, Boolean isValidLine) {
        this.date = date;
        this.injuryLocation = injuryLocation;
        this.gender = gender;
        this.ageGroup = ageGroup;
        this.incidentType = incidentType;
        this.daysLost = daysLost;
        this.plant = plant;
        this.reportType = reportType;
        this.shift = shift;
        this.department = department;
        this.incidentCost = incidentCost;
        this.weekDay = weekDay;
        this.month = month;
        this.year = year;
        this.isValidLine = isValidLine;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInjuryLocation() {
        return injuryLocation;
    }

    public void setInjuryLocation(String injuryLocation) {
        this.injuryLocation = injuryLocation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public Double getDaysLost() {
        return daysLost;
    }

    public void setDaysLost(Double daysLost) {
        this.daysLost = daysLost;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getIncidentCost() {
        return incidentCost;
    }

    public void setIncidentCost(String incidentCost) {
        this.incidentCost = incidentCost;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Boolean getValidLine() {
        return isValidLine;
    }

    public void setValidLine(Boolean validLine) {
        isValidLine = validLine;
    }
}
