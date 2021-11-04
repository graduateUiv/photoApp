package com.example.testapp.utils;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;

import java.io.File;
import java.util.ArrayList;


public class CategoryFolder extends AppCompatActivity implements itemClickListener {
    RecyclerView categoryFolderRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_folder_display);

        Intent intent = getIntent();
        String folderPath = intent.getStringExtra("folderPath");
        String folderName = intent.getStringExtra("folderName");


        getCategoryFolder(folderPath, folderName);
    }


    private void getCategoryFolder(String folderPath, String folderName){
        categoryFolderRecycler = findViewById(R.id.categoryFolderRecycler);
        categoryFolderRecycler.hasFixedSize();

        ArrayList<imageFolder> folds = new ArrayList<>();
        String newFilePath = Environment.getExternalStorageDirectory() + "/addPhoto/" + folderName +"/";
        File storageDir = new File(newFilePath);
        if (!storageDir.exists()) storageDir.mkdirs();
        File[] categoryFoldersNames = storageDir.listFiles();

        for(int i = 0 ; i < categoryFoldersNames.length; i++){
            imageFolder fold = new imageFolder();

            String categoryFileName = categoryFoldersNames[i].getName();

            File f = categoryFoldersNames[i];
            File[] files = f.listFiles();

            fold.setPath(newFilePath);
            fold.setFolderName(categoryFileName);
            fold.setNumberOfPics(files.length);
            folds.add(fold);

        }

        RecyclerView.Adapter categoryFolderAdapter = new CategoryFolderAdapter(folds, CategoryFolder.this, this);
        categoryFolderRecycler.setAdapter(categoryFolderAdapter);
    }
    @Override
    public void onPicClicked(PicHolder holder, int position, ArrayList<pictureFacer> pics) {

    }

    @Override
    public void onPicClicked(String pictureFolderPath, String folderName) {
        Intent move = new Intent(CategoryFolder.this,ImageDisplay.class);
        move.putExtra("folderPath",pictureFolderPath);
        move.putExtra("folderName",folderName);

        startActivity(move);
    }
}

