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

    private float size;
    private int style;
    private String encoding;
    private boolean emb;
    private EnumColor color;
    private EnumColor symColor = EnumColor.RED;

    public HTMLParser(){

    }

    public HTMLParser(String fontname, float size, int style, String encoding, boolean emb, EnumColor color)
    {
        super(fontname);
        this.size = size;
        this.style = style;
        this.encoding = encoding;
        this.emb = emb;
        this.color = color;
    }

    public HTMLParser(String fontname, float size, int style, String encoding, boolean emb, EnumColor color, EnumColor symColor)
    {
        super(fontname);
        this.size = size;
        this.style = style;
        this.encoding = encoding;
        this.emb = emb;
        this.color = color;
        this.symColor = symColor;
    }



    public Phrase parse(String str)
    {
        Font normalFont;
        org.jsoup.nodes.Document doc = Jsoup.parse(str);
        Phrase section = new Phrase(11);
        Elements tagB = doc.select("b");
        Elements tagI = doc.select("i");
        Elements tagU = doc.select("u");
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
            normalFont = FontStyle(this.getFontname()+"_BOLD",this.size,this.style, this.encoding, this.emb, this.color);
            section.setFont(normalFont);
            elm = tagB.text();
            section.add(elm);

        }
        else if (!tagI.isEmpty())
        {
            normalFont = FontStyle(this.getFontname()+"_ITALIC",this.size,this.style, this.encoding, this.emb, this.color);
            section.setFont(normalFont);
            elm = tagI.text();
            section.add(elm);
        }
        else if (!tagU.isEmpty())
        {
            normalFont = FontStyle(this.getFontname(),this.size,this.style, this.encoding, this.emb, this.color);
            section.setFont(normalFont);
            elm = tagU.text();
            Chunk underLine = new Chunk(elm);
            underLine.setUnderline(0.1f, -2f);
            section.add(underLine);
        }
        else if(!tagL.isEmpty())
        {
                Font symbol = FontFactory.getFont("FLORSN", BaseFont.IDENTITY_H, BaseFont.EMBEDDED,15,Font.NORMAL, symColor.color);
                Font font = FontStyle(this.getFontname(),this.size,this.style, this.encoding, this.emb, this.color);

                com.itextpdf.text.List lst = new com.itextpdf.text.List();
                Chunk chnk = new Chunk("\u2022 ",symbol);
                lst.setListSymbol(chnk);
                for(org.jsoup.nodes.Element li: tagL)
                {
                    lst.add(new ListItem(li.text(),font));
                }
                section.add(lst);
        }
        else
        {
            normalFont = FontStyle(this.getFontname(),this.size,this.style, this.encoding, this.emb, this.color);
            section.setFont(normalFont);
            section.add(elm);
        }

        return section;
    }
}
