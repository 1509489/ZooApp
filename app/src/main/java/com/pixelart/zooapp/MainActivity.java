package com.pixelart.zooapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Arrays;
import java.util.List;

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


    private void addAnimalsToDatabase()
    {
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        String[] name = getResources().getStringArray(R.array.animal_name);
        String[] description = getResources().getStringArray(R.array.animal_description);
        String[] category = getResources().getStringArray(R.array.animal_category);
        String[] location = getResources().getStringArray(R.array.animal_location);
        String[] habitat = getResources().getStringArray(R.array.animal_habitat);
        String[] diet = getResources().getStringArray(R.array.animal_diet);
        String[] size = getResources().getStringArray(R.array.animal_size);
        String[] weight = getResources().getStringArray(R.array.animal_weight);
        String[] status = getResources().getStringArray(R.array.animal_status);
        String[] threats = getResources().getStringArray(R.array.animal_threats);

        for (int i = 0; i < name.length; i++)
        {
           Animals animal = new Animals(name[i], description[i], location[i], habitat[i], diet[i],
                    size[i], weight[i], status[i], threats[i], category[i]);
            databaseHelper.addAnimals(animal);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        addAnimalsToDatabase();
    }
}
