package com.civi.pdf.patterns.enums;

/**
 * Created with IntelliJ IDEA.
 * User: sardor
 * Date: 9/13/13
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
public enum EnumPattern {

    STRONG_RED(1,"Strong Red");

    public int id;
    public String style;

    EnumPattern(int id, String style)
    {
        this.id = id;
        this.style = style;
    }
}
