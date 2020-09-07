package lesson4.bai41;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LaptopService {
    private Connection connection;

    public LaptopService(Connection connection) {
        this.connection = connection;
    }

    public void getCounterByMaker() {
        Map<String, Integer> counters = new HashMap<>();
        String query = "SELECT maker,COUNT(maker) FROM store_cms_plusplus.laptop GROUP BY maker ORDER BY COUNT(maker) DESC ";
        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(query);
            while (data.next()) {
                String maker = data.getString(1);
                int quantity = data.getInt(2);
                counters.put(maker, quantity);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(counters.toString());
    }
}
