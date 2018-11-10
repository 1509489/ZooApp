package com.pixelart.zooapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class AnimalsActivity extends AppCompatActivity {
    private static final String TAG = "AnimalActivity";

    private List<Animals> animalsList;
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

        animalsList = new ArrayList<>();
        recyclerView = findViewById(R.id.rvAnimals);
        layoutManager = new LinearLayoutManager(this);
        animator = new DefaultItemAnimator();

        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setItemAnimator(animator);

        adapter = new AnimalListAdapter(animalsList);
        recyclerView.setAdapter(adapter);

        initAnimals();
        adapter.notifyDataSetChanged();

    }

    private void initAnimals()
    {
        animalsList.add(new Animals("Sumatran Tigers", "Sumatran tigers have webbed paws, which means that they’re brilliant swimmers.",
                "", "", "", "", "", "", "", ""));

        animalsList.add(new Animals("Sumatran Tigers", "There were once so many Asiatic lions on our planet that they roamed from north-east " +
                "India to the Mediterranean but today there are only about 350 left in the wild and all of them live in India’s Gir Forest. ",
                "", "", "", "", "", "", "", ""));
    }
}
