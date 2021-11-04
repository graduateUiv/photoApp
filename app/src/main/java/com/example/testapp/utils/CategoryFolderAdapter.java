package com.example.testapp.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;

import java.util.ArrayList;

public class CategoryFolderAdapter extends RecyclerView.Adapter<CategoryFolderAdapter.CategoryFolerHolder>{


    private ArrayList<imageFolder> folders;
    private Context folderContx;
    private itemClickListener listenToClick;

    public CategoryFolderAdapter(ArrayList<imageFolder> folders, Context folderContx, itemClickListener listen){
        this.folders = folders;
        this.folderContx = folderContx;
        this.listenToClick = listen;
    }

    @NonNull
    @Override
    public CategoryFolerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View cell = inflater.inflate(R.layout.picture_folder_item, parent, false);

        return new CategoryFolerHolder(cell);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryFolerHolder holder, int position) {
        final imageFolder folder = folders.get(position);

        String text = "" + folder.getFolderName();
        String folderSizeString = "" + folder.getNumberOfPics() + " 장";
        holder.folderSize.setText(folderSizeString);
        holder.folderName.setText(text);

        holder.folderPic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                listenToClick.onPicClicked(folder.getPath(),folder.getFolderName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return folders.size();
    }

    public class CategoryFolerHolder extends  RecyclerView.ViewHolder{
        ImageView folderPic;
        TextView folderName;
        TextView folderSize;

        CardView folderCard;

        public CategoryFolerHolder(@NonNull View itemView) {
            super(itemView);
            folderPic = itemView.findViewById(R.id.folderPic);
            folderName = itemView.findViewById(R.id.folderName);
            folderSize=itemView.findViewById(R.id.folderSize);
            folderCard = itemView.findViewById(R.id.folderCard);
        }
    }
}