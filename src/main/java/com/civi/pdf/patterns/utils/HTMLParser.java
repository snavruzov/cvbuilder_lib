package com.civi.pdf.patterns.utils;

import com.civi.pdf.patterns.enums.EnumColor;
import com.civi.pdf.patterns.models.ModelFactory;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

/**
 * Created by Intellij IDEA.
 * User: Sardor Navruzov
 * Date: 9/18/13
 * Time: 10:42 AM
 */
public class HTMLParser extends ModelFactory
{

    public HTMLParser(){

    }

    public static Phrase parse(String str)
    {
        Font normalFont;
        org.jsoup.nodes.Document doc = Jsoup.parse(str);
        Phrase section = new Phrase(11);
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
        if (!tagB.isEmpty())
        {
            normalFont = FontFactory.getFont("FLORSN_BOLD", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 10, Font.NORMAL, new BaseColor(88, 88, 91));
            section.setFont(normalFont);
            elm = tagB.text();
            section.add(elm);

        }
        else if (!tagI.isEmpty())
        {
            normalFont = FontFactory.getFont("FLORSN_ITALIC", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 10, Font.NORMAL, new BaseColor(88, 88, 91));
            section.setFont(normalFont);
            elm = tagI.text();
            section.add(elm);
        }
        else if(!tagL.isEmpty())
        {
                Font symbol = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,15,Font.NORMAL,new BaseColor(191,0,0));
                Font font = FontFactory.getFont("FLORSN",BaseFont.IDENTITY_H, BaseFont.EMBEDDED,10,Font.NORMAL, EnumColor.GRAY.color);

                com.itextpdf.text.List lst = new com.itextpdf.text.List();
                Chunk chnk = new Chunk("\u2022 \t",symbol);
                lst.setListSymbol(chnk);
                for(org.jsoup.nodes.Element li: tagL)
                {
                    lst.add(new ListItem(li.text(),font));
                }
                section.add(lst);

        }
        else
        {
            normalFont = FontFactory.getFont("FLORSN", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 10, Font.NORMAL, new BaseColor(88, 88, 91));
            section.setFont(normalFont);
            section.add(elm);
        }

        return section;
    }
}
