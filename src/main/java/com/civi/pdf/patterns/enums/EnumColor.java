package com.civi.pdf.patterns.enums;

import com.itextpdf.text.BaseColor;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 9/15/13
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */
public enum EnumColor
{
    GRAY(new BaseColor(88, 88, 91)),
    GRAY_H(new BaseColor(108,108,108)),
    GRAY_L(new BaseColor(221,221,221)),
    GRAY_B(new BaseColor(34,34,34)),
    RED(new BaseColor(191, 0, 0));


    public BaseColor color;

    EnumColor(BaseColor color)
    {
        this.color = color;
    }
}
