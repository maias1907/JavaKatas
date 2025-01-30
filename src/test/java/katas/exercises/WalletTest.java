package katas.exercises;

import katas.exercises.wallet.RateProvider;
import katas.exercises.wallet.Stock;
import katas.exercises.wallet.Utils.Currency;
import katas.exercises.wallet.Utils.StockType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static katas.exercises.wallet.Utils.StockType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WalletTest {

    private Wallet wallet;
    private RateProvider staticRateProvider;

    @BeforeEach
    void setUp() {
        // Implementing a static rate provider for testing
        staticRateProvider = new StaticRateProvider();

        // Initialize the wallet with some stocks
        wallet = new Wallet(List.of(
                new Stock(5, PETROLEUM),  // 5 units of Petroleum
                new Stock(2, BITCOIN),    // 2 Bitcoins
                new Stock(100, USD)       // 100 USD
        ));
    }

    @Test
    void testWalletValueInEUR() {
        double expectedValue = (5 * 0.149484) + (2 * 101374.43) + (100 * 0.96);
        double actualValue = wallet.value(Currency.EUR, staticRateProvider);

        assertEquals(expectedValue, actualValue, 0.01); // Allow small floating-point precision error
    }

    @Test
    void testWalletValueInUSD() {
        double expectedValue = (5 * 0.155173) + (2 * 105361.10) + (100 * 1.0);
        double actualValue = wallet.value(Currency.USD, staticRateProvider);

        assertEquals(expectedValue, actualValue, 0.01);
    }

    @Test
    void testWalletWithNoStocks() {
        Wallet emptyWallet = new Wallet(List.of());

        double valueInEUR = emptyWallet.value(Currency.EUR, staticRateProvider);
        double valueInUSD = emptyWallet.value(Currency.USD, staticRateProvider);

        assertEquals(0.0, valueInEUR);
        assertEquals(0.0, valueInUSD);
    }

    /**
     * A simple static implementation of RateProvider for testing
     */
    static class StaticRateProvider implements RateProvider {
        @Override
        public double rate(StockType from, Currency to) {
            if (to == Currency.EUR) {
                return switch (from) {
                    case PETROLEUM -> 0.149484;
                    case BITCOIN -> 101374.43;
                    case USD -> 0.96;
                    default -> 1.0;
                };
            } else {
                return switch (from) {
                    case PETROLEUM -> 0.155173;
                    case BITCOIN -> 105361.10;
                    case EURO -> (1 / 0.96);
                    default -> 1.0;
                };
            }
        }
    }
}
