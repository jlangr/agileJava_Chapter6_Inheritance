package sis.report;

import sis.studentinfo.CourseSession;
import sis.studentinfo.Session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static sis.report.ReportConstant.NEWLINE;

public class CourseReport {
   private List<Session> sessions =
         new ArrayList<Session>();

   public void add(Session session) {
      sessions.add(session);
   }

   public String text() {
      Collections.sort(sessions);
      StringBuilder builder = new StringBuilder();
      for (Session session : sessions)
         builder.append(
               session.getDepartment() + " " +
                     session.getNumber() + NEWLINE);
      return builder.toString();
   }
}