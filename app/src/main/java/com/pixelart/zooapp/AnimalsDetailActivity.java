package com.pixelart.zooapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AnimalsDetailActivity extends AppCompatActivity {
    private static final String TAG = "AnimalsDetailActivity";

    private TextView tvName, tvDescritpion, tvLocation, tvHabitat, tvDiet, tvSize,
                tvWeight, tvStauts, tvThreats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_detail);

        tvName = findViewById(R.id.tvName);
        tvDescritpion = findViewById(R.id.tvDescription);
        tvLocation = findViewById(R.id.tvLocation);
        tvHabitat = findViewById(R.id.tvHabitat);
        tvDiet = findViewById(R.id.tvDiet);
        tvSize = findViewById(R.id.tvSize);
        tvWeight = findViewById(R.id.tvWeight);
        tvStauts = findViewById(R.id.tvStatus);
        tvThreats = findViewById(R.id.tvThreats);

    }

    @Override
    protected void onResume() {
        super.onResume();

        Animals animals = getIntent().getParcelableExtra("animals");

        tvName.setText(animals.getName());
        tvDescritpion.setText(animals.getDescription());
        tvLocation.setText(animals.getLocation());
        tvHabitat.setText(animals.getHabitat());
        tvDiet.setText(animals.getDiet());
        tvSize.setText(animals.getSize());
        tvWeight.setText(animals.getWeight());
        tvStauts.setText(animals.getStatus());
        tvThreats.setText(animals.getThreats());

        Log.d(TAG, animals.toString());
    }
}
