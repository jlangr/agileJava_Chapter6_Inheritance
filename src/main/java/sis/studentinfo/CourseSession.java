package sis.studentinfo;

import java.util.*;

/**
 * This class provides a representation of a single-semester
 * session of a specific university course.
 * @author Administrator
 */
public class CourseSession implements Comparable<CourseSession> {
   private static int count;
   private String department;
   private String number;
   private List<Student> students = new ArrayList<Student>();
   private Date startDate;
   private int numberOfCredits;

   public static CourseSession create(
         String department,
         String number,
         Date startDate) {
      return new CourseSession(department, number, startDate);
   }

   /**
    * Constructs a CourseSession starting on a specific date
    * @param startDate the date on which the CourseSession begins
    */
   protected CourseSession(
         String department, String number, Date startDate) {
      this.department = department;
      this.number = number;
      this.startDate = startDate;
      CourseSession.incrementCount();
   }

   static private void incrementCount() {
      ++count;
   }

   static void resetCount() {
      count = 0;
   }

   static int getCount() {
      return count;
   }

   public int compareTo(CourseSession that) {
      int compare =
         this.getDepartment().compareTo(that.getDepartment());
      if (compare != 0)
         return compare;
      return this.getNumber().compareTo(that.getNumber());
   }

   void setNumberOfCredits(int numberOfCredits) {
      this.numberOfCredits = numberOfCredits;
   }

   public String getDepartment() {
      return department;
   }

   public String getNumber() {
      return number;
   }

   int getNumberOfStudents() {
      return students.size();
   }

   public void enroll(Student student) {
      student.addCredits(numberOfCredits);
      students.add(student);
   }

   Student get(int index) {
      return students.get(index);
   }

   protected Date getStartDate() {
      return startDate;
   }

   public List<Student> getAllStudents() {
      return students;
   }

	protected int getSessionLength() {
		return 16;
	}

   /**
    * @return Date the last date of the course session
    */
   public Date getEndDate() {
      GregorianCalendar calendar = new GregorianCalendar();
      calendar.setTime(getStartDate());
      final int sessionLength = 16;
      final int daysInWeek = 7;
      final int daysFromFridayToMonday = 3;
      int numberOfDays =
         getSessionLength() * daysInWeek - daysFromFridayToMonday;
      calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
      return calendar.getTime();
   }
}