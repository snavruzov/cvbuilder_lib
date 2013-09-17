package com.civi.pdf.patterns.models;

import com.civi.pdf.patterns.api.Formulas;
import com.civi.pdf.patterns.beans.WorkExperience;
import com.civi.pdf.patterns.db.entity.CvDates;
import com.civi.pdf.patterns.db.entity.Sections;
import com.civi.pdf.patterns.enums.EnumCollor;
import com.civi.pdf.patterns.enums.EnumFormulas;
import com.civi.pdf.patterns.enums.EnumPattern;
import com.civi.pdf.patterns.enums.EnumSection;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sardor
 * Date: 9/13/13
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class PdfContentCreator extends ModelFactory {

    private Paragraph content;
    private EnumPattern pattern;
    protected Font boldFont = FontStyle("FLORSN",35, EnumCollor.RED);
    protected Font normalFont = FontStyle("FLORSN",35, EnumCollor.GRAY);

    public PdfContentCreator(){
    }

    public PdfContentCreator(float fontSize){
        super(new Paragraph(fontSize),"FLORSN");
    }
    public PdfContentCreator(EnumPattern pattern, Document document){
        super(new Paragraph(12),"FLORSN");
        this.pattern = pattern;
        headerSection(new CvDates(),document);
    }

    private Document headerSection(CvDates data, Document document)
    {
        if(pattern==EnumPattern.STRONG_RED)
        {
            Paragraph header = new Paragraph(12);


            addEmptyLine(header, 2);

        header.setIndentationLeft(30);
        header.setFont(boldFont);

        header.add(data.getSplitName()[0]);
        header.setFont(normalFont);
        header.add(data.getSplitName()[1]);

        addEmptyLine(header, 2);

        boldFont = FontStyle("FLORSN_BOLD", 11, EnumCollor.GRAY_H);
        header.setFont(boldFont);
        header.add(data.getJobTitle());

        header.add(Chunk.NEWLINE);
        normalFont = FontStyle("FLORSN",10, EnumCollor.GRAY);
        header.setFont(normalFont);
        header.add(data.getAddress1());

        header.add(DOT(EnumCollor.RED));

        normalFont = FontStyle("FLORSN", 10, EnumCollor.GRAY);
        header.setFont(normalFont);
        header.add(data.getAddress2());

        header.add(DOT(EnumCollor.RED));

        normalFont = FontStyle("FLORSN", 10, EnumCollor.GRAY);
        header.setFont(normalFont);
        header.add(data.getAddress3());

        addEmptyLine(header, 1);

        normalFont = FontStyle("FLORSN", 10, EnumCollor.GRAY);
        header.setFont(normalFont);
        header.add(data.getEmail());

        header.add(DOT(EnumCollor.RED));

        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
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
    private Document bodySection(List<Sections> data, Document document) throws DocumentException
    {
        if(pattern==EnumPattern.STRONG_RED)
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
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            /*HEADER SECTION*/

        Paragraph section = new Paragraph(12);
        for(Sections sc:data)
        {
            if(sc.getType()== EnumSection.WORK.type)
            {
                List<WorkExperience> list = (List<WorkExperience>)extractByteAttribute(sc.getAttributes());
                for (WorkExperience we: list)
                {
                    /*SECTION HEADER*/
                    boldFont = FontStyle("FLORSN_BOLD", 12, EnumCollor.RED);
                    section.setFont(boldFont);
                    section.add(sc.getSectionName());

                    addEmptyLine(section, 2);

                    boldFont = FontStyle("FLORSN_BOLD", 11, EnumCollor.GRAY_H);
                    section.setFont(boldFont);
                    section.add(we.getCompanyName());

                    addEmptyLine(section, 1);

                    normalFont = FontStyle("FLORSN_ITALIC", 11, EnumCollor.GRAY_B);
                    section.setFont(normalFont);
                    section.add(we.getStartDate()+" - "+we.getEndDate());

                    addEmptyLine(section, 1);

                    normalFont = FontStyle("FLORSN", 11, EnumCollor.GRAY);
                    section.setFont(normalFont);
                    section.add(we.getJobTitle());

                    cell1 = new PdfPCell(new Paragraph(" "));
                    cell1.setBorder(Rectangle.NO_BORDER);
                    cell1.setBorderWidthLeft(7f);
                    cell1.setBorderColor(EnumCollor.RED.color);

                    cell2 = new PdfPCell();
                    cell2.addElement(section);
                    cell2.setBorder(Rectangle.NO_BORDER);
                    cell2.setPadding(0);
                    cell2.setPaddingBottom(5);

                    table.addCell(cell1);
                    table.addCell(cell2);

                    /*BODY SECTION*/
                    table.addCell(setInfoIntoCell(we.getInformation()));

                }

            }

            /*FOOTER LINE SECTION*/
            section = new Paragraph();
            DottedLineSeparator dottedLine = new DottedLineSeparator();
            dottedLine.setGap(2);
            section.add(new Chunk(dottedLine));

            cell1 = new PdfPCell(new Paragraph(" "));
            cell1.setBorder(Rectangle.NO_BORDER);
            cell1.setBorderWidthLeft(7f);
            cell1.setBorderColor(new BaseColor(191,0,0));

            cell2 = new PdfPCell(section);

            cell2.setBorder(Rectangle.NO_BORDER);

            table.addCell(cell1);
            table.addCell(cell2);

            /*TABLE PADDING*/
            section = new Paragraph();
            addEmptyLine(section, 1);
            document.add(section);

            table = new PdfPTable(2);
            table.setWidthPercentage(103);

            table.setWidths(columnWidths);


        }


        document.add(table);


        }

        return document;


    }

    private PdfPTable setInfoIntoCell(String info) throws DocumentException
    {
        PdfPTable table = new PdfPTable(2);
        StringTokenizer st = new StringTokenizer(info);
        switch (pattern)
        {
            case STRONG_RED:
            {
                table = new PdfPTable(2);
                table.setWidthPercentage(103);
                float[] columnWidths = {0.1f, 2f};

                table.setWidths(columnWidths);

                Paragraph section = new Paragraph(11);

                while (st.hasMoreElements()) {

                    String element = (String)st.nextElement();
                    if(element.contains(Formulas.BOLD))
                    {
                        normalFont = FontStyle("FLORSN_BOLD", 10, EnumCollor.GRAY);
                        section.setFont(normalFont);
                        section.add(element);
                    }
                    else if(element.contains(Formulas.ITALIC))
                    {
                        normalFont = FontStyle("FLORSN_ITALIC", 10, EnumCollor.GRAY);
                        section.setFont(normalFont);
                        section.add(element);
                    }
                    else if(element.contains(Formulas.UNDERLINE))
                    {
                        normalFont = FontStyle("FLORSN", 10, EnumCollor.GRAY);
                        section.setFont(normalFont);
                        Chunk underline = new Chunk(element);
                        underline.setUnderline(0.1f,-2f);
                        section.add(underline);
                    }
                    else if(element.contains(Formulas.LIST))
                    {
                        com.itextpdf.text.List list = new com.itextpdf.text.List();
                        Chunk chunk = new Chunk("\u2022 \t",FontStyle("FLORSN", 10, EnumCollor.RED));
                        list.setListSymbol(chunk);
                        list.add(new ListItem(clearText(element),FontStyle("FLORSN", 10, EnumCollor.GRAY)));

                        section.add(list);

                    }

		        }


                PdfPCell cell1 = new PdfPCell(new Paragraph(" "));
                cell1.setBorder(Rectangle.NO_BORDER);
                cell1.setBorderWidthLeft(7f);
                cell1.setBorderColor(EnumCollor.RED.color);

                PdfPCell cell2 = new PdfPCell();
                cell2.addElement(section);
                cell2.setBorder(Rectangle.NO_BORDER);
                cell2.setBorderWidthLeft(1f);
                cell2.setBorderColor(EnumCollor.RED.color);

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
        text = text.replace(Formulas.BOLD,"");
        text = text.replace(Formulas.ITALIC,"");
        text = text.replace(Formulas.UNDERLINE,"");
        text = text.replace(Formulas.LIST,"");
        return text;
    }

   // private section


}
