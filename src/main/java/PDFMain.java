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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;


public class PDFMain {
    private static String FILE = "/home/sardor/Documents/PDF/test.pdf";

    public static void main(String[] args) {
        try {
            Document document = new Document();
            PdfWriter writer  = PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();

            PdfContentByte canvas = writer.getDirectContentUnder();
            colorRectangle(canvas, new BaseColor(236,236,236), 30, 682, 540, 135);
            colorRectangle(canvas, GrayColor.GRAY, 395, 645, 150, 150);
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

        Paragraph header = new Paragraph(12);
        FontFactory.register("/home/sardor/Documents/PDF/fonts/tt/Florsn01.ttf", "FLORSN");
        FontFactory.register("/home/sardor/Documents/PDF/fonts/tt/Florsn33.ttf", "FLORSN_BOLD");
        FontFactory.register("/home/sardor/Documents/PDF/fonts/tt/Florsn03.ttf", "FLORSN_ITALIC");

        Font boldFont = FontFactory.getFont("FLORSN_BOLD", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 35, Font.NORMAL, new BaseColor(191, 0, 0));
        Font normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,35,Font.NORMAL,new BaseColor(108,108,108));;

        addEmptyLine(header, 2);

        header.setIndentationLeft(30);
        header.setFont(boldFont);
        header.add("Sardor");
        header.setFont(normalFont);
        header.add("Navruzov");

        addEmptyLine(header, 2);

        boldFont = FontFactory.getFont("FLORSN_BOLD",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        header.setFont(boldFont);
        header.add("Java Developer");

        header.add(Chunk.NEWLINE);
        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
        header.setFont(normalFont);
        header.add("Uzbekistan ");

        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,30,Font.NORMAL,new BaseColor(191,0,0));
        header.setFont(normalFont);
        header.add(".");

        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
        header.setFont(normalFont);
        header.add(" Tashkent ");

        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,30,Font.NORMAL,new BaseColor(191,0,0));
        header.setFont(normalFont);
        header.add(".");

        normalFont = FontFactory.getFont("FLORSN_ITALIC",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
        header.setFont(normalFont);
        header.add(" Born on: 3/10/1987");

        addEmptyLine(header, 1);

        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
        header.setFont(normalFont);
        header.add("navruzov@gmail.com ");

        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,30,Font.NORMAL,new BaseColor(191,0,0));
        header.setFont(normalFont);
        header.add(".");

        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
        header.setFont(normalFont);
        header.add(" 998(94)6080716");

        addEmptyLine(header, 7);

        document.add(header);

        /*-------------------------------------------------------------------*/

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(103);
        float[] columnWidths = {0.1f, 2f};

        table.setWidths(columnWidths);

        /*HEADER SECTION*/

        Paragraph section = new Paragraph(12);

        boldFont = FontFactory.getFont("FLORSN_BOLD",BaseFont.IDENTITY_H,BaseFont.EMBEDDED,12,Font.NORMAL,new BaseColor(191,0,0));
        section.setFont(boldFont);
        section.add("Education:");

        addEmptyLine(section, 2);

        boldFont = FontFactory.getFont("FLORSN_BOLD",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        section.setFont(boldFont);
        section.add("National University of Uzbekistan ");

        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,30,Font.NORMAL,new BaseColor(191,0,0));
        section.setFont(normalFont);
        section.add(".");

        boldFont = FontFactory.getFont("FLORSN_BOLD",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        section.setFont(boldFont);
        section.add(" Tashkent");

        addEmptyLine(section, 1);

        normalFont = FontFactory.getFont("FLORSN_ITALIC",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(199,33,33));
        section.setFont(normalFont);
        section.add("September 2005 - July 2009");

        addEmptyLine(section, 1);

        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(88,88,91));
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

        /*END HEADER CENTER*/

        /*HEADER CONTENT*/

        section = new Paragraph(11);
        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
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

        /*END SECTION CONTENT*/

        /*FOOTER SECTION*/
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

        /*TABLE PADDING*/
        section = new Paragraph();
        addEmptyLine(section, 1);
        document.add(section);

        table = new PdfPTable(2);
        table.setWidthPercentage(103);

        table.setWidths(columnWidths);

        /*EDUCATION*/

        /*HEADER SECTION*/

        section = new Paragraph(12);

        boldFont = FontFactory.getFont("FLORSN_BOLD",BaseFont.IDENTITY_H,BaseFont.EMBEDDED,12,Font.NORMAL,new BaseColor(191,0,0));
        section.setFont(boldFont);
        section.add("Experience:");

        addEmptyLine(section, 2);

        boldFont = FontFactory.getFont("FLORSN_BOLD",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        section.setFont(boldFont);
        section.add("INTECH Inc. ");

        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,30,Font.NORMAL,new BaseColor(191,0,0));
        section.setFont(normalFont);
        section.add(".");

        boldFont = FontFactory.getFont("FLORSN_BOLD",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        section.setFont(boldFont);
        section.add(" Moscow");

        addEmptyLine(section, 1);

        normalFont = FontFactory.getFont("FLORSN_ITALIC",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(199,33,33));
        section.setFont(normalFont);
        section.add("Feb 2005 - August 2009");

        addEmptyLine(section, 1);

        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(88,88,91));
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

