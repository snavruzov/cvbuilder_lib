package com.civi.pdf.patterns.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: sardor
 * Date: 9/13/13
 * Time: 6:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class OtherExperience implements Serializable {

    private static final long serialVersionUID = 1L;

    private String entry;

    public OtherExperience(){}

    public OtherExperience(String entry)
    {
        this.entry = entry;
    }

    public String getEntry()
    {
        return entry;
    }

    public void setEntry(String entry)
    {
        this.entry = entry;
    }
}
