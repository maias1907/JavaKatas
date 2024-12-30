package katas.exercises;

import java.util.ArrayList;
import java.util.List;

public class StockTrader2 {


        int buy, sell;



    /**
     * Finds the maximum profit that can be achieved by buying and selling the stock MULTIPLE times.
     * The strategy is to buy at every local minimum and sell at the next local maximum.
     *
     * @param prices an array of prices on each day
     * @return the maximum profit that can be achieved
     */
    public static int maxProfit(int[] prices) {
        // Prices must be given for at least two days
        int n = prices.length,maxProfit=0;
        if (n == 1) {

            return 0;
        }

        int count = 0;
        // Solution array to store buy and sell intervals
        ArrayList<StockTrader2> sol = new ArrayList<>();

        // Traverse through the given price array
        int i = 0;
        while (i < n - 1) {
            // Find Local Minima (Buy point)
            while ((i < n - 1) && (prices[i + 1] <= prices[i])) {
                i++;
            }

            // If we reached the end, break as no further solution is possible
            if (i == n - 1) break;

            StockTrader2 e = new  StockTrader2();
            e.buy = i++; // Store the index of minima (buy point)

            // Find Local Maxima (Sell point)
            while ((i < n) && (prices[i] >= prices[i - 1])) {
                i++;
            }

            e.sell = i - 1; // Store the index of maxima (sell point)
            sol.add(e);

            // Increment the number of buy/sell pairs
            count++;
        }

        // Print the solution
        if (count == 0) {
            return 0;
        } else {
            for (int j = 0; j < count; j++) {
                maxProfit+=prices[sol.get(j).sell]-prices[sol.get(j).buy];

            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(stockPrices);
        System.out.println("Maximum Profit: " + profit);  // should be 7
    }
}
