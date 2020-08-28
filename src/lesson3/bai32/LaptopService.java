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
        if (laptopEntity.getToPrice() != null) {
            query = query + " AND price<=" + laptopEntity.getToPrice();
        }
        if (laptopEntity.getMaker() != null) {
            query = query + " AND maker='" + laptopEntity.getMaker() + "'";
        }
        if (laptopEntity.getScreen_size() != null) {
            query = query + " AND screen_size='" + laptopEntity.getScreen_size() + "'";
        }
        if (laptopEntity.getRam() != null) {
            query = query + " AND ram='" + laptopEntity.getRam() + "'";
        }
        if (laptopEntity.getType() != null) {
            query = query + " AND type='" + laptopEntity.getType() + "'";
        }
        if (laptopEntity.getSort().equals("increase")) {
            query = query + " AND ORDER BY " + laptopEntity.getSort() + " ASC";
        }
        if (laptopEntity.getSort().equals("decrease")) {
            query = query + " AND ORDER BY " + laptopEntity.getSort() + " DESC";
        }
        if (laptopEntity.getCard() != null) {
            query = query + " AND card='" + laptopEntity.getCard() + "'";
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
