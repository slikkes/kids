package com.example.slikk.asdf;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "kids")
public class Kid{

    @PrimaryKey(autoGenerate = true)
    private int _id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "points")
    private int points;

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
