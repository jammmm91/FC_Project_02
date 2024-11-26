package kr.book.search;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int price;
    private int sale_price;
    private String thumbnail;

    public Book() {

    }

    public Book(String title, String author, String publisher, int price, int sale_price, String thumbnail) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.sale_price = sale_price;
        this.thumbnail = thumbnail;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSale_price() {
        return sale_price;
    }

    public void setSale_price(int sale_price) {
        this.sale_price = sale_price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", sale_price=" + sale_price +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}


