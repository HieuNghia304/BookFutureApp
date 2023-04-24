package com.example.bookfuture.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookfuture.Database.SQLAccount;
import com.example.bookfuture.Database.SQLBill;
import com.example.bookfuture.Model.Account;
import com.example.bookfuture.Model.Bill;
import com.example.bookfuture.Model.Cart;
import com.example.bookfuture.R;

import java.util.ArrayList;

public class ResgisterActivity extends AppCompatActivity {
    private Button btnRegister;
    private EditText edtUser, edtPassWord, edtRetypePassWord,edtEmail,edtPhone;
    private TextView tvLogin;
    private ArrayList<Account> accountUserList;
    private SQLAccount sqlAccount;
    private SQLBill sqlBill;
    private ArrayList<Bill> billArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgister);
        initVew();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlAccount = new SQLAccount(ResgisterActivity.this);
                sqlBill = new SQLBill(ResgisterActivity.this);
                String nameAc = edtUser.getText().toString();
                String passAc = edtPassWord.getText().toString();
                String retypePassAc = edtRetypePassWord.getText().toString();
                boolean CheckAc = true;
                Account account = new Account(nameAc, passAc, "","");

                accountUserList = sqlAccount.getListAccountSQL();
                billArrayList = sqlBill.getListBillSQL();
                String name;
                for (Account ac : accountUserList) {
                    name = ac.getUserName();
                    if (nameAc.equals(name.trim())) {
                        CheckAc = false;
                        break;
                    }
                }
                if (nameAc.isEmpty()) {
                    Toast.makeText(ResgisterActivity.this, "Tên tài khoản không được để trống !!", Toast.LENGTH_SHORT).show();
                } else {
                    if (passAc.isEmpty()) {
                        Toast.makeText(ResgisterActivity.this, "Mật khẩu  không đươc để trống !!", Toast.LENGTH_SHORT).show();
                    } else {
                        if (passAc.equals(retypePassAc) == false) {
                            Toast.makeText(ResgisterActivity.this, "Nhập lại mật khẩu không khớp !!", Toast.LENGTH_SHORT).show();
                        } else{
                            if (CheckAc == false) {
                                Toast.makeText(ResgisterActivity.this, "Tài khoản này đã tồn tại !!", Toast.LENGTH_SHORT).show();
                            } else {
                                Account newAccount = new Account(nameAc,passAc,"1","1");
                                sqlAccount.setListAccountSQL(newAccount);
                                sqlBill.setListBillSQL(new Bill(getId(),new Cart(newAccount),0,0));
                                Toast.makeText(ResgisterActivity.this, "Thêm tài khoản thành công!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ResgisterActivity.this, LoginActivity.class);
                                intent.putExtra("nameUser", newAccount.getUserName().trim());
                                intent.putExtra("passWordUser", newAccount.getPassWord().trim());
                                setResult(RESULT_OK,intent);
                                finish();
                            }
                        }
                    }
                }
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResgisterActivity.this, LoginActivity.class);
                startActivityForResult(intent, 999);
            }
        });
    }


    private void initVew() {
        btnRegister = findViewById(R.id.btnRegister);
        accountUserList = new ArrayList<>();
        tvLogin = findViewById(R.id.tvLogin);
        edtUser = findViewById(R.id.edtUserNamePayment);
        edtPassWord = findViewById(R.id.edtPassword);
        edtRetypePassWord = findViewById(R.id.edtRetypePassword);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);

    }
    private int getId() {
        int max = 0;
        for (Bill m : billArrayList) {
            if (m.getBillId() > max) {
                max = m.getBillId();
            }
        }
        if (billArrayList.size() == 0) {
            return max;
        }
        return max + 1;
    }
}