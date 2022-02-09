package sol;

/**
 * A class that contains information about letter grades
 *
 * Uses isPassing() to determine whether a grade on a grade report passes
 * Uses toString() to convert grade information into strings to return
 */
public class LetterGrade implements IGrade {

    Letter grade;

    /**
     * Constructs a LetterGrade grade
     *
     * @param grade - the letter grade on a grade report
     */
    public LetterGrade(Letter grade) {
        this.grade = grade;
    }

    /**
     * Determines whether the grade on a grade report is a passing grade
     *
     * @return true is the grade is passing (i.e. A, B, or C),
     * false if not (i.e. NC)
     */
    public boolean isPassing() {
        return this.grade != Letter.NC;
    }

    /**
     * Converts letter grades into strings
     *
     * @return the String representation of each letter grade
     */
    @Override
    public String toString() {
        switch(grade) {
            case A:
                return "A";
            case B:
                return "B";
            case C:
                return "C";
            case NC:
                return "NC";
            default:
                break;
        }
        return null;
    }

}
