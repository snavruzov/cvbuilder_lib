/**
 * Created with IntelliJ IDEA.
 * User: sardor
 * Date: 9/9/13
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */

import com.civi.pdf.patterns.enums.EnumColor;
import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.LineSeparator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;


public class PDFMain {
    private static String FILE = "/home/sardor/Documents/PDF/test.pdf";
    private static String IMAGE_URL = "/home/sardor/Documents/PDF/prof.jpg";

    public static void main(String[] args) {
        try {
            Document document = new Document();
            PdfWriter writer  = PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();

            PdfContentByte canvas = writer.getDirectContentUnder();
            //colorRectangle(canvas, new BaseColor(236,236,236), 30, 682, 540, 135);
            //colorRectangle(canvas, GrayColor.WHITE, 395, 645, 150, 150);


            addContent(document,"SardorNavruzov",canvas);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void colorRectangle(PdfContentByte canvas,
                               BaseColor color, float x, float y, float width, float height) {
        canvas.saveState();
        canvas.setColorFill(color);
        canvas.setColorStroke(color);
        canvas.rectangle(x, y, width, height);
        canvas.fillStroke();
        canvas.restoreState();
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    private static void addMetaData(Document document) {
        document.addTitle("CiVi");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Sardor Navruzov");
        document.addCreator("Sardor Navruzov");
    }

    private static void addContent(Document document, String text,PdfContentByte canvas)
            throws DocumentException, IOException {

        Paragraph header = new Paragraph(25);
        FontFactory.register("/home/sardor/Documents/PDF/fonts/tt/neue/HelveticaNeueLight.ttf", "NEUE");
        FontFactory.register("/home/sardor/Documents/PDF/fonts/tt/neue/HelveticaNeue.ttf", "NEUE_BOLD");
        FontFactory.register("/home/sardor/Documents/PDF/fonts/tt/neue/HelveticaNeueLightItalic.ttf", "NEUE_ITALIC");
        FontFactory.register("/home/sardor/Documents/PDF/fonts/tt/PRINC.TTF", "FLORSN");

        Font boldFont = FontFactory.getFont("NEUE_BOLD", BaseFont.CP1252, BaseFont.EMBEDDED, 33, Font.NORMAL, new BaseColor(17,17,17));
        Font normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,9,Font.NORMAL,new BaseColor(34,34,34));

        /*PERSONAL INFO*/
        //C1
        PdfPTable phTable = new PdfPTable(4);
        phTable.setWidthPercentage(100);
        float[] columnPh = {0.5f, 2f,0.6f, 2f};
        phTable.setWidths(columnPh);

        Paragraph personal = new Paragraph(15);
        personal.setFont(normalFont);
        personal.add("E-mail");

        PdfPCell cellPh = new PdfPCell();
        cellPh.addElement(personal);
        cellPh.setBorder(Rectangle.NO_BORDER);
        cellPh.setPadding(0);
        cellPh.setPaddingLeft(5);
        //C2
        personal = new Paragraph(15);
        personal.setFont(normalFont);
        personal.add(": navruzov@mail.com");

        PdfPCell cell2Ph = new PdfPCell();
        cell2Ph.addElement(personal);
        cell2Ph.setBorder(Rectangle.NO_BORDER);
        cell2Ph.setPadding(0);
        cell2Ph.setPaddingLeft(5);

        //C3
        personal = new Paragraph(15);
        personal.setFont(normalFont);
        personal.add("Website");

        PdfPCell cell3Ph = new PdfPCell();
        cell3Ph.addElement(personal);
        cell3Ph.setBorder(Rectangle.NO_BORDER);
        cell3Ph.setPadding(0);
        cell3Ph.setPaddingLeft(5);

        //C4
        personal = new Paragraph(15);
        personal.setFont(normalFont);
        personal.add(": http://cvmkr.com");

        PdfPCell cell4Ph = new PdfPCell();
        cell4Ph.addElement(personal);
        cell4Ph.setBorder(Rectangle.NO_BORDER);
        cell4Ph.setPadding(0);
        cell4Ph.setPaddingLeft(5);
        //C5
        personal = new Paragraph(15);
        personal.setFont(normalFont);
        personal.add("Phone");

        PdfPCell cell5Ph = new PdfPCell();
        cell5Ph.addElement(personal);
        cell5Ph.setBorder(Rectangle.NO_BORDER);
        cell5Ph.setPadding(0);
        cell5Ph.setPaddingLeft(5);
        //C6
        personal = new Paragraph(15);
        personal.setFont(normalFont);
        personal.add(": (123) 456 789");
        personal.add(Chunk.NEWLINE);
        personal.add("  (123) 456 789");

        PdfPCell cell6Ph = new PdfPCell();
        cell6Ph.addElement(personal);
        cell6Ph.setBorder(Rectangle.NO_BORDER);
        cell6Ph.setPadding(0);
        cell6Ph.setPaddingLeft(5);
        //C7
        personal = new Paragraph(15);
        personal.setFont(normalFont);
        personal.add("Address");

        PdfPCell cell7Ph = new PdfPCell();
        cell7Ph.addElement(personal);
        cell7Ph.setBorder(Rectangle.NO_BORDER);
        cell7Ph.setPadding(0);
        cell7Ph.setPaddingLeft(5);
        //C8
        personal = new Paragraph(15);
        personal.setFont(normalFont);
        personal.add(": 956, 31st Street");
        personal.add(Chunk.NEWLINE);
        personal.add("  956, 31st Street");
        personal.add(Chunk.NEWLINE);
        personal.add("  United States ");

        PdfPCell cell8Ph = new PdfPCell();
        cell8Ph.addElement(personal);
        cell8Ph.setBorder(Rectangle.NO_BORDER);
        cell8Ph.setPadding(0);
        cell8Ph.setPaddingLeft(5);

        phTable.addCell(cellPh);
        phTable.addCell(cell2Ph);
        phTable.addCell(cell3Ph);
        phTable.addCell(cell4Ph);
        phTable.addCell(cell5Ph);
        phTable.addCell(cell6Ph);
        phTable.addCell(cell7Ph);
        phTable.addCell(cell8Ph);


        PdfPTable tableH = new PdfPTable(2);
        tableH.setWidthPercentage(103);
        float[] columnWidthsH = {0.5f, 2f};
        tableH.setWidths(columnWidthsH);

        header.setFont(boldFont);
        header.add("Sardor Navruzov");
        header.add(Chunk.NEWLINE);

        PdfPCell cellH = new PdfPCell(addImage(IMAGE_URL));
        cellH.setBorder(Rectangle.NO_BORDER);
        cellH.setBorderWidth(1);
        cellH.setRowspan(2);

        PdfPCell cell2H = new PdfPCell();
        cell2H.addElement(header);//addElement(header);
        cell2H.setBorder(Rectangle.NO_BORDER);
        cell2H.setPadding(0);
        cell2H.setPaddingLeft(5);
        cell2H.setFixedHeight(40);


        PdfPCell cellPersonal = new PdfPCell();
        cellPersonal.addElement(phTable);//addElement(header);
        cellPersonal.setBorder(Rectangle.NO_BORDER);
        cellPersonal.setPadding(0);

        tableH.addCell(cellH);
        tableH.addCell(cell2H);
        tableH.addCell(cellPersonal);

        document.add(tableH);
        Paragraph emptyPadding = new Paragraph();
        addEmptyLine(emptyPadding, 1);
        document.add(emptyPadding);


        PdfPTable bodyTable = new PdfPTable(2);
        bodyTable.setWidthPercentage(103);
        float[] columnB = {2f, 2f};
        bodyTable.setWidths(columnB);

        Paragraph body = new Paragraph(15);

        boldFont = FontFactory.getFont("NEUE_BOLD", BaseFont.CP1252, BaseFont.EMBEDDED, 15, Font.NORMAL, new BaseColor(17,17,17));
        body.setFont(boldFont);
        body.add("Objective");

        PdfPCell cellBody = new PdfPCell();
        cellBody.addElement(body);//addElement(header);
        cellBody.setColspan(2);
        cellBody.setBorder(Rectangle.NO_BORDER);
        cellBody.setPadding(0);
        cellBody.setPaddingBottom(4);
        cellBody.setBorderWidthBottom(1);
        cellBody.setBorderColor(EnumColor.GRAY_L.color);
        bodyTable.addCell(cellBody);

        body = new Paragraph(15);
        body.setFont(normalFont);
        body.add("Seeking a position as an accountasdasd asdasd asdasd asdant where extensive experience will be further developed and utilised. Extensive experience to the credit.");

        cellBody = new PdfPCell();
        cellBody.addElement(body);//addElement(header);
        cellBody.setColspan(2);
        cellBody.setBorder(Rectangle.NO_BORDER);
        cellBody.setPadding(0);
        cellBody.setPaddingBottom(18);
        bodyTable.addCell(cellBody);

        //////-------========

        body = new Paragraph(15);

        boldFont = FontFactory.getFont("NEUE_BOLD", BaseFont.CP1252, BaseFont.EMBEDDED, 15, Font.NORMAL, new BaseColor(17,17,17));
        body.setFont(boldFont);
        body.add("Work experience");

        cellBody = new PdfPCell();
        cellBody.addElement(body);//addElement(header);
        cellBody.setColspan(2);
        cellBody.setBorder(Rectangle.NO_BORDER);
        cellBody.setPadding(0);
        cellBody.setPaddingBottom(3);
        cellBody.setBorderWidthBottom(1);
        cellBody.setBorderColor(EnumColor.GRAY_L.color);
        bodyTable.addCell(cellBody);


        body = new Paragraph(15);
        boldFont = FontFactory.getFont("NEUE_BOLD", BaseFont.CP1252, BaseFont.EMBEDDED, 12, Font.NORMAL, new BaseColor(17,17,17));
        body.setFont(boldFont);
        body.add("DC Systems, DC");

        body.add(Chunk.NEWLINE);

        boldFont = FontFactory.getFont("NEUE_BOLD", BaseFont.CP1252, BaseFont.EMBEDDED, 10, Font.NORMAL, new BaseColor(17,17,17));
        body.setFont(boldFont);
        body.add("Accounting Assistant");

        addEmptyLine(body,1);
        List list = new List();

                Chunk chunk = new Chunk("   \u2022 \t",FontFactory.getFont("FLORSN",BaseFont.CP1252, BaseFont.EMBEDDED,15,Font.NORMAL,EnumColor.GRAY_B.color));

                list.setListSymbol(chunk);

                list.add(new ListItem(15,"Administered online banking functions.",normalFont));
                list.add(new ListItem(15,"Administered online banking functions.",normalFont));
                list.add(new ListItem(15,"Reduced credit period from 90 days to 60 days.",normalFont));
                body.add(list);


        PdfPCell cell1Body = new PdfPCell();
        cell1Body.addElement(body);//addElement(header);
        cell1Body.setBorder(Rectangle.NO_BORDER);
        cell1Body.setPadding(0);
        cell1Body.setPaddingTop(5);

        body = new Paragraph(15);
        boldFont = FontFactory.getFont("NEUE_BOLD", BaseFont.CP1252, BaseFont.EMBEDDED, 12, Font.NORMAL, new BaseColor(17,17,17));
        body.setFont(boldFont);
        body.setAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
        body.add("March 2003");

        Font lineFont = FontFactory.getFont("FLORSN",  12, Font.NORMAL, new BaseColor(17,17,17));
        body.setFont(lineFont);

        body.add(" —  ");

        boldFont = FontFactory.getFont("NEUE_BOLD", BaseFont.CP1252, BaseFont.EMBEDDED, 12, Font.NORMAL, new BaseColor(17,17,17));
        body.setFont(boldFont);
        body.add("June 2005");


        PdfPCell cell2Body = new PdfPCell();
        cell2Body.addElement(body);//addElement(header);
        cell2Body.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
        cell2Body.setBorder(Rectangle.NO_BORDER);
        cell2Body.setPadding(0);
        cell2Body.setPaddingTop(5);


        bodyTable.addCell(cell1Body);
        bodyTable.addCell(cell2Body);
        ///SECOND WORK

        body = new Paragraph(15);
        boldFont = FontFactory.getFont("NEUE_BOLD", BaseFont.CP1252, BaseFont.EMBEDDED, 12, Font.NORMAL, new BaseColor(17,17,17));
        body.setFont(boldFont);
        body.add("MyOffice Inc, Boston");

        body.add(Chunk.NEWLINE);

        boldFont = FontFactory.getFont("NEUE_BOLD", BaseFont.CP1252, BaseFont.EMBEDDED, 10, Font.NORMAL, new BaseColor(17,17,17));
        body.setFont(boldFont);
        body.add("Administrator");

        addEmptyLine(body,1);
        list = new List();

                chunk = new Chunk("   \u2022 \t",FontFactory.getFont("FLORSN",BaseFont.CP1252, BaseFont.EMBEDDED,15,Font.NORMAL,EnumColor.GRAY_B.color));

                list.setListSymbol(chunk);

                list.add(new ListItem(15,"Administered online banking functions.",normalFont));
                list.add(new ListItem(15,"Administered online banking functions.",normalFont));
                list.add(new ListItem(15,"Reduced credit period from 90 days to 60 days.",normalFont));
                body.add(list);


        cell1Body = new PdfPCell();
        cell1Body.addElement(body);//addElement(header);
        cell1Body.setBorder(Rectangle.NO_BORDER);
        cell1Body.setPadding(0);
        cell1Body.setPaddingTop(5);

        body = new Paragraph(15);
        boldFont = FontFactory.getFont("NEUE_BOLD", BaseFont.CP1252, BaseFont.EMBEDDED, 12, Font.NORMAL, new BaseColor(17,17,17));
        body.setFont(boldFont);
        body.setAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
        body.add("October 2005");

        lineFont = FontFactory.getFont("FLORSN",  12, Font.NORMAL, new BaseColor(17,17,17));
        body.setFont(lineFont);

        body.add(" —  ");

        boldFont = FontFactory.getFont("NEUE_BOLD", BaseFont.CP1252, BaseFont.EMBEDDED, 12, Font.NORMAL, new BaseColor(17,17,17));
        body.setFont(boldFont);
        body.add("Present");


        cell2Body = new PdfPCell();
        cell2Body.addElement(body);//addElement(header);
        cell2Body.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
        cell2Body.setBorder(Rectangle.NO_BORDER);
        cell2Body.setPadding(0);
        cell2Body.setPaddingTop(5);


        bodyTable.addCell(cell1Body);
        bodyTable.addCell(cell2Body);


        //Qualification
        body = new Paragraph(15);
        addEmptyLine(body,2);
               boldFont = FontFactory.getFont("NEUE_BOLD", BaseFont.CP1252, BaseFont.EMBEDDED, 15, Font.NORMAL, new BaseColor(17,17,17));
               body.setFont(boldFont);
               body.add("Qualification");

               cellBody = new PdfPCell();
               cellBody.addElement(body);//addElement(header);
               cellBody.setColspan(2);
               cellBody.setBorder(Rectangle.NO_BORDER);
               cellBody.setPadding(0);
               cellBody.setPaddingBottom(3);
               cellBody.setBorderWidthBottom(1);
               cellBody.setBorderColor(EnumColor.GRAY_L.color);

        bodyTable.addCell(cellBody);

        body = new Paragraph(15);
        list = new List();

                chunk = new Chunk("   \u2022 \t",FontFactory.getFont("FLORSN",BaseFont.CP1252, BaseFont.EMBEDDED,15,Font.NORMAL,EnumColor.GRAY_B.color));

                list.setListSymbol(chunk);

                list.add(new ListItem(15,"Administered online banking functions.",normalFont));
                list.add(new ListItem(15,"Administered online banking functions.",normalFont));
                list.add(new ListItem(15,"Reduced credit period from 90 days to 60 days.",normalFont));
                body.add(list);


        cell1Body = new PdfPCell();
        cell1Body.addElement(body);//addElement(header);
        cell1Body.setColspan(2);
        cell1Body.setBorder(Rectangle.NO_BORDER);
        cell1Body.setPadding(0);
        cell1Body.setPaddingTop(5);

        bodyTable.addCell(cell1Body);

        document.add(bodyTable);
        /*addEmptyLine(header, 2);

        header.setIndentationLeft(30);
        header.setFont(boldFont);
        header.add("Sardor");
        header.setFont(normalFont);
        header.add("Navruzov");

        addEmptyLine(header, 2);

        boldFont = FontFactory.getFont("NEUE_BOLD",BaseFont.CP1252, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        header.setFont(boldFont);
        header.add("Java Developer");

        header.add(Chunk.NEWLINE);
        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
        header.setFont(normalFont);
        header.add("Uzbekistan ");

        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,30,Font.NORMAL,new BaseColor(191,0,0));
        header.setFont(normalFont);
        header.add(".");

        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
        header.setFont(normalFont);
        header.add(" Tashkent ");

        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,30,Font.NORMAL,new BaseColor(191,0,0));
        header.setFont(normalFont);
        header.add(".");

        normalFont = FontFactory.getFont("NEUE_ITALIC",BaseFont.CP1252, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
        header.setFont(normalFont);
        header.add(" Born on: 3/10/1987");

        addEmptyLine(header, 1);

        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
        header.setFont(normalFont);
        header.add("navruzov@gmail.com ");

        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,30,Font.NORMAL,new BaseColor(191,0,0));
        header.setFont(normalFont);
        header.add(".");

        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
        header.setFont(normalFont);
        header.add(" 998(94)6080716");

        addEmptyLine(header, 7);

        document.add(header);

        *//*-------------------------------------------------------------------*//*

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(103);
        float[] columnWidths = {0.1f, 2f};

        table.setWidths(columnWidths);

        *//*HEADER SECTION*//*

        Paragraph section = new Paragraph(12);

        boldFont = FontFactory.getFont("NEUE_BOLD",BaseFont.CP1252,BaseFont.EMBEDDED,12,Font.NORMAL,new BaseColor(191,0,0));
        section.setFont(boldFont);
        section.add("Education:");

        addEmptyLine(section, 2);

        boldFont = FontFactory.getFont("NEUE_BOLD",BaseFont.CP1252, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        section.setFont(boldFont);
        section.add("National University of Uzbekistan ");

        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,30,Font.NORMAL,new BaseColor(191,0,0));
        section.setFont(normalFont);
        section.add(".");

        boldFont = FontFactory.getFont("NEUE_BOLD",BaseFont.CP1252, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        section.setFont(boldFont);
        section.add(" Tashkent");

        addEmptyLine(section, 1);

        normalFont = FontFactory.getFont("NEUE_ITALIC",BaseFont.CP1252, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(199,33,33));
        section.setFont(normalFont);
        section.add("September 2005 - July 2009");

        addEmptyLine(section, 1);

        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(88,88,91));
        section.setFont(normalFont);
        section.add("Bachelors Degree in Computer Science");

        PdfPCell cell1 = new PdfPCell(new Paragraph(" "));
        cell1.setBorder(Rectangle.NO_BORDER);
        cell1.setBorderWidthLeft(7f);
        cell1.setBorderColor(new BaseColor(191,0,0));

        PdfPCell cell2 = new PdfPCell();
        cell2.addElement(section);
        cell2.setBorder(Rectangle.NO_BORDER);
        cell2.setPadding(0);
        cell2.setPaddingBottom(5);

        table.addCell(cell1);
        table.addCell(cell2);

        *//*END HEADER CENTER*//*

        *//*HEADER CONTENT*//*

        section = new Paragraph(11);
        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
        section.setFont(normalFont);
        section.add("Two Dissertations <b>have</b> been published. Implemented computer modellkl of math theories. Studied computer " +
                "architectures and low-level programming languages. Studied data structure algorithms and their realizations.");

        cell1 = new PdfPCell(new Paragraph(" "));
        cell1.setBorder(Rectangle.NO_BORDER);
        cell1.setBorderWidthLeft(7f);
        cell1.setBorderColor(new BaseColor(191,0,0));

        cell2 = new PdfPCell();
        cell2.addElement(section);
        cell2.setBorder(Rectangle.NO_BORDER);
        cell2.setBorderWidthLeft(1f);
        cell2.setBorderColor(new BaseColor(191,0,0));

        cell2.setPadding(0);
        cell2.setPaddingLeft(8);
        cell2.setPaddingBottom(3);


        table.addCell(cell1);
        table.addCell(cell2);

        *//*END SECTION CONTENT*//*

        *//*FOOTER SECTION*//*
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

        document.add(table);

        *//*TABLE PADDING*//*
        section = new Paragraph();
        addEmptyLine(section, 1);
        document.add(section);

        table = new PdfPTable(2);
        table.setWidthPercentage(103);

        table.setWidths(columnWidths);

        *//*EDUCATION*//*

        *//*HEADER SECTION*//*

        section = new Paragraph(12);

        boldFont = FontFactory.getFont("NEUE_BOLD",BaseFont.CP1252,BaseFont.EMBEDDED,12,Font.NORMAL,new BaseColor(191,0,0));
        section.setFont(boldFont);
        section.add("Experience:");

        addEmptyLine(section, 2);

        boldFont = FontFactory.getFont("NEUE_BOLD",BaseFont.CP1252, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        section.setFont(boldFont);
        section.add("INTECH Inc. ");

        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,30,Font.NORMAL,new BaseColor(191,0,0));
        section.setFont(normalFont);
        section.add(".");

        boldFont = FontFactory.getFont("NEUE_BOLD",BaseFont.CP1252, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        section.setFont(boldFont);
        section.add(" Moscow");

        addEmptyLine(section, 1);

        normalFont = FontFactory.getFont("NEUE_ITALIC",BaseFont.CP1252, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(199,33,33));
        section.setFont(normalFont);
        section.add("Feb 2005 - August 2009");

        addEmptyLine(section, 1);

        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(88,88,91));
        section.setFont(normalFont);
        section.add("Lead Java Developer");

        cell1 = new PdfPCell(new Paragraph(" "));
        cell1.setBorder(Rectangle.NO_BORDER);
        cell1.setBorderWidthLeft(7f);
        cell1.setBorderColor(new BaseColor(191,0,0));

        cell2 = new PdfPCell();
        cell2.addElement(section);
        cell2.setBorder(Rectangle.NO_BORDER);
        cell2.setPadding(0);
        cell2.setPaddingBottom(5);

        table.addCell(cell1);
        table.addCell(cell2);

        *//*END HEADER CENTER*//*

        *//*HEADER CONTENT*//*

        List list = new List();
        section = new Paragraph(11);
        Chunk chunk = new Chunk("\u2022 \t",FontFactory.getFont("FLORSN",BaseFont.CP1252, BaseFont.EMBEDDED,15,Font.NORMAL,new BaseColor(191,0,0)));

        list.setListSymbol(chunk);

        list.add(new ListItem("Item 1"));
        section.add(list);


        list = new List();
        chunk = new Chunk("\u2022 \t",FontFactory.getFont("FLORSN",BaseFont.CP1252, BaseFont.EMBEDDED,15,Font.NORMAL,new BaseColor(191,0,0)));

        list.setListSymbol(chunk);

        list.add(new ListItem("Item 2"));
        section.add(list);

        addEmptyLine(section,2);

        String elem = "||<b>CMS</b>|| ||<i>(Content Management System)</i>|| has been implemented which integrates security module, report generation " +
                "module, module of controlling VAS media contents, IVR calls monitoring system and control system of " +
                "SMS/USSD distribution. The Sy||<b>st</b>||em has been ||<ul><li>implemented for</li> <li>companies</li> <li>such as</li></ul>|| Beeline Kazakhstan, Beeline " +
                "Uzbekistan, Beeline Tajikistan, Ucell(COSCOM) Uzbekistan, BWC (ROSTELECOM) Russia, Tele2 Russia, ALTEL " +
                "(Almaty) Kazakhstan. • Entertainment/Service Portals(||<b>WAP/WEB</b>|| Portals).";

        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
        section.setFont(normalFont);
        StringTokenizer st = new StringTokenizer(elem,"||");
        while (st.hasMoreElements()) {
            String str = (String)st.nextElement();
            org.jsoup.nodes.Document doc = Jsoup.parse(str);
            Elements tagB = doc.select("b");
            Elements tagI = doc.select("i");
            Elements tagL = doc.select("ul");
            if(!tagL.isEmpty() )
            {
                tagL=tagL.first().getElementsByTag("li");
            }
            String elm = str;



            System.out.println(str);


            int k = 0;
            if(!tagB.isEmpty())
            {
                normalFont = FontFactory.getFont("NEUE_BOLD",BaseFont.CP1252, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
                section.setFont(normalFont);
                elm = tagB.text();
                section.add(elm);

            }
            else if(!tagI.isEmpty())
            {
                normalFont = FontFactory.getFont("NEUE_ITALIC",BaseFont.CP1252, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
                section.setFont(normalFont);
                elm = tagI.text();
                section.add(elm);
            }
            else if(!tagL.isEmpty())
            {
                Font symbol = FontFactory.getFont("NEUE", BaseFont.CP1252, BaseFont.EMBEDDED, 15, Font.NORMAL, new BaseColor(191, 0, 0));
                Font font = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,10,Font.NORMAL, EnumColor.GRAY.color);

                com.itextpdf.text.List lst = new com.itextpdf.text.List();
                Chunk chnk = new Chunk("\u2022 \t",symbol);
                lst.setListSymbol(chnk);
                for(Element li: tagL)
                {
                    lst.add(new ListItem(li.text(),font));
                }
                section.add(lst);

            }
            else
            {
                normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
                section.setFont(normalFont);
                section.add(elm);
            }


        }


        *//*normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
        section.setFont(normalFont);

        section.add(" (Content Management System) has been implemented which integrates security module, report generation " +
                "module, module of controlling VAS media contents, IVR calls monitoring system and control system of " +
                "SMS/USSD distribution. The System has been implemented for companies such as Beeline Kazakhstan, Beeline " +
                "Uzbekistan, Beeline Tajikistan, Ucell(COSCOM) Uzbekistan, BWC (ROSTELECOM) Russia, Tele2 Russia, ALTEL " +
                "(Almaty) Kazakhstan. • Entertainment/Service Portals(WAP/WEB Portals) has been designed and developed, " +
                "including high-loaded and real-time connection modules between users and billing systems of mobile operators. " +
                "The Portals (Web-Sites) has been developed for companies such as Tele2 Russia, Tele2 Estonia, Tele2 " +
                "Kazakhstan, Tonix Kazakhstan, Beeline Tajikistan, MTS Russia. • EPS (Electronic Payment System) has been " +
                "developed for multibank Internet payment system. The system allows to order multimedia contents to mobile-phone " +
                "in real-time. All developed modules have been integrated to the EPS station as knowns as CyberPlat " +
                "(http://www.cyberplat.com).");*//*


        cell1 = new PdfPCell(new Paragraph(" "));
        cell1.setBorder(Rectangle.NO_BORDER);
        cell1.setBorderWidthLeft(7f);
        cell1.setBorderColor(new BaseColor(191,0,0));

        cell2 = new PdfPCell();
        cell2.addElement(section);
        cell2.setBorder(Rectangle.NO_BORDER);
        cell2.setBorderWidthLeft(1f);
        cell2.setBorderColor(new BaseColor(191,0,0));

        cell2.setPadding(0);
        cell2.setPaddingLeft(8);
        cell2.setPaddingBottom(3);


        table.addCell(cell1);
        table.addCell(cell2);

        *//*END SECTION CONTENT*//*


        ////////////////////////////////////////////////
        section = new Paragraph(12);

        addEmptyLine(section, 2);

        boldFont = FontFactory.getFont("NEUE_BOLD",BaseFont.CP1252, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        section.setFont(boldFont);
        section.add("INTECH Inc. ");

        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,30,Font.NORMAL,new BaseColor(191,0,0));
        section.setFont(normalFont);
        section.add(".");

        boldFont = FontFactory.getFont("NEUE_BOLD",BaseFont.CP1252, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        section.setFont(boldFont);
        section.add(" Moscow");

        addEmptyLine(section, 1);

        normalFont = FontFactory.getFont("NEUE_ITALIC",BaseFont.CP1252, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(199,33,33));
        section.setFont(normalFont);
        section.add("Feb 2005 - August 2009");

        addEmptyLine(section, 1);

        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(88,88,91));
        section.setFont(normalFont);
        section.add("Lead Java Developer");

        cell1 = new PdfPCell(new Paragraph(" "));
        cell1.setBorder(Rectangle.NO_BORDER);
        cell1.setBorderWidthLeft(7f);
        cell1.setBorderColor(new BaseColor(191,0,0));

        cell2 = new PdfPCell();
        cell2.addElement(section);
        cell2.setBorder(Rectangle.NO_BORDER);
        cell2.setPadding(0);
        cell2.setPaddingBottom(5);

        table.addCell(cell1);
        table.addCell(cell2);

        *//*END HEADER CENTER*//*

        *//*HEADER CONTENT*//*

        section = new Paragraph(11);
        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
        section.setFont(normalFont);
        section.add("CMS (Content Management System) has been implemented which integrates security module, report generation " +
                "module, module of controlling VAS media contents, IVR calls monitoring system and control system of " +
                "SMS/USSD distribution. The System has been implemented for companies such as Beeline Kazakhstan, Beeline " +
                "Uzbekistan, Beeline Tajikistan, Ucell(COSCOM) Uzbekistan, BWC (ROSTELECOM) Russia, Tele2 Russia, ALTEL " +
                "(Almaty) Kazakhstan. • Entertainment/Service Portals(WAP/WEB Portals) has been designed and developed, " +
                "including high-loaded and real-time connection modules between users and billing systems of mobile operators. " +
                "The Portals (Web-Sites) has been developed for companies such as Tele2 Russia, Tele2 Estonia, Tele2 " +
                "Kazakhstan, Tonix Kazakhstan, Beeline Tajikistan, MTS Russia. • EPS (Electronic Payment System) has been " +
                "developed for multibank Internet payment system. The system allows to order multimedia contents to mobile-phone " +
                "in real-time. All developed modules have been integrated to the EPS station as knowns as CyberPlat " +
                "(http://www.cyberplat.com).");

        cell1 = new PdfPCell(new Paragraph(" "));
        cell1.setBorder(Rectangle.NO_BORDER);
        cell1.setBorderWidthLeft(7f);
        cell1.setBorderColor(new BaseColor(191,0,0));

        cell2 = new PdfPCell();
        cell2.addElement(section);
        cell2.setBorder(Rectangle.NO_BORDER);
        cell2.setBorderWidthLeft(1f);
        cell2.setBorderColor(new BaseColor(191,0,0));

        cell2.setPadding(0);
        cell2.setPaddingLeft(8);
        cell2.setPaddingBottom(3);

        table.addCell(cell1);
        table.addCell(cell2);

        *//*END SECTION CONTENT*//*


        ////////////////////////////////////////////////

        section = new Paragraph(12);


        addEmptyLine(section, 2);

        boldFont = FontFactory.getFont("NEUE_BOLD",BaseFont.CP1252, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        section.setFont(boldFont);
        section.add("INTECH Inc. ");

        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,30,Font.NORMAL,new BaseColor(191,0,0));
        section.setFont(normalFont);
        section.add(".");

        boldFont = FontFactory.getFont("NEUE_BOLD",BaseFont.CP1252, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        section.setFont(boldFont);
        section.add(" Moscow");

        addEmptyLine(section, 1);

        normalFont = FontFactory.getFont("NEUE_ITALIC",BaseFont.CP1252, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(199,33,33));
        section.setFont(normalFont);
        section.add("Feb 2005 - August 2009");

        addEmptyLine(section, 1);

        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(88,88,91));
        section.setFont(normalFont);
        section.add("Lead Java Developer");

        cell1 = new PdfPCell(new Paragraph(" "));
        cell1.setBorder(Rectangle.NO_BORDER);
        cell1.setBorderWidthLeft(7f);
        cell1.setBorderColor(new BaseColor(191,0,0));

        cell2 = new PdfPCell();
        cell2.addElement(section);
        cell2.setBorder(Rectangle.NO_BORDER);
        cell2.setPadding(0);
        cell2.setPaddingBottom(5);

        table.addCell(cell1);
        table.addCell(cell2);

        *//*END HEADER CENTER*//*

        *//*HEADER CONTENT*//*

        section = new Paragraph(11);
        normalFont = FontFactory.getFont("NEUE",BaseFont.CP1252, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
        section.setFont(normalFont);
        section.add("CMS (Content Management System) has been implemented which integrates security module, report generation " +
                "module, module of controlling VAS media contents, IVR calls monitoring system and control system of " +
                "SMS/USSD distribution. The System has been implemented for companies such as Beeline Kazakhstan, Beeline " +
                "Uzbekistan, Beeline Tajikistan, Ucell(COSCOM) Uzbekistan, BWC (ROSTELECOM) Russia, Tele2 Russia, ALTEL " +
                "(Almaty) Kazakhstan. • Entertainment/Service Portals(WAP/WEB Portals) has been designed and developed, " +
                "including high-loaded and real-time connection modules between users and billing systems of mobile operators. " +
                "The Portals (Web-Sites) has been developed for companies such as Tele2 Russia, Tele2 Estonia, Tele2 " +
                "Kazakhstan, Tonix Kazakhstan, Beeline Tajikistan, MTS Russia. • EPS (Electronic Payment System) has been " +
                "developed for multibank Internet payment system. The system allows to order multimedia contents to mobile-phone " +
                "in real-time. All developed modules have been integrated to the EPS station as knowns as CyberPlat " +
                "(http://www.cyberplat.com).");

        cell1 = new PdfPCell(new Paragraph(" "));
        cell1.setBorder(Rectangle.NO_BORDER);
        cell1.setBorderWidthLeft(7f);
        cell1.setBorderColor(new BaseColor(191,0,0));

        cell2 = new PdfPCell();
        cell2.addElement(section);
        cell2.setBorder(Rectangle.NO_BORDER);
        cell2.setBorderWidthLeft(1f);
        cell2.setBorderColor(new BaseColor(191,0,0));

        cell2.setPadding(0);
        cell2.setPaddingLeft(8);
        cell2.setPaddingBottom(3);


        table.addCell(cell1);
        table.addCell(cell2);

        *//*END SECTION CONTENT*//*

        *//*FOOTER SECTION*//*

        cell1 = new PdfPCell(new Paragraph(" "));
        cell1.setBorder(Rectangle.NO_BORDER);
        cell1.setBorderWidthLeft(7f);
        cell1.setBorderColor(new BaseColor(191,0,0));

        cell2 = new PdfPCell(new Paragraph(" "));

        cell2.setBorder(Rectangle.NO_BORDER);

        table.addCell(cell1);
        table.addCell(cell2);
*/
        //document.add(table);
        // Start a new page
        //document.newPage();
    }

    private static Image addImage(String url) throws BadElementException, IOException{
      Image image1 = Image.getInstance(url);
      //image1.setAbsolutePosition(404f, 645f);
      image1.setScaleToFitLineWhenOverflow(true);
      image1.setScaleToFitHeight(true);
      image1.scaleToFit(105,120);
      //image1.setSWidthPercentage(80);scaleToFit(160,200);//AbsoluteHeight(130);
      //image1.scaleAbsoluteWidth(130);
      return image1;
    }


    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(Chunk.NEWLINE);
        }
    }
}
