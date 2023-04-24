package com.example.bookfuture.Manage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bookfuture.MainActivity;
import com.example.bookfuture.R;

public class PaydoneActivity extends AppCompatActivity {
    private Button btnContinuePay, btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paydone);
        intiView();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        btnContinuePay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(PaydoneActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
    private void intiView() {
        btnContinuePay = findViewById(R.id.btnContinuePay);
        btnOrder = findViewById(R.id.btnOrder);
    }
}