package com.civi.pdf.patterns.api;

import com.itextpdf.text.FontFactory;

/**
 * Created with IntelliJ IDEA.
 * User: sardor
 * Date: 9/13/13
 * Time: 11:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class PDFConfigRegister {

    private static final String FONT_PATH = "/home/sardor/Documents/PDF/fonts/tt";
    public PDFConfigRegister(){

    }

    public static void init(){
        FontFactory.register(FONT_PATH.concat("/Florsn01.ttf"), "FLORSN");
        FontFactory.register(FONT_PATH.concat("/Florsn33.ttf"), "FLORSN_BOLD");
        FontFactory.register(FONT_PATH.concat("/Florsn03.ttf"), "FLORSN_ITALIC");
    }

}
