package codes.victor;

/**
 * TransportOptimizer.java
 * TransportOptimizer calculates the number of daily, weekly and monthly ticket to buy.
 * Created by victor on 24/02/2017.
 */
class TransportOptimizer {
    private final static int DAILY_TICKET = 2;
    private final static int WEEKLY_TICKET = 7;
    private final static int MONTHLY_TICKET = 25;

    int calculate(int[] input) {
        int weeklyTicketCount = 0; // Number of weekly ticket bought.
        int dailyTicketCount = input.length; // First assume we only buy daily tickets, no weekly.

        int[] data = normalise(input); // Modify array shape from input to [1, 1, 0, 0, ...] for the 30 days.

        for(int i = 0; i < 30; i++) {
            if(data[i] == 1) {
                int count = 1;
                for(int j = 1; (j < (i + 7) && ((i + j) < 30)); j++) { // Try to find travel days within the week.
                    if(data[i + j] == 1) { count++; } // Increase counter if I travel on that day.
                }
                if((count * DAILY_TICKET) > WEEKLY_TICKET) { // If buying a weekly ticket is cheaper.
                    weeklyTicketCount++; // Buy weekly ticket.
                    dailyTicketCount -= count; // Reduce the number of daily ticket bought.
                    i += 7; // Do not go through the next 6 days.
                }
            }
        }

        return Integer.min((weeklyTicketCount * WEEKLY_TICKET) + (dailyTicketCount * DAILY_TICKET), MONTHLY_TICKET);
    }

    private int[] normalise(int[] data) {
        int a[] = new int[30];
        for(int i = 0; i < a.length - 1; i++) { a[i] = 0; }
        for(int element : data) { a[element - 1] = 1; }
        return a;
    }


}
