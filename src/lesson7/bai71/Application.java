package lesson7.bai71;

import java.sql.Connection;
import java.sql.DriverManager;

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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thue_xe_cms?characterEncoding=utf8", "root", "372001dung");
            System.out.println("SQP Conection to database established!");
        } catch (Exception e) {
            System.out.println("Connection  Failed!Check output console" + e);
            return;
        }
        ThueXeCms thueXeCms = new ThueXeCms(connection);
        thueXeCms.Xe5Cho();
        System.out.println("-------------------------------------------------------");
        thueXeCms.Dangkydongxe();
        thueXeCms.SortNhaCungCap();
        thueXeCms.CountNhaCungCap();
        thueXeCms.CountHangXe();
        thueXeCms.InformationNhaCungCap();
        thueXeCms.InforNhaCC();
        thueXeCms.InforNhaCCChuaDK();
    }
}