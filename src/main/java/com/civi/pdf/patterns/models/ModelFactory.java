package com.civi.pdf.patterns.models;

import com.civi.pdf.patterns.beans.WorkExperience;
import com.civi.pdf.patterns.enums.EnumCollor;
import com.civi.pdf.patterns.enums.EnumSection;
import com.civi.pdf.patterns.enums.EnumTable;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sardor
 * Date: 9/13/13
 * Time: 10:55 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class ModelFactory {

    private Paragraph paragraph;
    private String fontname;

    public ModelFactory(){

    }
    public ModelFactory(Paragraph paragraph){
        this.paragraph = paragraph;
        this.fontname = "FLORSN";
    }
    public ModelFactory(Paragraph paragraph, String fontname){
        this.paragraph = paragraph;
        this.fontname = fontname;
    }

    public Font FontStyle(){
        return FontFactory.getFont("FLORSN", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11, Font.NORMAL, new BaseColor(88,88,91));

    }
    public Font FontStyle(String fontname, float size, com.itextpdf.text.BaseColor color){
        return FontFactory.getFont(fontname, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, Font.NORMAL, color);

    }
    public Font FontStyle(String fontname, float size, EnumCollor color){
        return FontFactory.getFont(fontname, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, Font.NORMAL, color.color);

    }
    public Font FontStyle(String fontname, float size, int style, com.itextpdf.text.BaseColor color){
        return FontFactory.getFont(fontname, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, style, color);

    }
    public Font FontStyle(String fontname, float size, int style, EnumCollor collor){
        return FontFactory.getFont(fontname, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, style, collor.color);

    }

    public Paragraph DOT(EnumCollor collor)
    {
        Font normalFont = FontFactory.getFont(fontname,BaseFont.IDENTITY_H, BaseFont.EMBEDDED,30,Font.NORMAL,collor.color);
        paragraph.setFont(normalFont);
        paragraph.add(" . ");

        return paragraph;
    }

    public Paragraph DotLine()
    {
        Paragraph section = new Paragraph();
        DottedLineSeparator dottedLine = new DottedLineSeparator();
        dottedLine.setGap(2);

        section.add(new Chunk(dottedLine));

        return section;
    }


    public void colorRectangle(PdfContentByte canvas,
                                      BaseColor color, float x, float y, float width, float height) {
        canvas.saveState();
        canvas.setColorFill(color);
        canvas.setColorStroke(color);
        canvas.rectangle(x, y, width, height);
        canvas.fillStroke();
        canvas.restoreState();
    }

    private void addMetaData(Document document) {
        document.addTitle("CiVi");
        document.addSubject("Using iText");
        document.addKeywords("CiVi, PDF, CV");
        document.addAuthor("Sardor Navruzov");
        document.addCreator("Sardor Navruzov");
    }

    private void addContent(Document document, String text,PdfContentByte canvas)
            throws DocumentException, IOException {
    }

    public void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(Chunk.NEWLINE);
        }
    }


    @SuppressWarnings("unchecked")
    public Object extractByteAttribute(byte[] attr)
    {

        ObjectInputStream ois = null;
        Object list = null;
        try
        {
            ois = new ObjectInputStream(new ByteArrayInputStream(attr));

            list = ois.readObject();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            if(ois!=null)
            {
                try
                {
                    ois.close();
                } catch (IOException e)
                {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }

        return list;


    }

}
