package com.tarena.entity;

import java.sql.Blob;
import java.sql.Date;

public class Admin_Book {
    private String isbn;// 图书编号
    private String title;// 书名
    private String author;// 作者
    private double price;// 价格
    private String press;// 出版社
    private int edition;// 版次
    private Date published;// 出版日期、时间
    private int pages;// 页数
    private int words;// 字数
    private String packaging;// 包装
    private String fromat;// 开本
    private String form;// 用纸

    @Override
    public String toString() {
        return "Admin_Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                ", edition=" + edition +
                ", published=" + published +
                ", pages=" + pages +
                ", words=" + words +
                ", packaging='" + packaging + '\'' +
                ", fromat='" + fromat + '\'' +
                ", form='" + form + '\'' +
                '}';
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public String getFromat() {
        return fromat;
    }

    public void setFromat(String fromat) {
        this.fromat = fromat;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}
