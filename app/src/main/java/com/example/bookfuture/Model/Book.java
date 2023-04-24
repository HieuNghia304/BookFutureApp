package com.example.bookfuture.Model;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Book implements Serializable {
    private int bookId;
    private String nameBook;
    private String contentBook;
    private int priceBook;
    private int numberBook;
    private String authorBook;
    private int yearBook;
    private int pageBook;
    private Bitmap pathImage;

    public Book(int bookId, String nameBook, String contentBook, int priceBook, int numberBook, String authorBook, int yearBook, int pageBook, Bitmap pathImage) {
        this.bookId = bookId;
        this.nameBook = nameBook;
        this.contentBook = contentBook;
        this.priceBook = priceBook;
        this.numberBook = numberBook;
        this.authorBook = authorBook;
        this.yearBook = yearBook;
        this.pageBook = pageBook;
        this.pathImage = pathImage;
    }

    public Book(int bookId, String nameBook, int priceBook) {
        this.bookId = bookId;
        this.nameBook = nameBook;
        this.priceBook = priceBook;
    }

    public Bitmap getPathImage() {
        return pathImage;
    }

    public void setPathImage(Bitmap pathImage) {
        this.pathImage = pathImage;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getContentBook() {
        return contentBook;
    }

    public void setContentBook(String contentBook) {
        this.contentBook = contentBook;
    }

    public int getPriceBook() {
        return priceBook;
    }

    public void setPriceBook(int priceBook) {
        this.priceBook = priceBook;
    }

    public int getNumberBook() {
        return numberBook;
    }

    public void setNumberBook(int numberBook) {
        this.numberBook = numberBook;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public int getYearBook() {
        return yearBook;
    }

    public void setYearBook(int yearBook) {
        this.yearBook = yearBook;
    }

    public int getPageBook() {
        return pageBook;
    }

    public void setPageBook(int pageBook) {
        this.pageBook = pageBook;
    }
}
