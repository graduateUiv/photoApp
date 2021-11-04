package com.example.testapp.utils;

import static androidx.core.view.ViewCompat.setTransitionName;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.testapp.R;

import java.util.ArrayList;

public class pictureAdapter extends RecyclerView.Adapter<PicHolder> {


    private ArrayList<pictureFacer> pictureList;
    private Context pictureContx;
    private final itemClickListener picListener;


    public pictureAdapter(ArrayList<pictureFacer> pictureList, Context pictureContx, itemClickListener picListener){
        this.pictureList = pictureList;
        this.pictureContx = pictureContx;
        this.picListener = picListener;
    }

    @NonNull
    @Override
    public PicHolder onCreateViewHolder(@NonNull ViewGroup container, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View cell = inflater.inflate(R.layout.pic_holder_item, container, false);
        return new PicHolder(cell);
    }

    @Override
    public void onBindViewHolder(@NonNull PicHolder holder, int position) {

        final pictureFacer image = pictureList.get(position);

        Glide.with(pictureContx)
                .load(image.getPicturePath())
                .apply(new RequestOptions().centerCrop())
                .into(holder.picture);
        setTransitionName(holder.picture, String.valueOf(position) + "_image");

        holder.picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picListener.onPicClicked(holder,position, pictureList);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pictureList.size();
    }
}
