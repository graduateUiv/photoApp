package com.example.testtestaddphoto;

public class Folder {
    private String folderName;
//    int imageResId;

    public Folder(String name) {
        setFolderName(name);
//        setImageResId(image);
    }

    public String getFolderName() {
        return this.folderName;
    }

    public void setFolderName(String newFolderName) {
        this.folderName = newFolderName;
    }
//    private int getImageResId(){
//        return this.imageResId;
//    }
//    private void setImageResId(int newImage){
//        this.imageResId = newImage;
//    }
}
