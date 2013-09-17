package com.civi.pdf.patterns.enums;

/**
 * Created by Intellij IDEA.
 * User: Sardor Navruzov
 * Date: 9/16/13
 * Time: 6:30 PM
 */
public enum EnumSection
{
    WORK(1),
    EDUCATION(2),
    OTHER(3);

    public int type;

    EnumSection(int type)
    {
        this.type = type;
    }
}
