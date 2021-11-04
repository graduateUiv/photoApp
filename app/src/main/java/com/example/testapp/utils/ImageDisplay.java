package com.example.testapp.utils;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;
import com.example.testapp.fragment.pictureBrowserFragment;

import java.io.File;
import java.util.ArrayList;

public class ImageDisplay extends AppCompatActivity implements itemClickListener {


    RecyclerView imageRecycler;
    String folderPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);


        Intent intent = getIntent();
        String folderName = intent.getStringExtra("folderName");

        folderPath =  getIntent().getStringExtra("folderPath") + folderName +"/";
        System.out.println(folderPath);
        imageRecycler = findViewById(R.id.recycler);
        imageRecycler.hasFixedSize();

        getAllImagesByFolder(folderPath);

    }

    @Override
    public void onPicClicked(PicHolder holder, int position, ArrayList<pictureFacer> pics) {
        pictureBrowserFragment browser = pictureBrowserFragment.newInstance(pics,position,ImageDisplay.this);

        getSupportFragmentManager()
                .beginTransaction()
                .addSharedElement(holder.picture, position+"picture")
                .add(R.id.displayContainer, browser)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onPicClicked(String pictureFolderPath, String folderName) {

    }


    public void getAllImagesByFolder(String path){
        ArrayList<pictureFacer> images = new ArrayList<>();
        File storageDir = new File(path);
        if(!storageDir.exists()) storageDir.mkdir();
        File[] imgFolder = storageDir.listFiles();

        for(int i = 0 ; i < imgFolder.length; i++){
            pictureFacer pic = new pictureFacer();

            String picFileName = imgFolder[i].getName();

            pic.setPicturName(picFileName);
            pic.setPicturePath(path + picFileName);

            images.add(pic);

        }
        ArrayList<pictureFacer> reSelection = new ArrayList<>();
        for(int i = images.size()-1;i > -1;i--){
            reSelection.add(images.get(i));
        }
        images = reSelection;
        imageRecycler.setAdapter(new pictureAdapter(images,ImageDisplay.this,this));
    }
}

