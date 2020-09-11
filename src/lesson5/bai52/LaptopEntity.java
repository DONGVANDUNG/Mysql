package lesson5.bai52;

import java.sql.Connection;
import java.sql.Timestamp;

public class LaptopEntity {
    private int id;
    private int sold;
    private Timestamp created_timestamp;
    private Timestamp last_updated_timestamp;

    public LaptopEntity(int id, int sold) {
        this.id = id;
        this.sold = sold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
    @Override
    public String toString() {
        return "LaptopEntity{" +
                "id=" + id +
                ", sold=" + sold +
                ", created_timestamp=" + created_timestamp +
                ", last_updated_timestamp=" + last_updated_timestamp +
                '}';
    }
}
