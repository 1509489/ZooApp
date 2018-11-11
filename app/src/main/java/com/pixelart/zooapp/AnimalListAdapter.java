package com.pixelart.zooapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.List;

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.ViewHolder> {
    private static final String TAG = "AnimalListAdapter";

    private List<Animals> animalsList;
    private Context context;
    private int lastPosition = -1;

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
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Log.d(TAG, "onBindViewHolder");

        if(position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            animation.setInterpolator(context, android.R.interpolator.bounce);
            viewHolder.itemView.setAnimation(animation);
        }

        //Getting the animal details
        Animals animal = animalsList.get(position);
        viewHolder.tvName.setText(animal.getName());
        viewHolder.tvDescription.setText(animal.getDescription());

        String animalLocation = animal.getLocation();
        String animalHabitat = animal.getHabitat();
        String animalDiet = animal.getDiet();
        String animalSize = animal.getSize();
        String animalWeight = animal.getWeight();
        String animalStatus = animal.getStatus();
        String animalThreats = animal.getThreats();

        viewHolder.parentLayout.setOnClickListener((view) -> {

            Animals animals = new Animals(viewHolder.tvName.getText().toString(), viewHolder.tvDescription.getText().toString(),
                    animalLocation, animalHabitat, animalDiet, animalSize, animalWeight, animalStatus, animalThreats);

            Intent intent = new Intent(context, AnimalsDetailActivity.class);
            intent.putExtra("animals", animals);
            context.startActivity(intent);

            Log.d(TAG, "Clicked on " + animals.toString());
        });
    }

    @Override
    public int getItemCount() {
        return animalsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvDescription;
        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
