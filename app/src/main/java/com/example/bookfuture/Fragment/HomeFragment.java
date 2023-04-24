package com.example.bookfuture.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookfuture.Adapter.BookAdapter;
import com.example.bookfuture.Adapter.PhotoAdapter;
import com.example.bookfuture.Conttroler.SenData;
import com.example.bookfuture.MainActivity;
import com.example.bookfuture.Manage.AddBookActivity;
import com.example.bookfuture.Manage.DataBook;
import com.example.bookfuture.Model.Book;
import com.example.bookfuture.Model.Photo;
import com.example.bookfuture.R;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import me.relex.circleindicator.CircleIndicator3;

public class HomeFragment extends Fragment implements SenData {

    ViewPager viewPager;
    CircleIndicator circleIndicator;
    private List<Photo> mListPhoto;

    private ArrayList<Book> bookArrayList;
    private BookAdapter bookAdapter;
    private RecyclerView recyclerView;
    private View view;
    private MainActivity mainActivity;
    private DataBook dataBook;

    private final static int timeDelay = 5000;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mRunable = new Runnable() {
        @Override
        public void run() {
            if(viewPager.getCurrentItem() == mListPhoto.size() - 1){
                viewPager.setCurrentItem(0);
            }else{
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        }
    };

    public HomeFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //anh xa photo
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        circleIndicator = view.findViewById(R.id.circle_indicator);

        mListPhoto = getListPhoto();
        PhotoAdapter photoAdapter = new PhotoAdapter(mListPhoto);
        viewPager.setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager);
        mHandler.postDelayed(mRunable,timeDelay);

        viewPager.addOnAdapterChangeListener(new ViewPager.OnAdapterChangeListener() {
            @Override
            public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter oldAdapter, @Nullable PagerAdapter newAdapter) {

            }
        });

        //Hien Sach
        mainActivity = (MainActivity) getActivity();
        dataBook = new DataBook(bookArrayList,(MainActivity)mainActivity);
        recyclerView = view.findViewById(R.id.recyclerView_home);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mainActivity,
                2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        bookAdapter = new BookAdapter(dataBook.getListBook(),HomeFragment.this);
        recyclerView.setAdapter(bookAdapter);

        return view;
    }

    // Hiện quảng cáo
    private List<Photo> getListPhoto() {
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.img1));
        list.add(new Photo(R.drawable.img2));
        list.add(new Photo(R.drawable.img3));
        list.add(new Photo(R.drawable.img4));
        return list;
    }
    //Vong doi photo
    @Override
    public void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mRunable);
    }
    @Override
    public void onResume() {
        super.onResume();
        mHandler.postDelayed(mRunable, 2000);
    }
    //Hiện Sách

    @Override
    public void addBook(ArrayList<Book> list, int poition) {
        Intent intent = new Intent(mainActivity, AddBookActivity.class);
        intent.putExtra("id",list.get(poition).getBookId());
        intent.putExtra("idBill",mainActivity.idBill);
        startActivity(intent);
    }

    /*@Override
    public void addBook(Book book) {
        Intent intent = new Intent(mainActivity,AddBookActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("addBook",book);
        bundle.putInt("idBill",);
        intent.putExtras(bundle);
        startActivity(intent);
    }*/
}