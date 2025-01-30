package katas.exercises;

import org.junit.jupiter.api.Test;

import static katas.exercises.Lags.maximizeProfit;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class LagsTest {

    @Test
    void testMaxProfitBasicCase() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 5, 50));
        requests.add(new Lags.Request("REQ02", 3, 7, 80));
        requests.add(new Lags.Request("REQ03", 5, 4, 60));
        requests.add(new Lags.Request("REQ04", 6, 3, 70));

        int maxProfit = maximizeProfit(requests);
        int expectedProfit=120;
        assertEquals(expectedProfit, maximizeProfit(requests));
    }

    @Test
    void testNoOverlappingRequests() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add( new Lags.Request("REQ01", 0, 2, 30));
        requests.add(new Lags.Request("REQ02", 3, 2, 40));
        requests.add( new Lags.Request("REQ03", 6, 2, 50));





        int expectedProfit = 120; // REQ01 + REQ02 + REQ03 (All non-overlapping)
        assertEquals(expectedProfit, maximizeProfit(requests));
    }

    @Test
    void testAllOverlappingRequests() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 5, 50));
        requests.add(new Lags.Request("REQ02", 1, 4, 60));
        requests.add( new Lags.Request("REQ03", 2, 5, 70));
        int expectedProfit = 70; // Only REQ03 should be selected
        assertEquals(expectedProfit, maximizeProfit(requests));
    }

    @Test
    void testSingleRequest() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 2, 4, 100));



        int expectedProfit = 100; // Only one request
        assertEquals(expectedProfit, maximizeProfit(requests));
    }

    @Test
    void testEmptyRequestList() {
        List<Lags.Request> requests = new ArrayList<>();

        int expectedProfit = 0; // No requests, no profit
        assertEquals(expectedProfit, maximizeProfit(requests));
    }
}
