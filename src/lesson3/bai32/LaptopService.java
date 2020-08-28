package lesson3.bai32;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LaptopService {
    private Connection connection;

    public LaptopService(Connection connection) {
        this.connection = connection;
    }

    public List<LaptopEntity> FindLaptop(LaptopEntity laptopEntity) {
        List<LaptopEntity> laptopEntities = new ArrayList<>();
        String query = "SELECT *FROM store_cms_plusplus";
        if (laptopEntity.getFromPrice() != null) {
            query = query + " WHERE price>=" + laptopEntity.getFromPrice();
        }
        if(laptopEntity.getFromPrice()==null){
            query=query+" WHERE";
        }
        if (laptopEntity.getToPrice() != null) {
            query = query + " price<=" + laptopEntity.getToPrice()+" AND";
        }
        if (laptopEntity.getMaker() != null) {
            query = query + " maker='" + laptopEntity.getMaker() + "' AND";
        }
        if (laptopEntity.getScreen_size() != null) {
            query = query + " screen_size='" + laptopEntity.getScreen_size() + "'  AND";
        }
        if (laptopEntity.getRam() != null) {
            query = query + " ram='" + laptopEntity.getRam() + "'  AND";
        }
        if (laptopEntity.getType() != null) {
            query = query + "  type='" + laptopEntity.getType() + "'  AND";
        }
        if (laptopEntity.getCard() != null) {
            query = query + " card='" + laptopEntity.getCard() + "'  AND";
        }
        if (laptopEntity.getSort().equals("increase")) {
            query = query + " ORDER BY " + laptopEntity.getSort() + " ASC";
        }
        if (laptopEntity.getSort().equals("decrease")) {
            query = query + " ORDER BY " + laptopEntity.getSort() + " DESC";
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(query);
            while (data.next()) {
                LaptopEntity LT = new LaptopEntity(data.getInt(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), data.getString(7), data.getString(8), data.getString(9), data.getLong(10), data.getString(11), data.getString(12), data.getInt(13), data.getTimestamp(14), data.getTimestamp(15), data.getString(16));
                laptopEntities.add(LT);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return laptopEntities;
    }
}
