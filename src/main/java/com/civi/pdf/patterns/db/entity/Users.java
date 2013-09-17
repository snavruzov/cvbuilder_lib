package com.civi.pdf.patterns.db.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: sardor
 * Date: 9/13/13
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Users implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    private Integer     userId;
    private String      name;
    private String      lastName;
    private String      email;
    private String      phones;
    private String      address1;
    private String      address2;
    private String      address3;
    private String      skype;
    private String      website;
    private Set<CvDates> cvDates =
            new HashSet<CvDates>(0);

    public Users(){

    }

    public Users(Integer userId, String name, String lastName, String email, String phones, String address1, String address2, String address3, String skype, String website, Set<CvDates> cvDates)
    {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phones = phones;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.skype = skype;
        this.website = website;
        this.cvDates = cvDates;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Set<CvDates> getCvDates() {
        return cvDates;
    }

    public void setCvDates(Set<CvDates> cvDates) {
        this.cvDates = cvDates;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
