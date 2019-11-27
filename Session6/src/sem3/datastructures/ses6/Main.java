package sem3.datastructures.ses6;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {

    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(QueueTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        if(result.wasSuccessful())
            System.out.println("All tests succeeded!");
        else
            System.out.println("Some tests failed!");
    }
}
