package com.example.testapp.utils;

public class pictureFacer {

    private String pictureName;
    private String picturePath;
    private  String pictureSize;
    private  String imageUri;
    private Boolean selected = false;

    public pictureFacer(){

    }

    public pictureFacer(String picturName, String picturePath, String pictureSize, String imageUri) {
        this.pictureName = picturName;
        this.picturePath = picturePath;
        this.pictureSize = pictureSize;
        this.imageUri = imageUri;
    }


    public String getPicturName() {
        return pictureName;
    }

    public void setPicturName(String picturName) {
        this.pictureName = picturName;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getPictureSize() {
        return pictureSize;
    }

    public void setPictureSize(String pictureSize) {
        this.pictureSize = pictureSize;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
