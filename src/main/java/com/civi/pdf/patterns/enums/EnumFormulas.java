package com.civi.pdf.patterns.enums;

/**
 * Created by Intellij IDEA.
 * User: Sardor Navruzov
 * Date: 9/17/13
 * Time: 1:34 PM
 */
public enum EnumFormulas
{
    BOLD("=="),
    ITALIC("-=-"),
    UNDERLINE("_=_"),
    LIST("_-_");

    public String form;

    EnumFormulas(String form)
    {
        this.form = form;
    }
}
