package sol;

/**
 * A class that contains information about SNC grades
 *
 * Uses isPassing() to determine whether a grade on a grade report passes
 * Uses toString() to convert grade information into strings to return
 */
public class SNCGrade implements IGrade {

    SNC grade;
    boolean pass;
    boolean passDistinction;

    /**
     * Constructs a SNCGrade grade
     *
     * @param grade - the SNC grade on a grade report
     */
    public SNCGrade(SNC grade) {
        if (grade == SNC.S) {
            this.pass = true;
            this.grade = SNC.S;
        }
        else if (grade == SNC.SDIST) {
            this.pass = true;
            this.passDistinction = true;
            this.grade = SNC.SDIST;
        }
        else {
            this.pass = false;
            this.passDistinction = false;
            this.grade = SNC.NC;
        }
    }

    /**
     * Determines whether the grade on a grade report is a passing grade
     *
     * @return true is the grade is passing (i.e. SDIST or S),
     * false if not (i.e. NC)
     */
    public boolean isPassing() {
        return this.pass;
    }

    /**
     * Converts letter grades into strings
     *
     * @return the String representation of each SNC grade
     */
    @Override
    public String toString() {
        switch(grade) {
            case SDIST:
                return "S*";
            case S:
                return "S";
            case NC:
                return "NC";
            default:
                break;
        }
        return null;
    }

}
