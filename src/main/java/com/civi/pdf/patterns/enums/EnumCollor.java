package com.civi.pdf.patterns.enums;

import com.itextpdf.text.BaseColor;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 9/15/13
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */
public enum EnumCollor {
    GRAY(new BaseColor(88, 88, 91)),
    GRAY_H(new BaseColor(108,108,108)),
    GRAY_B(new BaseColor(199,33,33)),
    RED(new BaseColor(191, 0, 0));


    public BaseColor color;

    EnumCollor(BaseColor color)
    {
        this.color = color;
    }
}
