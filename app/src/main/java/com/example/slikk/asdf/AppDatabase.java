package com.example.slikk.asdf;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Kid.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract KidsDao kidsDao();
}
