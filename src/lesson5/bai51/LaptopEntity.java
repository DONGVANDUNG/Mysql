package lesson5.bai51;

import java.sql.Connection;

public class LaptopEntity {
    private String name;
    private String url;
    private String maker;
    private String type;
    private String ram;
    private String ssd;

    public LaptopEntity(String name, String url, String maker, String type, String ram, String ssd) {
        this.name = name;
        this.url = url;
        this.maker = maker;
        this.type = type;
        this.ram = ram;
        this.ssd = ssd;
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

    @Override
    public String toString() {
        return "LaptopService{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", maker='" + maker + '\'' +
                ", type='" + type + '\'' +
                ", ram='" + ram + '\'' +
                ", ssd='" + ssd + '\'' +
                '}';
    }
}
