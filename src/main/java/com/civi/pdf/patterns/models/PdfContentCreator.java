package com.civi.pdf.patterns.models;

import com.civi.pdf.patterns.api.Formulas;
import com.civi.pdf.patterns.beans.EducationExperience;
import com.civi.pdf.patterns.beans.OtherExperience;
import com.civi.pdf.patterns.beans.WorkExperience;
import com.civi.pdf.patterns.db.entity.CvDates;
import com.civi.pdf.patterns.db.entity.Sections;
import com.civi.pdf.patterns.enums.EnumColor;
import com.civi.pdf.patterns.enums.EnumPattern;
import com.civi.pdf.patterns.enums.EnumSection;
import com.civi.pdf.patterns.utils.HTMLParser;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sardor
 * Date: 9/13/13
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class PdfContentCreator extends ModelFactory
{

    private Paragraph content;
    private EnumPattern pattern;
    protected Font boldFont = FontStyle("FLORSN_BOLD", 35, EnumColor.RED);
    protected Font normalFont = FontStyle("FLORSN", 35, EnumColor.GRAY_H);
    private CvDates common;
    private Document document;
    private PdfContentByte canvas;
    private long count;
    private List<Sections> data;

    public PdfContentCreator()
    {
    }

    public PdfContentCreator(float fontSize)
    {
        super(new Paragraph(fontSize), "FLORSN");
    }

    public PdfContentCreator(EnumPattern pattern, List<Sections> data, CvDates common, Document document)
    {
        super(new Phrase(12), "FLORSN");
        this.pattern = pattern;
        this.data = data;
        this.common = common;
        this.document = document;

    }

    public PdfContentCreator(EnumPattern pattern, List<Sections> data, CvDates common, PdfContentByte canvas, Document document)
    {
        super(new Phrase(12), "FLORSN");
        this.pattern = pattern;
        this.data = data;
        this.common = common;
        this.canvas = canvas;
        this.document = document;

    }

    public void init()
    {
        metaInformation();

        all pattern initialization

        headerSection(common, document);
        try
        {
            bodySection(data, document);
        } catch (DocumentException e)
        {
            e.printStackTrace();
        }
    }

    private void metaInformation()
    {
        if(pattern==EnumPattern.STRONG_RED)
        {
             addMetaData(document, pattern.style);
             colorRectangle(canvas, new BaseColor(236,236,236), 30, 682, 540, 135);
             colorRectangle(canvas, GrayColor.GRAY, 395, 645, 150, 150);
        }else if(pattern==EnumPattern.COMMON)
        {
            com.civi.pdf.common.service.PdfContentCreator common = new com.civi.pdf.common.service.PdfContentCreator(data,co)
        }
    }

    private Document headerSection(CvDates data, Document document)
    {
        if (pattern == EnumPattern.STRONG_RED)
        {
            Paragraph header = new Paragraph(12);

            addEmptyLine(header, 2);

            header.setIndentationLeft(30);
            header.setFont(boldFont);

            header.add(data.getSplitName()[0]);
            header.setFont(normalFont);
            header.add(data.getSplitName()[1]);

            addEmptyLine(header, 2);

            boldFont = FontStyle("FLORSN_BOLD", 11, EnumColor.GRAY_H);
            header.setFont(boldFont);
            header.add(data.getJobTitle());

            header.add(Chunk.NEWLINE);
            normalFont = FontStyle("FLORSN", 10, EnumColor.GRAY);
            header.setFont(normalFont);
            header.add(data.getAddress1());


            header.add(" ");
            header.add(DOT(EnumColor.RED));
            header.add(" ");

            normalFont = FontStyle("FLORSN", 10, EnumColor.GRAY);
            header.setFont(normalFont);
            header.add(data.getAddress2());

            header.add(" ");
            header.add(DOT(EnumColor.RED));
            header.add(" ");

            normalFont = FontStyle("FLORSN", 10, EnumColor.GRAY);
            header.setFont(normalFont);
            header.add(data.getAddress3());

            addEmptyLine(header, 1);

            normalFont = FontStyle("FLORSN", 10, EnumColor.GRAY);
            header.setFont(normalFont);
            header.add(data.getEmail());

            header.add(" ");
            header.add(DOT(EnumColor.RED));
            header.add(" ");

            normalFont = FontFactory.getFont("FLORSN", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 10, Font.NORMAL, new BaseColor(88, 88, 91));
            header.setFont(normalFont);
            header.add(data.getPhones());

            addEmptyLine(header, 7);

            try
            {
                document.add(header);
            } catch (DocumentException e)
            {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }
        return document;

    }

    @SuppressWarnings("unchecked")
    private void bodySection(List<Sections> data, Document document) throws DocumentException
    {
        Integer numerate = 0;
        if (pattern == EnumPattern.STRONG_RED)
        {
            PdfPCell cell1 = new PdfPCell(new Paragraph(" "));
            PdfPCell cell2 = new PdfPCell();
            /*-------------------------------------------------------------------*/

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(103);
            float[] columnWidths = {0.1f, 2f};

            try
            {
                table.setWidths(columnWidths);
            } catch (DocumentException e)
            {
                e.printStackTrace();
            }

            /*HEADER SECTION*/


            for (Sections sc : data)
            {

                Paragraph section = new Paragraph(12);
                numerate++;

                if(sc.getNewPage())
                {
                    document.newPage();
                }
                /*SECTION HEADER*/
                boldFont = FontStyle("FLORSN_BOLD", 12, EnumColor.RED);
                section.setFont(boldFont);
                section.add(sc.getSectionName()+":");



                if (sc.getType() == EnumSection.WORK.type)
                {
                    List<WorkExperience> list = (List<WorkExperience>) extractByteAttribute(sc.getAttributes());

                    for (WorkExperience we : list)
                    {

                        addEmptyLine(section, 2);
                        System.out.println(we);
                        boldFont = FontStyle("FLORSN_BOLD", 11, EnumColor.GRAY_H);
                        section.setFont(boldFont);
                        section.add(we.getCompanyName());

                        addEmptyLine(section, 1);

                        normalFont = FontStyle("FLORSN_ITALIC", 11, EnumColor.GRAY_B);
                        section.setFont(normalFont);
                        section.add(we.getStartDate() + " - " + we.getEndDate());

                        addEmptyLine(section, 1);

                        normalFont = FontStyle("FLORSN", 11, EnumColor.GRAY);
                        section.setFont(normalFont);
                        section.add(we.getJobTitle());

                        cell1 = new PdfPCell(new Paragraph(" "));
                        cell1.setBorder(Rectangle.NO_BORDER);
                        cell1.setBorderWidthLeft(7f);
                        cell1.setBorderColor(EnumColor.RED.color);

                        cell2 = new PdfPCell();
                        cell2.addElement(section);
                        cell2.setBorder(Rectangle.NO_BORDER);
                        cell2.setPadding(0);
                        cell2.setPaddingBottom(5);

                        table.addCell(cell1);
                        table.addCell(cell2);

                        /*BODY SECTION*/
                        setInfoIntoCell(we.getInformation(),table);

                         section = new Paragraph(12);

                    }

                }
                else if (sc.getType() == EnumSection.EDUCATION.type)
                {
                    List<EducationExperience> list = (List<EducationExperience>) extractByteAttribute(sc.getAttributes());
                    for (EducationExperience edu : list)
                    {

                        addEmptyLine(section, 2);

                        boldFont = FontStyle("FLORSN_BOLD", 11, EnumColor.GRAY_H);
                        section.setFont(boldFont);
                        section.add(edu.getInstitutionName());

                        addEmptyLine(section, 1);

                        normalFont = FontStyle("FLORSN_ITALIC", 11, EnumColor.GRAY_B);
                        section.setFont(normalFont);
                        section.add(edu.getStartDate() + " - " + edu.getEndDate());

                        addEmptyLine(section, 1);

                        normalFont = FontStyle("FLORSN", 11, EnumColor.GRAY);
                        section.setFont(normalFont);
                        section.add(edu.getCourseName());

                        cell1 = new PdfPCell(new Paragraph(" "));
                        cell1.setBorder(Rectangle.NO_BORDER);
                        cell1.setBorderWidthLeft(7f);
                        cell1.setBorderColor(EnumColor.RED.color);

                        cell2 = new PdfPCell();
                        cell2.addElement(section);
                        cell2.setBorder(Rectangle.NO_BORDER);
                        cell2.setPadding(0);
                        cell2.setPaddingBottom(5);

                        table.addCell(cell1);
                        table.addCell(cell2);

                        /*BODY SECTION*/
                        setInfoIntoCell(edu.getInformation(),table);
                        section = new Paragraph(12);


                    }

                }
                else if (sc.getType() == EnumSection.OTHER.type)
                {
                    List<OtherExperience> list = (List<OtherExperience>) extractByteAttribute(sc.getAttributes());
                    for (OtherExperience edu : list)
                    {

                        addEmptyLine(section, 2);
                        cell1 = new PdfPCell(new Paragraph(" "));
                        cell1.setBorder(Rectangle.NO_BORDER);
                        cell1.setBorderWidthLeft(7f);
                        cell1.setBorderColor(EnumColor.RED.color);

                        cell2 = new PdfPCell();
                        cell2.addElement(section);
                        cell2.setBorder(Rectangle.NO_BORDER);
                        cell2.setPadding(0);
                        cell2.setPaddingBottom(5);

                        table.addCell(cell1);
                        table.addCell(cell2);

                        /*BODY SECTION*/
                        setInfoOthersIntoCell(edu.getEntry(),table);
                        section = new Paragraph(12);

                    }

                }

                /*FOOTER LINE SECTION*/
                if(this.count != numerate)
                {
                    section = new Paragraph();
                    section.add(DotLine());

                    cell1 = new PdfPCell(new Paragraph(" "));
                    cell1.setBorder(Rectangle.NO_BORDER);
                    cell1.setBorderWidthLeft(7f);
                    cell1.setBorderColor(EnumColor.RED.color);

                    cell2 = new PdfPCell(section);

                    cell2.setBorder(Rectangle.NO_BORDER);

                    table.addCell(cell1);
                    table.addCell(cell2);

                    document.add(table);


                    /*TABLE PADDING*/
                    section = new Paragraph();
                    addEmptyLine(section, 1);
                    document.add(section);

                    table = new PdfPTable(2);
                    table.setWidthPercentage(103);

                    table.setWidths(columnWidths);
                }


            }

            document.add(table);


        }

    }

    private PdfPTable setInfoIntoCell(String info,PdfPTable table) throws DocumentException
    {
        StringTokenizer st = new StringTokenizer(info,"||");
        switch (pattern)
        {
            case STRONG_RED:
            {
                Paragraph section = new Paragraph(11);

                while (st.hasMoreElements())
                {

                    String element = (String) st.nextElement();

                    section.add(new HTMLParser("FLORSN",10,Font.NORMAL,BaseFont.IDENTITY_H,BaseFont.EMBEDDED,EnumColor.GRAY,EnumColor.RED).parse(element));

                }


                PdfPCell cell1 = new PdfPCell(new Paragraph(" "));
                cell1.setBorder(Rectangle.NO_BORDER);
                cell1.setBorderWidthLeft(7f);
                cell1.setBorderColor(EnumColor.RED.color);

                PdfPCell cell2 = new PdfPCell();
                cell2.addElement(section);
                cell2.setBorder(Rectangle.NO_BORDER);
                cell2.setBorderWidthLeft(1f);
                cell2.setBorderColor(EnumColor.RED.color);

                cell2.setPadding(0);
                cell2.setPaddingLeft(8);
                cell2.setPaddingBottom(3);

                table.addCell(cell1);
                table.addCell(cell2);

                break;
            }
        }

        return table;


    }


    private PdfPTable setInfoOthersIntoCell(String info,PdfPTable table) throws DocumentException
    {
        StringTokenizer st = new StringTokenizer(info,"||");
        switch (pattern)
        {
            case STRONG_RED:
            {
                Paragraph section = new Paragraph(11);

                while (st.hasMoreElements())
                {

                    String element = (String) st.nextElement();

                    section.add(new HTMLParser("FLORSN",10,Font.NORMAL,BaseFont.IDENTITY_H,BaseFont.EMBEDDED,EnumColor.GRAY,EnumColor.RED).parse(element));

                }


                PdfPCell cell1 = new PdfPCell(new Paragraph(" "));
                cell1.setBorder(Rectangle.NO_BORDER);
                cell1.setBorderWidthLeft(7f);
                cell1.setBorderColor(EnumColor.RED.color);

                PdfPCell cell2 = new PdfPCell();
                cell2.addElement(section);
                cell2.setBorder(Rectangle.NO_BORDER);

                cell2.setPadding(0);
                cell2.setPaddingLeft(8);
                cell2.setPaddingBottom(3);

                table.addCell(cell1);
                table.addCell(cell2);

                break;
            }
        }

        return table;


    }

    private String clearText(String text)
    {
        text = text.replace(Formulas.BOLD, "");
        text = text.replace(Formulas.ITALIC, "");
        text = text.replace(Formulas.UNDERLINE, "");
        text = text.replace(Formulas.LIST, "");
        return text;
    }



    // private section


    public long getCount()
    {
        return count;
    }

    public void setCount(Long count)
    {
        this.count = count;
    }
}
