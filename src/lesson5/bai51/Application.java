package lesson5.bai51;

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
        LaptopService laptopService = new LaptopService(connection);
        System.out.println("-Moi ban them mot ban ghi moi!");
        System.out.print("\t+Name(if not can input 0): ");
        String name = sc.nextLine();
        if (name.equals("0")) {
            name = null;
        }
        System.out.print("\t+Maker(if not can input 0): ");
        String maker = sc.nextLine();
        if (maker.equals("0")) {
            maker = null;
        }
        System.out.print("\t+Url(if not can input 0): ");
        String url = sc.nextLine();
        if (url.equals("0")) {
            url = null;
        }
        System.out.print("\t+Type(if not can input 0): ");
        String type = sc.nextLine();
        if (type.equals("0")) {
            type = null;
        }
        System.out.print("\t+Ram(if not can input 0): ");
        String ram = sc.nextLine();
        if (ram.equals("0")) {
            ram = null;
        }
        System.out.print("\t+Ssd(if not can input 0): ");
        String ssd = sc.nextLine();
        if (ssd.equals("0")) {
            ssd = null;
        }
        LaptopEntity laptop = new LaptopEntity(name, maker, url, type, ram, ssd);
        laptopService.InsertInfor(laptop);
    }
}