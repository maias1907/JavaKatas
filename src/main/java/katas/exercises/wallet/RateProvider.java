package katas.exercises.wallet;

public interface RateProvider {
    double rate(Utils.StockType from, Utils.Currency to);
}