package katas.exercises;

import katas.exercises.wallet.RateProvider;
import katas.exercises.wallet.Stock;
import katas.exercises.wallet.Utils.*;
import java.util.List;

import static katas.exercises.wallet.Utils.StockType.*;


/**
 * Represents a wallet containing stocks, where each stock has a quantity and type.
 * The wallet's total value in a given currency can be calculated using an external rate provider.
 *
 * Implement the RateProvider imterface to fetch REAL rates from external API:
 *     http://api.fixer.io/
 *
 * Use the Mockito package (https://site.mockito.org/) to test your wallet implementation without performing a real HTTP requests to the API
 * during test execution.
 */
public class Wallet {

    private final List<Stock> stocks;

    public Wallet(List<Stock> stocks) {

        this.stocks = stocks;
    }

    /**
     * Computes the total value of the wallet in a specified currency using a rate provider.
     *
     * @param currency the target currency
     * @param rateProvider the rate provider
     * @return the total value of the wallet in the specified currency
     */
    public double value(Currency currency, RateProvider rateProvider) {
        double totalVal=0;

        for(Stock s: stocks)
        {
            totalVal+=(s.getQuantity()*rateProvider.rate(s.getType(),currency));
        }

        return totalVal;
    }

    public static void main(String[] args) {

        // implementing static rate provider just for the test
        class StaticRateProvider implements RateProvider {
            @Override
            public double rate(StockType from, Currency to) {
                if(to==Currency.EUR) {
                    if (from == PETROLEUM) {

                        return 0.149484;
                    }
                    else if(from ==BITCOIN)
                    {
                        return 101374.43;
                    }
                    else if(from==USD)
                    {
                        return 0.96;
                    }
                    else{
                        return 1.0;
                    }
                }
                else{
                    if (from == PETROLEUM) {

                        return 0.155173;
                    }
                    else if(from ==BITCOIN)
                    {
                        return  105361.10;
                    }
                    else if(from==EURO)
                    {
                        return (1/0.96);
                    }
                    else{
                        return 1.0;
                    }
                }

            }

        }

        RateProvider staticRateProvider = new StaticRateProvider();

        Wallet wallet = new Wallet(List.of(
                new Stock(5, PETROLEUM),
                new Stock(2, BITCOIN),
                new Stock(100, USD)
        ));

        double walletValue = wallet.value(Currency.EUR, staticRateProvider);
        System.out.println("Total Wallet Value in EUR: " + walletValue);
    }
}

