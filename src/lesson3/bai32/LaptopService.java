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
        String query = "SELECT *FROM `laptop` WHERE TRUE";
        if (laptopEntity.getFromPrice() != null) {
            query = query + " AND `price`>=" + laptopEntity.getFromPrice();
        }
        if (laptopEntity.getToPrice() != null) {
            query = query + " AND `price`<=" + laptopEntity.getToPrice();
        }
        if (laptopEntity.getMaker() != null) {
            query = query + " AND `maker`='" + laptopEntity.getMaker() + "'";
        }
        if (laptopEntity.getScreen_size() != null) {
            query = query + " AND `screen_size`='" + laptopEntity.getScreen_size() + "'";
        }
        if (laptopEntity.getRam() != null) {
            query = query + " AND `ram`='" + laptopEntity.getRam() + "'";
        }
        if (laptopEntity.getType() != null) {
            query = query + " AND `type`='" + laptopEntity.getType() + "'";
        }
        if (laptopEntity.getCard() != null) {
            query = query + " AND `card`='" + laptopEntity.getCard() + "'";
        }
        if (laptopEntity.getSort() != null) {
            if (laptopEntity.getSort().equals("increase")) {
                query = query + " AND ORDER BY " + laptopEntity.getSort() + " ASC";
            } else if (laptopEntity.getSort().equals("decrease")) {
                query = query + " AND ORDER BY " + laptopEntity.getSort() + " DESC";
            }
        }
        System.out.println(query);

        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(query);
            while (data.next()) {
                laptopEntities.add(new LaptopEntity(
                        data.getInt("id"),
                        data.getString("name"),
                        data.getString("url"),
                        data.getString("maker"),
                        data.getString("type"),
                        data.getString("ram"),
                        data.getString("cpu"),
                        data.getString("ssd"),
                        data.getString("ssd"),
                        data.getLong("price"),
                        data.getString("screen_resolution"),
                        data.getString("screen_size"),
                        data.getInt("sold"),
                        data.getTimestamp("created_timestamp"),
                        data.getTimestamp("last_updated_timestamp"),
                        data.getString("card")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return laptopEntities;
    }
}
