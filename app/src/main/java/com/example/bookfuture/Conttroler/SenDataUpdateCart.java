package com.example.bookfuture.Conttroler;

import com.example.bookfuture.Model.SelectedBook;

import java.util.ArrayList;

public interface SenDataUpdateCart {
    public void RemoveBookCart(ArrayList<SelectedBook> list, int position);
    public void UpdateBookCart(ArrayList<SelectedBook> list, int position);
}
