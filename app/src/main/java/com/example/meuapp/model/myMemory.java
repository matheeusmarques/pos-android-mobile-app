package com.example.meuapp.model;

import com.orm.SugarRecord;

public class myMemory extends SugarRecord<myMemory> {

    public myMemory(String title, String description, String image_1, String coord_x, String coord_y) {
        this.title = title;
        this.description = description;
        this.image_1 = image_1;
        this.coord_x = coord_x;
        this.coord_y = coord_y;
    }

    public myMemory() {
    }

    private String title;
    private String description;
    private String image_1;
    private String coord_x;
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

    public String getCoord_x() {
        return coord_x;
    }

    public void setCoord_x(String coord_x) {
        this.coord_x = coord_x;
    }

    public String getCoord_y() {
        return coord_y;
    }

    public void setCoord_y(String coord_y) {
        this.coord_y = coord_y;
    }
}
