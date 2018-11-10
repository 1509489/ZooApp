package com.pixelart.zooapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnContinue = findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener((view) -> {
            Intent intent = new Intent(this, CategoryActivity.class);
            startActivity(intent);
        });

    }
}
