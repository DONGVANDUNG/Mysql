package lesson5.bai52;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("---------- MySQL JBDC Conection Demo-----------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
        System.out.println("MySQL JDBC Driver Registersed!");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store_cms_plusplus?characterEncoding=utf8", "root", "372001dung");
            System.out.println("SQP Conection to database established!");
        } catch (Exception e) {
            System.out.println("Connection  Failed!Check output console" + e);
            return;
        }
        Scanner sc = new Scanner(System.in);
        LaptopService laptopEntity = new LaptopService(connection);
        System.out.print("\t-Ban muon thay doi thong tin ban ghi thu: ");
        int id = sc.nextInt();
        System.out.print("\t\t+Ban muon thay doi Sold la: ");
        int sold = sc.nextInt();
        LaptopEntity laptop = new LaptopEntity(id, sold);
        laptopEntity.UpdateInfor(laptop);
    }
}


