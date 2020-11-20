package lesson3.bai32;

import java.sql.Timestamp;
import java.util.List;

public class LaptopEntity {
    private int id;
    private String name;
    private String url;
    private String maker;
    private String type;
    private String ram;
    private String cpu;
    private String ssd;
    private String hdd;
    private Long price;
    private String Screen_resolution;
    private String screen_size;
    private int sold;
    private Timestamp created_timestamp;
    private Timestamp last_updated_timestamp;
    private Long FromPrice;
    private Long toPrice;
    private String sort;
    private String card;

    public LaptopEntity(String maker, String screen_size, String ram, String cpu, String type, String card) {
        this.maker = maker;
        this.screen_size = screen_size;
        this.ram = ram;
        this.cpu = cpu;
        this.type = type;
        this.card = card;
    }

    public LaptopEntity(Long fromPrice, Long toPrice, String maker, String screen_size, String ram, String cpu, String type, String card) {
        this.id = id;
        this.maker = maker;
        this.type = type;
        this.ram = ram;
        this.cpu = cpu;
        this.screen_size = screen_size;
        FromPrice = fromPrice;
        this.toPrice = toPrice;
        this.card = card;
    }

    public LaptopEntity(int id, String name, String url, String maker, String type, String ram, String cpu, String ssd, String hdd, Long price, String screen_resolution, String screen_size, int sold, Timestamp created_timestamp, Timestamp last_updated_timestamp, String card) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.maker = maker;
        this.type = type;
        this.ram = ram;
        this.cpu = cpu;
        this.ssd = ssd;
        this.hdd = hdd;
        this.price = price;
        Screen_resolution = screen_resolution;
        this.screen_size = screen_size;
        this.sold = sold;
        this.created_timestamp = created_timestamp;
        this.last_updated_timestamp = last_updated_timestamp;
        this.card = card;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Long getFromPrice() {
        return FromPrice;
    }

    public void setFromPrice(Long fromPrice) {
        FromPrice = fromPrice;
    }

    public Long getToPrice() {
        return toPrice;
    }

    public void setToPrice(Long toPrice) {
        this.toPrice = toPrice;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getScreen_size() {
        return screen_size;
    }

    public void setScreen_size(String screen_size) {
        this.screen_size = screen_size;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "lesson4.bai41.LaptopService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", maker='" + maker + '\'' +
                ", type='" + type + '\'' +
                ", ram='" + ram + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ssd='" + ssd + '\'' +
                ", hdd='" + hdd + '\'' +
                ", price=" + price +
                ", Screen_resolution='" + Screen_resolution + '\'' +
                ", screen_size='" + screen_size + '\'' +
                ", sold=" + sold +
                ", created_timestamp=" + created_timestamp +
                ", last_updated_timestamp=" + last_updated_timestamp +
                ", FromPrice=" + FromPrice +
                ", toPrice=" + toPrice +
                ", sort='" + sort + '\'' +
                ", card='" + card + '\'' +
                '}';
    }
}
