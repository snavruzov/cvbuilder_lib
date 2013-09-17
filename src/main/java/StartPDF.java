import com.civi.pdf.patterns.beans.WorkExperience;
import com.civi.pdf.patterns.db.HibernateDao;
import com.civi.pdf.patterns.db.entity.CvDates;
import com.civi.pdf.patterns.db.entity.Settings;
import com.civi.pdf.patterns.db.entity.Users;
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
public class StartPDF  extends HibernateDao
{
     public static void main(String[] args) {
        /* Session session = getSessionFactory();

        try
        {
            session.beginTransaction();
            Query q = session.createQuery("from Users");

            Users users = (Users)q.list().get(0);



            *//*Settings settings = new Settings();
            settings.setApptype(1);
            settings.setEmail("mail@gmail.com");
            settings.setIsdelete(false);
            settings.setIssocial_auth(false);
            settings.setPassword("adasdasdfg");

            settings.setUsers(users);*//*

            CvDates cvDates = new CvDates();
            //cvDates.setFull_name("SardorNavruzov");
            *//*

            List<WorkExperience> workExperiences = new ArrayList<WorkExperience>();

            *//**//*First JOB*//**//*
            WorkExperience workExperience = new WorkExperience();
            workExperience.setJobTitle("Developer");
            workExperience.setCompanyName("NASA");
            workExperience.setStartDate("12121212");
            workExperience.setEndDate("12121212");
            workExperience.setInformation("blablabl blalb");
            workExperiences.add(workExperience);

            *//**//*Second Job*//**//*
            workExperience = new WorkExperience();
            workExperience.setJobTitle("Engineer");
            workExperience.setCompanyName("NASA");
            workExperience.setStartDate("12121212");
            workExperience.setEndDate("12121212");
            workExperience.setInformation("ssssslabl blalb");
            workExperiences.add(workExperience);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(workExperiences);
            byte[] bytes = bos.toByteArray();

            cvDates.setWork_attr(bytes);
            cvDates.setUsers(users);
*//*
            //Get image from database
            CvDates jobs = (CvDates)session.get(CvDates.class, 1);
            byte[] bJobs = jobs.getImage();

            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bJobs));
            try {
                @SuppressWarnings("unchecked")
                List<WorkExperience> list = (List<WorkExperience>)ois.readObject();
                System.out.println(list.get(0).getJobTitle()+" "+list.get(1).getJobTitle());
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
            finally {
                ois.close();
            }

            //session.save(cvDates);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }*/

         System.out.println();

     }
}
