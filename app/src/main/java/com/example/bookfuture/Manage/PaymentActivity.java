package com.example.bookfuture.Manage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookfuture.R;

import java.text.DecimalFormat;

public class PaymentActivity extends AppCompatActivity {
    private TextView textTotalMoney;
    private Button btnPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        intiView();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String money = bundle.getString("total");
//            String money = String.valueOf(bundle.getString("total"));
            textTotalMoney.setText(money);

        }
        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PaymentActivity.this, "Thanh toán thành công !!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(PaymentActivity.this, PaydoneActivity.class);
                startActivity(intent1);
            }
        });
    }
    private void intiView() {
        btnPayment = findViewById(R.id.btnPayment);
        textTotalMoney = findViewById(R.id.textTotalMoney);
    }
//    public static String formatNumberCurrency(String number){
//        DecimalFormat format = new DecimalFormat("###.###");
//        return format.format(Double.parseDouble(number));
//    }
}