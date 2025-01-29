package katas.exercises.wallet;

public class Stock {
    private final int quantity;
    private final Utils.StockType type;

    public Stock(int quantity, Utils.StockType type) {
        this.quantity = quantity;
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public Utils.StockType getType() {
        return type;
    }
}