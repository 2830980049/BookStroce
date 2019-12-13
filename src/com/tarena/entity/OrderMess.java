package com.tarena.entity;

public class OrderMess {
    private String order_id;
    private String title;//'标题（书名）',
    private String isbn;
    private double price;// '价格',
    private String press;//'出版社',
    private int edition;//'版次',
    private int count;//数量

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderMess{" +
                "order_id='" + order_id + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                ", edition=" + edition +
                ", count=" + count +
                '}';
    }
}
