package com.sohaghlab.islamictune;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SlideAdapter extends RecyclerView.Adapter<SlideAdapter.SliderViewHolder> {

    //create list image and make constructor


    private List<SlideItem> slideItems;

    public SlideAdapter(List<SlideItem>slideItems){
        this.slideItems=slideItems;
    }


    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slide,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {


        holder.setImage(slideItems.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class SliderViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView =itemView.findViewById(R.id.image_slide);

        }

        //now create new method
        void setImage(SlideItem slideItem){
            imageView.setImageResource(slideItem.getImage()) ;
        }
    }
}
