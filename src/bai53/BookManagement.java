package bai53;

import java.util.Scanner;

public class BookManagement {
    private int n;
    Book books[];

    public BookManagement(int n) {
        this.n = n;
        Scanner sc=new Scanner(System.in);
        books=new Book[n];
        for (int i = 0; i <n ; i++) {
            System.out.println("-Nhap thong tin cho cuon sach thu "+(i+1)+": ");
            System.out.print("\t+Ten: ");
            String name=sc.nextLine();
            System.out.print("\t+Author: ");
            String author=sc.nextLine();
            System.out.print("\t+Gia ban: ");
            long price=sc.nextLong();
            System.out.print("\t+Tong so ban duoc: ");
            long total=sc.nextLong();
            sc.nextLine();
            books[i]=new Book(name,author,price,total);
        }
    }
    public int check(){
        int dem=0;
        for (int i = 0; i <n ; i++) {
            if(books[i].isbettesseller()){
                dem+=1;
            }
        }
        return dem;
    }
    public String BestBook(){
        Book banchay=books[0];
        for (int i = 0; i <n ; i++) {
            if(books[i].getTotalsold()>banchay.getTotalsold()){
                banchay=books[i];
            }
        }
        return banchay.toString();
    }
    public void showInfor(){
        for (int i = 0; i <n ; i++) {
            System.out.println("-Thong tin quyen sach thu "+(i+1)+" la: ");
            System.out.println(books[i].toString());
        }
        System.out.println("----------------------------------");
    }
}
