package lesson5.bai51;

import java.sql.*;

public class LaptopService {
    private Connection connection;

    public LaptopService(Connection connection) {
        this.connection = connection;
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
            Statement statement = connection.createStatement();
            boolean data = statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String Query = "SELECT*FROM store_cms_plusplus.laptop";
        try {
            Statement statement =connection.createStatement();
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


