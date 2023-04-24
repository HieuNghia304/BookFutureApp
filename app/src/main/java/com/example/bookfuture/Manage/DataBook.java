package com.example.bookfuture.Manage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.bookfuture.MainActivity;
import com.example.bookfuture.Model.Book;

import java.io.IOException;
import java.util.ArrayList;

public class DataBook {
    private ArrayList<Book> list;
    private Context context;

    public DataBook(ArrayList<Book> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public ArrayList<Book> getListBook() {
        list = new ArrayList<>();
        try {
            String[] fileNames = context.getApplicationContext().getAssets().list("ImageBook");
            //ic_eagle.png
            String pathImage1 = "ImageBook" + "/" + fileNames[0];
            Bitmap bitmapImage1 = BitmapFactory.decodeStream(context.getApplicationContext().getAssets().open(pathImage1));
            list.add(new Book(1, "Tuổi trẻ đáng được bao nhiêu", "Cuộc sống", 68000, 0, "Hồng Sơn", 2020, 300, bitmapImage1));

            String pathImage2 = "ImageBook" + "/" + fileNames[1];
            Bitmap bitmapImage2 = BitmapFactory.decodeStream(context.getApplicationContext().getAssets().open(pathImage2));
            list.add(new Book(2, "Đừng lựa chọn An Nhàn Khi Còn Trẻ", "Cuộc sống", 58000, 0, "Hồng Sơn", 2020, 300, bitmapImage2));

            String pathImage3 = "ImageBook" + "/" + fileNames[2];
            Bitmap bitmapImage3 = BitmapFactory.decodeStream(context.getApplicationContext().getAssets().open(pathImage3));
            list.add(new Book(3,"Tôi Vẽ-Phương pháp tự vẽ","Cuộc sống",59000,0,"Hồng Sơn",2020,300,bitmapImage3));

            String pathImage4 = "ImageBook" + "/" + fileNames[3];
            Bitmap bitmapImage4 = BitmapFactory.decodeStream(context.getApplicationContext().getAssets().open(pathImage4));
            list.add(new Book(4,"Chuyện mèo dạy Hải Âu bay","Cuộc sống",40000,0,"Hồng Sơn",2020,300,bitmapImage4));

            String pathImage5 = "ImageBook" + "/" + fileNames[4];
            Bitmap bitmapImage5 = BitmapFactory.decodeStream(context.getApplicationContext().getAssets().open(pathImage5));
            list.add(new Book(5,"Nhà giả kim","Cuộc sống",50000,0,"Hồng Sơn",2020,300,bitmapImage5));

            String pathImage6 = "ImageBook" + "/" + fileNames[5];
            Bitmap bitmapImage6 = BitmapFactory.decodeStream(context.getApplicationContext().getAssets().open(pathImage6));
            list.add(new Book(6,"Tử huyệt cảm xúc","Cuộc sống",70000,0,"Hồng Sơn",2020,300,bitmapImage6));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
