package sol;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * You can run the main method in this class to print which tests have failed
 */
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Homework1CTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("all tests passed!");
        }
    }
}