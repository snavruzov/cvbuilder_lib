package com.civi.pdf.patterns.beans;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: sardor
 * Date: 9/13/13
 * Time: 6:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class EducationExperience implements Serializable {

    private static final long serialVersionUID = 1L;

    private String courseName;
    private String institutionName;
    private String startDate;
    private String endDate;

    private String information;

    public EducationExperience() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
