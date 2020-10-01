package lesson7.bai71;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ThueXeCms {
    private Connection connection;

    public ThueXeCms(Connection connection) {
        this.connection = connection;
    }

    //   #1  Liệt kê những dòng xe có số chỗ ngồi trên 5 chỗ
    public void Xe5Cho() {
        String query = "SELECT DISTINCT dongxe.DongXe FROM dongxe JOIN dangkycungcap ON dongxe.DongXe=dangkycungcap.DongXe WHERE sochongoi>5";
        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(query);
            System.out.println("-Dong Xe co 5 cho tro len la:");
            while (data.next()) {
                String dongxe = data.getString("DongXe");
                System.out.println("\t+" + dongxe);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //   #2  Liệt kê thông tin của các nhà cung cấp ĐÃ TỪNG đăng ký cung cấp những dòng xe
//thuộc hãng xe “Toyota” với mức phí có đơn giá là 15.000 VNĐ/km hoặc những dòng xe
//thuộc hãng xe “KIA” với mức phí có đơn giá là 20.000 VNĐ/km
    public void Dangkydongxe() {
        String query = "SELECT nhacungcap.MaNhaCC,nhacungcap.TenNhaCC" +
                ",nhacungcap.DiaChi,nhacungcap.SoDT,nhacungcap.masothue " +
                "FROM dangkycungcap JOIN nhacungcap" +
                " ON dangkycungcap.MaNhaCC=nhacungcap.MaNhaCC " +
                "JOIN dongxe ON dangkycungcap.DongXe=dongxe.DongXe JOIN " +
                "mucphi ON dangkycungcap.MaMP=mucphi.MaMP WHERE " +
                "((DonGia=15000 AND HangXe='Toyota') OR (DonGia=20000 AND HangXe='KIA'))";
        try {
            Statement statement = connection.createStatement();
            ResultSet car = statement.executeQuery(query);
            System.out.println("-Nhung loai xe co Don gia=15000 va Hang Xe la Toyota | Don Gia=20000 va Hang Xe la KIA: ");
            while (car.next()) {
                String ma = car.getString("MaNhaCC");
                String name = car.getString("TenNhaCC");
                String diachi = car.getString("DiaChi");
                String sodt = car.getString("SoDT");
                String masothue = car.getString("MaSoThue");
                System.out.println("\t+Ma Nha Cung Cap:" + ma);
                System.out.println("\t+Ten: " + name);
                System.out.println("\t+Dia Chi: " + diachi);
                System.out.println("\t+So Dien Thoai: " + sodt);
                System.out.println("\t+Ma So Thue: " + masothue);
                System.out.println("------------------------------------------------------");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //  #3  Liệt kê thông tin toàn bộ nhà cung cấp được sắp xếp tăng dần theo tên nhà cung
    //cấp và giảm dần theo mã số thuế
    public void SortNhaCungCap() {
        String query = "SELECT *FROM nhacungcap ORDER BY TenNhaCC ASC,MaSoThue DESC";
        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(query);
            System.out.println("-Thong tin tat ca cac nha cung cap: ");
            while (data.next()) {
                String ma = data.getString("MaNhaCC");
                String name = data.getString("TenNhaCC");
                String diachi = data.getString("DiaChi");
                String sodt = data.getString("SoDT");
                String masothue = data.getString("MaSoThue");
                System.out.println("\t+Ma Nha Cung Cap:" + ma);
                System.out.println("\t+Ten: " + name);
                System.out.println("\t+Dia Chi: " + diachi);
                System.out.println("\t+So Dien Thoai: " + sodt);
                System.out.println("\t+Ma So Thue: " + masothue);
                System.out.println("------------------------------------------------------");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //  #4 Đếm số lần đăng ký cung cấp phương tiện tương ứng cho từng nhà cung cấp với
    //yêu cầu chỉ đếm cho những nhà cung cấp thực hiện đăng ký cung cấp có ngày bắt đầu
    //cung cấp là “20/11/2015”
    public void CountNhaCungCap() {
        String query = "SELECT COUNT(dangkycungcap.MaNhaCC) FROM dangkycungcap JOIN nhacungcap ON " +
                "dangkycungcap.MaNhaCC=nhacungcap.MaNhaCC WHERE NgayBatDauCungCap='2015-11-20'";
        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(query);
            while (data.next()) {
                int amount = data.getInt(1);
                System.out.println("\t-So lan dang ky cung cap cua nhung nha cung cap co ngay bat dau cung cap la (20/11/2015): " + amount);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //  #5  Liệt kê tên của toàn bộ các hãng xe có trong cơ sở dữ liệu với yêu cầu mỗi hãng xe
    //chỉ được liệt kê một lần
    public void CountHangXe() {
        String query = "SELECT DISTINCT HangXe FROM thue_xe_cms.dongxe";
        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(query);
            System.out.println("-Cac hang xe co trong co so du lieu: ");
            while (data.next()) {
                String Hang = data.getString("HangXe");
                System.out.println("\t+" + Hang);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //  #6  Liệt kê MaDKCC, MaNhaCC, TenNhaCC, DiaChi, MaSoThue, TenLoaiDV, DonGia,
    //HangXe, NgayBatDauCC, NgayKetThucCC của tất cả các lần đăng ký cung cấp phương
    //tiện với yêu cầu những nhà cung cấp nào chưa từng thực hiện đăng ký cung cấp phương
    //tiện thì cũng liệt kê thông tin những nhà cung cấp đó ra
    public void InformationNhaCungCap() {
        String query = "SELECT dangkycungcap.MaDKCC,nhacungcap.MaNhaCC," +
                "nhacungcap.TenNhaCC,\n" +
                "nhacungcap.DiaChi,nhacungcap.MaSoThue,loaidichvu.TenLoaiDV" +
                ",mucphi.DonGia,dongxe.HangXe,\n" +
                "dangkycungcap.NgayBatDauCungCap,dangkycungcap.NgayKetThucCungCap" +
                " FROM dangkycungcap JOIN nhacungcap\n" +
                "ON dangkycungcap.MaNhaCC=nhacungcap.MaNhaCC JOIN mucphi" +
                " ON mucphi.MaMP=-dangkycungcap.MaMP\n" +
                "JOIN dongxe ON dongxe.DongXe=dangkycungcap.DongXe JOIN" +
                " loaidichvu ON loaidichvu.MaLoaiDV\n" +
                "=dangkycungcap.MaLoaiDV";
        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(query);
            System.out.println("-Thong tin cua cac nha cung cap trong nhung lan dang ky la: ");
            while (data.next()) {
                String MaDKCC = data.getString(1);
                String Manhacungcap = data.getString(2);
                String Tennhacungcap = data.getString(3);
                String diachi = data.getString(4);
                String masothue = data.getString(5);
                String tenloaidv = data.getString(6);
                System.out.println("\t+Ma dang ki cung cap; " + MaDKCC);
                System.out.println("\t+Ma nha cung cap: " + Manhacungcap);
                System.out.println("\t+Ten nha cung cap: " + Tennhacungcap);
                System.out.println("\t+Dia chi: " + diachi);
                System.out.println("\t+Ma so thue: " + masothue);
                System.out.println("\t+Ten loai dich vu: " + tenloaidv);
                System.out.println("--------------------------------------------------");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // #7 Liệt kê thông tin của các nhà cung cấp đã từng đăng ký cung cấp phương tiện
    //thuộc dòng xe “Hiace” hoặc từng đăng ký cung cấp phương tiện thuộc dòng xe “Cerato”
    public void InforNhaCC() {
        String query = "SELECT DISTINCT nhacungcap.MaNhaCC,nhacungcap.TenNhaCC,nhacungcap.DiaChi,nhacungcap.SoDT,\n" +
                "nhacungcap.MaSoThue FROM dangkycungcap JOIN nhacungcap\n" +
                " ON dangkycungcap.MaNhaCC=nhacungcap.MaNhaCC WHERE\n" +
                " dangkycungcap.DongXe='Hiace' OR dangkycungcap.DongXe='Cerato'";
        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(query);
            System.out.println("-Thong tin cac nha cung cap dang ky phuong tien thuoc dong xe Hiace hoac Cerato: ");
            while (data.next()) {
                String ma = data.getString("MaNhaCC");
                String name = data.getString("TenNhaCC");
                String diachi = data.getString("DiaChi");
                String sodt = data.getString("SoDT");
                String masothue = data.getString("MaSoThue");
                System.out.println("\t+Ma Nha Cung Cap:" + ma);
                System.out.println("\t+Ten: " + name);
                System.out.println("\t+Dia Chi: " + diachi);
                System.out.println("\t+So Dien Thoai: " + sodt);
                System.out.println("\t+Ma So Thue: " + masothue);
                System.out.println("------------------------------------------------------");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //#8  Liệt kê thông tin của các nhà cung cấp chưa từng thực hiện đăng ký cung cấp
    //phương tiện lần nào cả.
    public void InforNhaCCChuaDK() {
        String query = "SELECT NCC.MaNhaCC,NCC.TenNhaCC,NCC.DiaChi,NCC.SoDT,NCC.MaSoThue FROM nhacungcap AS NCC WHERE NOT EXISTS " +
                "(SELECT MaNhaCC FROM dangkycungcap AS DK WHERE DK.MaNhaCC=NCC.MaNhaCC)";
        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(query);
            System.out.println("-Thong tin cac nha cung cap chua tung dang ky phuong tien nao ca: ");
            while (data.next()) {
                String ma = data.getString("MaNhaCC");
                String name = data.getString("TenNhaCC");
                String diachi = data.getString("DiaChi");
                String sodt = data.getString("SoDT");
                String masothue = data.getString("MaSoThue");
                System.out.println("\t+Ma Nha Cung Cap:" + ma);
                System.out.println("\t+Ten: " + name);
                System.out.println("\t+Dia Chi: " + diachi);
                System.out.println("\t+So Dien Thoai: " + sodt);
                System.out.println("\t+Ma So Thue: " + masothue);
                System.out.println("------------------------------------------------------");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
