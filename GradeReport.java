package sol;

import java.util.LinkedList;

/**
 * A class that contains information about a grade report
 */
public class GradeReport {

    private Student forStudent;
    private Course forCourse;
    private IGrade grade;

    /**
     * Constructs a GradeReport object
     *
     * @param forStudent - the student the grade report belongs to
     * @param forCourse - the course the grade report reports on
     * @param grade - the grade the grade reports records
     */
    public GradeReport(Student forStudent, Course forCourse, IGrade grade) {
        this.forStudent = forStudent;
        this.forCourse = forCourse;
        this.grade = grade;
    }

    /**
     *
     * @param name
     * @return
     */
    public boolean equalName(String name) {
        return (this.forStudent.name == name);
    }

    /**
     *
     * @param name
     * @param grade
     */
    public void newGrade(String name, IGrade grade) {
        if (this.forStudent.name == name) {
            this.grade = grade;
        }
    }

    /**
     *
     * @param courses
     * @return
     */
    public boolean inCourseList(LinkedList<Course> courses) {
        return courses.contains(this.forCourse);
    }

    /**
     *
     * @return
     */
    public String gradeToString() {
        return this.grade.toString();
    }

    /**
     *
     * @param course
     * @return
     */
    public boolean equalCourse(Course course) {
        return this.forCourse == course;
    }

}