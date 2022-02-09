package sol;

import java.util.LinkedList;

/**
 * A class that contains and operates with information about a faculty
 *
 * Uses the isTeaching() method to determine whether a faculty teaches a course
 * Uses the canGrade() method to determine whether a faculty can grade a student
 * Uses the viewGrade() method to show the grade on a given grade report
 */
public class Faculty extends Person implements StudentGraders {

    private String department;
    private LinkedList<Course> teaching;

    /**
     * Constructs a Faculty object
     *
     * @param name - the name of the faculty
     * @param department - the department the faculty belongs to
     */
    public Faculty(String name, String department) {
        this.name = name;
        this.department = department;
        LinkedList<Course> teaching = new LinkedList<Course>();
        this.teaching = teaching;
    }

    /**
     * Determines whether a faculty is teaching a given course
     *
     * @param course - a course
     * @return true if the faculty is teaching the given course; false if not
     */
    public boolean isTeaching(Course course) {
        return this.teaching.contains(course);
    }

    /**
     * Determines whether a faculty can grade a given student through
     * determining if the faculty teaches a course this student takes
     *
     * @param student - a particular student
     * @return true if the faculty teaches a course taken by the given student;
     * false if not
     */
    public boolean canGrade(Student student) {
        return student.canBeGraded(this);
    }

    /**
     * Shows the grade on a given grade report
     *
     * @param gradeReport - a grade report
     * @return the grade on the grade report as a string
     * @throws RuntimeException
     */
    public String viewGrade(GradeReport gradeReport) {
        // throws a RuntimeException when the faculty does not teach the course
        // on the course report
        if (gradeReport.inCourseList(this.teaching)){
            return gradeReport.gradeToString();
        }
        else {
            throw new RuntimeException("Access denied");
        }
    }

    /**
     *
     * @param gradeReport
     * @return
     */
    public boolean access(GradeReport gradeReport) {
        return gradeReport.inCourseList(this.teaching);
    }

    /**
     *
     * @param course
     */
    public void addToTeaching(Course course) {
        this.teaching.add(course);
    }

}