package com.example.dbdemo.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dbdemo.R;

public class DisplayContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");

        TextView nameTV = findViewById(R.id.name);
        nameTV.setText(name);
        TextView phoneTV = findViewById(R.id.number);
        phoneTV.setText(phone);
    }
}