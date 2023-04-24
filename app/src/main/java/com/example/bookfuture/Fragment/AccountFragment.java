package com.example.bookfuture.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookfuture.Login.LoginActivity;
import com.example.bookfuture.MainActivity;
import com.example.bookfuture.R;

public class AccountFragment extends Fragment {
    private TextView textViewExit,userNameInformation,passWordInformation;
    private View view;
    private MainActivity mainActivity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_account_infomation, container, false);
        initView();
        textViewExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void initView() {
        mainActivity = (MainActivity)getActivity();
        textViewExit = view.findViewById(R.id.textExit);
        userNameInformation = view.findViewById(R.id.userNameInformation);
        userNameInformation.setText(mainActivity.userName);
        passWordInformation = view.findViewById(R.id.passWordInformation);
        passWordInformation.setText(mainActivity.passWord);
    }
}
