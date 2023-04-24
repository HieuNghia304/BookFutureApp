package com.example.bookfuture.Model;

import android.graphics.Bitmap;

public class SelectedBook extends Book {
    int numberOfSelectedBook;

    public SelectedBook(int bookId, String nameBook, String contentBook, int priceBook, int numberBook, String authorBook, int yearBook, int pageBook, Bitmap pathImage) {
        super(bookId, nameBook, contentBook, priceBook, numberBook, authorBook, yearBook, pageBook, pathImage);
    }


    public SelectedBook(int bookId, String nameBook, String contentBook, int priceBook, int numberBook, String authorBook, int yearBook, int pageBook, Bitmap pathImage, int numberOfSelectedBook) {
        super(bookId, nameBook, contentBook, priceBook, numberBook, authorBook, yearBook, pageBook, pathImage);
        this.numberOfSelectedBook = numberOfSelectedBook;
    }

    public SelectedBook(Book book,int numberOfSelectedBook) {
        super(book.getBookId(), book.getNameBook(), book.getContentBook(), book.getPriceBook(), book.getNumberBook(), book.getAuthorBook(), book.getYearBook(), book.getPageBook(), book.getPathImage());
        this.numberOfSelectedBook = numberOfSelectedBook;
    }

    public SelectedBook(int bookId, String nameBook, int priceBook, int numberOfSelectedBook) {
        super(bookId, nameBook, priceBook);
        this.numberOfSelectedBook = numberOfSelectedBook;
    }

    public int getNumberOfSelectedBook() {
        return numberOfSelectedBook;
    }

    public void setNumberOfSelectedBook(int numberOfSelectedBook) {
        this.numberOfSelectedBook = numberOfSelectedBook;
    }
}

