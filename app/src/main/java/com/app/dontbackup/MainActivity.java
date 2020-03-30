package com.app.dontbackup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String name = "Cirilla Fiona Elen Riannon";
    int balance = 1337;
    String address = "Skellige,Belleteyn AL 1252";
    String phoneNumber = "(123) 4567890";
    String email = "ciri@skellige.com";
    TextView tvHello;
    TextView tvBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHello = findViewById(R.id.tv_hello);
        tvBalance = findViewById(R.id.tv_balance);
        tvHello.setText(getString(R.string.hello,name));
        tvBalance.setText(getString(R.string.balance, balance));
        writeSharedPrefs(name, balance, address, phoneNumber, email);

    }

//   write sensitive values to SharedPreferences
    private void writeSharedPrefs(String name, int balance, String address, String phoneNumber, String email){
        SharedPreferences prefs = this.getSharedPreferences(
                "com.app.dontbackup", Context.MODE_PRIVATE);
        prefs.edit().putString("name", name).apply();
        prefs.edit().putInt("balance", balance).apply();
        prefs.edit().putString("address", address).apply();
        prefs.edit().putString("phoneNumber", phoneNumber).apply();
        prefs.edit().putString("email", email).apply();

    }

}
