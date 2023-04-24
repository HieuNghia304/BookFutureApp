package com.example.bookfuture.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bookfuture.Model.Account;
import com.example.bookfuture.Model.Bill;
import com.example.bookfuture.Model.Cart;
import com.example.bookfuture.Model.SelectedBook;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SQLCart {
    DBHeplper dtbH;

    public SQLCart(Context context) {
        dtbH = new DBHeplper(context);
    }

    public ArrayList<SelectedBook> getListCartSQL(int id) {
        ArrayList<SelectedBook> list = new ArrayList<>();
        SQLiteDatabase dtb = dtbH.getReadableDatabase();
        Cursor cs = dtb.rawQuery("SELECT * FROM Cart", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()) {
            try {
                int idBill = cs.getInt(0);
                int idBook = cs.getInt(1);
                String nameBook = cs.getString(2);
                int bookOfSelect = cs.getInt(3);
                int price  = cs.getInt(4);
                if (id == idBill) {
                    SelectedBook selectedBook = new SelectedBook(idBook,nameBook,price,bookOfSelect);
                    list.add(selectedBook);
                }
                cs.moveToNext();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
        cs.close();
        return list;
    }
    public boolean setListCartSQL(int idBill,SelectedBook selectedBook) {
        SQLiteDatabase db = dtbH.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("billId",idBill);
        values.put("bookId", selectedBook.getBookId());
        values.put("bookName",selectedBook.getNameBook());
        values.put("numberOfSelect",selectedBook.getNumberOfSelectedBook());
        values.put("price",selectedBook.getPriceBook());
        long r = db.insert("Cart", null, values);
        if (r <= 0) {
            return false;
        }
        return true;
    }
    public boolean updateListBillSQL(int idBill,SelectedBook selectedBook) {
        SQLiteDatabase db = dtbH.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("bookName",selectedBook.getNameBook());
        values.put("numberOfSelect",selectedBook.getNumberOfSelectedBook());
        values.put("price",selectedBook.getPriceBook());
        int r = db.update("Cart", values,"billId=? AND bookId=?",
                new String[]{String.valueOf(idBill),String.valueOf(selectedBook.getBookId())});
        if (r <= 0) {
            return false;
        }
        return true;
    }
    public boolean deleteListCartSQL(int idBill,SelectedBook selectedBook) {
        SQLiteDatabase db = dtbH.getWritableDatabase();
        int r = db.delete("Cart", "billId=? AND bookId=?",
                new String[]{String.valueOf(idBill),String.valueOf(selectedBook.getBookId())});
        if (r <= 0) {
            return false;
        }
        return true;
    }
}
