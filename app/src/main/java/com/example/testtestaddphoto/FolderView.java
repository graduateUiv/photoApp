package com.example.testtestaddphoto;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class FolderView extends LinearLayout {
    TextView folderName;

    public FolderView(Context context) {
        super(context);
        init(context);
    }

    public FolderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.folder_part, this, true);
        folderName = findViewById(R.id.folderName);
    }

    public void setFolderName(String name) {
        folderName.setText(name);
    }
}
