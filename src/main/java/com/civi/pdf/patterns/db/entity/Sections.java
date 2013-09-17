package com.civi.pdf.patterns.db.entity;

/**
 * Created by Intellij IDEA.
 * User: Sardor Navruzov
 * Date: 9/16/13
 * Time: 5:07 PM
 */
public class Sections implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id_section;
    private CvDates dates;
    private byte[]      attributes;
    private String sectionName;
    private Integer position;
    private Integer type;

    public Sections()
    {
    }

    public Sections(Integer id_section, CvDates dates, byte[] attributes, String sectionName, Integer position)
    {
        this.id_section = id_section;
        this.dates = dates;
        this.attributes = attributes;
        this.sectionName = sectionName;
        this.position = position;
    }

    public byte[] getAttributes()
    {
        return attributes;
    }

    public void setAttributes(byte[] attributes)
    {
        this.attributes = attributes;
    }

    public Integer getId_section()
    {
        return id_section;
    }

    public void setId_section(Integer id_section)
    {
        this.id_section = id_section;
    }

    public CvDates getDates()
    {
        return dates;
    }

    public void setDates(CvDates dates)
    {
        this.dates = dates;
    }

    public String getSectionName()
    {
        return sectionName;
    }

    public void setSectionName(String sectionName)
    {
        this.sectionName = sectionName;
    }

    public Integer getPosition()
    {
        return position;
    }

    public void setPosition(Integer position)
    {
        this.position = position;
    }

    public Integer getType()
    {
        return type;
    }

    public void setType(Integer type)
    {
        this.type = type;
    }
}

