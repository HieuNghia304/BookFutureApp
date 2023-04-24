package com.example.bookfuture.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.bookfuture.Model.SelectedBook;
import com.example.bookfuture.R;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    private ArrayList<SelectedBook> list;
    EditText ed_seach;

    public SearchFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_search, container, false);
    }
}
