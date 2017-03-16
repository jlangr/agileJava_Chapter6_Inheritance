package sis.studentinfo;

import java.util.Date;

import static sis.studentinfo.DateUtil.createDate;

public class CourseSessionTest extends SessionTest {
   public void testCourseDates() {
      Date startDate = DateUtil.createDate(2003, 1, 6);
      Session session = createSession("ENGL", "200", startDate);
      Date sixteenWeeksOut = createDate(2003, 4, 25);
      assertEquals(sixteenWeeksOut, session.getEndDate());
   }

   public void testCount() {
      CourseSession.resetCount();
      createSession("", "", new Date());
      assertEquals(1, CourseSession.getCount());
      createSession("", "", new Date());
      assertEquals(2, CourseSession.getCount());
   }

   @Override
   protected Session createSession(String department, String number, Date date) {
      return CourseSession.create(department, number, date);
   }
}