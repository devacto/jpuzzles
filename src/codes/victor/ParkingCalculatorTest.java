package codes.victor;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ParkingCalculatorTest.java
 * ParkingCalculatorTest tests ParkingCalculator.
 *
 * Created by victor on 27/02/2017.
 */
public class ParkingCalculatorTest {
    @Test
    public void simpleCalculation() throws Exception {
        ParkingCalculator c = new ParkingCalculator();
        assertEquals(5, c.calculate("10:00", "11:00"));
    }

    @Test
    public void halfHourCalculation() throws Exception {
        ParkingCalculator c = new ParkingCalculator();
        assertEquals(5, c.calculate("22:30", "23:00"));
    }

    @Test
    public void errorHandling() throws Exception {
        ParkingCalculator c = new ParkingCalculator();
        assertEquals(-1, c.calculate("09:00", "08:00"));
    }

    @Test
    public void moreThanOneHour() throws Exception {
        ParkingCalculator c = new ParkingCalculator();
        assertEquals(9, c.calculate("20:00", "21:21"));
    }
}