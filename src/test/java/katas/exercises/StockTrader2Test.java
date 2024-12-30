package katas.exercises;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StockTrader2Test {

    @Test
    public void testMaxProfit() {
        // Test Case 1: Multiple transactions
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        assertEquals(7, StockTrader2.maxProfit(prices1));

        // Test Case 2: No profit (prices are decreasing)
        int[] prices2 = {7, 6, 4, 3, 1};
        assertEquals(0, StockTrader2.maxProfit(prices2));

        // Test Case 3: No profit (prices are constant)
        int[] prices3 = {5, 5, 5, 5, 5};
        assertEquals(0, StockTrader2.maxProfit(prices3));

        // Test Case 4: Single price, no transactions possible
        int[] prices4 = {10};
        assertEquals(0, StockTrader2.maxProfit(prices4));

        // Test Case 5: Prices are always increasing
        int[] prices5 = {1, 2, 3, 4, 5};
        assertEquals(4, StockTrader2.maxProfit(prices5));

        // Test Case 6: Prices are always decreasing
        int[] prices6 = {5, 4, 3, 2, 1};
        assertEquals(0, StockTrader2.maxProfit(prices6));

        // Test Case 7: Large array with multiple peaks and valleys
        int[] prices7 = {1, 3, 2, 4, 1, 5, 2, 6};
        assertEquals(12, StockTrader2.maxProfit(prices7));
    }
}
