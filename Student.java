package sol;

/**
 * A class that contains and operates with information about a student
 *
 * Uses the isTaking() method to determine whether a student takes a course
 * Uses the totalCredit() method to calculate the credit a student earns
 */
public class Student extends Person {

    private Course course1;
    private Course course2;

    /**
     * Constructs a Student object
     *
     * @param name - the name of the student
     * @param course1 - a course this student takes
     * @param course2 - another course this student takes
     * @throws IllegalArgumentException
     */
    public Student(String name, Course course1,Course course2) {
        this.name = name;
        this.course1 = course1;
        this.course2 = course2;
        // throws an IllegalArgumentException when the student's courses repeat
        if (this.course1 == this.course2) {
            throw new IllegalArgumentException("Invalid courses");
        }
    }

    /**
     * Determines whether a student is taking a given course
     *
     * @param course - a course
     * @return true if the given course is a course taken by the student;
     * false if not
     */
    public boolean isTaking(Course course) {
        return ((this.course1 == course) || (this.course2 == course));
    }

    /**
     * Calculates the total credit earned by a student
     *
     * @return a double value that is a student's credit number
     */
    public double totalCredits() {
        return this.course1.addCredits(this.course1, this.course2);
    }

    /**
     *
     * @param faculty
     * @return
     */
    public boolean canBeGraded(Faculty faculty) {
        return faculty.isTeaching(this.course1) ||
                faculty.isTeaching(this.course2);
    }

    /**
     *
     * @param course
     * @return
     */
    public boolean courseOverlap(Course course) {
        return ((this.course1 == course) || (this.course2 == course));
    }

}