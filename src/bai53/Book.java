package bai53;

public class Book {
    private String name;
    private String author;
    private long price;
    private long totalsold;

    public Book(String name, String author, long price, long totalsold) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.totalsold = totalsold;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getTotalsold() {
        return totalsold;
    }

    public void setTotalsold(long totalsold) {
        this.totalsold = totalsold;
    }
    public boolean isbettesseller(){
        if(totalsold>1000){
           return true;
        }
        else
        return false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", totalsold=" + totalsold +
                '}';
    }
}

