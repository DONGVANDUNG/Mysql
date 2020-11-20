package bai53;

public class Apptest {
    public static void main(String[] args) {
        BookManagement bookManagement=new BookManagement(3);
        bookManagement.showInfor();
        System.out.println("-Tong so sach besterseller la: "+bookManagement.check());
        System.out.println("-------------------------------------");
        System.out.println("-Thong tin cuon sach ban chay nhat la: "+bookManagement.BestBook());
    }
}
