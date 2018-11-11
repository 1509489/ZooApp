package com.pixelart.zooapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class CategoryActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    private String[] categories;
    private Spinner spCategories;
    private ListView listView;

    private ArrayAdapter lvAdapter;
    private ArrayAdapter spinnerAdapter;

    private String[] amphibians;
    private String[] birds;
    private String[] fish;
    private String[] mammals;
    private String[] invertebrates;
    private String[] reptiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categories = getResources().getStringArray(R.array.categories);
        amphibians = getResources().getStringArray(R.array.amphibians);
        birds = getResources().getStringArray(R.array.birds);
        fish = getResources().getStringArray(R.array.fish);
        mammals = getResources().getStringArray(R.array.mammals);
        invertebrates = getResources().getStringArray(R.array.invertebrates);
        reptiles = getResources().getStringArray(R.array.reptiles);

        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        //lvAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, amphibians);

        spinnerAdapter = new ArrayAdapter(this, R.layout.spiner_item_layout, categories);
        spCategories = findViewById(R.id.spinnerView);
        spCategories.setAdapter(spinnerAdapter);
        spCategories.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        switch (position)
        {
            case 0:
                lvAdapter = new ArrayAdapter(this, R.layout.listview_item_layout, amphibians);

                break;

            case 1:
                lvAdapter = new ArrayAdapter(this, R.layout.listview_item_layout, birds);
                break;

            case 2:
                lvAdapter = new ArrayAdapter(this, R.layout.listview_item_layout, fish);
                break;

            case 3:
                lvAdapter = new ArrayAdapter(this, R.layout.listview_item_layout, mammals);
                break;

            case 4:
                lvAdapter = new ArrayAdapter(this, R.layout.listview_item_layout, invertebrates);
                break;

            case 5:
                lvAdapter = new ArrayAdapter(this, R.layout.listview_item_layout, reptiles);
                break;

                default:
                    break;
        }

        listView.setAdapter(lvAdapter);
        lvAdapter.notifyDataSetChanged();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String category = parent.getItemAtPosition(position).toString();

        Toast.makeText(this, category, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, AnimalsActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);

    }
}
