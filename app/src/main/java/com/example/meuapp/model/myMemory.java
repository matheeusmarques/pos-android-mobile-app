package com.example.meuapp.model;

import com.orm.SugarRecord;

import java.util.Date;

public class myMemory extends SugarRecord<myMemory> {

    public myMemory(String title, String description, String image_1, Date date_memory, String coord_y) {
        this.title = title;
        this.description = description;
        this.image_1 = image_1;
        this.date_memory = date_memory;
        this.coord_y = coord_y;
    }

    public myMemory() {
    }

    private String title;
    private String description;
    private String image_1;
    private Date date_memory = new Date();
    private String coord_y;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_1() {
        return image_1;
    }

    public void setImage_1(String image_1) {
        this.image_1 = image_1;
    }

    public Date getDate_memory() {
        return date_memory;
    }

    public void setDate_memory(Date date_memory) {
        this.date_memory = date_memory;
    }

    public String getCoord_y() {
        return coord_y;
    }

    public void setCoord_y(String coord_y) {
        this.coord_y = coord_y;
    }
}
