package lesson4.bai42;

public class Statistic {
    private String maker;
    private int quantity;
    private long totalMoney;

    public Statistic(String maker, long totalMoney, int quantity) {
        this.maker = maker;
        this.quantity = quantity;
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "maker='" + maker + '\'' +
                ", quantity=" + quantity +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
