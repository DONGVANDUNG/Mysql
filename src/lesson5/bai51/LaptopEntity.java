package lesson5.bai51;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaptopEntity {
    private String name;
    private String url;
    private String maker;
    private String type;
    private String ram;
    private String ssd;
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

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
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

    @Override
    public String toString() {
        return "LaptopEntity{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", maker='" + maker + '\'' +
                ", type='" + type + '\'' +
                ", ram='" + ram + '\'' +
                ", ssd='" + ssd + '\'' +
                ", connnection=" + connnection +
                '}';
    }
}


