package lesson3.bai33;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LaptopService3 {
    private Connection connection;

    public LaptopService3(Connection connection) {
        this.connection = connection;
    }

    public List<LaptopEntity3> findlaptopfromDB() {
        String query = "SELECT*FROM store_cms_plusplus WHERE sold  ";
        List<LaptopEntity3> lap = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet laptop = statement.executeQuery(query);
            while (laptop.next()) {
                lap.add(new LaptopEntity3(laptop.getInt(1), laptop.getString(2), laptop.getString(3), laptop.getString(4), laptop.getString(5), laptop.getString(6), laptop.getString(7), laptop.getString(8), laptop.getString(9), laptop.getLong(10), laptop.getString(11), laptop.getString(12), laptop.getInt(13), laptop.getString(14), laptop.getTimestamp(15), laptop.getTimestamp(16)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lap;
    }
    public List<LaptopEntity3> sort(){
        String query="SELECT*FROM store_cms_plusplus ORDER BY sold DESC";
        List<LaptopEntity3> lap=new ArrayList<>();
        try {
            Statement statement=connection.createStatement();
            ResultSet laptop=statement.executeQuery(query);
            while (laptop.next()){
                    lap.add(new LaptopEntity3(laptop.getInt(1), laptop.getString(2), laptop.getString(3), laptop.getString(4), laptop.getString(5), laptop.getString(6), laptop.getString(7), laptop.getString(8), laptop.getString(9), laptop.getLong(10), laptop.getString(11), laptop.getString(12), laptop.getInt(13), laptop.getString(14), laptop.getTimestamp(15), laptop.getTimestamp(16)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lap;
    }
}
