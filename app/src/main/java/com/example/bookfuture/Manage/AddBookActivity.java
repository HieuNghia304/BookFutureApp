package com.example.bookfuture.Manage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.bookfuture.Database.SQLCart;
import com.example.bookfuture.Fragment.CartFragment;
import com.example.bookfuture.MainActivity;
import com.example.bookfuture.Model.Book;
import com.example.bookfuture.Model.SelectedBook;
import com.example.bookfuture.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AddBookActivity extends AppCompatActivity {
    private DataBook dataBook;
    private ArrayList<Book> bookArrayList;
    private int idBook,idBill;
    private Book book;
    private TextView textViewName, textViewPrice, textViewNumber;
    private ImageView imageBook, backBookCart;
    Button btnAddCart, btnsubtraction, btnsummation, btnBuynow;
    private SQLCart sqlCart;
    private SelectedBook selectedBook;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        intiView();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Book book=(Book) bundle.getSerializable("AddBook");
            idBook = bundle.getInt("id");
            idBill = bundle.getInt("idBill");
        }
        for (Book b : bookArrayList) {
            if (b.getBookId() == idBook) {
                book = b;
                imageBook.setImageBitmap(book.getPathImage());
                textViewName.setText(book.getNameBook());
//                textViewPrice.setText(String.valueOf(book.getPriceBook()));
                //format số
                String number = String.valueOf(book.getPriceBook());
//                textViewPrice.setText(formatNumberCurrency(number));

                break;
            }
        }
//tang
        btnsummation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(textViewNumber.getText().toString().trim());
                textViewNumber.setText(String.valueOf(number + 1));
//                Intent intent1 = new Intent(AddBookActivity.this, MainActivity.class);
            }
        });

//        giam
        btnsubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(textViewNumber.getText().toString().trim());
                if (number > 1) {
                    textViewNumber.setText(String.valueOf(number - 1));
                } else {
                    Toast.makeText(AddBookActivity.this, "Số lượng sach phải lớn hơn 0", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnBuynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedBook = new SelectedBook(book, Integer.valueOf(textViewNumber.getText().toString().trim()));
                sqlCart.setListCartSQL(idBill, selectedBook);
                Toast.makeText(AddBookActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(AddBookActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        backBookCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddBookActivity.this, "Bỏ chọn thành công", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(AddBookActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }

    private void intiView() {
        dataBook = new DataBook(bookArrayList, AddBookActivity.this);
        bookArrayList = dataBook.getListBook();
        textViewName = findViewById(R.id.textName);
        textViewPrice = findViewById(R.id.textPrice);
        imageBook = findViewById(R.id.imageBook);
        textViewNumber = findViewById(R.id.numberBook);
        btnsubtraction = findViewById(R.id.btnsubtraction);
        btnsummation = findViewById(R.id.btnsummation);
        btnBuynow = findViewById(R.id.btnBuynow);
        backBookCart= findViewById(R.id.backBookCart);
        sqlCart = new SQLCart(AddBookActivity.this);
    }
    public static String formatNumberCurrency(String number){
        DecimalFormat format = new DecimalFormat("###.###");
        return format.format(Double.parseDouble(number));
    }
}
