package sol;

import java.util.LinkedList;

/**
 * A class that contains and operates with information about a course
 *
 * Uses the toString() method to return information about a course,
 * specifically, its department and course code
 */
public class Course {

    private String department;
    private int courseNumber;
    private double credits;
    private LinkedList<GradeReport> gradebook;

    /**
     * Constructs a Course object
     *
     * @param department - the department the course belongs to
     * @param courseNumber - the course code of the course
     * @param credits - the credit value of the course
     * @throws IllegalArgumentException
     */

    public Course(String department, int courseNumber, double credits) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.credits = credits;
        // throws an IllegalArgumentException when the credit is not a valid value for a course
        if ((this.credits != 0.5) &&
                (this.credits != 1.0) && (this.credits != 1.5)) {
            throw new IllegalArgumentException("Invalid credits");
        }
        this.gradebook = new LinkedList<GradeReport>();
    }

    /**
     * Constructs a Course object with the fixed credit value of 1.0
     *
     * @param department - the department the course belongs to
     * @param courseNumber - the course code of the course
     */
    public Course(String department, int courseNumber) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.credits = 1.0;
    }

    /**
     * Returns department and course number information of a Course object as a
     * String
     *
     * @return a String combining a Course object's department and course number
     * information
     */
    @Override
    public String toString() {
        return this.department + this.courseNumber;
    }

    /**
     *
     * @param student
     * @param grade
     * @return
     */
    public void storeGrade
    (Student student, IGrade grade) {
        this.gradebook.add(new GradeReport(student, this, grade));
    }

    /**
     *
     * @param name
     * @return
     */
    private GradeReport findGradeReport(String name) {
        for (GradeReport gradeReport : this.gradebook) {
            if (gradeReport.equalName(name)) {
                return gradeReport;
            }
        }
        return null;
    }

    /**
     *
     * @param name
     * @param grade
     */
    public void updateGrade(String name, IGrade grade) {
        for (GradeReport gradeReport : this.gradebook) {
            gradeReport.newGrade(name, grade);
            return;
        }
        throw new RuntimeException("no grade for student");
    }

    /**
     *
     * @param profOrTa
     * @param name
     * @return
     */
    public String gradeLookup(StudentGraders profOrTa, String name) {
        for (GradeReport gradeReport : this.gradebook) {
            if (gradeReport.equalName(name)) {
                if (profOrTa.access(gradeReport)) {
                    return gradeReport.gradeToString();
                }
                else {
                    throw new RuntimeException("permission denied");
                }
            }
        }
        throw new RuntimeException("student " + name.toString() +" not found");
    }

    /**
     *
     * @return
     */
    public LinkedList<GradeReport> reportsWithC() {
        LinkedList<GradeReport> inTrouble = new LinkedList<GradeReport>();
        for (GradeReport gradeReport : this.gradebook) {
            if (gradeReport.gradeToString() == "C") {
                inTrouble.add(gradeReport);
            }
        }
        return inTrouble;
    }

    /**
     *
     * @param gradeReport
     */
    public void addTo(GradeReport gradeReport) {
        this.gradebook.add(gradeReport);
    }

    /**
     *
     * @param course1
     * @param course2
     * @return
     */
    public double addCredits(Course course1, Course course2) {
        return course1.credits + course2.credits;
    }

}