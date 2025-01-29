package katas.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * DroneFly Inc. operates a fleet of drones for package deliveries. Each drone can carry only one package at a time.
 * Customers send requests with the delivery start time, delivery duration,
 * and the payment they are willing to make for the delivery.
 *
 * Your task is to help DroneFly Inc. maximize its profit by finding the best combination of delivery
 * requests that a single drone can fulfill.
 *
 * Requests are sorted by their start times. Here's a sample input file with 4 delivery requests:
 *
 *  REQ01 0 5 50
 *  REQ02 3 7 80
 *  REQ03 5 9 60
 *  REQ04 6 9 70
 *
 *  The best combination is REQ01 and REQ04, with a total payment of 50+70=120.
 */
public class Lags {

    /**
     * Represents a delivery request.
     */
    static class Request {
        String id;
        int startTime;
        int duration;
        int payment;

        public Request(String id, int startTime, int duration, int payment) {
            this.id = id;
            this.startTime = startTime;
            this.duration = duration;
            this.payment = payment;
        }
    }

    /**
     * Finds the maximum profit from a list of delivery requests that do not overlap.
     *
     * @param requests the list of delivery requests, sorted by start time
     * @return the maximum profit
     */
    public static int maximizeProfit(List<Request> requests) {
        return 0;
    }

    public static void main(String[] args) {
        List<Request> requests = new ArrayList<>();
        requests.add(new Request("REQ01", 0, 5, 50));
        requests.add(new Request("REQ02", 3, 7, 80));
        requests.add(new Request("REQ03", 5, 4, 60));
        requests.add(new Request("REQ04", 6, 3, 70));

        int maxProfit = maximizeProfit(requests);

        System.out.println("Maximum Profit: " + maxProfit); // Output: 120
    }
}


