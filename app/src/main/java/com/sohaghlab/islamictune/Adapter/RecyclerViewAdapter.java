package com.sohaghlab.islamictune.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sohaghlab.islamictune.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title_text;
        ImageView img_card;
        CardView cardView_recycler;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title_text= itemView.findViewById(R.id.title_recycler_card);
            img_card= itemView.findViewById(R.id.img_recycler_id);
            cardView_recycler= itemView.findViewById(R.id.recycler_card_id);

        }
    }
}