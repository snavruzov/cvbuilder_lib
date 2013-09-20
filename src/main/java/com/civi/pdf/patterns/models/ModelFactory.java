package com.civi.pdf.patterns.models;

import com.civi.pdf.patterns.db.HibernateDao;
import com.civi.pdf.patterns.enums.EnumColor;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created with IntelliJ IDEA.
 * User: sardor
 * Date: 9/13/13
 * Time: 10:55 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class ModelFactory extends HibernateDao
{

    private Paragraph paragraph;
    private Phrase phrase;
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

    public ModelFactory(Phrase phrase, String fontname){
        this.phrase = phrase;
        this.fontname = fontname;
    }

    public Font FontStyle(){
        return FontFactory.getFont("FLORSN", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11, Font.NORMAL, new BaseColor(88,88,91));

    }
    public Font FontStyle(String fontname, float size, com.itextpdf.text.BaseColor color){
        return FontFactory.getFont(fontname, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, Font.NORMAL, color);

    }
    public Font FontStyle(String fontname, float size, EnumColor color){
        return FontFactory.getFont(fontname, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, Font.NORMAL, color.color);

    }
    public Font FontStyle(String fontname, float size, int style, com.itextpdf.text.BaseColor color){
        return FontFactory.getFont(fontname, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, style, color);

    }
    public Font FontStyle(String fontname, float size, int style, EnumColor color){
        return FontFactory.getFont(fontname, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, size, style, color.color);

    }

    public Phrase DOT(EnumColor color)
    {
        Font normalFont = FontFactory.getFont(fontname,BaseFont.IDENTITY_H, BaseFont.EMBEDDED,30,Font.NORMAL, color.color);
        Phrase phrase = new Phrase(12);
        phrase.setFont(normalFont);
        phrase.add(".");

        return phrase;
    }

    public Phrase DOT(EnumColor color,Phrase pr)
    {
        Font normalFont = FontFactory.getFont(fontname,BaseFont.IDENTITY_H, BaseFont.EMBEDDED,30,Font.NORMAL, color.color);
        pr.setFont(normalFont);
        pr.add(" . ");

        return pr;
    }

    public Phrase DotLine()
    {
        Phrase section = new Phrase();

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

    public void addMetaData(Document document, String style) {
        document.addTitle(String.format("CiVi(%s)",style));
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
