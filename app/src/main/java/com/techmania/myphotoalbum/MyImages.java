package com.techmania.myphotoalbum;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "my_images")
public class MyImages {

    @PrimaryKey(autoGenerate = true)
    public int image_id;
    public String image_title;
    public String image_description;
    public byte[] image;

    public MyImages(byte[] image, String image_description, String image_title) {
        this.image = image;
        this.image_description = image_description;
        this.image_title = image_title;
    }

    public int getImage_id() {
        return image_id;
    }

    public String getImage_title() {
        return image_title;
    }

    public String getImage_description() {
        return image_description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }
}
