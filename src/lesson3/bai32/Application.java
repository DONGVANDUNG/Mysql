package lesson3.bai32;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
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
        System.out.println("-Nhap vao nhung thong so ma ban muon tim kiem :");
        System.out.println("  +Price: ");
        System.out.print("\t+FromPrice(if not can input 0): ");
        Long fromprice = sc.nextLong();
        if (fromprice == 0) {
            fromprice = null;
        }
        System.out.print("\t+Toprice(if not can input 0) : ");
        Long toprice = sc.nextLong();
        if (toprice == 0) {
            toprice = null;
        }
        System.out.print("\t+Maker(if not can input 0) : ");
        sc.nextLine();
        String maker = sc.nextLine();
        if (maker.equals("0")) {
            maker = null;
        }
        System.out.print("\t+Screen_size(if not can input 0): ");
        String screen_size = sc.nextLine();
        if (screen_size.equals("0")) {
            screen_size = null;
        }
        System.out.print("\t+Ram(if not can input 0) : ");
        String ram = sc.nextLine();
        if (ram.equals("0")) {
            ram = null;
        }
        System.out.print("\t+Cpu(if not can input 0) : ");
        String cpu = sc.nextLine();
        if (cpu.equals("0")) {
            cpu = null;
        }
        System.out.print("\t+Type(if not can input 0) : ");
        String type = sc.nextLine();
        if (type.equals("0")) {
            type = null;
        }
        System.out.print("\t+Sort (increase/decrease) : ");
        String sort = sc.nextLine();
        if (sort.equals("0")) {
            sort = null;
        }
        System.out.print("\t+Card (if not can input 0): ");
        String card = sc.nextLine();
        if (card.equals("0")) {
            card = null;
        }
        LaptopEntity laptopEntity = new LaptopEntity(fromprice, toprice, maker, screen_size, ram, cpu, type, card);
        List<LaptopEntity> lap = laptopService.FindLaptop(laptopEntity);
    }
}