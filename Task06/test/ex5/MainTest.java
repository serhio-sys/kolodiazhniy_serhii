package ex5;
import ex2.NumberItem;
import ex2.ViewCalculation;
import ex3.ViewTable;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class MainTest {
    private static final ViewCalculation viewCalculation = new ViewCalculation();
    private static final MaxCommand max1 = new MaxCommand(viewCalculation);
    private static final MaxCommand max2 = new MaxCommand(viewCalculation);
    private static final MinCommand min1 = new MinCommand(viewCalculation);
    private static final MinCommand min2 = new MinCommand(viewCalculation);
    private final Random random = new Random();
    private static final CommandQueue queue = new CommandQueue();

    @BeforeClass
    public static void setUpBeforeClass() {
        assertEquals(10, viewCalculation.getItems().size());
    }

    @AfterClass
    public static void tearDownAfterClass() {
        assertEquals(max1.result, max2.result);
        assertEquals(min1.result, min2.result);
    }
    @Test
    public void testMax() throws Exception {
        max1.execute();
        assertEquals(viewCalculation.getItems().size(), max1.result.size());
    }

    @Test
    public void testMin() throws Exception {
        min1.execute();
        assertEquals(viewCalculation.getItems().size(), min1.result.size());
    }

    @Test
    public void testMaxQueue() {
        queue.put(max2);
        try {
            while (max2.isRun()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue.setShutdown();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            fail(e.toString());
        }
    }


    @Test
    public void testMinQueue() {
        queue.put(min2);
        try {
            while (min2.isRun()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue.setShutdown();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            fail(e.toString());
        }
    }
}
