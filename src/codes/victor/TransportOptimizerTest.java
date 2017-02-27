package codes.victor;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * TransportOptimizerTest.java
 * TransportOptimizerTest tests TransportOptimizer class.
 * Created by victor on 24/02/2017.
 */
public class TransportOptimizerTest {
    @Test
    public void simpleCalculation() throws Exception {
        TransportOptimizer t = new TransportOptimizer();
        int[] a = new int[7];
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;
        a[3] = 5;
        a[4] = 7;
        a[5] = 29;
        a[6] = 30;
        assertEquals(11, t.calculate(a));
    }

}