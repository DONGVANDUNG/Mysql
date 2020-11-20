package lesson4.bai41;

import java.sql.Timestamp;
import java.util.List;

public class Counter {
    private String maker;
    private int quantity;

    public Counter(String maker, int quantity) {
        this.maker = maker;
        this.quantity = quantity;
    }

    public Counter() {
    }

    @Override
    public String toString() {
        return "Counter{" +
                "maker:" + maker +
                ", quantity=" + quantity + "}";
    }
}