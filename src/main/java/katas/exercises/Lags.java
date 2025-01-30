package katas.exercises;

import java.util.ArrayList;
import java.util.Comparator;
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
        int end;

        public Request(String id, int startTime, int duration, int payment) {
            this.id = id;
            this.startTime = startTime;
            this.duration = duration;
            this.end=startTime+duration;
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
        if(requests.isEmpty())
        {
            return 0;
        }
        requests.sort(Comparator.comparingInt(r -> r.end)); // Sort by end time

        int n = requests.size();
        int[] dp = new int[n];

        dp[0] = requests.get(0).payment;

        for (int i = 1; i < n; i++) {
            int includeProfit = requests.get(i).payment;
            int latestNonConflict = findLastNonConflicting(requests, i);
            if (latestNonConflict != -1) {
                includeProfit += dp[latestNonConflict];
            }
            dp[i] = Math.max(dp[i - 1], includeProfit);
        }

        return dp[n - 1];

    }
    private static int findLastNonConflicting(List<Request> requests, int index) {
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (requests.get(mid).end <= requests.get(index).startTime) {
                if (requests.get(mid + 1).end <= requests.get(index).startTime) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
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


