package codes.victor;

/**
 * ParkingCalculator.java
 * ParkingCalculator calculates parking costs given:
 * - E which is the entry time in "HH:MM", and
 * - L which is the exit time in "HH:MM"
 * - E and L are always on the same day
 * - wrong input returns -1
 * <p>
 * Parking ticket prices are:
 * - entry fee of $2.
 * - first hour or part thereof of $3.
 * - subsequent hour or part thereof of $4.
 * <p>
 * Created by victor on 27/02/2017.
 */
class ParkingCalculator {
    private static final int ENTRY_FEE = 2;
    private static final int FIRST_HOUR_FEE = 3;
    private static final int SUBSEQUENT_HOUR_FEE = 4;

    int calculate(String E, String L) {
        int result = ENTRY_FEE;

        String entry = E.replace(":", "");
        String exit = L.replace(":", "");

        int numberOfHours = (int) Math.ceil(calculateHours(entry, exit));

        if (numberOfHours < 0) {
            return -1;
        }

        if (numberOfHours >= 1) {
            result = result + FIRST_HOUR_FEE;
            numberOfHours = numberOfHours - 1;
        }

        result = result + (numberOfHours * SUBSEQUENT_HOUR_FEE);

        return result;
    }

    private Double calculateHours(String entry, String exit) {
        Double entryHour = Double.valueOf(entry.substring(0, 2));
        Double entryMinute = Double.valueOf(entry.substring(2, 4));
        Double exitHour = Double.valueOf(exit.substring(0, 2));
        Double exitMinute = Double.valueOf(exit.substring(2, 4));

        if (exitMinute < entryMinute) {
            exitHour = exitHour - 1.0;
            exitMinute = exitMinute + 60.0;
        }

        return ((exitHour - entryHour) + ((exitMinute - entryMinute) / 60.0));
    }
}
