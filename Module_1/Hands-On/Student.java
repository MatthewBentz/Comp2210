/**
 * Student.java
 * A class to represent student data, for the
 * purpose of illustrating order by Comparable
 * and Comparator.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2017-09-06
 *
 */
public class Student implements Comparable<Student> {

   private String fname;
   private String lname;
   private int section;

   /** Creates a new student. */
   public Student(String last, String first, int sec) {
      lname = last;
      fname = first;
      section = sec;
   }

   /** Returns this student's first name. */
   public String getFirstName() {
      return fname;
   }

   /** Returns this student's last name. */
   public String getLastName() {
      return lname;
   }

   /** Returns this student's section. */
   public int getSection() {
      return section;
   }

   /**
    * Implement compareTo so that students are ordered in the
    * following way: in ascending order of last name, then in
    * ascending order of first name, and then in ascending order
    * of section.
    */
   @Override
   public int compareTo(Student s) {
      if (s.equals(null) || this.equals(null)) {
         throw new NullPointerException();
      }
      int LN = this.getLastName().compareTo(s.getLastName());
      if (LN != 0) {
         return LN;
      }
      int FN = this.getFirstName().compareTo(s.getFirstName());
      if (FN != 0) {
         return FN;
      }
      int SN = 0;
      if (this.getSection() < s.getSection()) {
         SN = -1;
      }
      if (this.getSection() > s.getSection()) {
         SN = 1;
      }
      return SN;
   }

   /** Returns a string representation of this student. */
   @Override
   public String toString() {
      return section + ", " + lname + ", " + fname;
   }
}
