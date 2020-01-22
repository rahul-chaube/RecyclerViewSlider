package com.rahulchaube.recyclerviewslider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.ViewHolder> {
    Context context;
    SliderListner sliderListner;

    public SliderAdapter(Context context, SliderListner sliderListner) {
        this.context = context;
        this.sliderListner = sliderListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (position == 0) {
            Glide.with(context).load("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg").into(holder.imageView);
        } else if (position == 1) {
            Glide.with(context).load("https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072823__340.jpg").into(holder.imageView);
        }
        else if (position == 2) {
            Glide.with(context).load("https://image.shutterstock.com/image-photo/colorful-flower-on-dark-tropical-260nw-721703848.jpg").into(holder.imageView);
        }
        else if (position == 3) {
            Glide.with(context).load("https://images.pexels.com/photos/459225/pexels-photo-459225.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500").into(holder.imageView);
        }
        else if (position == 4) {
            Glide.with(context).load("https://image.shutterstock.com/image-photo/bright-spring-view-cameo-island-260nw-1048185397.jpg").into(holder.imageView);
        }
        else if (position == 5) {
            Glide.with(context).load("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg").into(holder.imageView);
        }
        else if (position == 6) {
            Glide.with(context).load("https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500").into(holder.imageView);
        }
        else if (position == 7) {
            Glide.with(context).load("https://www.w3schools.com/howto/img_nature_wide.jpg").into(holder.imageView);
        }
        else if (position == 8) {
            Glide.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZ8DDmOYkhrs5vd0cq-B1f1WzxduWACwBL_NEJqQh1Ym-zYRwYJA&s").into(holder.imageView);
        }
        else if (position == 9) {
            Glide.with(context).load("https://i.ytimg.com/vi/gD4uACwPChA/maxresdefault.jpg").into(holder.imageView);
        }
        else  {
            Glide.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZEsEGpnfleurQKVQQkH95_ujjWsTC5_MDwWtiq8F0u7Aa9jP9jQ&s").into(holder.imageView);
        }


    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    interface SliderListner
    {
        void currentPage(int position);
    }
}
