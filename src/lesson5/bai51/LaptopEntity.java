package lesson5.bai51;

import lesson4.bai41.LaptopService;

import java.sql.*;
import java.util.ArrayList;
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
    private Connection connnection;

    public LaptopEntity(String name, String url, String maker, String type, String ram, String ssd) {
        this.name = name;
        this.url = url;
        this.maker = maker;
        this.type = type;
        this.ram = ram;
        this.ssd = ssd;
    }

    public LaptopEntity(Connection connnection) {
        this.connnection = connnection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getScreen_resolution() {
        return Screen_resolution;
    }

    public void setScreen_resolution(String screen_resolution) {
        Screen_resolution = screen_resolution;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public Timestamp getCreated_timestamp() {
        return created_timestamp;
    }

    public void setCreated_timestamp(Timestamp created_timestamp) {
        this.created_timestamp = created_timestamp;
    }

    public Timestamp getLast_updated_timestamp() {
        return last_updated_timestamp;
    }

    public void setLast_updated_timestamp(Timestamp last_updated_timestamp) {
        this.last_updated_timestamp = last_updated_timestamp;
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
        return "lesson4.bai41.LaptopEntity{" +
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

    public void InsertInfor(LaptopEntity laptop) {
        String query = "INSERT IGNORE INTO store_cms_plusplus.laptop " +
                "(name,maker,url,type,ram,ssd) VALUES(" +
                "'" + laptop.getName() + "','" +
                "" + laptop.getMaker() + "','" +
                "" + laptop.getUrl() + "','" +
                "" + laptop.getType() + "','" +
                "" + laptop.getRam() + "','" +
                "" + laptop.getSsd() + "')";
        try {
            Statement statement = connnection.createStatement();
            boolean data = statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String Query = "SELECT*FROM store_cms_plusplus.laptop";
        try {
            Statement statement = connnection.createStatement();
            ResultSet resultSet = statement.executeQuery(Query);
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                if (name.equals(laptop.getName())) {
                    System.out.println("------------------------------------------------------");
                    System.out.println("\tInsert success to DB");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
