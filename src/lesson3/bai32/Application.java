package lesson3.bai32;

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
            Scanner sc = new Scanner(System.in);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store_cms_plusplus?characterEncoding=utf8", "root", "372001dung");
            System.out.println("SQP Conection to database established!");
            LaptopService laptopService = new LaptopService(connection);
            System.out.println("-Nhap vao nhung thong so ma ban muon tim kiem :");
            System.out.println("\t+Price: ");
            System.out.print("\t\t+FromPrice(if not can input 0): ");
            Long fromprice = sc.nextLong();
            if (fromprice.equals("0")) {
                fromprice = null;
            }
                System.out.print("Toprice(if not can input 0) : ");
                Long toprice = sc.nextLong();
                if (toprice.equals("0")) {
                    toprice = null;
                }
                System.out.print("\t+Maker(if not can input 0) : ");
                String maker = sc.next();
                if (maker.equals("0")) {
                    maker = null;
                }
                System.out.print("\t+Screen_size(if not can input 0: ");
                String screen_size = sc.next();
                if (screen_size.equals("0")) {
                    screen_size = null;
                }
                System.out.print("\t+Ram(if not can input 0) : ");
                String ram = sc.next();
                if (ram.equals("0")) {
                    ram = null;
                }
                System.out.print("\t+Cpu(if not can input 0) : ");
                String cpu = sc.next();
                if (cpu.equals("0")) {
                    cpu = null;
                }
                System.out.print("\t+Type(if not can input 0) : ");
                String type = sc.next();
                if (type.equals("0 ")) {
                    type = null;
                }
                System.out.print("\t+Sort (increase/decrease) : ");
                String sort = sc.next();
                System.out.print("\t+Card (if not can input 0): ");
                String card = sc.next();
                if (card.equals("0")) {
                    card = null;
                }
                LaptopEntity laptopEntity = new LaptopEntity(fromprice, toprice, maker, screen_size, ram, cpu, type, card);
                laptopService.FindLaptop(laptopEntity);
        } catch (Exception e) {
            System.out.println("Connection  Failed!Check output console" + e);
            return;
        }
    }
}