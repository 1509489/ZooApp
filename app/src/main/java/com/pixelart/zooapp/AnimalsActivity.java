package com.pixelart.zooapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalsActivity extends AppCompatActivity {
    private static final String TAG = "AnimalActivity";

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.ItemAnimator animator;
    private AnimalListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.rvAnimals);
        layoutManager = new LinearLayoutManager(this);
        animator = new DefaultItemAnimator();

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(animator);

    }


    @Override
    protected void onResume() {
        super.onResume();
        String category = getIntent().getStringExtra("category");

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<Animals> animals = databaseHelper.getAnimalsByCategory(category);

        for (Animals  animal : animals)
        {
            Log.d(TAG, "displayAnimal " + animal.getName() + " " + animal.getDescription());
        }

        adapter = new AnimalListAdapter(animals);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
