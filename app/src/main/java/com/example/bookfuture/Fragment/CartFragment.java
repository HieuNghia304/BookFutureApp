package com.example.bookfuture.Fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bookfuture.Adapter.BookAdapter;
import com.example.bookfuture.Adapter.CartAdapter;
import com.example.bookfuture.Conttroler.SenDataUpdateCart;
import com.example.bookfuture.Database.SQLCart;
import com.example.bookfuture.MainActivity;
import com.example.bookfuture.Manage.DataBook;
import com.example.bookfuture.Manage.PaymentActivity;
import com.example.bookfuture.Model.Book;
import com.example.bookfuture.Model.SelectedBook;
import com.example.bookfuture.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class CartFragment extends Fragment implements SenDataUpdateCart {
    private ArrayList<SelectedBook> selectedBookArrayList;
    private ArrayList<Book> bookArrayList;
    private CartAdapter cartAdapter;
    private RecyclerView recyclerView;
    Dialog dialog;
//    private ViewPager2 viewPager2;
    private View view;
    private MainActivity mainActivity;
    private SQLCart sqlCart;
    private DataBook dataBook;
    private TextView textViewTotalMoney;
    private Button buttonPayment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cart, container, false);
        mainActivity = (MainActivity) getActivity();
        initView();
        setListBookCart();
        buttonPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, PaymentActivity.class);
                intent.putExtra("total",textViewTotalMoney.getText().toString());
                startActivity(intent);
            }
        });
        return view;
    }

    //Hien book
    private void setListBookCart() {
        bookArrayList = dataBook.getListBook();
        selectedBookArrayList = sqlCart.getListCartSQL(mainActivity.ibBill);
        selectedBookArrayList = getSelectList();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mainActivity,
                1, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        cartAdapter = new CartAdapter(selectedBookArrayList,CartFragment.this);
        recyclerView.setAdapter(cartAdapter);

        textViewTotalMoney.setText(String.valueOf(getTotalMoney()));
    }

    private int getTotalMoney() {
        int total = 0;
        for (SelectedBook selectBook:selectedBookArrayList) {
            total += selectBook.getNumberOfSelectedBook() * selectBook.getPriceBook();
        }
        return total;
    }

    private void initView() {
        dataBook = new DataBook(bookArrayList,mainActivity);
        sqlCart = new SQLCart(mainActivity);
        textViewTotalMoney = view.findViewById(R.id.textTotalMoney);
        recyclerView = view.findViewById(R.id.recyclerViewCart);
        recyclerView.setHasFixedSize(true);
//        viewPager2 = view.findViewById(R.id.viewPager2Cart);
//        viewPager2.setVisibility(View.GONE);
        buttonPayment = view.findViewById(R.id.payment);
    }

    private ArrayList<SelectedBook> getSelectList() {
        ArrayList<SelectedBook> list = new ArrayList<>();
        for (SelectedBook selectBook:selectedBookArrayList) {
            for (Book book:bookArrayList) {
                if (selectBook.getBookId() == book.getBookId()) {
                    SelectedBook s = new SelectedBook(book,selectBook.getNumberOfSelectedBook());
                    list.add(s);
                }
            }
        }

        return  list;
    }

    @Override
     public void RemoveBookCart(ArrayList<SelectedBook> list, int position) {
        SelectedBook selectedBook = list.get(position);
        sqlCart.deleteListCartSQL(MainActivity.idBill,selectedBook);
        selectedBookArrayList = sqlCart.getListCartSQL(MainActivity.idBill);
        selectedBookArrayList = getSelectList();
        Toast.makeText(mainActivity, "Update lại giỏ hàng thành công", Toast.LENGTH_SHORT).show();
        setListBookCart();
    }

    @Override
    public void UpdateBookCart(ArrayList<SelectedBook> list, int position) {
        SelectedBook selectedBook = list.get(position);
        sqlCart.updateListBillSQL(MainActivity.idBill,selectedBook);
        selectedBookArrayList = sqlCart.getListCartSQL(MainActivity.idBill);
        selectedBookArrayList = getSelectList();
        Toast.makeText(mainActivity, "Update lại giỏ hàng thành công", Toast.LENGTH_SHORT).show();
        setListBookCart();
    }
}
