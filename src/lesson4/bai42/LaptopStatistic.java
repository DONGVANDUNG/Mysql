package lesson4.bai42;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LaptopStatistic {
    private Connection connection;

    public LaptopStatistic(Connection connection) {
        this.connection = connection;
    }
    public void getStatisticByMaker(){
        List<Statistic>statistics=new ArrayList<>();
        String query="SELECT maker,price,COUNT(maker) FROM store_cms_plusplus.laptop GROUP BY maker";
        try {
            Statement statement=connection.createStatement();
            ResultSet data=statement.executeQuery(query);
            while(data.next()){
                String maker=data.getString(1);
                long totalMoney=data.getLong(2);
                int quantity=data.getInt(3);
                statistics.add(new Statistic(maker,totalMoney*quantity,quantity));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(statistics.toString());
    }
}
