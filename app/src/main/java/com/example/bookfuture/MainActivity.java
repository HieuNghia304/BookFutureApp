package com.example.bookfuture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.bookfuture.Adapter.PhotoAdapter;
import com.example.bookfuture.Database.SQLBill;
import com.example.bookfuture.Fragment.AccountFragment;
import com.example.bookfuture.Fragment.CartFragment;
import com.example.bookfuture.Fragment.HomeFragment;
import com.example.bookfuture.Fragment.SearchFragment;
import com.example.bookfuture.Model.Bill;
import com.example.bookfuture.Model.Photo;
import com.example.bookfuture.R;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {
    public static String userName;
    public static String passWord;
    public int ibBill;
    private int key = 0;
    private ArrayList<Bill> billArrayList;
    private SQLBill sqlBill;
    public static int idBill;
    BottomNavigationView mnBottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mnBottom = findViewById(R.id.navMenu);
        loadFragment(new HomeFragment());
        mnBottom.setOnItemSelectedListener(getListener());
        billArrayList = new ArrayList<>();
        sqlBill = new SQLBill(MainActivity.this);
        billArrayList = sqlBill.getListBillSQL();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId()== android.R.id.home)
        {
            finish();
            return true;
        }
        return true;

    }

    @NonNull
    private NavigationBarView.OnItemSelectedListener getListener() {
        return new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fmNew;
                switch (item.getItemId()) {
                    case R.id.menuHome:
                        fmNew = new HomeFragment();
                        loadFragment(new HomeFragment());
                        return true;
                    case R.id.menuSeach:
                        fmNew = new SearchFragment();
                        loadFragment(new SearchFragment());
                        return true;
                    case R.id.menuAccount:
                        fmNew = new AccountFragment();
                        loadFragment(new AccountFragment());
                        return true;
                    case R.id.menuCart:
                        fmNew = new CartFragment();
                        loadFragment(new CartFragment());
                        return true;
                }
                return true;
            }
        };
    }

    void loadFragment (Fragment fmNew)
    {
        FragmentTransaction fmTran = getSupportFragmentManager().beginTransaction();
        fmTran.replace(R.id.main_fragment, fmNew);
        fmTran.addToBackStack(null);
        fmTran.commit();
    }

    private int idBillSQL(String nameUser) {
        int i = -1;
        for (Bill b : billArrayList) {
            if (b.getCart().getAccount().getUserName().toString().trim().equals(nameUser.trim())) {
                i = b.getBillId();
            }
        }
        return i;
    }
}