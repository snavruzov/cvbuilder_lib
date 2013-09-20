/*import com.civi.pdf.patterns.beans.WorkExperience;
import com.civi.pdf.patterns.db.HibernateDao;
import com.civi.pdf.patterns.db.entity.CvDates;
import com.civi.pdf.patterns.db.entity.Settings;
import com.civi.pdf.patterns.db.entity.Users;
import com.itextpdf.tool.xml.parser.state.TagEncounteredState;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;*/

import com.civi.pdf.patterns.PdfPatterns;
import com.civi.pdf.patterns.api.PDFConfigRegister;
import com.civi.pdf.patterns.beans.EducationExperience;
import com.civi.pdf.patterns.beans.OtherExperience;
import com.civi.pdf.patterns.beans.WorkExperience;
import com.civi.pdf.patterns.db.HibernateDao;
import com.civi.pdf.patterns.db.entity.CvDates;
import com.civi.pdf.patterns.db.entity.Sections;
import com.civi.pdf.patterns.db.entity.Settings;
import com.civi.pdf.patterns.db.entity.Users;
import com.civi.pdf.patterns.enums.EnumPattern;
import com.civi.pdf.patterns.enums.EnumSection;
import com.civi.pdf.patterns.factory.ProcessPdtDesign;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User: Sardor Navruzov
 * Date: 9/14/13
 * Time: 5:48 PM
 */
public class StartPDF //extends HibernateDao
{
     public static void main(String[] args) {
        // Session session = getSessionFactory();

         PDFConfigRegister.init();
         PdfPatterns create = new ProcessPdtDesign();
         create.BuildPdfDesign(EnumPattern.STRONG_RED,5);

        /*try
        {
            session.beginTransaction();
            Query q = session.createQuery("from Users");

            Users users = (Users)q.list().get(0);


            CvDates cvDates = new CvDates();
            cvDates.setFullName("SardorNavruzov");
            cvDates.setAddress1("Uzbekistan");
            cvDates.setAddress2("Tashkent");
            cvDates.setAddress3("YunusAbad 8,4");
            cvDates.setEmail("sardor@mail.ru");
            cvDates.setJobTitle("Java Developer");
            cvDates.setPhones("9856565656");
            cvDates.setTitle("My CV");
            cvDates.setWebsite("www.test.ru");

            cvDates.setUsers(users);

            Sections sections = new Sections();

            List<WorkExperience> workExperiences = new ArrayList<WorkExperience>();
            List<EducationExperience> eduExperiences = new ArrayList<EducationExperience>();
            List<OtherExperience> otherExperiences = new ArrayList<OtherExperience>();
            List<OtherExperience> quaExperiences = new ArrayList<OtherExperience>();

            //First JOB
            WorkExperience workExperience = new WorkExperience();
            workExperience.setJobTitle("Developer");
            workExperience.setCompanyName("NASA");
            workExperience.setStartDate("12121212");
            workExperience.setEndDate("12121212");
            workExperience.setInformation("blablabl blalb");
            workExperiences.add(workExperience);

            //Second Job
            workExperience = new WorkExperience();
            workExperience.setJobTitle("Engineer");
            workExperience.setCompanyName("NASA");
            workExperience.setStartDate("12121212");
            workExperience.setEndDate("12121212");
            workExperience.setInformation("ssssslabl blalb");
            workExperiences.add(workExperience);

            //Education
            EducationExperience eduExperience = new EducationExperience();
            eduExperience.setInstitutionName("Harvard University");
            eduExperience.setCourseName("Computer Science");
            eduExperience.setStartDate("2013/01/01");
            eduExperience.setEndDate("2015/01/01");
            eduExperience.setInformation("||<b>CMS</b>|| ||<i>(Content Management System)</i>|| " +
                    "has been implemented which integrates security module, report generation " +
                    "module, module of controlling VAS media contents, IVR calls monitoring system " +
                    "and control system of " +
                    "SMS/USSD distribution. The Sy||<b>st</b>||em has been " +
                    "||<ul><li>implemented for</li> <li>companies</li> <li>such as</li></ul>|| " +
                    "Beeline Kazakhstan, Beeline " +
                    "Uzbekistan, Beeline Tajikistan, Ucell(COSCOM) Uzbekistan, BWC (ROSTELECOM) Russia.");
            eduExperiences.add(eduExperience);

            //Others
            OtherExperience otherExperience = new OtherExperience();
            otherExperience.setEntry("||<b>CMS</b>|| ||<i>(Content Management System)</i>|| " + "has been implemented which integrates security module, report generation " + "module, module of controlling VAS media contents, IVR calls monitoring system " + "and control system of " + "SMS/USSD distribution. The Sy||<b>st</b>||em has been " + "||<ul><li>implemented for</li> <li>companies</li> <li>such as</li></ul>|| " + "Beeline Kazakhstan, Beeline " + "Uzbekistan, Beeline Tajikistan, Ucell(COSCOM) Uzbekistan, BWC (ROSTELECOM) Russia.");
            otherExperiences.add(otherExperience);


            OtherExperience quaExperience = new OtherExperience();
            quaExperience.setEntry("||<ul><li>implemented for</li> <li>companies</li> <li>such as</li><li>such as</li></ul>||");
            quaExperiences.add(quaExperience);


            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(workExperiences);
            byte[] bytes = bos.toByteArray();


            sections.setSectionName("Work Experience");
            sections.setDates(cvDates);
            sections.setPosition(1);
            sections.setType(EnumSection.WORK.type);
            sections.setAttributes(bytes);
            session.save(sections);
            //===============================
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(eduExperiences);
            bytes = bos.toByteArray();

            sections = new Sections();
            sections.setSectionName("Education");
            sections.setDates(cvDates);
            sections.setPosition(2);
            sections.setType(EnumSection.EDUCATION.type);
            sections.setAttributes(bytes);
            session.save(sections);
            //===============================
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(otherExperiences);
            bytes = bos.toByteArray();

            sections = new Sections();
            sections.setSectionName("Skills");
            sections.setDates(cvDates);
            sections.setPosition(3);
            sections.setType(EnumSection.OTHER.type);
            sections.setAttributes(bytes);
            session.save(sections);
            //===============================
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(quaExperiences);
            bytes = bos.toByteArray();

            sections = new Sections();
            sections.setSectionName("Qualification");
            sections.setDates(cvDates);
            sections.setPosition(4);
            sections.setType(EnumSection.OTHER.type);
            sections.setAttributes(bytes);

            session.save(sections);

            //session.save(cvDates);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }*/


     }
}
