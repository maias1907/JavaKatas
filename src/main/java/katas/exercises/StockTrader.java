package katas.exercises;

public class StockTrader {

    /**
     * Finds the maximum profit that can be achieved by buying and selling the stock ONCE.
     *
     * Aim for O(n)
     *
     * @param prices an array of prices on each day
     * @return the maximum profit, or 0 if no profit can be achieved
     */
    public static int maxProfit(int[] prices) {
        int i,maxProfit=0,lowBuy=prices[0];
        for(i=1;i<prices.length;i++)
        {
            if(prices[i]-lowBuy >maxProfit)
            {
                maxProfit=prices[i]-lowBuy;
            }
            if(prices[i]<lowBuy)
            {
                lowBuy=prices[i];
            }

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(stockPrices);
        System.out.println("Maximum Profit: " + profit);  // should be 5
    }
}