        /*END HEADER CENTER*/

        /*HEADER CONTENT*/

        List list = new List();
        section = new Paragraph(11);
        Chunk chunk = new Chunk("\u2022 \t",FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,15,Font.NORMAL,new BaseColor(191,0,0)));

        list.setListSymbol(chunk);

        list.add(new ListItem("Item 1"));
        section.add(list);


        list = new List();
        chunk = new Chunk("\u2022 \t",FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,15,Font.NORMAL,new BaseColor(191,0,0)));

        list.setListSymbol(chunk);

        list.add(new ListItem("Item 2"));
        section.add(list);

        addEmptyLine(section,2);

        String elem = "||<b>CMS</b>|| ||<i>(Content Management System)</i>|| has been implemented which integrates security module, report generation " +
                "module, module of controlling VAS media contents, IVR calls monitoring system and control system of " +
                "SMS/USSD distribution. The Sy||<b>st</b>||em has been ||<ul><li>implemented for</li> <li>companies</li> <li>such as</li></ul>|| Beeline Kazakhstan, Beeline " +
                "Uzbekistan, Beeline Tajikistan, Ucell(COSCOM) Uzbekistan, BWC (ROSTELECOM) Russia, Tele2 Russia, ALTEL " +
                "(Almaty) Kazakhstan. • Entertainment/Service Portals(||<b>WAP/WEB</b>|| Portals).";

        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
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
                normalFont = FontFactory.getFont("FLORSN_BOLD",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
                section.setFont(normalFont);
                elm = tagB.text();
                section.add(elm);

            }
            else if(!tagI.isEmpty())
            {
                normalFont = FontFactory.getFont("FLORSN_ITALIC",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
                section.setFont(normalFont);
                elm = tagI.text();
                section.add(elm);
            }
            else if(!tagL.isEmpty())
            {
                Font symbol = FontFactory.getFont("FLORSN", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 15, Font.NORMAL, new BaseColor(191, 0, 0));
                Font font = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,10,Font.NORMAL, EnumColor.GRAY.color);

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
                normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
                section.setFont(normalFont);
                section.add(elm);
            }


        }


        /*normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
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
                "(http://www.cyberplat.com).");*/


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

        /*END SECTION CONTENT*/


        ////////////////////////////////////////////////
        section = new Paragraph(12);

        addEmptyLine(section, 2);

        boldFont = FontFactory.getFont("FLORSN_BOLD",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        section.setFont(boldFont);
        section.add("INTECH Inc. ");

        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,30,Font.NORMAL,new BaseColor(191,0,0));
        section.setFont(normalFont);
        section.add(".");

        boldFont = FontFactory.getFont("FLORSN_BOLD",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        section.setFont(boldFont);
        section.add(" Moscow");

        addEmptyLine(section, 1);

        normalFont = FontFactory.getFont("FLORSN_ITALIC",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(199,33,33));
        section.setFont(normalFont);
        section.add("Feb 2005 - August 2009");

        addEmptyLine(section, 1);

        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(88,88,91));
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

        /*END HEADER CENTER*/

        /*HEADER CONTENT*/

        section = new Paragraph(11);
        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
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

        /*END SECTION CONTENT*/


        ////////////////////////////////////////////////

        section = new Paragraph(12);


        addEmptyLine(section, 2);

        boldFont = FontFactory.getFont("FLORSN_BOLD",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        section.setFont(boldFont);
        section.add("INTECH Inc. ");

        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,30,Font.NORMAL,new BaseColor(191,0,0));
        section.setFont(normalFont);
        section.add(".");

        boldFont = FontFactory.getFont("FLORSN_BOLD",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(108,108,108));
        section.setFont(boldFont);
        section.add(" Moscow");

        addEmptyLine(section, 1);

        normalFont = FontFactory.getFont("FLORSN_ITALIC",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(199,33,33));
        section.setFont(normalFont);
        section.add("Feb 2005 - August 2009");

        addEmptyLine(section, 1);

        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,11,Font.NORMAL,new BaseColor(88,88,91));
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

        /*END HEADER CENTER*/

        /*HEADER CONTENT*/

        section = new Paragraph(11);
        normalFont = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,10,Font.NORMAL,new BaseColor(88,88,91));
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

        /*END SECTION CONTENT*/

        /*FOOTER SECTION*/

        cell1 = new PdfPCell(new Paragraph(" "));
        cell1.setBorder(Rectangle.NO_BORDER);
        cell1.setBorderWidthLeft(7f);
        cell1.setBorderColor(new BaseColor(191,0,0));

        cell2 = new PdfPCell(new Paragraph(" "));

        cell2.setBorder(Rectangle.NO_BORDER);

        table.addCell(cell1);
        table.addCell(cell2);

        document.add(table);
        // Start a new page
        //document.newPage();
    }




    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(Chunk.NEWLINE);
        }
    }
}
