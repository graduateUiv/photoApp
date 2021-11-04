package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MapWithPhoto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_with_photo);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_map);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void increaseValue(View v) {
        MyView.radius += 2;
        System.out.println(MyView.radius);
    }

    public void decreaseValue(View v) {
        MyView.radius -= 2;
        System.out.println(MyView.radius);
    }

    public void setRed(View v) {
        MyView.whatColor = 1;
        System.out.println(MyView.whatColor);
    }

    public void setBlue(View v) {
        MyView.whatColor = 2;
        System.out.println(MyView.whatColor);
    }

    public void setYellow(View v) {
        MyView.whatColor = 3;
        System.out.println(MyView.whatColor);
    }

    public void setGreen(View v) {
        MyView.whatColor = 4;
        System.out.println(MyView.whatColor);
    }

    public void setBlack(View v) {
        MyView.whatColor = 5;
        System.out.println(MyView.whatColor);
    }

    public void clearPaint(View v) {
        MyView.clearPaint();
    }

    public void savePaint(View v) {
//        MyView.savePaint();
    }

    public void loadPaint(View v) {
//        MyView.loadPaint();
    }

    //map intent toolbar 뒤로가기 기능 추가
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:{
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed(){
        super.onBackPressed();
        //stopPlay();

    }

}

