package com.example.grocery;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Item.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    public abstract ItemDAO itemDAO();

    public static AppDatabase getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context,AppDatabase.class,"Grocery.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}