package sol;

/**
 * A class that contains and operates with information about a TA
 *
 * Uses the viewGrade() method to show the grade on a given grade report
 */
public class TA extends Student implements StudentGraders {

    Course assisting;

    /**
     * Constructs a TA object
     *
     * @param name - the name of the TA
     * @param course1 - a course the TA takes
     * @param course2 - the other course the TA takes
     * @param assisting - the course the TA is assisting in
     * @throws IllegalArgumentException
     */
    public TA(String name, Course course1, Course course2, Course assisting) {
        super(name, course1, course2);
        this.assisting = assisting;
        // throws an IllegalArgumentException when the TA assists a class they
        // are taking
        if (this.courseOverlap(this.assisting)) {
            throw new IllegalArgumentException
                    ("Cannot take and assist the same course");
        }
    }

    /**
     * Shows the grade on a given grade report
     *
     * @param gradeReport - a grade report
     * @return the grade on the grade report as a string
     * @throws RuntimeException
     */
    public String viewGrade(GradeReport gradeReport) {
        // throws a RuntimeException when the TA does not assist the course
        // on the course report
        if (gradeReport.equalCourse(this.assisting)) {
            return gradeReport.gradeToString();
        }
        else{
            throw new RuntimeException("Access denied");
        }
    }

    /**
     *
     * @param gradeReport
     * @return
     */
    public boolean access(GradeReport gradeReport) {
        return gradeReport.equalCourse(this.assisting);
    }

}
