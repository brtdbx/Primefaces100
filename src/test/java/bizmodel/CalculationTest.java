package bizmodel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculationTest {

    public CalculationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of doCalculation method, of class Calculation.
     */
    @Test
    public void testDoCalculationAdd() {
        System.out.println("doCalculation");
        Calculation instance = new Calculation();
        instance.setNumber1(10);
        instance.setNumber2(20);
        instance.doCalculation(Calculation.Operation.ADD);
        //assertEquals(30, instance.getResult());
        double expResult = 30.0;
        double result = instance.getResult();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testDoCalculationMultiply() {
        System.out.println("doCalculation");
        Calculation instance = new Calculation();
        instance.setNumber1(10);
        instance.setNumber2(20);
        instance.doCalculation(Calculation.Operation.MULTIPLY);
        double expResult = 200.0;
        double result = instance.getResult();
        assertEquals(expResult, result, 0.0);
    }

}
