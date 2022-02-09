package sol;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class Homework1CTest {

    /**
     *
     */
    @Test
    public void testGradeLookup() {
        Course course1 = new Course("FREN", 100, 1.0);
        Course course2 = new Course("FREN", 200, 1.0);
        Course course3 = new Course("MATH", 180, 1.0);
        Course course4 = new Course("MATH", 520, 1.0);
        Course course5 = new Course("CSCI", 112, 1.0);
        Course course6 = new Course("CSCI", 200, 1.0);
        Course course7 = new Course("HIST", 105, 1.0);
        Course course8 = new Course("HIST", 574, 1.0);

        IGrade grade1 = new LetterGrade(Letter.A);
        IGrade grade2 = new LetterGrade(Letter.B);
        IGrade grade3 = new LetterGrade(Letter.NC);
        IGrade grade4 = new SNCGrade(SNC.S);
        IGrade grade5 = new SNCGrade(SNC.SDIST);

        Student student1 = new Student("Alicia", course2, course4);
        Student student2 = new Student("Shania", course3, course6);
        Student student3 = new Student("Rachel", course1, course4);
        Student student4 = new Student("Lia", course2, course7);
        Student student5 = new Student("Ava", course7, course8);
        Student student6 = new Student("Autumn", course1, course7);

        Faculty professor1 = new Faculty("Gaillard", "FREN");
        professor1.addToTeaching(course1);
        professor1.addToTeaching(course2);

        Faculty professor2 = new Faculty("Fisler", "CSCI");
        professor2.addToTeaching(course5);
        professor2.addToTeaching(course6);

        Faculty professor3 = new Faculty("Brokaw", "HIST");
        professor3.addToTeaching(course7);
        professor3.addToTeaching(course8);

        TA ta1 = new TA("Danna", course1, course3, course6);
        TA ta2 = new TA("Sarah", course2, course7, course6);
        TA ta3 = new TA("Cassie", course2, course6, course4);
        TA ta4 = new TA("Mia", course7, course8, course2);
        TA ta5 = new TA("Ella", course6, course7, course3);
        TA ta6 = new TA("Caitlyn", course2, course6, course7);

        GradeReport gradeReport1 = new GradeReport(student1, course2, grade4);
        GradeReport gradeReport2 = new GradeReport(student2, course3, grade1);
        GradeReport gradeReport3 = new GradeReport(student2, course6, grade3);
        GradeReport gradeReport4 = new GradeReport(student3, course1, grade2);
        GradeReport gradeReport5 = new GradeReport(student4, course7, grade4);
        GradeReport gradeReport6 = new GradeReport(student5, course7, grade1);
        GradeReport gradeReport7 = new GradeReport(student1, course4, grade1);
        GradeReport gradeReport8 = new GradeReport(student6, course7, grade1);

        LinkedList<GradeReport> gradebook = new LinkedList<GradeReport>();
        course1.addTo(gradeReport4);
        course2.addTo(gradeReport1);
        course3.addTo(gradeReport2);
        course4.addTo(gradeReport7);
        course6.addTo(gradeReport3);

        // how come the order changes the result; update success or fail?
        course7.addTo(gradeReport6);
        course7.addTo(gradeReport5);// Student: "Lia", Course: course7, Grade: S
        course7.addTo(gradeReport8);

        course1.updateGrade("Rachel", grade1);
        course7.updateGrade("Lia", grade2); // updating Lia's course7 grade to B

        Assert.assertEquals(course2.gradeLookup(ta4, "Alicia"), "S");
        Assert.assertEquals(course3.gradeLookup(ta5, "Shania"), "A");
        Assert.assertEquals(course4.gradeLookup(ta3, "Alicia"), "A");
        Assert.assertEquals(course6.gradeLookup(ta1, "Shania"), "NC");
        Assert.assertEquals(course6.gradeLookup(ta2, "Shania"), "NC");
        Assert.assertEquals(course1.gradeLookup(professor1, "Rachel"), "A");

        // course 7 issues: did not update
        Assert.assertEquals(course7.gradeLookup(ta6, "Ava"), "A");
        Assert.assertEquals(course7.gradeLookup(ta6, "Lia"), "B");

        Assert.assertEquals(course7.gradeLookup(professor3, "Ava"), "A");
        Assert.assertEquals(course7.gradeLookup(professor3, "Autumn"), "A");
        Assert.assertEquals(course7.gradeLookup(professor3, "Lia"), "B");


    }



}