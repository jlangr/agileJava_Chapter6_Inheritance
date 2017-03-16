package sis.summer;

import sis.studentinfo.DateUtil;
import sis.studentinfo.Session;
import sis.studentinfo.SessionTest;

import java.util.Date;

public class SummerCourseSessionTest extends SessionTest {
   public void testEndDate() {
      Date startDate = DateUtil.createDate(2003, 6, 9);
      Session session = SummerCourseSession.create("ENGL", "200", startDate);
      Date eightWeeksOut = DateUtil.createDate(2003, 8, 1);
      assertEquals(eightWeeksOut, session.getEndDate());
   }

   @Override
   protected Session createSession(String department, String number, Date date) {
      return SummerCourseSession.create(department, number, date);
   }
}