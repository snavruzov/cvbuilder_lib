package com.civi.pdf.patterns.beans;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: sardor
 * Date: 9/13/13
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class WorkExperience implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jobTitle;
    private String companyName;
    private String startDate;
    private String endDate;

    private String information;

    public WorkExperience() {
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String toString()
    {
         return "["+jobTitle+", "+companyName+", "+startDate+", "+endDate+"]";

    }
}
