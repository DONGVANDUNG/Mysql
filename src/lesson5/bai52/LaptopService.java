package lesson5.bai52;

import java.sql.*;

public class LaptopService {
    private Connection connection;

    public LaptopService(Connection connection) {
        this.connection = connection;
    }

    public void UpdateInfor(LaptopEntity laptop) {
        String query = "UPDATE store_cms_plusplus.laptop SET sold=" + laptop.getSold() + " WHERE id= " + laptop.getId();
        try {
            Statement statement = connection.createStatement();
            boolean result = statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String Query = "SELECT*FROM store_cms_plusplus.laptop WHERE id= " + laptop.getId();
        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(Query);
            while (data.next()) {
                int sold = data.getInt("sold");
                if (laptop.getSold() == sold) {
                    System.out.println("Update success to Database!!!");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
