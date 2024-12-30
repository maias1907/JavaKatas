package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockTraderTest {
    @Test
    public void testMaxProfit() {

            // Test Case 1: Normal scenario
            int[] prices1 = {7, 1, 5, 3, 6, 4};
            assertEquals(5, StockTrader.maxProfit(prices1), "The maximum profit should be 5.");

            // Test Case 2: Prices decrease continuously
            int[] prices2 = {7, 6, 5, 4, 3, 2, 1};
            assertEquals(0, StockTrader.maxProfit(prices2), "The maximum profit should be 0.");

            // Test Case 3: Prices increase continuously
            int[] prices3 = {1, 2, 3, 4, 5, 6, 7};
            assertEquals(6, StockTrader.maxProfit(prices3), "The maximum profit should be 6.");

            // Test Case 4: Single day (no transactions possible)
            int[] prices4 = {5};
            assertEquals(0, StockTrader.maxProfit(prices4), "The maximum profit should be 0.");

            // Test Case 5: Two days with decreasing prices
            int[] prices5 = {6, 4};
            assertEquals(0, StockTrader.maxProfit(prices5), "The maximum profit should be 0.");

            // Test Case 6: Two days with increasing prices
            int[] prices6 = {4, 6};
            assertEquals(2, StockTrader.maxProfit(prices6), "The maximum profit should be 2.");

            // Test Case 7: Large price difference
            int[] prices7 = {1, 100};
            assertEquals(99, StockTrader.maxProfit(prices7), "The maximum profit should be 99.");

            // Test Case 8: Prices with multiple ups and downs
            int[] prices8 = {3, 2, 6, 1, 4};
            assertEquals(4, StockTrader.maxProfit(prices8), "The maximum profit should be 4.");

            // Test Case 9: Repeated values
            int[] prices9 = {5, 5, 5, 5, 5};
            assertEquals(0, StockTrader.maxProfit(prices9), "The maximum profit should be 0.");
        }
}
