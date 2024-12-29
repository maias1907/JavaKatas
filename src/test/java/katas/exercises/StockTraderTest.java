package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockTraderTest {
    @Test
    public void testMaxProfit() {
        // Test case 1: Normal case with prices {7, 1, 5, 3, 6, 4}
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        assertEquals(7, StockTrader2.maxProfit(prices1), "The maximum profit should be 7.");

        // Test case 2: No profit case with prices {7, 6, 4, 3, 1}
        int[] prices2 = {7, 6, 4, 3, 1};
        assertEquals(0, StockTrader2.maxProfit(prices2), "The maximum profit should be 0.");

        // Test case 3: Single price (No profit can be made) with prices {5}
        int[] prices3 = {5};
        assertEquals(0, StockTrader2.maxProfit(prices3), "The maximum profit should be 0.");

        // Test case 4: Prices with consecutive increases {1, 2, 3, 4, 5}
        int[] prices4 = {1, 2, 3, 4, 5};
        assertEquals(4, StockTrader2.maxProfit(prices4), "The maximum profit should be 4.");

        // Test case 5: Prices with single decrease followed by increase {10, 1, 5}
        int[] prices5 = {10, 1, 5};
        assertEquals(4, StockTrader2.maxProfit(prices5), "The maximum profit should be 4.");

        // Test case 6: Prices with no increase {5, 5, 5, 5, 5}
        int[] prices6 = {5, 5, 5, 5, 5};
        assertEquals(0, StockTrader2.maxProfit(prices6), "The maximum profit should be 0.");

        // Test case 7: Prices with random fluctuations {1, 7, 3, 5, 10, 2, 4}
        int[] prices7 = {1, 7, 3, 5, 10, 2, 4};
        assertEquals(13, StockTrader2.maxProfit(prices7), "The maximum profit should be 13.");
    }
}
