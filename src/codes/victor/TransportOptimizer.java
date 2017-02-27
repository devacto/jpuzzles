package codes.victor;

/**
 * TransportOptimizer.java
 * TransportOptimizer
 * Created by victor on 24/02/2017.
 */
public class TransportOptimizer {


//    }

    public int solution(int[] A) {

        int weeklyTicketCount = 0;
        int dailyTicketCount = A.length;

        int dailyTicket = 2;
        int weeklyTicket = 7;
        int monthlyTicket = 30;

        // write your code in Java SE 8
        int[] normalisedData = normalise(A);

        int i = 0;
        while(i < 30) {
            int count = 0; // count number of 1;
            if(normalisedData[i] == 1) {
                count++;
                for(int j = 1; (j < (i + 7)) && ((i + j) < 30); j++) {
                    int toInspectIndex = i + j;
                    int toInspect = normalisedData[toInspectIndex];
                    if(toInspect == 1) { count++; }
                }
                int weeklyDailyCost = count * dailyTicket;
                if (weeklyDailyCost > weeklyTicket) {
                    weeklyTicketCount++; // buy weekly ticket
                    dailyTicketCount = dailyTicketCount - count;
                    i = i + 7;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        int totalCost = (weeklyTicketCount * weeklyTicket) + (dailyTicketCount * dailyTicket);
        if (totalCost < monthlyTicket) {
            return totalCost;
        } else {
            return monthlyTicket;
        }

    }

    private int[] normalise(int[] data) {
        int a[] = new int[30];

        for(int i = 0; i < a.length - 1; i++) {
            a[i] = 0;
        }

        for(int element : data) {
            a[element - 1] = 1;
        }

        return a;
    }


}
