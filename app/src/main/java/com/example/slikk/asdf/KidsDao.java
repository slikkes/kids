package com.example.slikk.asdf;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import java.util.List;

@Dao
public interface KidsDao {

    @Insert
    public void addKid(Kid kid);

    @Query("select * from kids")
    public List<Kid> getKids();

    @Query("select * from kids")
    public Cursor getCursorAll();

    @Delete
    public void deleteKid(Kid kid);

    @Update
    public void updateKid(Kid kid);

}
