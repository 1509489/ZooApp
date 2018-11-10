package com.pixelart.zooapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.ViewHolder> {
    private static final String TAG = "AnimalListAdapter";

    private List<Animals> animalsList;
    private Context context;
    private int lastPostion = -1;

    public AnimalListAdapter(List<Animals> animalsList) {
        this.animalsList = animalsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder");

        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recycleview_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int postion) {
        Log.d(TAG, "onBindViewHolder");

        Animals animal = animalsList.get(postion);
        viewHolder.tvName.setText(animal.getName());
        viewHolder.tvDescription.setText(animal.getDescription());
    }

    @Override
    public int getItemCount() {
        return animalsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
