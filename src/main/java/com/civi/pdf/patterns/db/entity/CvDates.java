package com.civi.pdf.patterns.db.entity;

import com.civi.pdf.patterns.beans.EducationExperience;
import com.civi.pdf.patterns.beans.OtherExperience;
import com.civi.pdf.patterns.beans.WorkExperience;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sardor
 * Date: 9/13/13
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class CvDates implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    private Integer     id_cv;
    private Users       users;
    private String      jobTitle;
    private String      fullName;
    private String      email;
    private String      phones;
    private String      address1;
    private String      address2;
    private String      address3;
    private String      website;
    private byte[]     image;
    private String     title;

    public CvDates() {
    }

    public CvDates(Integer id_cv, Users users, String jobTitle, String fullName, String email, String phones, String address1, String address2, String address3, String website, byte[] image, String title)
    {
        this.id_cv = id_cv;
        this.users = users;
        this.jobTitle = jobTitle;
        this.fullName = fullName;
        this.email = email;
        this.phones = phones;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.website = website;
        this.image = image;
        this.title = title;
    }

    public String getJobTitle()
    {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
    }

    public Integer getId_cv()
    {
        return id_cv;
    }

    public void setId_cv(Integer id_cv)
    {
        this.id_cv = id_cv;
    }

    public Users getUsers()
    {
        return users;
    }

    public void setUsers(Users users)
    {
        this.users = users;
    }


    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhones()
    {
        return phones;
    }

    public void setPhones(String phones)
    {
        this.phones = phones;
    }

    public String getAddress1()
    {
        return address1;
    }

    public void setAddress1(String address1)
    {
        this.address1 = address1;
    }

    public String getAddress2()
    {
        return address2;
    }

    public void setAddress2(String address2)
    {
        this.address2 = address2;
    }

    public String getAddress3()
    {
        return address3;
    }

    public void setAddress3(String address3)
    {
        this.address3 = address3;
    }

    public String getWebsite()
    {
        return website;
    }

    public void setWebsite(String website)
    {
        this.website = website;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(byte[] image)
    {
        this.image = image;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String[] getSplitName()
    {
        if(fullName!=null)
        {
            return fullName.split(" ");
        }
        else return new String[]{fullName," "};
    }
}
