package com.civi.pdf.patterns.factory;

import com.civi.pdf.patterns.PdfPatterns;
import com.civi.pdf.patterns.api.Constants;
import com.civi.pdf.patterns.db.HibernateDao;
import com.civi.pdf.patterns.db.entity.CvDates;
import com.civi.pdf.patterns.db.entity.Sections;
import com.civi.pdf.patterns.db.entity.Users;
import com.civi.pdf.patterns.enums.EnumPattern;
import com.civi.pdf.patterns.models.ModelFactory;
import com.civi.pdf.patterns.models.PdfContentCreator;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sardor
 * Date: 9/13/13
 * Time: 10:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProcessPdtDesign extends ModelFactory implements PdfPatterns{

    private final Document document = new Document();

    @Override
    public void BuildPdfDesign(EnumPattern pattern, Integer id) {
        synchronized (document)
        {
            Session session = getSessionFactory();
            try
            {
                session.beginTransaction();
                Query q = session.createQuery("from CvDates where id_cv=:id");
                q.setParameter("id",id);

                CvDates cv = (CvDates)q.list().get(0);

                q = session.createQuery("from Sections where dates.id_cv=:id order by position");
                q.setParameter("id",id);

                List<Sections> sections = (List<Sections>)q.list();


                q = session.createQuery("select count(*) from Sections where dates.id_cv=:id");
                q.setParameter("id",id);

                Long count = (Long)q.uniqueResult();


                PdfWriter writer  = PdfWriter.getInstance(document,
                        new FileOutputStream(Constants.FILE_PATH.concat(id.toString()+".pdf")));

                document.open();
                PdfContentByte canvas = writer.getDirectContentUnder();

                PdfContentCreator creator = new PdfContentCreator(pattern,sections,cv,canvas,document);
                creator.setCount(count);
                creator.init();

                session.getTransaction().commit();
            } catch (DocumentException e)
            {
                e.printStackTrace();
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            finally {
                {
                    document.close();
                    session.close();
                }
            }

        }


    }
}
